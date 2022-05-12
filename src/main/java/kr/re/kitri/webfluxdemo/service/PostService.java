package kr.re.kitri.webfluxdemo.service;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Flux<Post> getAllPost() {
        return postRepository.selectAllPosts();
    }

    public Mono<Post> getPostById(int id) {
        return postRepository.selectPostById(id);
    }

    public Mono<Void> setPost(Mono<Post> post) {
        return postRepository.insertPost(post);
    }
}
