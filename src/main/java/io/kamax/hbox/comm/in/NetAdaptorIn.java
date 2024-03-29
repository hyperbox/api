/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Max Dor
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

package io.kamax.hbox.comm.in;

import io.kamax.hbox.comm.io.NetServiceIO;
import io.kamax.hbox.constant.EntityType;

import java.util.ArrayList;
import java.util.List;

public class NetAdaptorIn extends ObjectIn<EntityType> {

    private String label;
    private String modeId;
    private List<NetServiceIO> services = new ArrayList<NetServiceIO>();

    public NetAdaptorIn() {
        super(EntityType.NetAdaptor);
    }

    public NetAdaptorIn(String modeId, String id) {
        this();
        setId(id);
        setModeId(modeId);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getModeId() {
        return modeId;
    }

    public void setModeId(String modeId) {
        this.modeId = modeId;
    }

    public List<NetServiceIO> getServices() {
        return services;
    }

    public void setServices(List<NetServiceIO> services) {
        this.services = services;
    }

    public void setService(NetServiceIO service) {
        services.add(service);
    }

}
