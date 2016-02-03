/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.report;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sv.edu.ufg.icti.siu.entidades.Investigador;
import sv.edu.ufg.icti.siu.beans.InvestigadorFacade;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@ManagedBean
@RequestScoped
public class InvestigadorPDF implements Serializable{
  @Inject InvestigadorFacade ejbFacade;
    private Investigador investigador;
    //public List<Investigador> listInvestigadores;
    JasperPrint jasperPrint;
    
    public void generarPdf(Integer id) throws JRException, IOException{
        System.out.println("Entramos al metodo");
        System.out.println("Vemos si llega con variable:"+id);
        
        Investigador invest;
      invest = new Investigador();
        invest = ejbFacade.find(id);
        
         System.out.println("prueba de objeto:"+invest.getNia());
         
         List<Investigador> milista = new ArrayList<Investigador>();
         milista.add(invest);
         
         System.out.println("probandolista:"+milista.isEmpty());
        
        
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(milista);
        System.out.println("pasa");
        Map params;
        params = new HashMap<>();//por si lo usamos
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("informes/report1.jasper"));	
        jasperPrint=JasperFillManager.fillReport(jasper.getPath(), params, beanCollectionDataSource);
        HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
        ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }

    /**
     * @return the investigador
     */
    public Investigador getInvestigador() {
        return investigador;
    }

    /**
     * @param investigador the investigador to set
     */
    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

   
}
