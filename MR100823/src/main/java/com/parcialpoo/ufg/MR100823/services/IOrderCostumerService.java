package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.OrderCostumer;

/**
 * Interfaz para definir los métodos de servicio de la entidad OrderCostumer.
 *
 * @author remr1
 */
public interface IOrderCostumerService {

    /**
     * Obtiene una lista con todas las entidades OrderCostumer almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades OrderCostumer.
     */
    public List<OrderCostumer> showAll();

    /**
     * Obtiene una entidad OrderCostumer específica por su ID.
     *
     * @param pOrderCostumer_Id el ID de la entidad OrderCostumer a obtener.
     * @return la entidad OrderCostumer correspondiente al ID dado, o null si no se encuentra.
     */
    public OrderCostumer FindById(Integer pOrderCostumer_Id);

    /**
     * Guarda una entidad OrderCostumer en la base de datos.
     *
     * @param pOrderCostumer la entidad OrderCostumer a guardar.
     */
    public void saveOrderCostumer(OrderCostumer pOrderCostumer);

    /**
     * Elimina una entidad OrderCostumer de la base de datos.
     *
     * @param pOrderCostumer la entidad OrderCostumer a eliminar.
     */
    public void deleteOrderCostumer(OrderCostumer pOrderCostumer);

}