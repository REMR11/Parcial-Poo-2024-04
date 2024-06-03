package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Ingredient;

/**
 * Interfaz para definir los métodos de servicio de la entidad Ingredient.
 *
 * @author remr1
 */
public interface IIngredientService {

    /**
     * Obtiene una lista con todas las entidades Ingredient almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Ingredient.
     */
    public List<Ingredient> showAll();

    /**
     * Obtiene una entidad Ingredient específica por su ID.
     *
     * @param pIngredient_Id el ID de la entidad Ingredient a obtener.
     * @return la entidad Ingredient correspondiente al ID dado, o null si no se encuentra.
     */
    public Ingredient FindById(Integer pIngredient_Id);

    /**
     * Guarda una entidad Ingredient en la base de datos.
     *
     * @param pIngredient la entidad Ingredient a guardar.
     */
    public void saveIngredient(Ingredient pIngredient);

    /**
     * Elimina una entidad Ingredient de la base de datos.
     *
     * @param pIngredient la entidad Ingredient a eliminar.
     */
    public void deleteIngredient(Ingredient pIngredient);

}