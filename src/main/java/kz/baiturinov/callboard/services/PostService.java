package kz.baiturinov.callboard.services;

import kz.baiturinov.callboard.models.Posts;
import kz.baiturinov.callboard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Posts save(Posts posts) {
        return postRepository.save(posts);
    }

    public List<Posts> findAll() {
        return postRepository.findAll();
    }
}
