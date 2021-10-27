package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.MessageRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table message
 * @author: Laura De Villeros
 */
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAll(){ return messageRepository.getAll(); }
    public Optional<Message> getMessage(int id){ return messageRepository.getMessage(id);}
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> element= messageRepository.getMessage(message.getIdMessage());
            if(element.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> element=messageRepository.getMessage(message.getIdMessage());
            if(!element.isEmpty()){
                if(message.getMessageText()!=null){
                    element.get().setMessageText(message.getMessageText());
                }
                if(message.getSkate()!=null){
                    element.get().setSkate(message.getSkate());
                }
                if(message.getClient()!=null){
                    element.get().setClient(message.getClient());
                }
                messageRepository.save(element.get());
                return element.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(int id){
        Boolean aBoolean=getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}
