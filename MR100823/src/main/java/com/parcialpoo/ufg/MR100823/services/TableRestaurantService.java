package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.TableRestaurant;
import com.parcialpoo.ufg.MR100823.repository.TableRestaurantRepository;

/**
 * Servicio para manejar las operaciones de la entidad TableRestaurant.
 *
 * @author remr1
 */
public class TableRestaurantService implements ITableRestaurantService {

    /**
     * Inyección de dependencia de la interfaz TableRestaurantRepository.
     */
    @Autowired
    private TableRestaurantRepository pTableRestaurantRepository;

    /**
     * Obtiene una lista con todas las entidades TableRestaurant almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades TableRestaurant.
     */
    @Override
    public List<TableRestaurant> showAll() {
        return pTableRestaurantRepository.findAll();
    }

    /**
     * Obtiene una entidad TableRestaurant específica por su ID.
     *
     * @param pTableRestaurant_Id el ID de la entidad TableRestaurant a obtener.
     * @return la entidad TableRestaurant correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public TableRestaurant FindById(Integer pTableRestaurant_Id) {
        return pTableRestaurantRepository.findById(pTableRestaurant_Id).orElse(null);
    }

    /**
     * Guarda una entidad TableRestaurant en la base de datos.
     *
     * @param pTableRestaurant la entidad TableRestaurant a guardar.
     */
    @Override
    public void saveTableRestaurant(TableRestaurant pTableRestaurant) {
        pTableRestaurantRepository.save(pTableRestaurant);
    }

    /**
     * Elimina una entidad TableRestaurant de la base de datos.
     *
     * @param pTableRestaurant la entidad TableRestaurant a eliminar.
     */
    @Override
    public void deleteTableRestaurant(TableRestaurant pTableRestaurant) {
        pTableRestaurantRepository.delete(pTableRestaurant);
    }

}