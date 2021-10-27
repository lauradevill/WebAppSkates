package com.ProyectoWebApp.EmpresaPatinetas.controller;

import com.ProyectoWebApp.EmpresaPatinetas.service.MessageService;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity message
 * @author: Laura De Villeros
 */
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Message> getMessages() { return messageService.getAll(); }
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int gMessageId) {
        return messageService.getMessage(gMessageId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) { return messageService.save(message); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) { return messageService.update(message); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int dMessageId) { return messageService.deleteMessage(dMessageId); }
}
