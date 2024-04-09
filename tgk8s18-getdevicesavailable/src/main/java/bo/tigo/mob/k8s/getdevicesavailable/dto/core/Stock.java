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
 * Stock
 *
 * @author Jhojan Arias
 * @since 1.0
 */
public class Stock {

    private String stockId;

    private String resourceType;

    private ResourceInventory resourceInventory;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public ResourceInventory getResourceInventory() {
        return resourceInventory;
    }

    public void setResourceInventory(ResourceInventory resourceInventory) {
        this.resourceInventory = resourceInventory;
    }

	@Override
	public String toString() {
		return "Stock [\n" + 
				"\tstockId=" + stockId + ", \n" + 
				"\tresourceType=" + resourceType + ", \n" +
				"\tresourceInventory=" + resourceInventory + " \n" + 
				"]";
	}

}
