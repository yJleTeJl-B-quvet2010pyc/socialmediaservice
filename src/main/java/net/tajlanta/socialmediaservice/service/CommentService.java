package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.dto.CommentDTO;
import net.tajlanta.socialmediaservice.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    List<CommentDTO> readAll();

    CommentDTO read(Long id);

}
