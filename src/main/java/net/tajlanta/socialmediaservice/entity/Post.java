package net.tajlanta.socialmediaservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "posts")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {


    boolean commentsAllowed;

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 2000, message = "Not valid")
    private String content;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments;

    public boolean isCommentsAllowed() {
        return this.commentsAllowed;
    }

    public Post(boolean commentsAllowed, Long id, String content) {
        this.commentsAllowed = commentsAllowed;
        this.id = id;
        this.content = content;
    }

    public void setContent(@Size(max = 2000, message = "Not valid") String content) {
        this.content = content;
    }
}
