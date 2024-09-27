package com.poly.schedule_manager_be.service;

import com.nimbusds.jose.JOSEException;
import com.poly.schedule_manager_be.dto.request.AuthenticationRequest;
import com.poly.schedule_manager_be.dto.request.IntrospectRequest;
import com.poly.schedule_manager_be.dto.response.AuthenticationResponse;
import com.poly.schedule_manager_be.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest request);
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
