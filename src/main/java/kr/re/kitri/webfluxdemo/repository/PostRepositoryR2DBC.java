package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryR2DBC extends ReactiveCrudRepository<Post, Integer> {
}
