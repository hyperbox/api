/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2014 Maxime Dor
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

package io.kamax.hbox.comm.out.event.service;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.ServiceOut;
import io.kamax.hbox.states.ServiceState;
import java.util.Date;

public class ServiceStateEventOut extends ServiceEventOut {

   protected ServiceStateEventOut() {
      // Used for (de)serialization
   }

   public ServiceStateEventOut(Date time, Enum<?> id, ServerOut srvOut, ServiceOut svcOut) {
      super(time, id, srvOut, svcOut);
   }

   public ServiceState getState() {
      return getService().getState();
   }

}
