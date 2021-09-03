/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Max Dor
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

package io.kamax.hbox.hypervisor.vbox;

public class VBoxPlatformUtil {

    public static String getInstallPathWin() {
        if (System.getenv("VBOX_INSTALL_PATH") != null) {
            return System.getenv("VBOX_INSTALL_PATH");
        } else if (System.getenv("VBOX_MSI_INSTALL_PATH") != null) {
            return System.getenv("VBOX_MSI_INSTALL_PATH");
        } else {
            return "C:\\Program Files\\Oracle\\VirtualBox";
        }
    }

}
