package com.cisneros.todos.service;

import com.cisneros.todos.request.AuthenticationRequest;
import com.cisneros.todos.request.RegisterRequest;
import com.cisneros.todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}
