package com.ProyectoWebApp.EmpresaPatinetas.repository;
import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.ClientCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table client
 * @author: Laura De Villeros
 */
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    public List<Client> getAll() { return (List<Client>) clientCrudRepository.findAll(); }
    public Optional<Client> getClient(int id) { return clientCrudRepository.findById(id); }
    public Client save(Client client) { return clientCrudRepository.save(client); }
    public void delete(Client client) { clientCrudRepository.delete(client); }
}
