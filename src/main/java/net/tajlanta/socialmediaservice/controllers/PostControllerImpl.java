package net.tajlanta.socialmediaservice.controllers;

import jakarta.validation.Valid;
import net.tajlanta.socialmediaservice.dto.PostDTO;
import net.tajlanta.socialmediaservice.entity.Post;
import net.tajlanta.socialmediaservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostControllerImpl implements PostController {
    private final PostService postService;

    @Autowired
    public PostControllerImpl(final PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<?> create(@Valid @RequestBody Post post) {
        postService.create(post);
        return post != null
                ? new ResponseEntity<>(post, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<PostDTO>> read() {
        final List<PostDTO> posts = postService.readAll();

        return posts != null && !posts.isEmpty()
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<PostDTO> read(@PathVariable(name = "id") Long id) {
        final PostDTO post = postService.read(id);

        return post != null
                ? new ResponseEntity<>(post, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Post post) {
        final boolean updated = postService.update(post, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        postService.delete(id);


        return new ResponseEntity<>(HttpStatus.OK);

    }


}
