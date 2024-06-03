package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.OrderCostumer;
import com.parcialpoo.ufg.MR100823.repository.OrderCostumerRepository;

/**
 * Servicio para manejar las operaciones de la entidad OrderCostumer.
 *
 * @author remr1
 */
public class OrderCostumerService implements IOrderCostumerService {

    /**
     * Inyección de dependencia de la interfaz OrderCostumerRepository.
     */
    @Autowired
    private OrderCostumerRepository pOrderCostumerRepository;

    /**
     * Obtiene una lista con todas las entidades OrderCostumer almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades OrderCostumer.
     */
    @Override
    public List<OrderCostumer> showAll() {
        return pOrderCostumerRepository.findAll();
    }

    /**
     * Obtiene una entidad OrderCostumer específica por su ID.
     *
     * @param pOrderCostumer_Id el ID de la entidad OrderCostumer a obtener.
     * @return la entidad OrderCostumer correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public OrderCostumer FindById(Integer pOrderCostumer_Id) {
        return pOrderCostumerRepository.findById(pOrderCostumer_Id).orElse(null);
    }

    /**
     * Guarda una entidad OrderCostumer en la base de datos.
     *
     * @param pOrderCostumer la entidad OrderCostumer a guardar.
     */
    @Override
    public void saveOrderCostumer(OrderCostumer pOrderCostumer) {
        pOrderCostumerRepository.save(pOrderCostumer);
    }

    /**
     * Elimina una entidad OrderCostumer de la base de datos.
     *
     * @param pOrderCostumer la entidad OrderCostumer a eliminar.
     */
    @Override
    public void deleteOrderCostumer(OrderCostumer pOrderCostumer) {
        pOrderCostumerRepository.delete(pOrderCostumer);
    }

}