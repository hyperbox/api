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

package io.kamax.hbox.kryonet;

import io.kamax.hbox.comm.Answer;
import io.kamax.hbox.comm.AnswerType;
import io.kamax.hbox.comm.Command;
import io.kamax.hbox.comm.Message;
import io.kamax.hbox.comm.Request;
import io.kamax.hbox.comm.in.Action;
import io.kamax.hbox.comm.in.MachineIn;
import io.kamax.hbox.comm.in.MediumIn;
import io.kamax.hbox.comm.in.NetworkAttachModeIn;
import io.kamax.hbox.comm.in.NetworkAttachNameIn;
import io.kamax.hbox.comm.in.NetworkInterfaceIn;
import io.kamax.hbox.comm.in.NetworkInterfaceTypeIn;
import io.kamax.hbox.comm.in.OsTypeIn;
import io.kamax.hbox.comm.in.ServerIn;
import io.kamax.hbox.comm.in.SessionIn;
import io.kamax.hbox.comm.in.SnapshotIn;
import io.kamax.hbox.comm.in.StorageControllerIn;
import io.kamax.hbox.comm.in.StorageControllerSubTypeIn;
import io.kamax.hbox.comm.in.StorageControllerTypeIn;
import io.kamax.hbox.comm.in.StorageDeviceAttachmentIn;
import io.kamax.hbox.comm.in.StoreIn;
import io.kamax.hbox.comm.in.StoreItemIn;
import io.kamax.hbox.comm.in.TaskIn;
import io.kamax.hbox.comm.in.UserIn;
import io.kamax.hbox.comm.io.BooleanSettingIO;
import io.kamax.hbox.comm.io.PositiveNumberSettingIO;
import io.kamax.hbox.comm.io.StringSettingIO;
import io.kamax.hbox.comm.out.ExceptionOut;
import io.kamax.hbox.comm.out.MachineMetricOut;
import io.kamax.hbox.comm.out.ServerOut;
import io.kamax.hbox.comm.out.SessionOut;
import io.kamax.hbox.comm.out.StoreItemOut;
import io.kamax.hbox.comm.out.StoreOut;
import io.kamax.hbox.comm.out.TaskOut;
import io.kamax.hbox.comm.out.event.UnknownEventOut;
import io.kamax.hbox.comm.out.event.machine.MachineDataChangeEventOut;
import io.kamax.hbox.comm.out.event.machine.MachineRegistrationEventOut;
import io.kamax.hbox.comm.out.event.machine.MachineStateEventOut;
import io.kamax.hbox.comm.out.event.session.SessionStateEventOut;
import io.kamax.hbox.comm.out.event.snapshot.SnapshotDeletedEventOut;
import io.kamax.hbox.comm.out.event.snapshot.SnapshotModifiedEventOut;
import io.kamax.hbox.comm.out.event.snapshot.SnapshotRestoredEventOut;
import io.kamax.hbox.comm.out.event.snapshot.SnapshotTakenEventOut;
import io.kamax.hbox.comm.out.event.system.SystemStateEventOut;
import io.kamax.hbox.comm.out.event.task.TaskQueueEventOut;
import io.kamax.hbox.comm.out.event.task.TaskStateEventOut;
import io.kamax.hbox.comm.out.hypervisor.MachineOut;
import io.kamax.hbox.comm.out.hypervisor.MachineSessionOut;
import io.kamax.hbox.comm.out.hypervisor.OsTypeOut;
import io.kamax.hbox.comm.out.hypervisor.SnapshotOut;
import io.kamax.hbox.comm.out.network.NetworkAttachModeOut;
import io.kamax.hbox.comm.out.network.NetworkAttachNameOut;
import io.kamax.hbox.comm.out.network.NetworkInterfaceOut;
import io.kamax.hbox.comm.out.network.NetworkInterfaceTypeOut;
import io.kamax.hbox.comm.out.security.UserOut;
import io.kamax.hbox.comm.out.storage.MediumOut;
import io.kamax.hbox.comm.out.storage.StorageControllerOut;
import io.kamax.hbox.comm.out.storage.StorageControllerSubTypeOut;
import io.kamax.hbox.comm.out.storage.StorageControllerTypeOut;
import io.kamax.hbox.comm.out.storage.StorageDeviceAttachmentOut;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.StorageControllerSubType;
import io.kamax.hbox.constant.StorageControllerType;
import io.kamax.hbox.constant.StoreAttribute;
import io.kamax.hbox.constant.StoreItemAttribute;
import io.kamax.hbox.states.ACPI;
import io.kamax.hbox.states.MachineSessionStates;
import io.kamax.hbox.states.MachineStates;
import io.kamax.hbox.states.ModuleState;
import io.kamax.hbox.states.ProgressTrackerState;
import io.kamax.hbox.states.ServerState;
import io.kamax.hbox.states.SessionStates;
import io.kamax.hbox.states.TaskQueueEvents;
import io.kamax.hbox.states.TaskState;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import com.esotericsoftware.kryo.Kryo;

