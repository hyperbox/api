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

package io.kamax.hbox.constant;

public enum EntityType {

    Attribute,
    Audio,
    Backend,
    Connector,
    Console,
    CPU,
    Device,
    DHCPServer,
    DiskDrive,
    Display,
    DVD,
    DvdDrive,
    Floppy,
    FloppyDrive,
    Guest,
    GuestNetworkInterface,
    HardDisk,
    Host,
    Hyperbox,
    Hypervisor,
    Keyboard,
    Machine,
    Medium,
    Memory,
    Module,
    Motherboard,
    Mouse,
    Network,
    NetworkAttachMode,
    NetworkAttachName,
    NetworkInterace,
    NetworkInterfaceType,
    NetMode,
    NetAdaptor,
    NetService,
    NetServiceType,
    OsType,
    Permission,
    ProgressTracker,
    Screenshot,
    Server,
    Service,
    Session,
    SharedFolder,
    Snapshot,
    StorageAttachment,
    StorageController,
    StorageControllerType,
    StorageControllerSubType,
    Store,
    StoreItem,
    Task,
    USB,
    User,

    Unknown;

    public String getId() {
        return toString();
    }

    public boolean match(String id) {
        return getId().contentEquals(id);
    }

}
