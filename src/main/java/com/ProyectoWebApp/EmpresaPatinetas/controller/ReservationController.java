package com.ProyectoWebApp.EmpresaPatinetas.controller;

import com.ProyectoWebApp.EmpresaPatinetas.service.ReservationService;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity reservation
 * @author: Laura De Villeros
 */
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reservation> getReservations() { return reservationService.getAll(); }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int gReservationId) {
        return reservationService.getReservation(gReservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) { return reservationService.save(reservation); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) { return reservationService.update(reservation); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int dReservationId) { return reservationService.deleteReservation(dReservationId); }
}
