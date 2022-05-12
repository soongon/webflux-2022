package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Post;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository {

    public Flux<Post> selectAllPosts() {
        // DB에 접속하여 글 데이터를 가져온다...
        List<Post> postList = Arrays.asList(
                new Post(1, 1, "오늘은 좋은날", "매우 좋아요....."),
                new Post(1, 2, "오늘은 좋은날2", "매우 좋아요..2222"),
                new Post(2, 3, "오늘은 좋은날3", "매우 좋아요..3333"),
                new Post(2, 4, "오늘은 좋은날4", "매우 좋아요..4444")
        );
        return Flux.fromIterable(postList);
    }
}
