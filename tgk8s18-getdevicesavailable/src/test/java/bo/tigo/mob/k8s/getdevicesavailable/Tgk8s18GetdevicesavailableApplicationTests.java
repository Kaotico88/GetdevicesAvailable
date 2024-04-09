/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022 for TELEFONICA
 * CELULAR DE BOLIVIA S.A. (Telecel S.A.) use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.tigo.mob.k8s.getdevicesavailable.dto.ResponseObject;
import bo.tigo.mob.k8s.getdevicesavailable.dto.core.Data;
import bo.tigo.mob.k8s.getdevicesavailable.dto.core.DevicesAvailable;
import bo.tigo.mob.k8s.getdevicesavailable.dto.core.ResourceInventory;
import bo.tigo.mob.k8s.getdevicesavailable.dto.core.Stock;
import bo.tigo.mob.k8s.getdevicesavailable.service.ResponseObjectService;

/**
 * Tgk8s18GetdevicesavailableApplicationTests
 *
 * @author Elio Arias
 * @since 1.0
 */
@SpringBootTest
class Tgk8s18GetdevicesavailableApplicationTests {

	public ResponseObject object;
	
	public Data data;
	
	public DevicesAvailable devAva;
	
	public Stock stock;
	
	public ResourceInventory resInv;
	
	@Autowired
	public ResponseObjectService service;
	
	
    @Test
    void testfindAllObjects() {
//    	object = new ResponseObject();
//    	data = new Data();
//    	devAva = new DevicesAvailable();
//    	stock = new Stock();
//    	resInv = new ResourceInventory();
    	
//    	List<DevicesAvailable> devAvas = new ArrayList<DevicesAvailable>();
    	
    	String sku = "71100690256";
    	String stockId = "888";
    	String cadena = "";
    	
//    	resInv.setResourceInventoryId("888");
//    	resInv.setName("GENERICA CDADES. TERCERIZADAS");
//    	resInv.setInventoryType("warehouse");
//    	stock.setStockId(stockId);
//    	stock.setResourceType("devices");
//    	stock.setResourceInventory(resInv);
//    	devAva.setDevicesAvailableId("100100018");
//    	devAva.setCount(1);
//    	devAva.setSku(sku);
//    	devAva.setStock(stock);
//    	
//    	devAvas.add(devAva);
//    
//    	data.setDevicesAvailableList(devAvas);
//    	
//    	object.setData(data);
//    	    	
//    	System.out.println(object+"\n");
    	
    	ResponseObject object = service.getQueryRecords(Optional.of(sku), Optional.of(stockId), cadena);
    	System.out.println(object);
    }

}
 