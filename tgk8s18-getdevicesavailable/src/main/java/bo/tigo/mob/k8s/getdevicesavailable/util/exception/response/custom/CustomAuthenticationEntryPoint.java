/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022
 * for Mob Army S.R.L. use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.util.exception.response.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CustomAuthenticationEntryPoint
 **
 * @author Elio Arias
 * @since 1.0
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    final static Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        logger.warn("CustomAuthenticationEntryPoint.class -> ({}): {}.", request.getRequestURI(),
                authException.getMessage());
        // logger.warn("CustomAuthenticationEntryPoint.class -> (full): ", ex);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getOutputStream().println(
                objectMapper.writeValueAsString(new XErrorResponse(HttpStatus.UNAUTHORIZED, "Unauthorized.....")));
    }

}
