/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.ufg.icti.siu.entidades.Evidencia;
import sv.edu.ufg.icti.siu.entidades.Investigador;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Stateless
public class EvidenciaFecha {
    @PersistenceContext(unitName = "ICTISIU-1.0PU")
    private EntityManager em;
    
     /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }
    
    public List<Evidencia> evidenciasxYear(String ano1, String ano2, Investigador investigador) {
        
        
     Query q =getEm().createNamedQuery("Evidencia.findByFecha", Investigador.class);
            q.setParameter("ano1", ano1);  
            q.setParameter("ano2", ano2);
            q.setParameter("investigador", investigador);
            return q.getResultList();
        
    }
    
}
