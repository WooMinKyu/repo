package com.woo.repo.controller;

import com.woo.repo.domain.Todo;
import com.woo.repo.repository.TodoRepository;
import com.woo.repo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoRestController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    //전체 todo
    @GetMapping()
    public List<Todo> todoList(Model model){
        List<Todo> todoList = todoRepository.findAll();
        model.addAllAttributes(todoList);
        return todoList;
    }

    //todo 입력
    @PostMapping("/input")
    public void input(@RequestBody Todo todo) {
        todoService.inputTodo(todo);
    }

    //todo 수정
    @PostMapping("/modify/{tno}")
    public void modify(@PathVariable Long tno, @RequestBody Todo todo) {
        todoService.modifyTodo(tno,todo);
    }

    //todo 완료
    @PutMapping("/{tno}")
    public void complete(@PathVariable Long tno){
        Todo complete = todoService.complete(tno);
    }

    //todo 취소
    @PutMapping("/cancel/{tno}")
    public void cancel(@PathVariable Long tno){
        Todo cancel = todoService.cancel(tno);
    }

}
