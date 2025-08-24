package com.cisneros.todos.service;

import com.cisneros.todos.request.TodoRequest;
import com.cisneros.todos.response.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getAllTodos();
    TodoResponse createTodo(TodoRequest todoRequest);
    TodoResponse toggleTodoCompletion(long id);
}
