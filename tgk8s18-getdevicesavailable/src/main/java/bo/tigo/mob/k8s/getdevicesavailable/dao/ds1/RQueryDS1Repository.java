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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.tigo.mob.k8s.getdevicesavailable.dto.core.DevicesAvailable;
import bo.tigo.mob.k8s.getdevicesavailable.util.exception.RepositoryException;

/**
 * RQueryDS1Repository
 *
 * @author Elio Arias
 * @since 1.0
 */
@Repository
public class RQueryDS1Repository {

    public static final int MAX_PAGE_SIZE = 1000;

    @Autowired
    MQueryDS1Mapper mapper;

    public List<DevicesAvailable> getQuery1Records(Optional<String> sku, Optional<String> stockId)
            throws RepositoryException {
        return mapper.getQuery1Records(sku.orElse(null), stockId.orElse(null));
    }

}
