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

package io.kamax.hbox.comm.out.event.machine;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.hypervisor.MachineOut;
import io.kamax.hbox.event.HyperboxEvents;

import java.util.Date;

public final class MachineRegistrationEventOut extends MachineEventOut {

    private Boolean isRegistered;

    @SuppressWarnings("unused")
    private MachineRegistrationEventOut() {
        // Used for serialization
    }

    public MachineRegistrationEventOut(Date time, ServerOut srvOut, MachineOut mOut, Boolean isRegistered) {
        super(time, HyperboxEvents.MachineRegistration, srvOut, mOut);
        this.isRegistered = isRegistered;
    }

    public Boolean isRegistered() {
        return isRegistered;
    }

    @Override
    public String toString() {
        return "Machine ID #" + getUuid() + " was " + (isRegistered() ? "registered" : "unregistered") + " @ " + getTime();
    }

}
