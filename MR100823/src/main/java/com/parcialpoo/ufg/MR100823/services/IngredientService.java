package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Ingredient;
import com.parcialpoo.ufg.MR100823.repository.IngredientRepository;

/**
 * Servicio para manejar las operaciones de la entidad Ingredient.
 *
 * @author remr1
 */
public class IngredientService implements IIngredientService {

    /**
     * Inyección de dependencia de la interfaz IngredientRepository.
     */
    @Autowired
    private IngredientRepository pIngredientRepository;

    /**
     * Obtiene una lista con todas las entidades Ingredient almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Ingredient.
     */
    @Override
    public List<Ingredient> showAll() {
        return pIngredientRepository.findAll();
    }

    /**
     * Obtiene una entidad Ingredient específica por su ID.
     *
     * @param pIngredient_Id el ID de la entidad Ingredient a obtener.
     * @return la entidad Ingredient correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Ingredient FindById(Integer pIngredient_Id) {
        return pIngredientRepository.findById(pIngredient_Id).orElse(null);
    }

    /**
     * Guarda una entidad Ingredient en la base de datos.
     *
     * @param pIngredient la entidad Ingredient a guardar.
     */
    @Override
    public void saveIngredient(Ingredient pIngredient) {
        pIngredientRepository.save(pIngredient);
    }

    /**
     * Elimina una entidad Ingredient de la base de datos.
     *
     * @param pIngredient la entidad Ingredient a eliminar.
     */
    @Override
    public void deleteIngredient(Ingredient pIngredient) {
        pIngredientRepository.delete(pIngredient);
    }

}