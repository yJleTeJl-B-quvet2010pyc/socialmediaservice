package net.tajlanta.socialmediaservice.service;

import net.tajlanta.socialmediaservice.dto.ClientDTO;
import net.tajlanta.socialmediaservice.entity.Client;
import net.tajlanta.socialmediaservice.mappers.ClientDTOMapper;
import net.tajlanta.socialmediaservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientDTOMapper clientDTOMapper;

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<ClientDTO> readAll() {

        return clientRepository.findAll()
                .stream()
                .map(clientDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO read(Long id) {
        return clientDTOMapper.apply(
                clientRepository.getReferenceById(id));
    }

    @Override
    public boolean update(Client client, Long id) {
        return false;
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
