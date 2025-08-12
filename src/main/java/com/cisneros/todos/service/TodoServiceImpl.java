package com.cisneros.todos.service;

import com.cisneros.todos.entity.Todo;
import com.cisneros.todos.entity.User;
import com.cisneros.todos.repository.TodoRepository;
import com.cisneros.todos.request.TodoRequest;
import com.cisneros.todos.response.TodoResponse;
import com.cisneros.todos.util.FindAuthenticatedUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public TodoServiceImpl(TodoRepository todoRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.todoRepository = todoRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional
    public TodoResponse createTodo(TodoRequest todoRequest) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();
        Todo todo = new Todo(
                todoRequest.getTitle(),
                todoRequest.getDescription(),
                todoRequest.getPriority(),
                false,
                currentUser
        );
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponse(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getDescription(),
                savedTodo.getPriority(),
                savedTodo.isComplete()
        );
    }
}