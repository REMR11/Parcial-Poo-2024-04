package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Menu;

/**
 * Interfaz para definir los métodos de servicio de la entidad Menu.
 *
 * @author remr1
 */
public interface IMenuService {

    /**
     * Obtiene una lista con todas las entidades Menu almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Menu.
     */
    public List<Menu> showAll();

    /**
     * Obtiene una entidad Menu específica por su ID.
     *
     * @param pMenu_Id el ID de la entidad Menu a obtener.
     * @return la entidad Menu correspondiente al ID dado, o null si no se encuentra.
     */
    public Menu FindById(Integer pMenu_Id);

    /**
     * Guarda una entidad Menu en la base de datos.
     *
     * @param pMenu la entidad Menu a guardar.
     */
    public void saveMenu(Menu pMenu);

    /**
     * Elimina una entidad Menu de la base de datos.
     *
     * @param pMenu la entidad Menu a eliminar.
     */
    public void deleteMenu(Menu pMenu);

}