/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ufg.icti.siu.entidades.Categoria;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {
    @PersistenceContext(unitName = "ICTISIU-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
}
