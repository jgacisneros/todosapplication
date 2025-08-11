package com.cisneros.todos.service;

import com.cisneros.todos.entity.Authority;
import com.cisneros.todos.entity.User;
import com.cisneros.todos.repository.UserRepository;
import com.cisneros.todos.response.UserResponse;
import com.cisneros.todos.util.FindAuthenticatedUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public UserServiceImpl(UserRepository userRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.userRepository = userRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserInfo() {
        User user = findAuthenticatedUser.getAuthenticatedUser();
        return new UserResponse(
                user.getId(),
                user.getFirstName() + " " + user.getLastName(),
                user.getEmail(),
                user.getAuthorities().stream()
                        .map(auth -> (Authority) auth).toList()
        );

    }

    @Override
    public void deleteUser() {
        User user = findAuthenticatedUser.getAuthenticatedUser();
        if (isLastAdmin(user)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Admin cannot delete itself");
        }
        userRepository.delete(user);
    }

    private boolean isLastAdmin(User user) {
        boolean isAdmin = user.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN"
                        .equals(authority.getAuthority()));
        if (isAdmin) {
            long adminCount = userRepository.countAdminUsers();
            return adminCount <= 1;
        }
        return false;
    }

}