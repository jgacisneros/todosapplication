package com.cisneros.todos.service;

import com.cisneros.todos.response.UserResponse;

import java.util.List;

public interface AdminService {
    List<UserResponse> getAllUsers();
}