/**
 * Used to register classes that will be sent through the channel.
 * 
 * @author max
 */
public class KryoRegister {

   public static void register(Kryo kryo) {
      kryo.setRegistrationRequired(false);
      /*
       * Register Java API classes
       */
      kryo.register(ArrayList.class);
      kryo.register(HashMap.class);
      kryo.register(HashSet.class);
      kryo.register(Date.class);

      /*
       * Register Hyperbox API communication classes
       */
      kryo.register(Message.class);
      kryo.register(Request.class);
      kryo.register(Answer.class);
      kryo.register(AnswerType.class);
      kryo.register(Command.class);
      kryo.register(Action.class);
      kryo.register(ExceptionOut.class);

      /*
       * Register Hyperbox API IO classes
       */
      kryo.register(StringSettingIO.class);
      kryo.register(BooleanSettingIO.class);
      kryo.register(PositiveNumberSettingIO.class);

      kryo.register(MachineIn.class);
      kryo.register(MachineOut.class);

      kryo.register(MachineMetricOut.class);

      kryo.register(MachineSessionOut.class);

      kryo.register(StoreIn.class);
      kryo.register(StoreOut.class);

      kryo.register(StoreItemIn.class);
      kryo.register(StoreItemOut.class);

      kryo.register(MediumIn.class);
      kryo.register(MediumOut.class);

      kryo.register(NetworkInterfaceIn.class);
      kryo.register(NetworkInterfaceOut.class);

      kryo.register(NetworkAttachModeIn.class);
      kryo.register(NetworkAttachModeOut.class);

      kryo.register(NetworkAttachNameIn.class);
      kryo.register(NetworkAttachNameOut.class);

      kryo.register(NetworkInterfaceTypeIn.class);
      kryo.register(NetworkInterfaceTypeOut.class);

      kryo.register(StorageControllerIn.class);
      kryo.register(StorageControllerOut.class);

      kryo.register(StorageControllerTypeIn.class);
      kryo.register(StorageControllerTypeOut.class);

      kryo.register(StorageControllerSubTypeIn.class);
      kryo.register(StorageControllerSubTypeOut.class);

      kryo.register(StorageDeviceAttachmentIn.class);
      kryo.register(StorageDeviceAttachmentOut.class);

      kryo.register(SnapshotIn.class);
      kryo.register(SnapshotOut.class);

      kryo.register(UserIn.class);
      kryo.register(UserOut.class);

      kryo.register(SessionOut.class);
      kryo.register(SessionIn.class);

      kryo.register(ServerIn.class);
      kryo.register(ServerOut.class);

      kryo.register(TaskIn.class);
      kryo.register(TaskOut.class);

      kryo.register(OsTypeIn.class);
      kryo.register(OsTypeOut.class);

      /*
       * Events
       */
      kryo.register(MachineDataChangeEventOut.class);
      kryo.register(MachineRegistrationEventOut.class);
      kryo.register(MachineStateEventOut.class);
      kryo.register(SessionStateEventOut.class);
      kryo.register(SnapshotModifiedEventOut.class);
      kryo.register(SnapshotDeletedEventOut.class);
      kryo.register(SnapshotRestoredEventOut.class);
      kryo.register(SnapshotTakenEventOut.class);
      kryo.register(SystemStateEventOut.class);
      kryo.register(TaskQueueEventOut.class);
      kryo.register(TaskStateEventOut.class);
      kryo.register(UnknownEventOut.class);

      /*
       * Register Hyperbox API business classes
       */
      kryo.register(ACPI.class);
      kryo.register(EntityType.class);
      kryo.register(MachineSessionStates.class);
      kryo.register(MachineStates.class);
      kryo.register(ModuleState.class);
      kryo.register(ProgressTrackerState.class);
      kryo.register(SessionStates.class);
      kryo.register(StoreAttribute.class);
      kryo.register(StoreItemAttribute.class);
      kryo.register(ServerState.class);
      kryo.register(TaskQueueEvents.class);
      kryo.register(TaskState.class);
      kryo.register(StorageControllerSubType.class);
      kryo.register(StorageControllerType.class);
   }

}
