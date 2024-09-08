package com.woo.repo.service;

import com.woo.repo.domain.Todo;
import com.woo.repo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo complete(Long tno) {
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        todo.setComplete(true);

        Todo completeTodo = todoRepository.save(todo);
        return completeTodo;
    }

    @Override
    public Todo cancel(Long tno) {
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        todo.setComplete(false);

        Todo cancelTodo = todoRepository.save(todo);
        return cancelTodo;
    }

    @Override
    public void inputTodo(Todo todo) {

        todo.setDueDate(LocalDate.now());
        todo.setComplete(false);

        todoRepository.save(todo);
    }

    @Override
    public void modifyTodo(Long tno, Todo todo) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo optionalTodo = result.orElseThrow();

        optionalTodo.setTitle(todo.getTitle());
        optionalTodo.setContent(todo.getContent());
        optionalTodo.setDueDate(todo.getDueDate());

        todoRepository.save(optionalTodo);

    }
}
