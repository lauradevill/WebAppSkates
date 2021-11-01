package com.ProyectoWebApp.EmpresaPatinetas.repository;

import com.ProyectoWebApp.EmpresaPatinetas.entity.Client;
import com.ProyectoWebApp.EmpresaPatinetas.entity.custom.CountClient;
import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.ReservationCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table reservation
 * @author: Laura De Villeros
 */
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll() { return (List<Reservation>) reservationCrudRepository.findAll(); }
    public Optional<Reservation> getReservation(int id) { return reservationCrudRepository.findById(id); }
    public Reservation save(Reservation reservation) { return reservationCrudRepository.save(reservation); }
    public void delete(Reservation reservation) { reservationCrudRepository.delete(reservation); }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne,Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            Client client= (Client) report.get(i)[0];
            Integer cantidad=(Integer) report.get(i)[1];
            CountClient cc= new CountClient(cantidad,client);
            res.add(cc);
        }
        return res;
    }
}
