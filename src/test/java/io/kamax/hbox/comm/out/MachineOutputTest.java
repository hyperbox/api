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

import io.kamax.hbox.comm.io.SettingIO;
import io.kamax.hbox.comm.out.hypervisor.MachineOut;
import io.kamax.hbox.comm.out.storage.StorageControllerOut;

import java.util.Collection;

import static org.junit.Assert.*;

public class MachineOutputTest {

    private MachineOutputTest() {
        // not used
    }

    public static void validateFull(MachineOut mOut) {
        validateSimple(mOut);
        for (String settingName : mOut.listSettingsId()) {
            assertNotNull(settingName);
            SettingIO setting = mOut.getSetting(settingName);
            assertNotNull(setting);
            assertNotNull(setting.getName());
            assertNotNull(setting.getRawValue());
        }
        for (StorageControllerOut scOut : mOut.listStorageController()) {
            StorageControllerOutputTest.validateSimple(scOut);
        }
    }

    public static void validateSimple(MachineOut mOut) {
        assertNotNull(mOut);
        assertNotNull(mOut.getUuid());
        assertFalse(mOut.getUuid().isEmpty());
        assertNotNull(mOut.getName());
        assertFalse(mOut.getName().isEmpty());
        assertNotNull(mOut.getState());
        assertFalse(mOut.getState().isEmpty());
    }

    public static void validateList(Collection<MachineOut> mOutList) {
        for (MachineOut mOut : mOutList) {
            validateSimple(mOut);
        }
    }

    public static void compareSimple(MachineOut mOut1, MachineOut mOut2) {
        assertTrue(mOut1.getUuid().contentEquals(mOut2.getUuid()));
        assertTrue(mOut1.getName().contentEquals(mOut2.getName()));
        assertTrue(mOut1.getState().contentEquals(mOut2.getState()));
    }

    public static void compareFull(MachineOut mOut1, MachineOut mOut2) {
        compareSimple(mOut1, mOut2);

        assertTrue(mOut1.listSettingsId().size() == mOut2.listSettingsId().size());

        for (String settingName : mOut1.listSettingsId()) {
            mOut2.getSetting(settingName).getName().contentEquals(mOut1.getSetting(settingName).getName());
        }

        for (String settingName : mOut2.listSettingsId()) {
            mOut1.getSetting(settingName).getName().contentEquals(mOut2.getSetting(settingName).getName());
        }
    }

}
