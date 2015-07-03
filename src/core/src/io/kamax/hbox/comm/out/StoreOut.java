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

import io.kamax.hbox.comm.io.StringSettingIO;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.StoreAttribute;

// TODO add getters/setters
public final class StoreOut extends ObjectOut {

   @SuppressWarnings("unused")
   private StoreOut() {
      // used for (de)serialisation
   }

   public StoreOut(String id, String label, String location) {
      super(EntityType.Store, id);
      setSetting(new StringSettingIO(StoreAttribute.Label, label));
      setSetting(new StringSettingIO(StoreAttribute.Location, location));
   }

   public String getLabel() {
      return getSetting(StoreAttribute.Label).getString();
   }

   public String getLocation() {
      return getSetting(StoreAttribute.Location).getString();
   }

   @Override
   public String toString() {
      return getLabel();
   }

}
