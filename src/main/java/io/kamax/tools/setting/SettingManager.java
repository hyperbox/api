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

package io.kamax.tools.setting;

import java.util.*;

public class SettingManager {

    private Map<String, _Setting> settingMap = new HashMap<String, _Setting>();

    public List<_Setting> list() {
        return new ArrayList<_Setting>(settingMap.values());
    }

    public boolean has(String settingName) {
        return settingMap.containsKey(settingName);
    }

    public boolean has(Enum<?> settingEnum) {
        return settingMap.containsKey(settingEnum.toString());
    }

    public _Setting get(String settingName) {

        return settingMap.get(settingName);
    }

    public _Setting get(Enum<?> settingEnum) {

        return settingMap.get(settingEnum.toString());
    }

    public void set(List<_Setting> settings) {
        for (_Setting setting : settings) {
            set(setting);
        }
    }

    public void set(_Setting setting) {

        settingMap.put(setting.getName(), setting);
    }

    public void unset(String id) {
        unset(Arrays.asList(id));
    }

    public void unset(List<String> ids) {
        for (String id : ids) {
            settingMap.remove(id);
        }
    }

}
