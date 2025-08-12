package com.cisneros.todos.service;

import com.cisneros.todos.request.TodoRequest;
import com.cisneros.todos.response.TodoResponse;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);

}
