package net.tajlanta.socialmediaservice.controllers;

import net.tajlanta.socialmediaservice.dto.PostDTO;
import net.tajlanta.socialmediaservice.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
public interface PostController {
    @PostMapping
    ResponseEntity<?> create(@RequestBody Post post);

    @GetMapping
    ResponseEntity<List<PostDTO>> read();

    @GetMapping("/{id}")
    ResponseEntity<PostDTO> read(@PathVariable(name = "id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Post post);

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(name = "id") Long id);
}
