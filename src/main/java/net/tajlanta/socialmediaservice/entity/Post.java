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

    @Size(max = 2000, message = "Xuli raspizdelsya")
    private String content;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments;
}
