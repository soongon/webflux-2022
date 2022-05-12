package kr.re.kitri.webfluxdemo.controller;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Flux<Post> viewAllPost() {
        return postService.getAllPost();
    }
}
