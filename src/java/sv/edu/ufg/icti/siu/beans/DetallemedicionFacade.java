/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ufg.icti.siu.entidades.Detallemedicion;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Stateless
public class DetallemedicionFacade extends AbstractFacade<Detallemedicion> {
    @PersistenceContext(unitName = "ICTISIU-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallemedicionFacade() {
        super(Detallemedicion.class);
    }
    
}
