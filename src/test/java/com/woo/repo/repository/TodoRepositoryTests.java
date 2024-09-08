package com.woo.repo.repository;

import com.woo.repo.domain.Todo;
import com.woo.repo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    public void test1() {

        Assertions.assertNotNull(todoRepository);

        log.info(todoRepository.getClass().getName());

    }

    @Test
    public void testList() {

        List<Todo> todoList = todoRepository.findAll();

        log.info(todoList);

    }

    @Test
    public void testInsert() {

        Todo result = null;

        for (int i = 0; i < 10; i++) {
            Todo todo = Todo.builder()
                    .title("Title")
                    .content("Content")
                    .dueDate(LocalDate.of(2024, 9, 6))
                    .build();
            result = todoRepository.save(todo);
        }

        log.info(result);

    }

    @Test
    public void testRead() {

       Long tno = 3L;

       Optional<Todo> result = todoRepository.findById(tno);

       Todo todo = result.orElseThrow();

       log.info(todo);
    }

    @Test
    public void testUpdate() {

        Long tno = 3L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        /*todo.setTitle("Update Title");
        todo.setContent("Updated content");*/
        todo.setComplete(false);

        todoRepository.save(todo);

    }

    @Test
    public void testInput() {

        Todo todo = Todo.builder()
                .title("Title2")
                .content("Content2")
                .dueDate(LocalDate.of(2024,9,6))
                .build();
        Todo result = todoRepository.save(todo);
    }

    @Test
    public void testComplete() {

        Long tno = 3L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        Todo completeTodo = todoService.complete(tno);

        log.info(completeTodo);
    }

    @Test
    public void testCancel() {

        Long tno = 3L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        Todo cancelTodo = todoService.cancel(tno);

        log.info(cancelTodo);
    }

    @Test
    public void testModify() {

        Long tno = 4L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        todo.setTitle("Modified Title");
        todo.setContent("Modified Content");
        todo.setDueDate(LocalDate.of(2024,9,7));
        todo.setComplete(false);

        todoService.modifyTodo(tno,todo);

        log.info(todo);
    }
}
