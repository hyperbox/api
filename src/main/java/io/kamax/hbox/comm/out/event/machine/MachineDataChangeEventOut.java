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

package io.kamax.hbox.comm.out.event.machine;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.hypervisor.MachineOut;
import io.kamax.hbox.event.HyperboxEvents;

import java.util.Date;

public final class MachineDataChangeEventOut extends MachineEventOut {

    @SuppressWarnings("unused")
    private MachineDataChangeEventOut() {
        // Used for serialization
    }

    public MachineDataChangeEventOut(Date time, ServerOut srvOut, MachineOut mOut) {
        super(time, HyperboxEvents.MachineDataChange, srvOut, mOut);
    }

    @Override
    public String toString() {
        return "Data changed for Machine ID #" + getUuid() + " on Server ID " + getServerId() + " @ " + getTime();
    }

}
