/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022 for TELEFONICA
 * CELULAR DE BOLIVIA S.A. (Telecel S.A.) use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.api;

import static java.util.Optional.ofNullable;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.tigo.mob.k8s.getdevicesavailable.dto.ResponseObject;
import bo.tigo.mob.k8s.getdevicesavailable.dto.HealthMessage;
import bo.tigo.mob.k8s.getdevicesavailable.service.ResponseObjectService;
import bo.tigo.mob.k8s.getdevicesavailable.util.AElog;
import bo.tigo.mob.k8s.getdevicesavailable.util.AEutil;
import bo.tigo.mob.k8s.getdevicesavailable.util.exception.response.custom.CustomRuntimeException;

/**
 * GeneralResource
 *
 * @author Elio Arias
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/devicesAvailable")
public class GeneralResource {
    private static final Logger logger = LoggerFactory.getLogger(GeneralResource.class);

    @Autowired
    private AEutil util;

    @Autowired
    private ResponseObjectService service;

    @GetMapping("/status")
    public ResponseEntity<Object> healthRequest(HttpServletRequest request) throws Exception {

        HealthMessage object;
        HttpHeaders responseHeaders = new HttpHeaders();
        requestLog(request, "X: ");

        object = new HealthMessage("Service is operating normally!!");

        responseHeaders.set("Custom-Message", "HTTP/1.1 200 OK");
        return new ResponseEntity<Object>(object, responseHeaders, HttpStatus.OK);
    }

    // typos de params: @RequestHeader @RequestParam, @PathVariable, @Nullable
    @GetMapping
    public ResponseEntity<ResponseObject> findAllObjects(@RequestParam Map<String, String> allParams,
            HttpServletRequest request) {
        String sessionLogId = System.currentTimeMillis() + ": ";
        ResponseObject responseObj = new ResponseObject();//este es el objetito
        HttpHeaders responseHeaders = new HttpHeaders();
        requestLog(request, sessionLogId);

        int allowedParams = 0;
        String sku = allParams.get("sku");
        String stockId = allParams.get("stockId");
        allowedParams += sku != null ? 1 : 0;
        allowedParams += stockId != null ? 1 : 0;

        if (allowedParams != allParams.size()) {
            throw new CustomRuntimeException(HttpStatus.BAD_REQUEST, 400, "Se enviaron parámetros desconocidos.");
        }

        if ((sku == null || sku.trim().isEmpty()) && (stockId == null || stockId.trim().isEmpty())) {
            throw new CustomRuntimeException(HttpStatus.BAD_REQUEST, 400, "Es requerido al menos un parametro.");
        }

        if (sku != null && sku.trim().isEmpty()) {
            throw new CustomRuntimeException(HttpStatus.BAD_REQUEST, 400, "El parámetro 'sku' no es válido.");
        }

        if (stockId != null && stockId.trim().isEmpty()) {
            throw new CustomRuntimeException(HttpStatus.BAD_REQUEST, 400, "El parámetro 'stockId' no es válido.");
        }

        responseObj = service.getQueryRecords(ofNullable(sku), ofNullable(stockId), sessionLogId);

        // Si responseObj == null || responseObj.getDataList().isEmpty()
        if (responseObj == null || responseObj.getData().getDevicesAvailableList() == null
                || responseObj.getData().getDevicesAvailableList().isEmpty()) {
            throw new CustomRuntimeException(HttpStatus.NOT_FOUND, 404,
                    "No se encontraron resultados para la búsqueda.");
        }

        responseHeaders.set("Custom-Message", "HTTP/1.1 200 OK");
        return new ResponseEntity<ResponseObject>(responseObj, responseHeaders, HttpStatus.OK);
    }

    private synchronized void requestLog(HttpServletRequest request, String sessionLogId) {
        AElog.infoX(logger,
                sessionLogId + util.getInetAddressPort() + " <= " + request.getRemoteHost() + " {method:"
                        + request.getMethod() + ", URI:" + request.getRequestURI() + ", query:"
                        + request.getQueryString() + "}");
    }

}
