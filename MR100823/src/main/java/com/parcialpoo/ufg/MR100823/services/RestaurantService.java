package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.repository.RestaurantRepository;

/**
 * Servicio para manejar las operaciones de la entidad Restaurant.
 *
 * @author remr1
 */
public class RestaurantService implements IRestaurantService {

    /**
     * Inyección de dependencia de la interfaz RestaurantRepository.
     */
    @Autowired
    private RestaurantRepository pRestaurantRepository;

    /**
     * Obtiene una lista con todas las entidades Restaurant almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Restaurant.
     */
    @Override
    public List<Restaurant> showAll() {
        return pRestaurantRepository.findAll();
    }

    /**
     * Obtiene una entidad Restaurant específica por su ID.
     *
     * @param pRestaurant_Id el ID de la entidad Restaurant a obtener.
     * @return la entidad Restaurant correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Restaurant FindById(Integer pRestaurant_Id) {
        return pRestaurantRepository.findById(pRestaurant_Id).orElse(null);
    }

    /**
     * Guarda una entidad Restaurant en la base de datos.
     *
     * @param pRestaurant la entidad Restaurant a guardar.
     */
    @Override
    public void saveRestaurant(Restaurant pRestaurant) {
        pRestaurantRepository.save(pRestaurant);
    }

    /**
     * Elimina una entidad Restaurant de la base de datos.
     *
     * @param pRestaurant la entidad Restaurant a eliminar.
     */
    @Override
    public void deleteRestaurant(Restaurant pRestaurant) {
        pRestaurantRepository.delete(pRestaurant);
    }

}