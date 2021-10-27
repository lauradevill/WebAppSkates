package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.SkateRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Skate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table skate
 * @author: Laura De Villeros
 */
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;
    public List<Skate> getAll(){ return skateRepository.getAll(); }
    public Optional<Skate> getSkate(int id){ return skateRepository.getSkate(id);}
    public Skate save(Skate skate){
        if(skate.getId()==null){
            return skateRepository.save(skate);
        }else{
            Optional<Skate> element= skateRepository.getSkate(skate.getId());
            if(element.isEmpty()){
                return skateRepository.save(skate);
            }else{
                return skate;
            }
        }
    }
    public Skate update(Skate skate){
        if(skate.getId()!=null){
            Optional<Skate> element=skateRepository.getSkate(skate.getId());
            if(!element.isEmpty()){
                if(skate.getName()!=null){
                    element.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    element.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    element.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){
                    element.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    element.get().setCategory(skate.getCategory());
                }
                if(skate.getMessages()!=null){
                    element.get().setMessages(skate.getMessages());
                }
                if(skate.getReservations()!=null){
                    element.get().setReservations(skate.getReservations());
                }
                skateRepository.save(element.get());
                return element.get();
            }else{
                return skate;
            }
        }else{
            return skate;
        }
    }
    public boolean deleteSkate(int id){
        Boolean aBoolean=getSkate(id).map(skate -> {
            skateRepository.delete(skate);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}
