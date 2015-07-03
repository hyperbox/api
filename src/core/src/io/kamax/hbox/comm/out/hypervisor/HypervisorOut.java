/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * hyperbox at altherian dot org
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
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.HypervisorAttribute;
import java.util.List;

public class HypervisorOut extends ObjectOut {

   protected HypervisorOut() {
      // Used for serialization
   }

   public HypervisorOut(String id) {
      super(EntityType.Hypervisor, id);
   }

   public HypervisorOut(String id, List<SettingIO> settings) {
      super(EntityType.Hypervisor, id, settings);
   }

   public String getType() {
      return getSetting(HypervisorAttribute.Type).getString();
   }

   public String getVendor() {
      return getSetting(HypervisorAttribute.Vendor).getString();
   }

   public String getProduct() {
      return getSetting(HypervisorAttribute.Product).getString();
   }

   public String getVersion() {
      return getSetting(HypervisorAttribute.Version).getString();
   }

   public String getRevision() {
      return getSetting(HypervisorAttribute.Revision).getString();
   }

}
