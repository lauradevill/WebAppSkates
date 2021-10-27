package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.AdminRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table admin
 * @author: Laura De Villeros
 */
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> getAll(){ return adminRepository.getAll(); }
    public Optional<Admin> getAdmin(int id){ return adminRepository.getAdmin(id);}
    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> element= adminRepository.getAdmin(admin.getIdAdmin());
            if(element.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> element=adminRepository.getAdmin(admin.getIdAdmin());
            if(!element.isEmpty()){
                if(admin.getNameAdmin()!=null){
                    element.get().setNameAdmin(admin.getNameAdmin());
                }
                if(admin.getEmailAdmin()!=null){
                    element.get().setEmailAdmin(admin.getEmailAdmin());
                }
                if(admin.getPasswordAdmin()!=null){
                    element.get().setPasswordAdmin(admin.getPasswordAdmin());
                }
                adminRepository.save(element.get());
                return element.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    public boolean deleteAdmin(int id){
        boolean aBoolean=getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}
