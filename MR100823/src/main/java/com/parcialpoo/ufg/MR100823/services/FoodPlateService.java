package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.repository.FoodPlateRepository;

/**
 * Servicio para manejar las operaciones de la entidad FoodPlate.
 *
 * @author remr1
 */
@Service
public class FoodPlateService implements IFoodPlateService {

    /**
     * Inyección de dependencia de la interfaz FoodPlateRepository.
     */
	@Autowired
    private FoodPlateRepository pFoodPlateRepository;

    /**
     * Obtiene una lista con todas las entidades FoodPlate almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades FoodPlate.
     */
    @Override
    public List<FoodPlate> showAll() {
        return pFoodPlateRepository.findAll();
    }

    /**
     * Obtiene una entidad FoodPlate específica por su ID.
     *
     * @param pFoodPlate_Id el ID de la entidad FoodPlate a obtener.
     * @return la entidad FoodPlate correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public FoodPlate FindById(Integer pFoodPlate_Id) {
        return pFoodPlateRepository.findById(pFoodPlate_Id).orElse(null);
    }

    /**
     * Guarda una entidad FoodPlate en la base de datos.
     *
     * @param pFoodPlate la entidad FoodPlate a guardar.
     */
    @Override
    public void saveFoodPlate(FoodPlate pFoodPlate) {
        pFoodPlateRepository.save(pFoodPlate);
    }

    /**
     * Elimina una entidad FoodPlate de la base de datos.
     *
     * @param pFoodPlate la entidad FoodPlate a eliminar.
     */
    @Override
    public void deleteFoodPlate(FoodPlate pFoodPlate) {
        pFoodPlateRepository.delete(pFoodPlate);
    }

}