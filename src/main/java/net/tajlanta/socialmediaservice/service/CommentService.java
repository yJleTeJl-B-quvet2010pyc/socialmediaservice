package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.entity.Comment;
import net.tajlanta.socialmediaservice.entity.Post;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    List<Comment> readAll();

    Comment read(Long id);

    boolean update(Comment comment, Long id);

    boolean delete(Long id);
}
