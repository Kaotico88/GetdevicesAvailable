/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022 for TELEFONICA
 * CELULAR DE BOLIVIA S.A. (Telecel S.A.) use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.dto.core;

import java.util.List;

/**
 * Data
 *
 * @author Jhojan Arias
 * @since 1.0
 */
public class Data {

    private List<DevicesAvailable> devicesAvailableList;

    public List<DevicesAvailable> getDevicesAvailableList() {
        return devicesAvailableList;
    }

    public void setDevicesAvailableList(List<DevicesAvailable> devicesAvailableList) {
        this.devicesAvailableList = devicesAvailableList;
    }

	@Override
	public String toString() {
		return "Data [\n" + 
					"\tdevicesAvailableList=" + devicesAvailableList + " \n" + 
					"]";
	}
    
    

}
