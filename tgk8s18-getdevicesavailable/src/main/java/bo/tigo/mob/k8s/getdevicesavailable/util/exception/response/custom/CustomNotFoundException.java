/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022
 * for Mob Army S.R.L. use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.util.exception.response.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CustomNotFoundException captures the exception to be customized. Is used to
 * customize the body of the error response
 *
 * @author Elio Arias
 * @since 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomNotFoundException(String message) {
        super(message);
    }

}
