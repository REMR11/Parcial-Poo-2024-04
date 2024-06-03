package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Payment;

/**
 * Interfaz para definir los métodos de servicio de la entidad Payment.
 *
 * @author remr1
 */
public interface IPaymentService {

    /**
     * Obtiene una lista con todas las entidades Payment almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Payment.
     */
    public List<Payment> showAll();

    /**
     * Obtiene una entidad Payment específica por su ID.
     *
     * @param pPayment_Id el ID de la entidad Payment a obtener.
     * @return la entidad Payment correspondiente al ID dado, o null si no se encuentra.
     */
    public Payment FindById(Integer pPayment_Id);

    /**
     * Guarda una entidad Payment en la base de datos.
     *
     * @param pPayment la entidad Payment a guardar.
     */
    public void savePayment(Payment pPayment);

    /**
     * Elimina una entidad Payment de la base de datos.
     *
     * @param pPayment la entidad Payment a eliminar.
     */
    public void deletePayment(Payment pPayment);

}