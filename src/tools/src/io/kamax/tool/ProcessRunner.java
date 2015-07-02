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

package io.kamax.tool;

import java.io.IOException;

public class ProcessRunner {

   private String[] args;
   private Process p;
   private int rc = Integer.MAX_VALUE;
   private String stdOut;
   private String stdErr;

   public static void runHeadless(Process p) {
      new StreamDumper(p.getInputStream()).start();
      new StreamDumper(p.getErrorStream()).start();
   }

   public static ProcessRunner runAndWait(String[] args) {
      return new ProcessRunner(args).runSync();
   }

   public ProcessRunner(String[] args) {
      this.args = args;
   }

   public ProcessRunner runSync() {
      try {
         p = new ProcessBuilder(args).start();
      } catch (IOException e) {
         throw new RuntimeException("Unable to build process", e);
      }

      StreamReader srOut = new StreamReader(p.getInputStream());
      StreamReader srErr = new StreamReader(p.getErrorStream());
      srOut.start();
      srErr.start();

      try {
         rc = p.waitFor();
      } catch (InterruptedException e) {
         rc = Integer.MIN_VALUE;
      } finally {
         stdOut = srOut.getData();
         stdErr = srErr.getData();
      }

      return this;
   }

   public String getStdErr() {
      return stdErr;
   }

   public String getStdOut() {
      return stdOut;
   }

   /**
    * Get the process return code
    * 
    * @return process return code or Integer.MAX_VALUE if failed to create and start process or Integer.MIN_VALUE if Interrupted
    */
   public int getRc() {
      return rc;
   }

}
