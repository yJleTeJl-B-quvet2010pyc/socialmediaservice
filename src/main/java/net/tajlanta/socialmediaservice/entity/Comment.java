package net.tajlanta.socialmediaservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name = "comments")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 150, message = "{validation.name.size.too_long}")
    private String body;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
