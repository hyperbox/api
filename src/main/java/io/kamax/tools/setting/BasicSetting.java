/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Max Dor
 *
 * https://apps.kamax.io/hyperbox
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

public abstract class BasicSetting<T> implements _Setting {

    private String name;
    private T value;

    public BasicSetting(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public BasicSetting(Enum<?> setting, T value) {
        this(setting.toString(), value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public Boolean getBoolean() {
        return ((getString().compareToIgnoreCase("yes") == 0) ||
                (getString().compareToIgnoreCase("1") == 0) || (getString().compareToIgnoreCase("true") == 0));
    }

    @Override
    public Long getNumber() {
        return Long.parseLong(getString());
    }

    @Override
    public String getString() {
        return getValue().toString();
    }

}
