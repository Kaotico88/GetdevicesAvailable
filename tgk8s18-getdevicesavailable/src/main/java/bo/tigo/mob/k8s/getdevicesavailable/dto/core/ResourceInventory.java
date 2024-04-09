/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022 for TELEFONICA
 * CELULAR DE BOLIVIA S.A. (Telecel S.A.) use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.dto.core;

/**
 * ResourceInventory
 *
 * @author Jhojan Arias
 * @since 1.0
 */
public class ResourceInventory {

    private String resourceInventoryId;

    private String name;

    private String inventoryType;

    public String getResourceInventoryId() {
        return resourceInventoryId;
    }

    public void setResourceInventoryId(String resourceInventoryId) {
        this.resourceInventoryId = resourceInventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

	@Override
	public String toString() {
		return "ResourceInventory [\n" + 
			"\tresourceInventoryId=" + resourceInventoryId + ", \n" +
			"\tname=" + name + ", \n" + 
			"\tinventoryType=" + inventoryType + " \n" +
			"]";
	}

}
