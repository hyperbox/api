/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * 
 * http://kamax.io/hbox/
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

import io.kamax.hbox.comm.out.storage.MediumOut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public final class MediumOutputTest {

    public static void validateSimple(MediumOut medOut) {
        assertFalse(medOut.getId().isEmpty());
        assertFalse(medOut.getUuid().isEmpty());
    }

    public static void validateFull(MediumOut medOut) {
        validateSimple(medOut);
        assertFalse(medOut.getLocation().isEmpty());
        // TODO add isBase()
        // assertFalse(medOut.getBaseUuid().isEmpty());
        assertNotNull(medOut.getLogicalSize());
        if (medOut.hasParent()) {
            // assertFalse(medOut.getParentUuid().isEmpty());
        } else {
            // assertTrue(medOut.getParentUuid().isEmpty());
        }
    }

}
