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

package io.kamax.hbox.comm.out;

public class ExceptionOut extends ObjectOut {

    // TODO create error code
    private String errno;
    private String error;
    private String stackTrace;

    @SuppressWarnings("unused")
    private ExceptionOut() {
        // used for (de)serialisation
    }

    public ExceptionOut(String errno, String error, String stackTrace) {
        this.errno = errno;
        this.error = error;
        this.stackTrace = stackTrace;
    }

    /**
     * @return the errno
     */
    public String getErrno() {
        return errno;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    public String getStakTrace() {
        return stackTrace;
    }

}
