package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.ClientRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table client
 * @author: Laura De Villeros
 */
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAll(){ return clientRepository.getAll(); }
    public Optional<Client> getClient(int id){ return clientRepository.getClient(id);}
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> element= clientRepository.getClient(client.getIdClient());
            if(element.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> element=clientRepository.getClient(client.getIdClient());
            if(!element.isEmpty()){
                if(client.getName()!=null){
                    element.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    //element.get().setEmail(client.getEmail());
                    element.get().setEmail(element.get().getEmail());
                }
                if(client.getPassword()!=null){
                    element.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    element.get().setAge(client.getAge());
                }
                if(client.getMessages()!=null){
                    element.get().setMessages(client.getMessages());
                }
                if(client.getReservations()!=null){
                    element.get().setReservations(client.getReservations());
                }
                clientRepository.save(element.get());
                return element.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean deleteClient(int id){
        boolean aBoolean=getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}
