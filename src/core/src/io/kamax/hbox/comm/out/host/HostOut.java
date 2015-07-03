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

package io.kamax.hbox.comm.out.host;

import io.kamax.hbox.comm.io.SettingIO;
import io.kamax.hbox.comm.out.ObjectOut;
import io.kamax.hbox.constant.HostAttribute;
import java.util.Collection;

public class HostOut extends ObjectOut {

   @SuppressWarnings("unused")
   private HostOut() {
      // Used for serialization
   }

   public HostOut(Collection<SettingIO> sIoList) {
      setSetting(sIoList);
   }

   public String getHostname() {
      return getSetting(HostAttribute.Hostname).getString();
   }

   public String getOSName() {
      return getSetting(HostAttribute.OperatingSystemName).getString();
   }

   public String getOSVersion() {
      return getSetting(HostAttribute.OperatingSystemVersion).getString();
   }

   public Long getMemorySize() {
      return getSetting(HostAttribute.MemoryTotal).getNumber();
   }

   public Long getMemoryAvailable() {
      return getSetting(HostAttribute.MemoryAvailable).getNumber();
   }

}
