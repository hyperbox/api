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

package io.kamax.tools;

public class FileSizeNumber {

    private long byteSize;
    private long humanSize;
    private String humanUnit;

    public FileSizeNumber(long byteSize) {
        this.byteSize = byteSize;
        evaluate();
    }

    public FileSizeNumber(String byteSize) {
        this(Long.parseLong(byteSize));
    }

    private void evaluate() {
        if (byteSize >= 1125899906842624L) {
            humanUnit = "PB";
            humanSize = byteSize / 1125899906842624L;
        } else if (byteSize >= 1099511627776L) {
            humanUnit = "TB";
            humanSize = byteSize / 1099511627776L;
        } else if (byteSize >= 1073741824L) {
            humanUnit = "GB";
            humanSize = byteSize / 1073741824L;
        } else if (byteSize >= 1048576L) {
            humanUnit = "MB";
            humanSize = byteSize / 1048576L;
        } else if (byteSize >= 1024) {
            humanUnit = "KB";
            humanSize = byteSize / 1024;
        } else {
            humanUnit = "B";
            humanSize = byteSize;
        }
    }

    public long getHumanSize() {
        return humanSize;
    }

    public String getHumanUnit() {
        return humanUnit;
    }

}
