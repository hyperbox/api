/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2014 Max Dor
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

package io.kamax.tools.helper.sql;

import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class Warnings {

    public static String extract(Statement stmt) throws SQLException {
        return extract(stmt.getWarnings());
    }

    public static String extract(SQLWarning warning) {
        StringBuilder warnings = new StringBuilder();
        while (warning != null) {
            warnings.append(warning.getMessage()).append("\n");
            warning = warning.getNextWarning();
        }
        return warnings.toString();
    }

}
