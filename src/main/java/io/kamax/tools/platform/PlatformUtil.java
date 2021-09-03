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

package io.kamax.tools.platform;

import org.apache.commons.lang3.SystemUtils;

import java.util.Date;

public class PlatformUtil {

    public static Date getBootTime() {
        // System.out.println(ProcessRunner.runAndWait(new String[] { "wmic", "os", "get", "lastbootuptime" }).getStdOut());
        throw new RuntimeException("PlatformUtil::getBootTime() Not implemented");
    }

    /**
     * Return one of the given parameters depending on the current platform
     *
     * @param onWin value to be returned if Platform is Windows
     * @param other value to be returned for other platforms
     * @return String
     */
    public static String getString(String onLinux, String other) {
        if (SystemUtils.IS_OS_LINUX) {
            return onLinux;
        } else {
            return other;
        }
    }

    /**
     * Return one of the given parameters depending on the current platform
     *
     * @param onLinux value to be returned if Platform is Linux
     * @param onWin   value to be returned if Platform is Windows
     * @param others  value to be returned for other platforms
     * @return String
     */
    public static String getString(String onLinux, String onWin, String others) {
        if (SystemUtils.IS_OS_WINDOWS) {
            return onWin;
        } else {
            return getString(onLinux, others);
        }
    }

}
