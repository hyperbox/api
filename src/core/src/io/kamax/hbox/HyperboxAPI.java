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

package io.kamax.hbox;

import io.kamax.tool.Version;
import io.kamax.tool.logging.Logger;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class HyperboxAPI {

   private static Properties buildProperties = new Properties();
   private static Version version;
   private static Version protocolVersion;

   private static void failedToLoad(Exception e) {
      version = Version.UNKNOWN;
      protocolVersion = Version.UNKNOWN;
      Logger.error("Unable to access or read the api.build.properties ressource: " + e.getMessage());
      Logger.error("API version and revision may not be accurate");
   }

   private static void invalidVersion(Version v) {
      Logger.error("Invalid API version in properties: " + v);
      Logger.error("Failing back to default version");
   }

   private static void loadVersions() {
      try {
         buildProperties.load(HyperboxAPI.class.getResourceAsStream("/api.build.properties"));

         Version rawVersion = new Version(buildProperties.getProperty("version"));
         if (rawVersion.isValid()) {
            version = rawVersion;
         } else {
            version = Version.UNKNOWN;
            invalidVersion(rawVersion);
         }

         Version rawProtocolVersion = new Version(buildProperties.getProperty("protocol"));
         if (rawProtocolVersion.isValid()) {
            protocolVersion = rawProtocolVersion;
         } else {
            protocolVersion = Version.UNKNOWN;
            ;
            invalidVersion(rawProtocolVersion);
         }
      } catch (IOException e) {
         failedToLoad(e);
      } catch (NullPointerException e) {
         failedToLoad(e);
      } catch (NumberFormatException e) {
         failedToLoad(e);
      }
   }

   public static Version getVersion() {
      if (version == null) {
         loadVersions();
      }

      return version;
   }

   public static Version getProtocolVersion() {
      if (protocolVersion == null) {
         loadVersions();
      }

      return protocolVersion;
   }

   public static void processArgs(Set<String> args) {
      if (args.contains("--apiversion")) {
         System.out.println(getVersion());
         System.exit(0);
      }
      if (args.contains("--netversion")) {
         System.out.println(HyperboxAPI.getProtocolVersion());
         System.exit(0);
      }
   }

   public static String getLogHeader(String fullVersion) {
      StringBuilder header = new StringBuilder();
      header.append("Hyperbox " + fullVersion);
      header.append(" - ");
      header.append("Java " + System.getProperty("java.version") + " " + System.getProperty("java.vm.name") + " "
            + System.getProperty("java.vm.version"));
      header.append(" - ");
      header.append(System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch"));
      return header.toString();
   }

}
