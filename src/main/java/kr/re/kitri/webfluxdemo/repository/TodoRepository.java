package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
public class TodoRepository {
    public Flux<Todo> retrieveTodos() {

        WebClient webClient =
                WebClient.create("https://jsonplaceholder.typicode.com");

        Flux<Todo> todoFlux = webClient
                .get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);

        return todoFlux;
    }
}
