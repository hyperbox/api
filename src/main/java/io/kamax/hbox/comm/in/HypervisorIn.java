/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Max Dor
 * hyperbox at altherian dot org
 *
 * https://apps.kamax.io/hyperbox
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.hbox.comm.in;

import io.kamax.hbox.comm.io.BooleanSettingIO;
import io.kamax.hbox.comm.io.StringSettingIO;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.HypervisorAttribute;

public class HypervisorIn extends ObjectIn<EntityType> {

    public HypervisorIn() {
        super(EntityType.Hypervisor);
    }

    public HypervisorIn(String id) {
        super(EntityType.Hypervisor, id);
    }

    public String getConnectOptions() {
        return getSetting(HypervisorAttribute.ConnectorOptions).getString();
    }

    public void setConnectionOptions(String options) {
        setSetting(new StringSettingIO(HypervisorAttribute.ConnectorOptions, options));
    }

    public Boolean getAutoConnect() {
        return getSetting(HypervisorAttribute.ConnectorAuto).getBoolean();
    }

    public void setAutoConnect(Boolean auto) {
        setSetting(new BooleanSettingIO(HypervisorAttribute.ConnectorAuto, auto));
    }

}
