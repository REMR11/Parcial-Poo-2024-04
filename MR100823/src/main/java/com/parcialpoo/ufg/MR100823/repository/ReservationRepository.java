package com.parcialpoo.ufg.MR100823.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcialpoo.ufg.MR100823.models.Reservation;
@Repository

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
