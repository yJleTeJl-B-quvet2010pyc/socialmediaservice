package net.tajlanta.socialmediaservice.repository;

import net.tajlanta.socialmediaservice.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @EntityGraph(attributePaths = "comments")
    List<Post> findAll();
}
