package com.ProyectoWebApp.EmpresaPatinetas.repository;

import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.CategoryCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table category
 * @author: Laura De Villeros
 */
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    public List<Category> getAll() { return (List<Category>) categoryCrudRepository.findAll(); }
    public Optional<Category> getCategory(int id) { return categoryCrudRepository.findById(id); }
    public Category save(Category category) { return categoryCrudRepository.save(category); }
    public void delete(Category category) { categoryCrudRepository.delete(category); }
}
