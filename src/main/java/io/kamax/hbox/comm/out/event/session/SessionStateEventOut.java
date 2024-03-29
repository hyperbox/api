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

package io.kamax.hbox.comm.out.event.session;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.SessionOut;
import io.kamax.hbox.comm.out.event.EventOut;
import io.kamax.hbox.event.HyperboxEvents;
import io.kamax.hbox.states.SessionStates;

import java.util.Date;

public final class SessionStateEventOut extends EventOut {

    private SessionStates state;

    @SuppressWarnings("unused")
    private SessionStateEventOut() {
        // Used for serialization
    }

    public SessionStateEventOut(Date time, ServerOut srvOut, SessionOut sOut, SessionStates state) {
        super(time, HyperboxEvents.SessionState, srvOut);
        set(SessionOut.class, sOut);
        this.state = state;
    }

    public SessionStates getState() {
        return state;
    }

    public SessionOut getSession() {
        return get(SessionOut.class);
    }

    public String getSesionId() {
        return getSession().getId();
    }

    @Override
    public String toString() {
        return "Session ID #" + getSesionId() + " | State changed to " + getState() + " @ " + getTime();
    }

}
