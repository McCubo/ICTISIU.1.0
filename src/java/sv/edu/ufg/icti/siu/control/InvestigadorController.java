package sv.edu.ufg.icti.siu.control;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sv.edu.ufg.icti.siu.entidades.Investigador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import sv.edu.ufg.icti.siu.beans.EvidenciaFecha;
import sv.edu.ufg.icti.siu.beans.InvestigadorPuntos;
import sv.edu.ufg.icti.siu.control.util.JsfUtil;
import sv.edu.ufg.icti.siu.entidades.Calificacion;
import sv.edu.ufg.icti.siu.entidades.Evaluacion;
import sv.edu.ufg.icti.siu.entidades.Evidencia;

@Named(value = "investigadorController")
@ViewScoped
public class InvestigadorController extends AbstractController<Investigador> {

    @Inject
    private GradoacademicoController gradoacademicoListController;
    @Inject
    private TipocontratacionController idtipocontraController;
    @Inject
    private EvidenciaController evidenciaListController;
    @Inject
    private EvaluacionController evaluacionListController;
 @Inject
    private InvestigadorPuntos puntos;
      @Inject
      private CalificacionController calificacionControl;
      @Inject 
      private EvidenciaFecha evidenciaFecha;
    private String ano;
    private String ano2;
    private Date year;
    private int id;
    private String estado;
    private Investigador investigador;//para busqueda no es necesario pero por tiempo
    private Collection<Investigador> activos;
    private Collection<Investigador> inactivos;
    private Collection<Evaluacion> evaluados;
    private Collection<Evidencia> listaEvidencia;
     private Collection<Investigador> invesestado;//contenga la lista de los investigadores segun su estado
    
    public InvestigadorController() {
        // Inform the Abstract parent controller of the concrete Investigador?cap_first Entity
        super(Investigador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idtipocontraController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Gradoacademico entities
     * that are retrieved from Investigador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Gradoacademico page
     */
    public String navigateGradoacademicoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Gradoacademico_items", this.getSelected().getGradoacademicoList());
        }
        return "/gradoacademico/index";
    }

