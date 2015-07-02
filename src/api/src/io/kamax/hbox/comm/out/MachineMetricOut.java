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

import java.util.Date;

public class MachineMetricOut extends ObjectOut {

   private String machineUuid;
   private Date time;
   private double value;

   @SuppressWarnings("unused")
   private MachineMetricOut() {
      // used for (de)serialisation
   }

   public MachineMetricOut(String machineUuid, Date time, double value) {
      this.machineUuid = machineUuid;
      this.time = time;
      this.value = value;
   }

   /**
    * @return the machineUuid
    */
   public String getMachineUuid() {
      return machineUuid;
   }

   /**
    * @return the time
    */
   public Date getTime() {
      return time;
   }

   /**
    * @return the value
    */
   public double getValue() {
      return value;
   }

}
