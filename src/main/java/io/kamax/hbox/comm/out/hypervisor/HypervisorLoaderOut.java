/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Max Dor
 * hyperbox at altherian dot org
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

package io.kamax.hbox.comm.out.hypervisor;

public class HypervisorLoaderOut {

    private String vendor;
    private String product;
    private String version;
    private String typeId;
    private String hypervisorId;

    @SuppressWarnings("unused")
    private HypervisorLoaderOut() {

    }

    public HypervisorLoaderOut(String vendor, String product, String version, String typeId, String hypervisorId) {
        this.vendor = vendor;
        this.product = product;
        this.version = version;
        this.typeId = typeId;
        this.hypervisorId = hypervisorId;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @return the typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @return the hypervisorId
     */
    public String getHypervisorId() {
        return hypervisorId;
    }

    @Override
    public String toString() {
        return vendor + " " + product + " - " + hypervisorId;
    }

}
