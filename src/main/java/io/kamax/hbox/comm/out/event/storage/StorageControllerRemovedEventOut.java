/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2014 Max Dor
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

package io.kamax.hbox.comm.out.event.storage;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.hypervisor.MachineOut;
import io.kamax.hbox.comm.out.storage.StorageControllerOut;
import io.kamax.hbox.event.HyperboxEvents;

import java.util.Date;

public class StorageControllerRemovedEventOut extends StorageControllerEventOut {

    protected StorageControllerRemovedEventOut() {
        // Used for serialization
    }

    public StorageControllerRemovedEventOut(Date time, ServerOut srvOut, MachineOut vmOut, StorageControllerOut stoOut) {
        super(time, HyperboxEvents.StorageControllerRemoved, srvOut, vmOut, stoOut);
    }

}
