package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.repository.CostumerRepository;

/**
 * Servicio para manejar las operaciones de la entidad Costumer.
 *
 * @author remr1
 *  */
public class CostumerService implements ICostumerService {

    /**
     * Inyección de dependencia de la interfaz CostumerRepository.
     */
    @Autowired
    private CostumerRepository costumerRepository;

    /**
     * Obtiene una lista con todas las entidades Costumer almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Costumer.
     */
    @Override
    public List<Costumer> showAll() {
        return costumerRepository.findAll();
    }

    /**
     * Obtiene una entidad Costumer específica por su ID.
     *
     * @param pCostumer_Id el ID de la entidad Costumer a obtener.
     * @return la entidad Costumer correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Costumer FindById(Integer pCostumer_Id) {
        Costumer costumer = costumerRepository.findById(pCostumer_Id).orElse(null);
        return costumer;
    }

    /**
     * Guarda una entidad Costumer en la base de datos.
     *
     * @param pCoscutmer la entidad Costumer a guardar.
     */
    @Override
    public void saveCostumer(Costumer pCoscutmer) {
        costumerRepository.save(pCoscutmer);
    }

    /**
     * Elimina una entidad Costumer de la base de datos.
     *
     * @param pCostumer la entidad Costumer a eliminar.
     */
    @Override
    public void deleteCostumer(Costumer pCostumer) {
        costumerRepository.delete(pCostumer);
    }

}