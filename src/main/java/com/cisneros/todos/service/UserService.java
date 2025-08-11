package com.cisneros.todos.service;

import com.cisneros.todos.request.PasswordUpdateRequest;
import com.cisneros.todos.response.UserResponse;

public interface UserService {
    UserResponse getUserInfo();

    void deleteUser();

    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);
}
