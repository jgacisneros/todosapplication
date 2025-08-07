package com.cisneros.todos.service;

import com.cisneros.todos.request.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
}
