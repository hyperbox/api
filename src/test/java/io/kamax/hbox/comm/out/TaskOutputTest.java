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

import static org.junit.Assert.*;

public final class TaskOutputTest {

    public static void validateSimple(TaskOut tOut) {
        assertNotNull(tOut.getId());
        assertFalse(tOut.getId().isEmpty());
        assertNotNull(tOut.getState());
    }

    public static void validateFull(TaskOut tOut) {
        validateSimple(tOut);
        assertNotNull(tOut.getActionId());
        assertNotNull(tOut.getCreateTime());
        assertNotNull(tOut.getQueueTime());
        assertNotNull(tOut.getRequestId());
        assertNotNull(tOut.getStartTime());
        assertNotNull(tOut.getStopTime());
        assertNotNull(tOut.getUser());
    }

    public static void compareSimple(TaskOut tOut01, TaskOut tOut02) {
        assertTrue(tOut01.getId().contentEquals(tOut02.getId()));
    }

    public static void compareFull(TaskOut tOut01, TaskOut tOut02) {
        compareSimple(tOut01, tOut02);
    }

}
