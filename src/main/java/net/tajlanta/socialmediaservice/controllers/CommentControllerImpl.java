package net.tajlanta.socialmediaservice.controllers;

import jakarta.validation.Valid;
import net.tajlanta.socialmediaservice.dto.CommentDTO;
import net.tajlanta.socialmediaservice.entity.Comment;
import net.tajlanta.socialmediaservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentControllerImpl implements CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentControllerImpl(CommentService commentService) {

        this.commentService = commentService;
    }

    @Override
    public ResponseEntity<?> create(@Valid @RequestBody Comment comment) {
        if (comment.getPost().isCommentsAllowed()) {
            commentService.create(comment);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseEntity<List<CommentDTO>> read() {
        final List<CommentDTO> comments = commentService.readAll();

        return comments != null && !comments.isEmpty()
                ? new ResponseEntity<>(comments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
