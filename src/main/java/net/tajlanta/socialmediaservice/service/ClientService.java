package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.entity.Client;

import java.util.List;

public interface ClientService {

    void create(Client client);

    List<Client> readAll();

    Client read(Long id);

    boolean update(Client client, Long id);

    boolean delete(Long id);

}
