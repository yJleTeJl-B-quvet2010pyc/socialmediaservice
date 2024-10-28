package net.tajlanta.socialmediaservice.controllers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import net.tajlanta.socialmediaservice.entity.Comment;
import net.tajlanta.socialmediaservice.entity.Post;
import net.tajlanta.socialmediaservice.service.CommentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CommentControllerImplTest {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    jakarta.validation.Validator validator = factory.getValidator();

    @Mock
    CommentService commentService;

    @InjectMocks
    CommentControllerImpl controller;

    @Test
    public void create_ReturnsInvalidResponseEntityIfCommentsAreNotAllowed() {
        var post = new Post(false, 1L, "no comments");

        var comment = new Comment(1L, "i want to make a comment", post);

        var responseEntity = this.controller.create(comment);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());

    }

    @Test
    public void create_ReturnsInvalidResponseEntityIfContentIsLarger150Symbols() {
        var post = new Post(true, 1L, "i need more comments");
        var comment = new Comment(1L, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", post);
        Set<ConstraintViolation<Comment>> violations = validator.validate(comment);

        assertFalse(violations.isEmpty());
    }
}
