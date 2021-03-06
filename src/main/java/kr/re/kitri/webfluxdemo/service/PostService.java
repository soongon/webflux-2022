package kr.re.kitri.webfluxdemo.service;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.repository.PostRepository;
import kr.re.kitri.webfluxdemo.repository.PostRepositoryR2DBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepositoryR2DBC postRepository;
    //private PostRepository postRepository;

    public Flux<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Mono<Post> getPostById(int id) {
        return postRepository
                .findById(id)
                .switchIfEmpty(Mono.just(
                        new Post(0, 0, "No data", "No data")));
    }

    public Mono<Post> setPost(Mono<Post> post) {
        return post.flatMap(t -> postRepository.save(t));
    }

    public Mono<Long> getPostCount() {
        return postRepository.count();
    }

    public Mono<Void> deletePostById(int id) {
        return postRepository.deleteById(id);
    }

    public Flux<Post> getPostsByTitleLike(String like) {
        return postRepository.selectPostsByTitleLike(like);
    }
}
