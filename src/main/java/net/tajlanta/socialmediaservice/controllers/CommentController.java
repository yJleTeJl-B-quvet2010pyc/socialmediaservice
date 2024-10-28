package net.tajlanta.socialmediaservice.controllers;

import net.tajlanta.socialmediaservice.dto.CommentDTO;
import net.tajlanta.socialmediaservice.entity.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/comments")
public interface CommentController {
    @PostMapping
    ResponseEntity<?> create(@RequestBody Comment comment);

    @GetMapping
    ResponseEntity<List<CommentDTO>> read();
}
