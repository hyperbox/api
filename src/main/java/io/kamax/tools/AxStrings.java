/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Max Dor
 * hyperbox at altherian dot org
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

package io.kamax.tools;

public class AxStrings {

    protected AxStrings() {
        // we don't plan on instance this
    }

    /**
     * Detects if a String is NULL or empty and return the failover value in case of.<br/>
     * Else, the String is returned untouched.
     *
     * @param before   String to validate
     * @param failover Failover string ins case original string is null or empty
     * @return the wanted value
     */
    public static String getNonEmpty(Object before, String failover) {
        if (isEmpty(before)) {
            return failover;
        } else {
            return before.toString();
        }
    }

    public static String getNonEmpty(Object candidate, Object... failovers) {
        if (!isEmpty(candidate)) {
            return candidate.toString();
        }

        if (failovers.length == 1) {
            return failovers[0].toString();
        }

        return getNonEmpty(failovers);
    }

    /**
     * Return true if a String is null or empty
     *
     * @param s The String to check
     * @return true if s == null || s.isEmpty(), false otherwise
     */
    public static boolean isEmpty(String s) {
        return ((s == null) || s.isEmpty());
    }

    public static boolean isEmpty(String... sAll) {
        for (String s : sAll) {
            if (!isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true if an Object is null or its .toString() method returns null or an empty string
     *
     * @param o The Object to check
     * @return true if o == null || isEmpty(o.toString()), false otherwise
     */
    public static boolean isEmpty(Object o) {
        return ((o == null) || isEmpty(o.toString()));
    }

    public static boolean isEmpty(Object... sAll) {
        for (Object s : sAll) {
            if (!isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(String l, String r) {
        return (l != null) && (r != null) && l.equals(r);
    }

    public static boolean contentEquals(String l, String r) {
        return (l != null) && (r != null) && l.contentEquals(r);
    }

    /**
     * Get the string representation of the object
     *
     * @param o The object to represent
     * @return o.toString() or null if o is null
     */
    public static String get(Object o) {
        if (o != null) {
            return o.toString();
        } else {
            return null;
        }
    }

}
