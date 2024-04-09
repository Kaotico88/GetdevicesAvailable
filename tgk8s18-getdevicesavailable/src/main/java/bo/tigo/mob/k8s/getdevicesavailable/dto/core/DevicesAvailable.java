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
 * DevicesAvailable
 *
 * @author Jhojan Arias
 * @since 1.0
 */
public class DevicesAvailable {

    private String devicesAvailableId;

    private Integer count;

    private String sku;

    private Stock stock;

    public String getDevicesAvailableId() {
        return devicesAvailableId;
    }

    public void setDevicesAvailableId(String devicesAvailableId) {
        this.devicesAvailableId = devicesAvailableId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

	@Override
	public String toString() {
		return "DevicesAvailable [\n" + 
				"\tdevicesAvailableId=" + devicesAvailableId + ", \n" +
				"\tcount=" + count + ", \n" +
				"\tsku=" + sku + ", \n" +
				"\tstock=" + stock + "\n" + 
				"]";
	}

}