    /**
     * Sets the "selected" attribute of the Tipocontratacion controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdtipocontra(ActionEvent event) {
        if (this.getSelected() != null && idtipocontraController.getSelected() == null) {
            idtipocontraController.setSelected(this.getSelected().getIdtipocontra());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Evidencia entities that
     * are retrieved from Investigador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Evidencia page
     */
    public String navigateEvidenciaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Evidencia_items", this.getSelected().getEvidenciaList());
        }
        return "/evidencia/index";
    }

    /**
     * Sets the "items" attribute with a collection of Evaluacion entities that
     * are retrieved from Investigador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Evaluacion page
     */
    public String navigateEvaluacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Evaluacion_items", this.getSelected().getEvaluacionList());
        }
        return "/evaluacion/index";
    }
    public void generaCod(ActionEvent event ){
        
        String cod = this.getSelected().getApellidos();
        String aux;
        String aux2;
        StringBuilder micod = new StringBuilder();
        for(int i=0;i<cod.length();i++){
            //extraer las mayusculas
            if(Character.isUpperCase(cod.charAt(i))){
                micod.append(cod.charAt(i));
            }
        }
        if(micod.length()==1){
            //si es solo un apellido
            aux=micod.toString()+micod.toString();
        }else{
          aux = micod.toString();  
        }
        //System.out.println("contar"+micod.length());
        //se le suma 10000 al numero de investigadores
        //pero como java cuenta el 0 el primer investigador sera 10000
       aux2 = String.valueOf(this.getItems().size()+10000);
        this.getSelected().setNia(aux+aux2);
        
    }
     public void postProcessXLS(Object document) {
         //usando extension de primefaces esto no queda muy bien
         //hay que leer lo nuevo de poi
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
             
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
        }
    }
     
      public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
       
        
        pdf.setPageSize(PageSize.A4.rotate());
        pdf.open();
        Paragraph titulo = new Paragraph("Instituto de Ciencia, Tecnología e Innovación (ICTI-UFG)");
        Paragraph subti = new Paragraph("Investigadores");
        titulo.setAlignment(Element.ALIGN_CENTER);
        pdf.add(titulo);
        subti.setAlignment(Element.ALIGN_CENTER);
        pdf.add(subti);
        pdf.add(new Paragraph(" ") );
        
       
       
 
       // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String logo = servletContext.getRealPath("")  + File.separator + "imagenes" + File.separator + "ICTI03.jpg";
         
        //pdf.add(Image.getInstance(logo));
    }
      public void mostrarpuntos(ActionEvent event){
          //tess para la suma de puntos de investigadores activos por a
          int puntos=0;
          System.out.println("entro al mostrar puntos");
          System.out.println("mostremos el id:"+this.id);
          System.out.println("mostremos el ano"+this.ano);
          puntos = this.puntos.sumarPuntos(this.id, this.ano);
          System.out.println("prueba;"+puntos);
          
          
          
      }
      
     

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the activos
     */
    public Collection<Investigador> getActivos() {
        if(activos==null){
            activos = this.puntos.investigadoresActivos();
        }
        return activos;
    }
    

    /**
     * @param activos the activos to set
     */
    public void setActivos(Collection<Investigador> activos) {
        this.activos = activos;
    }
    public List<Evaluacion> listaEvaluados(){
        //System.out.println("antes del date");
        //Date fecha = new Date(); 
        //System.out.println("despues de asignar date");
         
        //Investigador invest = new Investigador();     
        List<Evaluacion> lista = new ArrayList<Evaluacion>();
        //System.out.println("despues del arraylist");
        //System.out.println("imprimo ano"+this.ano);
        if(this.ano==null){
           // System.out.println("chequeo que ano esta vacio");
            lista=null;
             return lista;
        }else{
           // System.out.println("ano no esta vacio");
            Iterator it = this.getActivos().iterator();
           // System.out.println("asigne iterator");
            int puntos=0;
       while(it.hasNext()){
            Evaluacion evi = new Evaluacion();
           Investigador i = new Investigador();
         i =(Investigador) it.next();
           //System.out.println("Imprimir nombre:"+i.getNombres());
         evi.setIdinvestigador(i);
         evi.setFecha(this.year);
         puntos = this.puntos.sumarPuntos(i.getIdinvestigador(), this.ano);
         evi.setPuntaje(puntos);
         evi.setIdcal(this.calificacion(puntos));
         lista.add(evi);
         
         //reiniciamos investigador
         
            
        }
       
       
          return lista; 
       }
       
    }

    /**
     * @return the evaluados
     */
    public Collection<Evaluacion> getEvaluados() {
       // System.out.println("Entro al metodo getEvaluados");
        if(evaluados==null){
            evaluados = this.listaEvaluados();
            if(evaluados==null){
               System.out.println("la lista esta vacia:"); 
            }else{
                System.out.println("no esta vacia:"+evaluados.size());
            }
            
        }
        return evaluados;
    }

    /**
     * @param evaluados the evaluados to set
     */
    public void setEvaluados(Collection<Evaluacion> evaluados) {
        this.evaluados = evaluados;
    }
    public void resetEvaluados(ActionEvent event){
        this.evaluados=null;
    }
    
    public Calificacion calificacion(int puntos){
        Calificacion cal= new Calificacion();
        //si existe una modificacion en los puntos a evaluar tienen que ser llamados de la base de datos
        //ejemplo llenamos el puntajemax y puntajemin
        //cal = calificacionControl.getPorId(4) para la categoria D
        //if(puntos>=cal.getPuntajemin() && puntos<=cal.getPuntajemax()
        
        if(puntos>=0 && puntos<19){
            cal = calificacionControl.getPorId(4);
             
        }if(puntos>18 && puntos<33){
            cal = calificacionControl.getPorId(3);
        }if(puntos>32 && puntos<47){
            cal = calificacionControl.getPorId(2);
        }if(puntos>47){
            cal = calificacionControl.getPorId(1);
        }
        
        
        return cal;
        
    }
    public void guardarEvaluados(ActionEvent event){
        //System.out.println("antes del date");
        //Date fecha = new Date();
        //System.out.println("despues de asignar date");
         
        //Investigador invest = new Investigador();     
        
        //System.out.println("despues del arraylist");
        //System.out.println("imprimo ano"+this.ano);
        if(this.ano==null){
            System.out.println("chequeo que ano esta vacio");
            
             
        }else{
            //System.out.println("ano no esta vacio");
            Iterator it = this.getActivos().iterator();
            //System.out.println("asigne iterator");
            int puntos=0;
       while(it.hasNext()){
            Evaluacion evi = new Evaluacion();
           Investigador i = new Investigador();
         i =(Investigador) it.next();
           //System.out.println("Imprimir nombre:"+i.getNombres());
         evi.setIdinvestigador(i);
         evi.setFecha(this.year);
         puntos = this.puntos.sumarPuntos(i.getIdinvestigador(), this.ano);
         evi.setPuntaje(puntos);
         evi.setIdcal(this.calificacion(puntos));
         evaluacionListController.guardarDirecto(evi);
         //guardar cada objeto en la base de datos;
    }}JsfUtil.addSuccessMessage("Evaluaciones guardadas");}

    /**
     * @return the year
     */
    public Date getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * @return the inactivos
     */
    public Collection<Investigador> getInactivos() {
        if(inactivos==null){
            inactivos = this.puntos.investigadoresInactivos();
        }
        return inactivos;
    }

    /**
     * @param inactivos the inactivos to set
     */
    public void setInactivos(Collection<Investigador> inactivos) {
        this.inactivos = inactivos;
    }

    /**
     * @return the ano2
     */
    public String getAno2() {
        return ano2;
    }

    /**
     * @param ano2 the ano2 to set
     */
    public void setAno2(String ano2) {
        this.ano2 = ano2;
    }

    /**
     * @return the invesestado
     */
    public Collection<Investigador> getInvesestado() {
           if(this.estado!=null){
            if("A".equals(this.estado)){
                invesestado=this.puntos.investigadoresActivos();
                
            }else{
                if("I".equals(this.estado)){
                    invesestado=this.puntos.investigadoresInactivos();
                }
            }
            
        }
        return invesestado;
    }

    /**
     * @param invesestado the invesestado to set
     */
    public void setInvesestado(Collection<Investigador> invesestado) {
        this.invesestado = invesestado;
    }
    
    
    //Solo para test1 si ya no se relizaran quitarlo
    public void investigadorEstado(ActionEvent event){
        System.out.println("Imprimo el estado "+this.estado);
        if(this.estado!=null){
            if("A".equals(this.estado)){
                setInvesestado(this.puntos.investigadoresActivos());
                
            }else{
                if("I".equals(this.estado)){
                    setInvesestado(this.puntos.investigadoresInactivos());
                }
            }
            
        }
    
    }
    //test objeto investigador quitarlo si no considera usarlo
    //ha sido usado en vez de selected
    //
    public void comprobandoObjetoinvestigador(ActionEvent event){
        System.out.println("Imprimiento nombre "+this.investigador.getNombres());
        System.out.println("Imprimo cuantas evidencia tiene"+this.investigador.getEvidenciaList().size());
    }
   

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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

    /**
     * @return the listaEvidencia
     */
    public Collection<Evidencia> getListaEvidencia() {
    
        if(this.ano!=null){
            System.out.println("imprimir ano2:"+this.ano2);
                if(this.ano2.isEmpty()){
        this.ano2 = this.ano;
    }
                System.out.println("imprimir ano2:"+this.ano2);
    listaEvidencia = evidenciaFecha.evidenciasxYear(ano, ano2, investigador);
        System.out.println("Contenido de la lista:"+listaEvidencia.size());
        return listaEvidencia;    }
return listaEvidencia;
    }

    /**
     * @param listaEvidencia the listaEvidencia to set
     */
    public void setListaEvidencia(Collection<Evidencia> listaEvidencia) {
        this.listaEvidencia = listaEvidencia;
    }
    JasperPrint jasperPrint;
    public void init() throws JRException{
        
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(this.listaEvidencia);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("investigador", this.investigador);
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("informes/report2.jasper"));	
        jasperPrint=JasperFillManager.fillReport(jasper.getPath(), params, beanCollectionDataSource);
    }
    public void DOCX(ActionEvent actionEvent) throws JRException, IOException{
        init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=investreport.docx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRDocxExporter docxExporter=new JRDocxExporter();
       
     //docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
       //docxExporter.setExporterOutput();
       
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, servletOutputStream);
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
      run3.setText("EVIDENCIAS INVESTIGADOR");
      
      XWPFParagraph titulo4 = documento.createParagraph();
      titulo4.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun run4 = titulo4.createRun();
      run4.setBold(true);
      run4.setText(""+this.investigador.getNombres()+" "+this.investigador.getApellidos());
      
      
      
      XWPFTable tab = documento.createTable();
      XWPFTableRow fila = tab.getRow(0);
	
      //esta es la primer fila y la tomaremos como cabecera de columnas
      fila.getCell(0).setText("No");
      fila.addNewTableCell().setText("Fecha");
      fila.addNewTableCell().setText("Medición    ");
      fila.addNewTableCell().setText("Puntos  ");
      
      
      //recorremos la lista
      Iterator it = this.listaEvidencia.iterator();
      int no =1;
      while(it.hasNext()){
          Evidencia evi = new Evidencia();
          
          evi = (Evidencia) it.next();
          //rellenamos las nuevas filas
          
          fila = tab.createRow();
	  fila.getCell(0).setText(""+no);
	  fila.getCell(1).setText(""+evi.getFecha());
	  fila.getCell(2).setText(""+evi.getIdmedicion().getNombre());
	  fila.getCell(3).setText(""+evi.getPuntos());
	  no++;
      }
      documento.createParagraph().createRun().addBreak();
      
      HttpServletResponse res = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       res.setHeader("Content-disposition",  "attachment; filename=investigadorEvi.docx");
         
         
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
