/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.beans;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import sv.edu.ufg.icti.siu.entidades.Investigador;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Stateless
public class InvestigadorPuntos {
     @PersistenceContext(unitName = "ICTISIU-1.0PU")
    private EntityManager em;
    

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }
    
    
    public int sumarPuntos(int investigador, String ano){
        int puntos=0;
        String estado="Aceptado";
        //System.out.println("entro a sumar puntos");
         try {//jmacrsys 4 para test
             StoredProcedureQuery q = getEm().createStoredProcedureQuery("calificar");
             q.registerStoredProcedureParameter("idinves", Integer.class, ParameterMode.IN);
             q.registerStoredProcedureParameter("estado", String.class, ParameterMode.IN);
             q.registerStoredProcedureParameter("ano", String.class, ParameterMode.IN);
             q.registerStoredProcedureParameter("total", Integer.class, ParameterMode.OUT);
             //q.setParameter("idinves", investigador.getIdinvestigador());
             q.setParameter("idinves", investigador);
             q.setParameter("estado", estado);
             q.setParameter("ano", ano);
             q.execute();
             
             if(q.getOutputParameterValue("total")==null){
                 puntos=0;
             }else{
                 puntos = (Integer)q.getOutputParameterValue("total"); 
             }
            
             //System.out.println("Puntos:"+puntos);
             
             
             
             
         }catch (NoResultException e) {
         System.out.println("No encuentra resultado poner contador luego");
        } catch (Exception e) {
            System.out.println("Error mientras ejecuta query: " + e.getMessage());
            e.printStackTrace();
            
        }
        return puntos;
    }

    
    
    public List<Investigador> investigadoresActivos() {
      
            System.out.println("entro a buscar activos");
            String estado ="Activo";
            Query q =getEm().createNamedQuery("Investigador.findByEstado", Investigador.class);
            q.setParameter("estado", estado);
                
            return q.getResultList(); 
    }
     public List<Investigador> investigadoresInactivos() {
      
            System.out.println("entro a buscar Inactivos");
            String estado ="Inactivo";
            Query q =getEm().createNamedQuery("Investigador.findByEstado", Investigador.class);
            q.setParameter("estado", estado);
                
            return q.getResultList(); 
    }
     
    
}
