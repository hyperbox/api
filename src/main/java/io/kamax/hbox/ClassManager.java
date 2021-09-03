/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 - Max Dor
 *
 * https://apps.kamax.io/hyperbox
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.hbox;

import io.kamax.hbox.exception.HyperboxException;
import io.kamax.tools.logging.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

public class ClassManager {

    private static Map<URL, Reflections> classes = new HashMap<URL, Reflections>();

    static {
        Set<URL> urls = new HashSet<URL>();
        for (URL url : ClasspathHelper.forJavaClassPath()) {
            if (url.getFile().endsWith(".jar") || url.getFile().endsWith(".class") || url.getFile().endsWith("/")) {
                urls.add(url);
            }
        }
        scan(urls);
    }

    private static void scan(Set<URL> urls, ClassLoader... loaders) {
        Long start = System.currentTimeMillis();
        Reflections scan = new Reflections(new ConfigurationBuilder().addClassLoaders(loaders).setUrls(urls)
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner())
                .setExecutorService(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())));
        for (URL url : urls) {
            classes.put(url, scan);
        }

        Logger.debug("Scanning urls took " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void add(Set<URL> rawUrls, ClassLoader... loaders) {
        Set<URL> urls = new HashSet<URL>();
        for (URL rawUrl : rawUrls) {
            if (!classes.containsKey(rawUrl)) {
                Logger.debug("Adding " + rawUrl.toString() + " to URL to scan");
                urls.add(rawUrl);
            }
        }
        scan(urls, loaders);
    }

    public static void reload(Set<URL> rawUrls, ClassLoader... loaders) {
        scan(rawUrls, loaders);
    }

    public static void remove(Set<URL> urls) {
        for (URL url : urls) {
            classes.remove(url);
            Logger.debug("URL removed: " + url);
        }
        Logger.debug(classes.keySet().size() + " remaining URLs:");
        for (URL url : classes.keySet()) {
            Logger.debug("\t" + url);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T loadClass(Class<T> itWannabeClass, String it) {
        try {
            Class<T> itClass = (Class<T>) Class.forName(it);
            T itInstance = itClass.newInstance();
            return itInstance;
        } catch (Exception e) {
            Logger.error("Failed to load " + it + " : " + e.getLocalizedMessage());
            Logger.exception(e);
            throw new HyperboxException(e);
        }
    }

    public static <T> Set<Class<? extends T>> getSubTypes(Class<T> type) {
        Long start = System.currentTimeMillis();
        Set<Class<? extends T>> classList = new HashSet<Class<? extends T>>();
        for (Reflections data : classes.values()) {
            for (Class<? extends T> rawClass : data.getSubTypesOf(type)) {

                /*
                 * Since we have modules, it is possible that several classes have the same name.
                 * To avoid any conflict, we want to make sure only the good classes are returned.
                 * 
                 * For the queried class type, if it comes from the system class loader (same as us), we have no problem
                 * since that class type will be unique in the system.
                 * 
                 * On the other hand, if the queried class type is not from the system class loader, it means it comes
                 * from a module. In that case, we must only return results that are from the same class loader.
                 */
                if (ClassManager.class.getClassLoader().equals(type.getClassLoader()) || rawClass.getClassLoader().equals(type.getClassLoader())) {
                    classList.addAll(data.getSubTypesOf(type));
                }
            }
        }
        Logger.debug(type.getSimpleName() + " providers took " + (System.currentTimeMillis() - start) + " ms to find");
        return classList;
    }

    public static <T> Set<Class<? extends T>> getAnnotatedSubTypes(Class<T> type, Class<? extends Annotation> note) {
        Long start = System.currentTimeMillis();
        Set<Class<? extends T>> classList = new HashSet<Class<? extends T>>();
        for (Class<? extends T> subType : getSubTypes(type)) {

            if (Modifier.isAbstract(subType.getModifiers())) {
                Logger.debug(subType.getName() + " is abstract and was ignored");
            } else {
                for (Annotation subTypeNote : subType.getAnnotations()) {
                    if (!subTypeNote.annotationType().equals(note)) {
                        Logger.debug(subTypeNote.annotationType().getName() + " ignored, does not have annotation " + note.getName());
                    } else {
                        Logger.debug("Found match for " + type.getName() + ": " + subType.getName());
                        classList.add(subType);
                    }
                }

            }
        }
        Logger.debug(type.getSimpleName() + " providers took " + (System.currentTimeMillis() - start) + " ms to find");
        return classList;
    }

    public static <T> Set<T> getQuiet(Class<T> type) {
        Set<T> loadedClasses = new HashSet<T>();

        Set<Class<? extends T>> classes = getSubTypes(type);
        for (Class<? extends T> rawObject : classes) {
            try {
                if (!Modifier.isAbstract(rawObject.getModifiers())) {
                    T view = rawObject.newInstance();
                    loadedClasses.add(view);
                }
            } catch (Exception e) {
                Logger.debug("Failed to load " + rawObject.getSimpleName() + " : " + e.getLocalizedMessage());
            }
        }

        return loadedClasses;
    }

    public static <T> Set<T> getAtLeastOneOrFail(Class<T> type) throws HyperboxException {
        Set<T> objects = getQuiet(type);

        if (objects.isEmpty()) {
            throw new HyperboxException("Unable to find any match for " + type.getSimpleName());
        }

        return objects;
    }

    public static <T> Set<T> getAllOrFail(Class<T> type) throws HyperboxException {
        try {
            Set<Class<? extends T>> classes = getSubTypes(type);
            Set<T> loadedClasses = new HashSet<T>();
            for (Class<? extends T> rawObject : classes) {
                if (!Modifier.isAbstract(rawObject.getModifiers())) {
                    T view = rawObject.newInstance();
                    loadedClasses.add(view);
                }
            }
            return loadedClasses;
        } catch (Exception e) {
            Logger.exception(e);
            throw new HyperboxException("Failed to load " + type.getSimpleName(), e);
        }
    }

}
