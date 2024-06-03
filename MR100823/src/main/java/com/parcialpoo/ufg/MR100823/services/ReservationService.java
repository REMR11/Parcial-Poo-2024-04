package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Reservation;
import com.parcialpoo.ufg.MR100823.repository.ReservationRepository;

/**
 * Servicio para manejar las operaciones de la entidad Reservation.
 *
 * @author remr1
 */
public class ReservationService implements IReservationService {

    /**
     * Inyección de dependencia de la interfaz ReservationRepository.
     */
    @Autowired
    private ReservationRepository pReservationRepository;

    /**
     * Obtiene una lista con todas las entidades Reservation almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Reservation.
     */
    @Override
    public List<Reservation> showAll() {
        return pReservationRepository.findAll();
    }

    /**
     * Obtiene una entidad Reservation específica por su ID.
     *
     * @param pReservation_Id el ID de la entidad Reservation a obtener.
     * @return la entidad Reservation correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Reservation FindById(Integer pReservation_Id) {
        return pReservationRepository.findById(pReservation_Id).orElse(null);
    }

    /**
     * Guarda una entidad Reservation en la base de datos.
     *
     * @param pReservation la entidad Reservation a guardar.
     */
    @Override
    public void saveReservation(Reservation pReservation) {
        pReservationRepository.save(pReservation);
    }

    /**
     * Elimina una entidad Reservation de la base de datos.
     *
     * @param pReservation la entidad Reservation a eliminar.
     */
    @Override
    public void deleteReservation(Reservation pReservation) {
        pReservationRepository.delete(pReservation);
    }

}