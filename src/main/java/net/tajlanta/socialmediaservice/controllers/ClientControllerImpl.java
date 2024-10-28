package net.tajlanta.socialmediaservice.controllers;

import net.tajlanta.socialmediaservice.dto.ClientDTO;
import net.tajlanta.socialmediaservice.entity.Client;
import net.tajlanta.socialmediaservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientControllerImpl(final ClientService clientService) {

        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> read() {
        final List<ClientDTO> clients = clientService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ClientDTO> read(@PathVariable(name = "id") Long id) {
        final ClientDTO client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
