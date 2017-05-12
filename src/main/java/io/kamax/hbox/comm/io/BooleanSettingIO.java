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

package io.kamax.hbox.comm.io;

/**
 * Helper class to implement a boolean type for the Setting Comm object
 *
 * @author max
 */
public final class BooleanSettingIO extends SettingIO {

    /**
     * Empty constructor for serialisation classes.<br/>
     * <ul>
     * <b>!! DO NOT USE !!</b>
     * </ul>
     */
    @SuppressWarnings("unused")
    private BooleanSettingIO() {

    }

    /**
     * Constructor for a new boolean setting, with the given name and value
     *
     * @param name  The name of this setting as Object
     * @param value The boolean value for this setting
     */
    public BooleanSettingIO(Object name, Boolean value) {
        super(name, value);
    }

    /**
     * Get the boolean value of this setting
     *
     * @return boolean value of this setting
     */
    public boolean getValue() {
        return (Boolean) getRawValue();
    }

    @Override
    public Boolean getBoolean() {
        return (Boolean) getRawValue();
    }

}
