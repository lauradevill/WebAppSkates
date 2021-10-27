package com.ProyectoWebApp.EmpresaPatinetas.repository;

import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.AdminCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table admin
 * @author: Laura De Villeros
 */
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    public List<Admin> getAll() { return (List<Admin>) adminCrudRepository.findAll(); }
    public Optional<Admin> getAdmin(int id) { return adminCrudRepository.findById(id); }
    public Admin save(Admin admin) { return adminCrudRepository.save(admin); }
    public void delete(Admin admin) { adminCrudRepository.delete(admin); }
}
