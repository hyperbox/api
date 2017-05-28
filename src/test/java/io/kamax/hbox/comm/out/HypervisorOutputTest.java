/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * hyperbox at altherian dot org
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

package io.kamax.hbox.comm.out;

import io.kamax.hbox.comm.out.hypervisor.HypervisorOut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class HypervisorOutputTest {

    public static void validateFull(HypervisorOut hypOut) {
        assertFalse(hypOut.getId().isEmpty());
        assertNotNull(hypOut.getVendor());
        assertNotNull(hypOut.getProduct());
        assertNotNull(hypOut.getVersion());
        assertNotNull(hypOut.getRevision());
    }

}
