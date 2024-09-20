package net.tajlanta.socialmediaservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "clients")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, max = 12, message = "Incorrect name. Your name should be from 2 to 12 characters.")
    private String username;
    private String password;
}
