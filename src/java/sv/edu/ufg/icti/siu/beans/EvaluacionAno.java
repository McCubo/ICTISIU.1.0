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
import sv.edu.ufg.icti.siu.entidades.Evaluacion;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Stateless
public class EvaluacionAno {
     @PersistenceContext(unitName = "ICTISIU-1.0PU")
    private EntityManager em;
     
     /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }
    
    public List<Evaluacion> evaluadosxAno(String ano){
        System.out.println("entro al query evaluadosxano"+ano);
        if(ano==null){
            System.out.println("ano es null");
        }else{
      Query q =getEm().createNamedQuery("Evaluacion.findByFecha", Evaluacion.class);
            q.setParameter("fecha", ano); 
            
            return q.getResultList();
        
    }
       return null;
    
}}
