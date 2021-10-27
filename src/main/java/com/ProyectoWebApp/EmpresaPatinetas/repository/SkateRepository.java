package com.ProyectoWebApp.EmpresaPatinetas.repository;


import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.SkateCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Skate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table skate
 * @author: Laura De Villeros
 */
public class SkateRepository {
    @Autowired
    private SkateCrudRepository skateCrudRepository;
    public List<Skate> getAll() { return (List<Skate>) skateCrudRepository.findAll(); }
    public Optional<Skate> getSkate(int id) { return skateCrudRepository.findById(id); }
    public Skate save(Skate skate) { return skateCrudRepository.save(skate);}
    public void delete(Skate skate) { skateCrudRepository.delete(skate); }
}
