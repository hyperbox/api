/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Max Dor
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

package io.kamax.hbox.comm.out;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ServerOutputTest {

    public static void validateSimple(ServerOut srvOut) {
        assertNotNull(srvOut);
        assertNotNull(srvOut.getId());
        assertFalse(srvOut.getId().isEmpty());
    }

    public static void validateFull(ServerOut srvOut) {
        assertNotNull(srvOut.getType());
        assertFalse(srvOut.getType().isEmpty());
        assertNotNull(srvOut.getVersion());
        assertFalse(srvOut.getVersion().isEmpty());
    }

}
