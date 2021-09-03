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

package io.kamax.hbox.comm.out.event.server;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.event.HyperboxEvents;
import io.kamax.hbox.states.ServerConnectionState;

import java.util.Date;

public class ServerConnectionStateEventOut extends ServerEventOut {

    private ServerConnectionState state;

    @SuppressWarnings("unused")
    private ServerConnectionStateEventOut() {
        // Used for serialization
    }

    public ServerConnectionStateEventOut(Date time, ServerOut srvOut, ServerConnectionState state) {
        super(time, HyperboxEvents.ServerConnectionState, srvOut);
        this.state = state;
    }

    public ServerConnectionState getState() {
        return state;
    }

}
