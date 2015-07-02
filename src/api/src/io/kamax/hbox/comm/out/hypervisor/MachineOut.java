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

package io.kamax.hbox.comm.out.hypervisor;

import io.kamax.hbox.comm.io.SettingIO;
import io.kamax.hbox.comm.out.ObjectOut;
import io.kamax.hbox.comm.out.network.NetworkInterfaceOut;
import io.kamax.hbox.comm.out.storage.StorageControllerOut;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.MachineAttribute;
import io.kamax.hbox.exception.HyperboxException;
import io.kamax.hbox.states.MachineStates;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MachineOut extends ObjectOut {

   private String serverId;
   private String uuid;
   private boolean isAvailable = true;
   private String state;
   private Map<Long, NetworkInterfaceOut> nics = new HashMap<Long, NetworkInterfaceOut>();
   private Map<String, StorageControllerOut> strCtrs = new HashMap<String, StorageControllerOut>();

   @SuppressWarnings("unused")
   private MachineOut() {
      // Used for serialization
   }

   public MachineOut(String serverId, String uuid, MachineStates state, List<SettingIO> settings, List<StorageControllerOut> scList,
         List<NetworkInterfaceOut> nicList) {
      this(serverId, uuid, settings);
      if (state == null) {
         throw new HyperboxException("State cannot be null or empty");
      }
      this.state = state.getId();
      for (StorageControllerOut scOut : scList) {
         strCtrs.put(scOut.getId(), scOut);
      }
      for (NetworkInterfaceOut nicOut : nicList) {
         nics.put(nicOut.getNicId(), nicOut);
      }
   }

   public MachineOut(String serverId, String uuid, String state, List<SettingIO> settings) {
      this(serverId, uuid, settings);
      if (state == null) {
         throw new HyperboxException("State cannot be null or empty");
      }
      this.state = state;
   }

   private MachineOut(String serverId, String uuid, List<SettingIO> settings) {
      super(EntityType.Machine, uuid, settings);
      this.uuid = uuid;
      this.serverId = serverId;
   }

   public MachineOut(String serverId, String uuid, String state, boolean isAvailable) {
      this(serverId, uuid);
      this.isAvailable = isAvailable;
   }

   /**
    * Build a machine message with the given UUID.
    * 
    * @param serverId The server to which this VM belongs to
    * @param uuid The UUID of the machine to send data about.
    */
   public MachineOut(String serverId, String uuid) {
      super(EntityType.Machine, uuid);
      this.uuid = uuid;
      this.serverId = serverId;
   }

   public String getServerId() {
      return serverId;
   }

   /**
    * Get the UUID for this machine
    * 
    * @return a String for this UUID
    */
   public String getUuid() {
      return uuid;
   }

   public boolean isAvailable() {
      return isAvailable;
   }

   /**
    * Get the machine state
    * 
    * @return a String representing the machine state
    * @see MachineStates
    */
   public String getState() {
      return state;
   }

   /**
    * Get the machine name.<br/>
    * Helper method that gets the setting name and return its value.
    * 
    * @return a String containing the name
    */
   public String getName() {
      if (hasSetting(MachineAttribute.Name)) {
         return getSetting(MachineAttribute.Name).getString();
      } else {
         return uuid;
      }
   }

   public Boolean hasSnapshots() {
      return hasSetting(MachineAttribute.HasSnapshot) && getSetting(MachineAttribute.HasSnapshot).getBoolean();
   }

   public String getCurrentSnapshot() {
      return getSetting(MachineAttribute.CurrentSnapshotUuid).getString();
   }

   public List<StorageControllerOut> listStorageController() {
      List<StorageControllerOut> scList = new ArrayList<StorageControllerOut>(strCtrs.values());
      return scList;
   }

   public StorageControllerOut getStorageController(String id) {
      return strCtrs.get(id);
   }

   public List<NetworkInterfaceOut> listNetworkInterface() {
      return new ArrayList<NetworkInterfaceOut>(nics.values());
   }

   @Override
   public String toString() {
      return getName();
   }

}
