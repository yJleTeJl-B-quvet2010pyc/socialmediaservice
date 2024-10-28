package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.dto.CommentDTO;
import net.tajlanta.socialmediaservice.entity.Comment;
import net.tajlanta.socialmediaservice.mappers.CommentDTOMapper;
import net.tajlanta.socialmediaservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentDTOMapper commentDTOMapper;

    @Override
    public Comment create(Comment comment) {
        commentRepository.save(comment);

        return comment;
    }

    @Override
    public List<CommentDTO> readAll() {

        return commentRepository.findAll()
                .stream()
                .map(commentDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO read(Long id) {

        return commentDTOMapper.apply(commentRepository.findById(id).get());
    }

}
