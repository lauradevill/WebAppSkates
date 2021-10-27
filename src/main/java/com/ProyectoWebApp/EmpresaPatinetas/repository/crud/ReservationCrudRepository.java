package com.ProyectoWebApp.EmpresaPatinetas.repository.crud;

import com.ProyectoWebApp.EmpresaPatinetas.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
