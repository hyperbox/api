/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2021 Max Dor
 *
 * https://apps.kamax.io/hyperbox
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.tools.logging;

import io.kamax.hbox.HyperboxAPI;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KxLog {

    public static final String logPrefix = "[app]";

    private static final String rootPkg = HyperboxAPI.class.getPackage().getName();

    public static Logger make(Class<?> c) {
        String name = c.getCanonicalName();
        if (name.startsWith(rootPkg)) {
            name = StringUtils.replace(name, rootPkg, logPrefix, 1);
        }
        return LoggerFactory.getLogger(name);
    }

}
