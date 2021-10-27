package com.ProyectoWebApp.EmpresaPatinetas.repository;

import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.MessageCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table messsage
 * @author: Laura De Villeros
 */
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> getAll() { return (List<Message>) messageCrudRepository.findAll(); }
    public Optional<Message> getMessage(int id) { return messageCrudRepository.findById(id); }
    public Message save(Message message) { return messageCrudRepository.save(message); }
    public void delete(Message message) { messageCrudRepository.delete(message); }
}
