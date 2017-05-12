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

package io.kamax.hbox.comm.out;

import io.kamax.hbox.comm.io.SettingIO;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.ModuleAttribute;

import java.util.Collection;

public class ModuleOut extends ObjectOut {

    protected ModuleOut() {
        // used for (de)serialisation
    }

    public ModuleOut(String id) {
        super(EntityType.Module, id);
    }

    public ModuleOut(String id, Collection<SettingIO> settings) {
        super(EntityType.Module, id, settings);
    }

    public String getDescriptorFile() {
        return getSetting(ModuleAttribute.DescriptorFile).getString();
    }

    public String getName() {
        return getSetting(ModuleAttribute.Name).getString();
    }

    public String getVersion() {
        return getSetting(ModuleAttribute.Version).getString();
    }

    public boolean isLoaded() {
        return getSetting(ModuleAttribute.isLoaded).getBoolean();
    }

    @Override
    public String toString() {
        return "Module ID " + getId() + " (" + getName() + ")";
    }

}
