package net.tajlanta.socialmediaservice.controllers;

import net.tajlanta.socialmediaservice.entity.Comment;
import net.tajlanta.socialmediaservice.entity.Post;
import net.tajlanta.socialmediaservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }
    @PostMapping("/comments")
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        if(comment.getPost().isCommentsAllowed()) {
            commentService.create(comment);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> read() {
        final List<Comment> comments = commentService.readAll();

        return comments != null &&  !comments.isEmpty()
                ? new ResponseEntity<>(comments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
