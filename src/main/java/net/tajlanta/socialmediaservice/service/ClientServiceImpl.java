package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.entity.Client;
import net.tajlanta.socialmediaservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class ClientServiceImpl implements ClientService {

    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        final Long clientId = (long) CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
       return clientRepository.findAll();
    }

    @Override
    public Client read(Long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public boolean update(Client client, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        clientRepository.deleteById(id);
        if (clientRepository.existsById(id)) {
            return false;
        }
        return true;
    }
}
