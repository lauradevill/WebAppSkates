package com.ProyectoWebApp.EmpresaPatinetas.repository.crud;

import com.ProyectoWebApp.EmpresaPatinetas.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);

    //Esto es JPQL
    @Query("select r.client, COUNT(r.client) from Reservation AS r group by r.client order by COUNT(r.client) desc")
    public List<Object[]> countTotalReservationByClient();
}
