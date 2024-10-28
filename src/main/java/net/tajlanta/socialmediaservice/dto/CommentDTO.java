package net.tajlanta.socialmediaservice.dto;

import net.tajlanta.socialmediaservice.entity.Post;

public record CommentDTO(Long id, String body, Post post) {
}
