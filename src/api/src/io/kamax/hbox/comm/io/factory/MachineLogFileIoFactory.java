package io.kamax.hbox.comm.io.factory;

import io.kamax.hbox.comm.io.MachineLogFileIO;
import io.kamax.hbox.hypervisor._MachineLogFile;

public class MachineLogFileIoFactory {

   private MachineLogFileIoFactory() {
      // only static
   }

   public static MachineLogFileIO get(String logId) {
      return new MachineLogFileIO(logId);
   }

   public static MachineLogFileIO get(_MachineLogFile log) {
      return new MachineLogFileIO(log.getId(), log.getFileName(), log.getLog());
   }

}
