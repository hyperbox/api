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

import io.kamax.hbox.constant.StoreItemAttribute;

import static org.junit.Assert.*;

public class StoreItemOutputTest {

    public static void validateFull(StoreItemOut siOut) {
        validateSimple(siOut);
    }

    public static void validateSimple(StoreItemOut siOut) {
        assertNotNull(siOut);

        assertTrue(siOut.hasSetting(StoreItemAttribute.Name));
        assertNotNull(siOut.getSetting(StoreItemAttribute.Name).getString());
        assertFalse(siOut.getSetting(StoreItemAttribute.Name).getString().isEmpty());

        assertTrue(siOut.hasSetting(StoreItemAttribute.Path));
        assertNotNull(siOut.getSetting(StoreItemAttribute.Path).getString());
        assertFalse(siOut.getSetting(StoreItemAttribute.Path).getString().isEmpty());

        assertTrue(siOut.hasSetting(StoreItemAttribute.Size));
        assertNotNull(siOut.getSetting(StoreItemAttribute.Size).getNumber());

        assertTrue(siOut.hasSetting(StoreItemAttribute.IsContainer));
        assertNotNull(siOut.getSetting(StoreItemAttribute.IsContainer).getBoolean());
    }

}
