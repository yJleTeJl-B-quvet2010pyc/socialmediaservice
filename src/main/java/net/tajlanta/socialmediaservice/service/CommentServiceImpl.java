package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.entity.Comment;
import net.tajlanta.socialmediaservice.repository.CommentRepository;
import net.tajlanta.socialmediaservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CommentServiceImpl implements CommentService {

    private static final AtomicInteger COMMENT_ID_HOLDER = new AtomicInteger();

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment create(Comment comment) {
        final long commentId = COMMENT_ID_HOLDER.getAndIncrement();
        comment.setId(commentId);
        commentRepository.save(comment);

        return comment;
    }

    @Override
    public List<Comment> readAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment read(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public boolean update(Comment comment, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        commentRepository.deleteById(id);
        if (commentRepository.existsById(id)) {
            return false;
        }
        return true;
    }
}
