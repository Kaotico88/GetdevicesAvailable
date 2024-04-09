/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022 for TELEFONICA
 * CELULAR DE BOLIVIA S.A. (Telecel S.A.) use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import bo.tigo.mob.k8s.getdevicesavailable.dto.core.DevicesAvailable;
import bo.tigo.mob.k8s.getdevicesavailable.util.exception.RepositoryException;

/**
 * MQueryDS1Mapper
 *
 * @author Elio Arias
 * @since 1.0
 */
@Mapper
public interface MQueryDS1Mapper {

    public List<DevicesAvailable> getQuery1Records(@Param("recordSku") String recordSku,
            @Param("recordStockId") String recordStockId) throws RepositoryException;

}
