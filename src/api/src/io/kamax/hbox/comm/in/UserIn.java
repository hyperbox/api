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

package io.kamax.hbox.comm.in;

import io.kamax.hbox.comm.out.security.UserOut;
import io.kamax.hbox.constant.EntityType;
import java.util.HashSet;
import java.util.Set;

public final class UserIn extends ObjectIn<EntityType> {

   private String domain;
   private String username;
   private char[] password;
   private Set<PermissionIn> perms = new HashSet<PermissionIn>();

   public UserIn() {
      super(EntityType.User);
   }

   public UserIn(String id) {
      super(EntityType.User, id);
   }

   public UserIn(UserOut usrOut) {
      this(usrOut.getId());
   }

   public UserIn(String username, char[] password) {
      this("", username, password);
   }

   public UserIn(String domain, String username, char[] password) {
      this();
      setDomain(domain);
      setUsername(username);
      setPassword(password);
   }

   /**
    * @return the domain
    */
   public String getDomain() {
      return domain;
   }

   /**
    * @param domain the domain to set
    */
   public void setDomain(String domain) {
      this.domain = domain;
   }

   /**
    * @return the username
    */
   public String getUsername() {
      return username;
   }

   /**
    * @param username the username to set
    */
   public void setUsername(String username) {
      this.username = username;
   }

   /**
    * @return the password
    */
   public char[] getPassword() {
      return password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(char[] password) {
      this.password = password;
   }

   public void addPermission(PermissionIn permIn) {
      perms.add(permIn);
   }

   public void removePermission(PermissionIn permIn) {
      perms.remove(permIn);
   }

}
