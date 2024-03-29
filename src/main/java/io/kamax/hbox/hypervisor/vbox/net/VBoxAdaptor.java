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

package io.kamax.hbox.hypervisor.vbox.net;

import io.kamax.hbox.exception.HyperboxException;
import io.kamax.tools.logging.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VBoxAdaptor implements _NetAdaptor {

    private String id;
    private String label;
    private _NetMode mode;
    private boolean isEnabled;
    private Map<String, _NetService> services = new HashMap<String, _NetService>();

    public VBoxAdaptor(String id, String label, _NetMode mode, boolean isEnabled) {
        this(id, label, mode, isEnabled, new ArrayList<_NetService>());
    }

    public VBoxAdaptor(String id, String label, _NetMode mode, boolean isEnabled, List<_NetService> services) {
        this.id = id;
        this.label = label;
        this.mode = mode;
        this.isEnabled = isEnabled;
        for (_NetService service : services) {
            setService(service);
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        if (!mode.canRenameAdaptor()) {
            throw new HyperboxException("Cannot set label on interface type " + mode.getLabel());
        }

        Logger.warning("Renaming " + mode.getLabel() + " interface is not implemented");
    }

    @Override
    public _NetMode getMode() {
        return mode;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public List<_NetService> getServices() {
        return new ArrayList<_NetService>(services.values());
    }

    @Override
    public void setService(_NetService service) {
        if (mode.getSupportedServices().contains(service.getType())) {
            process(service);
            services.put(service.getType(), service);
        }
    }

    protected void process(_NetService service) {
        throw new HyperboxException("Service type " + service.getType() + " is not supported on " + getMode().getId() + " adaptor");
    }

    @Override
    public _NetService getService(String serviceTypeId) {
        throw new HyperboxException("Service type " + serviceTypeId + " is not supported on " + getMode().getId() + " adaptor");
    }

    protected void throwUnsupportedServiceType(String serviceTypeId) {
        throw new HyperboxException("Service type " + serviceTypeId + " is not supported on " + getMode().getId() + " adaptor");
    }

}
