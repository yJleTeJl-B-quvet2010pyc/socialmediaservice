package net.tajlanta.socialmediaservice.repository;

import net.tajlanta.socialmediaservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}