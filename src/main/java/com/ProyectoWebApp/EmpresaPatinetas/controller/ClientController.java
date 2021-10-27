package com.ProyectoWebApp.EmpresaPatinetas.controller;

import com.ProyectoWebApp.EmpresaPatinetas.service.ClientService;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity client
 * @author: Laura De Villeros
 */
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Client> getClients() { return clientService.getAll(); }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int gClientId) {
        return clientService.getClient(gClientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) { return clientService.save(client); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) { return clientService.update(client); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int dClientId) { return clientService.deleteClient(dClientId); }
}
