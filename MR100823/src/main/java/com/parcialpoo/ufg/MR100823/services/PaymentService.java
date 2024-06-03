package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Payment;
import com.parcialpoo.ufg.MR100823.repository.PaymentRepository;

/**
 * Servicio para manejar las operaciones de la entidad Payment.
 *
 * @author remr1
 */
public class PaymentService implements IPaymentService {

    /**
     * Inyección de dependencia de la interfaz PaymentRepository.
     */
    @Autowired
    private PaymentRepository pPaymentRepository;

    /**
     * Obtiene una lista con todas las entidades Payment almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Payment.
     */
    @Override
    public List<Payment> showAll() {
        return pPaymentRepository.findAll();
    }

    /**
     * Obtiene una entidad Payment específica por su ID.
     *
     * @param pPayment_Id el ID de la entidad Payment a obtener.
     * @return la entidad Payment correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Payment FindById(Integer pPayment_Id) {
        return pPaymentRepository.findById(pPayment_Id).orElse(null);
    }

    /**
     * Guarda una entidad Payment en la base de datos.
     *
     * @param pPayment la entidad Payment a guardar.
     */
    @Override
    public void savePayment(Payment pPayment) {
        pPaymentRepository.save(pPayment);
    }

    /**
     * Elimina una entidad Payment de la base de datos.
     *
     * @param pPayment la entidad Payment a eliminar.
     */
    @Override
    public void deletePayment(Payment pPayment) {
        pPaymentRepository.delete(pPayment);
    }

}