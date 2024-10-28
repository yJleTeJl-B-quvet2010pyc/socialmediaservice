package net.tajlanta.socialmediaservice.mappers;

import net.tajlanta.socialmediaservice.dto.CommentDTO;
import net.tajlanta.socialmediaservice.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CommentDTOMapper implements Function<Comment, CommentDTO> {

    @Override
    public CommentDTO apply(Comment comment) {
        return new CommentDTO(comment.getId(),
                comment.getBody(),
                comment.getPost());
    }
}
