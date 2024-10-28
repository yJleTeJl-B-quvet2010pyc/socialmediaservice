package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.dto.ClientDTO;
import net.tajlanta.socialmediaservice.entity.Client;

import java.util.List;

public interface ClientService {

    void create(Client client);

    List<ClientDTO> readAll();

    ClientDTO read(Long id);

    boolean update(Client client, Long id);

    void delete(Long id);

}
