package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Reservation;

/**
 * Interfaz para definir los métodos de servicio de la entidad Reservation.
 *
 * @author remr1
 */
public interface IReservationService {

    /**
     * Obtiene una lista con todas las entidades Reservation almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Reservation.
     */
    public List<Reservation> showAll();

    /**
     * Obtiene una entidad Reservation específica por su ID.
     *
     * @param pReservation_Id el ID de la entidad Reservation a obtener.
     * @return la entidad Reservation correspondiente al ID dado, o null si no se encuentra.
     */
    public Reservation FindById(Integer pReservation_Id);

    /**
     * Guarda una entidad Reservation en la base de datos.
     *
     * @param pReservation la entidad Reservation a guardar.
     */
    public void saveReservation(Reservation pReservation);

    /**
     * Elimina una entidad Reservation de la base de datos.
     *
     * @param pReservation la entidad Reservation a eliminar.
     */
    public void deleteReservation(Reservation pReservation);

}