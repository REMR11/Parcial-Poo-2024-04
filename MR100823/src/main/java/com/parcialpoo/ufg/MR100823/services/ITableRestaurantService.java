package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.TableRestaurant;

/**
 * Interfaz para definir los métodos de servicio de la entidad TableRestaurant.
 *
 * @author remr1
 */
public interface ITableRestaurantService {

    /**
     * Obtiene una lista con todas las entidades TableRestaurant almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades TableRestaurant.
     */
    public List<TableRestaurant> showAll();

    /**
     * Obtiene una entidad TableRestaurant específica por su ID.
     *
     * @param pTableRestaurant_Id el ID de la entidad TableRestaurant a obtener.
     * @return la entidad TableRestaurant correspondiente al ID dado, o null si no se encuentra.
     */
    public TableRestaurant FindById(Integer pTableRestaurant_Id);

    /**
     * Guarda una entidad TableRestaurant en la base de datos.
     *
     * @param pTableRestaurant la entidad TableRestaurant a guardar.
     */
    public void saveTableRestaurant(TableRestaurant pTableRestaurant);

    /**
     * Elimina una entidad TableRestaurant de la base de datos.
     *
     * @param pTableRestaurant la entidad TableRestaurant a eliminar.
     */
    public void deleteTableRestaurant(TableRestaurant pTableRestaurant);

}