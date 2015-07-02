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

package io.kamax.hbox.comm.out.event.task;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.TaskOut;
import io.kamax.hbox.event.HyperboxEvents;
import io.kamax.hbox.states.TaskState;
import java.util.Date;

public class TaskStateEventOut extends TaskEventOut {

   @SuppressWarnings("unused")
   private TaskStateEventOut() {
      // Used for serialization
   }

   public TaskStateEventOut(Date time, ServerOut srvOut, TaskOut tOut) {
      super(time, HyperboxEvents.TaskState, srvOut, tOut);
   }

   public TaskState getState() {
      return getTask().getState();
   }

   @Override
   public String toString() {
      return "Task ID #" + getTaskId() + " state changed to " + getState() + " @ " + getTime();
   }

}
