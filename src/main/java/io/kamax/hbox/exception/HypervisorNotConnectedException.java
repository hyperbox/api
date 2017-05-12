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

package io.kamax.hbox.exception;


public class HypervisorNotConnectedException extends HypervisorException {

    private static final long serialVersionUID = 497724057007129191L;

    public HypervisorNotConnectedException() {
        super("Hypervisor is not connected");
    }

    public HypervisorNotConnectedException(String s) {
        super(s);
    }

    public HypervisorNotConnectedException(Throwable t) {
        super(t);
    }

    public HypervisorNotConnectedException(String s, Throwable t) {
        super(s, t);
    }

}
