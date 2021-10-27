package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.ReservationRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table reservation
 * @author: Laura De Villeros GR22
 */
public class ReservationService {
    /**
     * Methods brought from the Repository
     */
    @Autowired
    /**
     * Creation of an instance of Reservation Repository
     */
    private ReservationRepository reservationRepository;

    /**
     * Method for getting all Reservations
     * @return list of reservations
     */
    public List<Reservation> getAll(){ return reservationRepository.getAll(); }

    /**
     * Method for getting a Reservation by Id
     * @param id, identification of a Reservation
     * @return a Reservation
     */
    public Optional<Reservation> getReservation(int id){ return reservationRepository.getReservation(id);}

    /**
     * Method to Save a Reservation
     * @param reservation
     * @return a Reservation saved
     */
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> element= reservationRepository.getReservation(reservation.getIdReservation());
            if(element.isEmpty()){
                return reservationRepository.save(reservation);
                //reservation.status="created";
            }else{
                return reservation;
            }
        }
    }

    /**
     * Method to update a Reservation
     * @param reservation
     * @return a Reservation updated
     */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> element=reservationRepository.getReservation(reservation.getIdReservation());
            if(!element.isEmpty()){
                if(reservation.getStartDate()!=null){
                    element.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    element.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    element.get().setStatus(reservation.getStatus());
                }
                if(reservation.getSkate()!=null){
                    element.get().setSkate(reservation.getSkate());
                }
                if(reservation.getClient()!=null){
                    element.get().setClient(reservation.getClient());
                }
                if(reservation.getScore()!=null){
                    element.get().setScore(reservation.getScore());
                }
                reservationRepository.save(element.get());
                return element.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    /**
     * Method to delete a Reservation
     * @param id, identification of a Reservation
     * @return true or false
     */
    public boolean deleteReservation(int id){
        boolean aBoolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}
