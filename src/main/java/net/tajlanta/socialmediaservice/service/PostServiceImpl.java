package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.entity.Post;
import net.tajlanta.socialmediaservice.repository.ClientRepository;
import net.tajlanta.socialmediaservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostServiceImpl implements PostService {

    private static final AtomicInteger POST_ID_HOLDER = new AtomicInteger();

    @Autowired
    private PostRepository postRepository;

    @Override
    public void create(Post post) {
        final Long postId = (long) POST_ID_HOLDER.incrementAndGet();
        post.setId(postId);
        postRepository.save(post);
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Override
    public Post read(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public boolean update(Post post, Long id) {
        if(postRepository.existsById(id)) {
            postRepository.save(post);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        postRepository.deleteById(id);
        if(postRepository.existsById(id)) {
            return false;
        }
        return true;
    }
}
