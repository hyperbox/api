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

package io.kamax.hbox.comm.in;

import io.kamax.hbox.comm.io.BooleanSettingIO;
import io.kamax.hbox.comm.io.SettingIO;
import io.kamax.hbox.comm.io.StringSettingIO;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.ModuleAttribute;
import java.util.List;

public class ModuleIn extends ObjectIn<EntityType> {

   public ModuleIn() {
      super(EntityType.Module);
   }

   public ModuleIn(String id) {
      super(EntityType.Module, id);
   }

   public ModuleIn(String id, List<SettingIO> settings) {
      super(EntityType.Module, id, settings);
   }

   public String getDescriptorFile() {
      return getSetting(ModuleAttribute.DescriptorFile).getString();
   }

   public void setDescriptorFile(String filePath) {
      setSetting(new StringSettingIO(ModuleAttribute.DescriptorFile, filePath));
   }

   public String getName() {
      return getSetting(ModuleAttribute.Name).getString();
   }

   public void setName(String name) {
      setSetting(new StringSettingIO(ModuleAttribute.Name, name));
   }

   public String getVersion() {
      return getSetting(ModuleAttribute.Version).getString();
   }

   public void setVersion(String version) {
      setSetting(new StringSettingIO(ModuleAttribute.Version, version));
   }

   public boolean isEnabled() {
      return getSetting(ModuleAttribute.isEnabled).getBoolean();
   }

   public void setEnabled(boolean isEnabled) {
      setSetting(new BooleanSettingIO(ModuleAttribute.isEnabled, isEnabled));
   }

   public boolean isLoaded() {
      return getSetting(ModuleAttribute.isLoaded).getBoolean();
   }

   public void setLoaded(boolean isLoaded) {
      setSetting(new BooleanSettingIO(ModuleAttribute.isLoaded, isLoaded));
   }

}
