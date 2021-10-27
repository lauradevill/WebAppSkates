package com.ProyectoWebApp.EmpresaPatinetas.controller;

import com.ProyectoWebApp.EmpresaPatinetas.service.SkateService;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Skate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity skate
 * @author: Laura De Villeros
 */
public class SkateController {
    @Autowired
    private SkateService skateService;

    @GetMapping("/all")
    public List<Skate> getSkates() { return skateService.getAll(); }
    @GetMapping("/{id}")
    public Optional<Skate> getSkate(@PathVariable("id") int gSkateId) {
        return skateService.getSkate(gSkateId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate) { return skateService.save(skate); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate) { return skateService.update(skate); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int dSkateId) { return skateService.deleteSkate(dSkateId); }
}
