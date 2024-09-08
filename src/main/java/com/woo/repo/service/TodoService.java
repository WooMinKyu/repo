package com.woo.repo.service;

import com.woo.repo.domain.Todo;

public interface TodoService {

    Todo complete(Long tno);

    Todo cancel(Long tno);

    void inputTodo(Todo todo);

    void modifyTodo(Long tno, Todo todo);
}
