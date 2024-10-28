package net.tajlanta.socialmediaservice.mappers;

import net.tajlanta.socialmediaservice.dto.PostDTO;
import net.tajlanta.socialmediaservice.entity.Post;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PostDTOMapper implements Function<Post, PostDTO> {

    @Override
    public PostDTO apply(Post post) {
        return new PostDTO(post.getId(),
                post.getContent(),
                post.getComments()
                        .stream()
                        .collect(Collectors.toList()));
    }
}
