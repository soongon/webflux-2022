package kr.re.kitri.webfluxdemo.controller;

import kr.re.kitri.webfluxdemo.model.Todo;
import kr.re.kitri.webfluxdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public Flux<Todo> viewAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Mono<Todo> viewTodoById(@PathVariable long id) {

    }
}
