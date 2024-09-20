package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.entity.Post;

import java.util.List;

public interface PostService {
    void create(Post post);

    List<Post> readAll();

    Post read(Long id);

    boolean update(Post post, Long id);

    boolean delete(Long id);
}
