/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Maxime Dor
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

package io.kamax.hbox.comm.out.event.net;

import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.event.EventOut;
import java.util.Date;

public abstract class NetAdaptorEventOut extends EventOut {

   private String hypId;
   private String netModeId;
   private String netAdaptorId;

   protected NetAdaptorEventOut() {
      // Used for (de)serialization
   }

   public NetAdaptorEventOut(Date time, Enum<?> id, ServerOut srvOut, String hypId, String netModeId, String netAdaptorId) {
      super(time, id, srvOut);
      this.hypId = hypId;
      this.netModeId = netModeId;
      this.netAdaptorId = netAdaptorId;
   }

   public String getHypervisor() {
      return hypId;
   }

   public String getNetMode() {
      return netModeId;
   }

   public String getNetAdaptor() {
      return netAdaptorId;
   }

}
