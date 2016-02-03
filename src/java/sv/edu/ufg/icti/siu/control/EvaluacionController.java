package sv.edu.ufg.icti.siu.control;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sv.edu.ufg.icti.siu.entidades.Evaluacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import sv.edu.ufg.icti.siu.beans.EvaluacionAno;

@Named(value = "evaluacionController")
@ViewScoped
public class EvaluacionController extends AbstractController<Evaluacion> {

    @Inject
    private InvestigadorController idinvestigadorController;
    @Inject
    private CalificacionController idcalController;
    @Inject
    private EvaluacionAno eva;
    private String anoeva;
    private Collection<Evaluacion> listaEva;

    public EvaluacionController() {
        // Inform the Abstract parent controller of the concrete Evaluacion?cap_first Entity
        super(Evaluacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idinvestigadorController.setSelected(null);
        idcalController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Investigador controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdinvestigador(ActionEvent event) {
        if (this.getSelected() != null && idinvestigadorController.getSelected() == null) {
            idinvestigadorController.setSelected(this.getSelected().getIdinvestigador());
        }
    }

    /**
     * Sets the "selected" attribute of the Calificacion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdcal(ActionEvent event) {
        if (this.getSelected() != null && idcalController.getSelected() == null) {
            idcalController.setSelected(this.getSelected().getIdcal());
        }
    }
    //modificar la exportacion de informe
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        
        
        pdf.setPageSize(PageSize.A4.rotate());
        pdf.open();
        Paragraph titulo = new Paragraph("Instituto de Ciencia, Tecnología e Innovación (ICTI-UFG)");
        Paragraph subti = new Paragraph("Evaluaciones");
        titulo.setAlignment(Element.ALIGN_CENTER);
        pdf.add(titulo);
        subti.setAlignment(Element.ALIGN_CENTER);
        pdf.add(subti);
        pdf.add(new Paragraph(" ") );
        
       
       
 
       // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String logo = servletContext.getRealPath("")  + File.separator + "imagenes" + File.separator + "ICTI03.jpg";
         
        //pdf.add(Image.getInstance(logo));
    }

    /**
     * @return the anoeva
     */
    public String getAnoeva() {
        return anoeva;
    }

    /**
     * @param anoeva the anoeva to set
     */
    public void setAnoeva(String anoeva) {
        this.anoeva = anoeva;
    }

    /**
     * @return the listaEva
     */
    public Collection<Evaluacion> getListaEva() {
        if(listaEva==null){
            System.out.println("entro a recuperar la lista de evaluados");
           listaEva=this.eva.evaluadosxAno(anoeva);
        }
        return listaEva;
    }

    /**
     * @param listaEva the listaEva to set
     */
    public void setListaEva(Collection<Evaluacion> listaEva) {
        this.listaEva = listaEva;
    }
     JasperPrint jasperPrint;
    public void init() throws JRException{
        System.out.println("Entramos al init:");
        System.out.println("imprimo el ano:"+this.anoeva);
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(this.listaEva);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ano", this.anoeva);
        //params.put("listaeva", beanCollectionDataSource); 
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("informes/evaluados2.jasper"));	
        jasperPrint=JasperFillManager.fillReport(jasper.getPath(), params, beanCollectionDataSource);
    }
    public void DOCX(ActionEvent actionEvent) throws JRException, IOException{
        init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.docx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRDocxExporter docxExporter=new JRDocxExporter();
       
     //docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
       //docxExporter.setExporterOutput();
       
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
   }
    public void PDF(ActionEvent actionEvent) throws JRException, IOException{  
       init();  
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();  
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");  
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();  
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);  
       FacesContext.getCurrentInstance().responseComplete();  
         
         //pendiente
   }  
    public void XLSX(ActionEvent actionEvent) throws JRException, IOException{
       init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.xlsx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRXlsxExporter docxExporter=new JRXlsxExporter();
       
       //recordar usar nuevo metodo input
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
   }
    //creamos un documento a pie con poi
    //dar formato a la tabla si lo requieren
    public void personalizadoDOCX(ActionEvent actionEvent) throws IOException{
        
      XWPFDocument documento = new XWPFDocument();  
      
      XWPFParagraph titulo1 = documento.createParagraph();
      titulo1.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun run1 = titulo1.createRun();
      run1.setBold(true);
      run1.setText("UNIVERSIDAD FRANCISCO GAVIDIA");
      
      XWPFParagraph titulo2 = documento.createParagraph();
      titulo2.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun run2 = titulo2.createRun();
      run2.setBold(true);
      run2.setText("INSTITUTO DE CIENCIA, TECNOLOGIA E INNVACION");
      
      XWPFParagraph titulo3 = documento.createParagraph();
      titulo3.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun run3 = titulo3.createRun();
      run3.setBold(true);
      run3.setText("PERSONAL SISTEMA DE INVESTIGACION");
      
      XWPFParagraph titulo4 = documento.createParagraph();
      titulo4.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun run4 = titulo4.createRun();
      run4.setBold(true);
      run4.setText("ANO "+anoeva);
      
      XWPFTable tab = documento.createTable();
      XWPFTableRow fila = tab.getRow(0);
	
      //esta es la primer fila y la tomaremos como cabecera de columnas
      fila.getCell(0).setText("No");
      fila.addNewTableCell().setText("Nombre");
      fila.addNewTableCell().setText("Fecha  ");
      fila.addNewTableCell().setText("Categoría  ");
      fila.addNewTableCell().setText("Puntos ");
      fila.addNewTableCell().setText("Bono   ");
      fila.addNewTableCell().setText("Firma   ");
      
      //recorremos la lista
      Iterator it = this.getListaEva().iterator();
      int no =1;
      while(it.hasNext()){
          Evaluacion eval = new Evaluacion();
          
          eval = (Evaluacion) it.next();
          //rellenamos las nuevas filas
          
          fila = tab.createRow();
	  fila.getCell(0).setText(""+no);
	  fila.getCell(1).setText(""+eval.getIdinvestigador().getNombres()+" "+eval.getIdinvestigador().getApellidos());
	  fila.getCell(2).setText(""+anoeva);
	  fila.getCell(3).setText(""+eval.getIdcal().getNombre());
	  fila.getCell(4).setText(""+eval.getPuntaje());
	  fila.getCell(5).setText("$"+eval.getIdcal().getBono());
          fila.getCell(6).setText("              ");
          no++;
      }
      documento.createParagraph().createRun().addBreak();
      
      HttpServletResponse res = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       res.setHeader("Content-disposition",  "attachment; filename=evaluacion.docx");
         
         
        try {
            ServletOutputStream out = res.getOutputStream();
   
             documento.write(out);
             out.flush();
             out.close();
       } catch (IOException ex) { 
               ex.printStackTrace();
       }
  
         
      FacesContext faces = FacesContext.getCurrentInstance();
      faces.responseComplete();  
        
    }
    
}
