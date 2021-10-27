package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.CategoryRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table category
 * @author: Laura De Villeros
 */
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){ return categoryRepository.getAll(); }
    public Optional<Category> getCategory(int id){ return categoryRepository.getCategory(id);}
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> element= categoryRepository.getCategory(category.getId());
            if(element.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> element=categoryRepository.getCategory(category.getId());
            if(!element.isEmpty()){
                if(category.getName()!=null) {
                    element.get().setName(category.getName());
                }else{ element.get().setName(element.get().getName()); }

                if(category.getDescription()!=null){
                    element.get().setDescription(category.getDescription());
                }else{ element.get().setDescription(element.get().getDescription()); }

                if(category.getSkates()!=null){
                    element.get().setSkates(category.getSkates());
                }else{ element.get().setSkates(element.get().getSkates()); }

                categoryRepository.save(element.get());
                return element.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }
    public boolean deleteCategory(int id){
        boolean aBoolean=getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
   }
}
