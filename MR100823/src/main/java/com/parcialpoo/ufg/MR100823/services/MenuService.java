package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Menu;
import com.parcialpoo.ufg.MR100823.repository.MenuRepository;

/**
 * Servicio para manejar las operaciones de la entidad Menu.
 *
 * @author remr1
 */
public class MenuService implements IMenuService {

    /**
     * Inyección de dependencia de la interfaz MenuRepository.
     */
    @Autowired
    private MenuRepository pMenuRepository;

    /**
     * Obtiene una lista con todas las entidades Menu almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Menu.
     */
    @Override
    public List<Menu> showAll() {
        return pMenuRepository.findAll();
    }

    /**
     * Obtiene una entidad Menu específica por su ID.
     *
     * @param pMenu_Id el ID de la entidad Menu a obtener.
     * @return la entidad Menu correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Menu FindById(Integer pMenu_Id) {
        return pMenuRepository.findById(pMenu_Id).orElse(null);
    }

    /**
     * Guarda una entidad Menu en la base de datos.
     *
     * @param pMenu la entidad Menu a guardar.
     */
    @Override
    public void saveMenu(Menu pMenu) {
        pMenuRepository.save(pMenu);
    }

    /**
     * Elimina una entidad Menu de la base de datos.
     *
     * @param pMenu la entidad Menu a eliminar.
     */
    @Override
    public void deleteMenu(Menu pMenu) {
        pMenuRepository.delete(pMenu);
    }

}