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

package io.kamax.hbox.comm.io.factory;

import io.kamax.hbox.comm.in.Action;
import io.kamax.hbox.comm.in.StorageControllerIn;
import io.kamax.hbox.comm.out.storage.StorageControllerOut;

public final class StorageControllerIoFactory {

   public static String getId(String machineUuid, String name) {
      return machineUuid + "|" + name;
   }

   /**
    * Create the equivalent in an Input object of this Storage Controller output object. The input object will have its {@link Action} set to
    * {@link Action#Modify}
    * 
    * @param scOut The Storage Controller output object to transform
    * @return an input Storage Controller object labelled as {@link Action#Modify}
    * @see StorageControllerIn
    * @see StorageControllerOut
    * @see Action
    */
   public static StorageControllerIn get(StorageControllerOut scOut) {
      StorageControllerIn scIn = new StorageControllerIn(scOut.getMachineUuid(), scOut.getName(), scOut.getType(), scOut.listSettings());
      scIn.setAction(Action.Modify);
      return scIn;
   }

}
