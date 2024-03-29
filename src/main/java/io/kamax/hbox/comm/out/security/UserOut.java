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

package io.kamax.hbox.comm.out.security;

import io.kamax.hbox.comm.io.StringSettingIO;
import io.kamax.hbox.comm.out.ObjectOut;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.constant.UserAttribute;

public class UserOut extends ObjectOut {

    protected UserOut() {
        // used for (de)serialisation
    }

    public UserOut(String id, String username, String domain) {
        super(EntityType.User, id);
        setSetting(new StringSettingIO(UserAttribute.Username, username));
        setSetting(new StringSettingIO(UserAttribute.Domain, domain));
    }

    public String getUsername() {
        return getSetting(UserAttribute.Username).getString();
    }

    public String getDomain() {
        return getSetting(UserAttribute.Domain).getString();
    }

    public String getDomainLogonName() {
        if (getDomain() != null) {
            return getDomain() + "\\" + getUsername();
        } else {
            return getUsername();
        }
    }

}
