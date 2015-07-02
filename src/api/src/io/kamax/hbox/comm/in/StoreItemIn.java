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

package io.kamax.hbox.comm.in;

import io.kamax.hbox.comm.io.StringSettingIO;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.StoreItemAttribute;

// TODO add getters/setters
public final class StoreItemIn extends ObjectIn<EntityType> {

   public StoreItemIn() {
      super(EntityType.StoreItem, "-1");
   }

   public StoreItemIn(String path) {
      this();
      setSetting(new StringSettingIO(StoreItemAttribute.Path, path));
   }

   public StoreItemIn(String name, String path) {
      this(path);
      setSetting(new StringSettingIO(StoreItemAttribute.Name, name));
   }

   public String getName() {
      return getSetting(StoreItemAttribute.Name).getString();
   }

   public String getPath() {
      if (hasSetting(StoreItemAttribute.Path)) {
         return getSetting(StoreItemAttribute.Path).getString();
      } else {
         return "";
      }
   }

}
