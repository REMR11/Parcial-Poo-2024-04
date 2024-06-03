package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Restaurant;

/**
 * Interfaz para definir los métodos de servicio de la entidad Restaurant.
 *
 * @author remr1
 */
public interface IRestaurantService {

    /**
     * Obtiene una lista con todas las entidades Restaurant almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Restaurant.
     */
    public List<Restaurant> showAll();

    /**
     * Obtiene una entidad Restaurant específica por su ID.
     *
     * @param pRestaurant_Id el ID de la entidad Restaurant a obtener.
     * @return la entidad Restaurant correspondiente al ID dado, o null si no se encuentra.
     */
    public Restaurant FindById(Integer pRestaurant_Id);

    /**
     * Guarda una entidad Restaurant en la base de datos.
     *
     * @param pRestaurant la entidad Restaurant a guardar.
     */
    public void saveRestaurant(Restaurant pRestaurant);

    /**
     * Elimina una entidad Restaurant de la base de datos.
     *
     * @param pRestaurant la entidad Restaurant a eliminar.
     */
    public void deleteRestaurant(Restaurant pRestaurant);

}