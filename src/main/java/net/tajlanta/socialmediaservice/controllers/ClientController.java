package net.tajlanta.socialmediaservice.controllers;

import net.tajlanta.socialmediaservice.dto.ClientDTO;
import net.tajlanta.socialmediaservice.entity.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public interface ClientController {

    @PostMapping
    ResponseEntity<?> create(@RequestBody Client client);

    @GetMapping
    ResponseEntity<List<ClientDTO>> read();

    @GetMapping("/{id}")
    ResponseEntity<ClientDTO> read(@PathVariable(name = "id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Client client);

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(name = "id") Long id);


}
