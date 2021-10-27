package com.ProyectoWebApp.EmpresaPatinetas.controller;

import com.ProyectoWebApp.EmpresaPatinetas.service.AdminService;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity admin
 * @author: Laura De Villeros
 */
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Admin> getAdmins() { return adminService.getAll(); }
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int gAdminId) {
        return adminService.getAdmin(gAdminId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) { return adminService.save(admin); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) { return adminService.update(admin); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int dAdminId) { return adminService.deleteAdmin(dAdminId); }
}
