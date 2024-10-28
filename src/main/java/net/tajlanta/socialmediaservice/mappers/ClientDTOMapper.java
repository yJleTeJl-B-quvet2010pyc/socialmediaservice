package net.tajlanta.socialmediaservice.mappers;

import net.tajlanta.socialmediaservice.dto.ClientDTO;
import net.tajlanta.socialmediaservice.entity.Client;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class ClientDTOMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(),
                client.getUsername());
    }
}
