package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;

/**
 * Interfaz para definir los métodos de servicio de la entidad FoodPlate.
 *
 * @author remr1
 */
public interface IFoodPlateService {

    /**
     * Obtiene una lista con todas las entidades FoodPlate almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades FoodPlate.
     */
    public List<FoodPlate> showAll();

    /**
     * Obtiene una entidad FoodPlate específica por su ID.
     *
     * @param pFoodPlate_Id el ID de la entidad FoodPlate a obtener.
     * @return la entidad FoodPlate correspondiente al ID dado, o null si no se encuentra.
     */
    public FoodPlate FindById(Integer pFoodPlate_Id);

    /**
     * Guarda una entidad FoodPlate en la base de datos.
     *
     * @param pFoodPlate la entidad FoodPlate a guardar.
     */
    public void saveFoodPlate(FoodPlate pFoodPlate);

    /**
     * Elimina una entidad FoodPlate de la base de datos.
     *
     * @param pFoodPlate la entidad FoodPlate a eliminar.
     */
    public void deleteFoodPlate(FoodPlate pFoodPlate);

}