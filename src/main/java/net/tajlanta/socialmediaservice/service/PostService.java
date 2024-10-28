package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.dto.PostDTO;
import net.tajlanta.socialmediaservice.entity.Post;

import java.util.List;

public interface PostService {
    void create(Post post);

    List<PostDTO> readAll();

    PostDTO read(Long id);

    boolean update(Post post, Long id);

    void delete(Long id);
}
