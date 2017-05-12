/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Maxime Dor
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

package io.kamax.hbox.comm.out.network;

import io.kamax.hbox.comm.out.ObjectOut;
import io.kamax.hbox.constant.EntityType;

public class NetAdaptorOut extends ObjectOut {

    private String label;
    private String modeId;
    private boolean isEnabled;
    private boolean hasServices;

    protected NetAdaptorOut() {
        // Serialization
    }

    public NetAdaptorOut(String id, String label, String modeId, boolean isEnabled, boolean hasServices) {
        super(EntityType.NetAdaptor, id);
        this.label = label;
        this.modeId = modeId;
        this.isEnabled = isEnabled;
        this.hasServices = hasServices;
    }

    public String getLabel() {
        return label;
    }

    public String getMode() {
        return modeId;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public boolean hasServices() {
        return hasServices;
    }

}
