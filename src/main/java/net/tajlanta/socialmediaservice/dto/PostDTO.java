package net.tajlanta.socialmediaservice.dto;

import net.tajlanta.socialmediaservice.entity.Comment;

import java.util.List;

public record PostDTO(Long id, String content, List<Comment> comments) {
}
