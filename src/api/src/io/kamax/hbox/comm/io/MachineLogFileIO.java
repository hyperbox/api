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

package io.kamax.hbox.comm.io;

import io.kamax.hbox.hypervisor._MachineLogFile;
import java.util.ArrayList;
import java.util.List;

public class MachineLogFileIO implements _MachineLogFile {

   private String id;
   private String filename;
   private List<String> log;

   @Override
   public String getId() {
      return id;
   }

   @Override
   public List<String> getLog() {
      return log;
   }

   @Override
   public String getFileName() {
      return filename;
   }

   protected MachineLogFileIO() {
      // only for serialization
   }

   public MachineLogFileIO(String id, String filename, List<String> log) {
      this.id = id;
      this.log = new ArrayList<String>(log);
      this.filename = filename;
   }

   public MachineLogFileIO(String id) {
      this.id = id;
   }

}
