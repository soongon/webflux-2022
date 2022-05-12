package kr.re.kitri.webfluxdemo.controller;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class PostController {

    @Autowired
    private PostService postService;

    // select * from posts where title like %good%
    @GetMapping("/posts/title/{like}")
    public Flux<Post> findPostsByTitleLike(@PathVariable String like) {
        return postService.getPostsByTitleLike(like);
    }

    @GetMapping("/posts/count")
    public Mono<Long> postsCount() {
        return postService.getPostCount();
    }

    @GetMapping("/posts")
    public Flux<Post> viewAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public Mono<Post> viewPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts")
    public Mono<Post> registPost(@RequestBody Mono<Post> post) {
        return postService.setPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public Mono<Void> removePostById(@PathVariable int id) {
        return postService.deletePostById(id);
    }
}
