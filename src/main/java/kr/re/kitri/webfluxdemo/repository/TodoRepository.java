package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TodoRepository {

    private WebClient webClient =
            WebClient.create("https://jsonplaceholder.typicode.com");

    public Flux<Todo> retrieveTodos() {
        Flux<Todo> todoFlux = webClient
                .get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);

        return todoFlux;
    }

    public Mono<Todo> retrieveTodoById(long id) {
        return webClient
                .get()
                .uri("/todos/" + id)
                .retrieve()
                .bodyToMono(Todo.class);
    }
}
