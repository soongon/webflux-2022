package kr.re.kitri.webfluxdemo.service;

import kr.re.kitri.webfluxdemo.model.Todo;
import kr.re.kitri.webfluxdemo.repository.PostRepositoryR2DBC;
import kr.re.kitri.webfluxdemo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    // private PostRepositoryR2DBC postRepositoryR2DBC;

    public Flux<Todo> getAllTodos() {
        // postRepositoryR2DBC.save();
        return todoRepository.retrieveTodos();
    }
}
