package net.tajlanta.socialmediaservice.repository;

import net.tajlanta.socialmediaservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
