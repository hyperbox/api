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

import io.kamax.hbox.comm.out.hypervisor.OsTypeOut;

import static org.junit.Assert.*;

public final class OsTypeOutputTest {

    public static void validateSimple(OsTypeOut osOut) {
        assertFalse(osOut.getId().isEmpty());
        assertFalse(osOut.getName().isEmpty());
        assertNotNull(osOut.getBitness());
    }

    public static void validateFull(OsTypeOut osOut) {
        validateSimple(osOut);
    }

    public static void compareSimple(OsTypeOut osOut01, OsTypeOut osOut02) {
        assertTrue(osOut01.getId().contentEquals(osOut02.getId()));
        assertTrue(osOut01.getName().contentEquals(osOut02.getName()));
        assertTrue(osOut01.getBitness() == osOut02.getBitness());
    }

    public static void compareFull(OsTypeOut osOut01, OsTypeOut osOut02) {
        compareSimple(osOut01, osOut02);
    }

}
