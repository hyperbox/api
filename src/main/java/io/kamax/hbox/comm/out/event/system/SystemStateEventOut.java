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

package io.kamax.hbox.comm.out.event.system;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.event.EventOut;
import io.kamax.hbox.event.HyperboxEvents;
import io.kamax.hbox.states.ServerState;
import io.kamax.tools.TimeFormater;

import java.util.Date;

/**
 * Event message representing a change into the System state
 *
 * @author max
 */
public class SystemStateEventOut extends EventOut {

    private ServerState ss;

    /**
     * Used for serialisation, do not use!
     */
    @SuppressWarnings("unused")
    private SystemStateEventOut() {
        // Used for serialization
    }

    /**
     * Create a new System Event comm message with the given state.
     *
     * @param time   when the event occurred
     * @param srvOut The server it originated from
     * @param ss     The new SystemState
     */
    public SystemStateEventOut(Date time, ServerOut srvOut, ServerState ss) {
        super(time, HyperboxEvents.SystemState, srvOut);
        this.ss = ss;
    }

    /**
     * Get the system state stored in this event comm message.
     *
     * @return the system state at the time of creation of the message.
     */
    public ServerState getState() {
        return ss;
    }

    @Override
    public String toString() {
        return "Systeam state changed to " + ss + " @ " + TimeFormater.get(getTime());
    }

}
