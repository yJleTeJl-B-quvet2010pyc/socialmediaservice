package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.dto.PostDTO;
import net.tajlanta.socialmediaservice.entity.Post;
import net.tajlanta.socialmediaservice.mappers.PostDTOMapper;
import net.tajlanta.socialmediaservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostDTOMapper postDTOMapper;

    @Override
    public void create(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> readAll() {

        return postRepository.findAll()
                .stream()
                .map(postDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO read(Long id) {
        return postDTOMapper.apply(postRepository.findById(id).get());
    }

    @Override
    public boolean update(Post post, Long id) {
        if (postRepository.existsById(id)) {
            postRepository.save(post);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
