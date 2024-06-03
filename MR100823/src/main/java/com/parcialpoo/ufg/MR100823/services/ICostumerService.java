package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Costumer;

/**
 * Interfaz para definir los métodos de servicio de la entidad Costumer.
 *
 * @author remr1
 */
public interface ICostumerService {

    /**
     * Obtiene una lista con todas las entidades Costumer almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Costumer.
     */
    public List<Costumer> showAll();

    /**
     * Obtiene una entidad Costumer específica por su ID.
     *
     * @param pCostumer_Id el ID de la entidad Costumer a obtener.
     * @return la entidad Costumer correspondiente al ID dado, o null si no se encuentra.
     */
    public Costumer FindById(Integer pCostumer_Id);

    /**
     * Guarda una entidad Costumer en la base de datos.
     *
     * @param pCoscutmer la entidad Costumer a guardar.
     */
    public void saveCostumer(Costumer pCoscutmer);

    /**
     * Elimina una entidad Costumer de la base de datos.
     *
     * @param pCostumer la entidad Costumer a eliminar.
     */
    public void deleteCostumer(Costumer pCostumer);

}