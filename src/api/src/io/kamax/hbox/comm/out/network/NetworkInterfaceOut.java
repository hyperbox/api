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

package io.kamax.hbox.comm.out.network;

import io.kamax.hbox.comm.io.SettingIO;
import io.kamax.hbox.comm.out.ObjectOut;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.NetworkInterfaceAttribute;
import java.util.List;

public final class NetworkInterfaceOut extends ObjectOut {

   private long nicId;

   @SuppressWarnings("unused")
   private NetworkInterfaceOut() {
      // stub
   }

   public NetworkInterfaceOut(Long nicId, List<SettingIO> settings) {
      super(EntityType.NetworkInterace, nicId.toString(), settings);
      this.nicId = nicId;
   }

   public long getNicId() {
      return nicId;
   }

   public boolean isEnabled() {
      return getSetting(NetworkInterfaceAttribute.Enabled).getBoolean();
   }

   public boolean isCableConnected() {
      return getSetting(NetworkInterfaceAttribute.CableConnected).getBoolean();
   }

   public String getAttachMode() {
      return getSetting(NetworkInterfaceAttribute.AttachMode).getString();
   }

   public String getAttachName() {
      return getSetting(NetworkInterfaceAttribute.AttachName).getString();
   }

   public String getAdapterType() {
      return getSetting(NetworkInterfaceAttribute.AdapterType).getString();
   }

   public String getMacAddress() {
      return getSetting(NetworkInterfaceAttribute.MacAddress).getString();
   }

}
