package sv.edu.ufg.icti.siu.control;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import sv.edu.ufg.icti.siu.entidades.Evidencia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named(value = "evidenciaController")
@ViewScoped
public class EvidenciaController extends AbstractController<Evidencia> {

    @Inject
    private ArchivoController archivoListController;
    @Inject
    private InvestigadorController idinvestigadorController;
    @Inject
    private MedicionController idmedicionController;
    @Inject
    private InstitucionController idinstitucionController;
private StreamedContent file;
    public EvidenciaController() {
        // Inform the Abstract parent controller of the concrete Evidencia?cap_first Entity
        super(Evidencia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idinvestigadorController.setSelected(null);
        idmedicionController.setSelected(null);
        idinstitucionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Archivo entities that are
     * retrieved from Evidencia?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Archivo page
     */
    public String navigateArchivoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Archivo_items", this.getSelected().getArchivoList());
        }
        return "/archivo/index";
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
     * Sets the "selected" attribute of the Medicion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdmedicion(ActionEvent event) {
        if (this.getSelected() != null && idmedicionController.getSelected() == null) {
            idmedicionController.setSelected(this.getSelected().getIdmedicion());
        }
    }

    /**
     * Sets the "selected" attribute of the Institucion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdinstitucion(ActionEvent event) {
        if (this.getSelected() != null && idinstitucionController.getSelected() == null) {
            idinstitucionController.setSelected(this.getSelected().getIdinstitucion());
        }
    }
     public void pasarPuntos(ActionEvent event){
       this.getSelected().setPuntos(this.getSelected().getIdmedicion().getPuntaje());
       
    }
     public void guardarArchivo(FileUploadEvent event){
         System.out.println("entro a guardar archivo");
        FacesMessage msg = new FacesMessage("ok! ", event.getFile().getFileName() + " esta guardado.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Manipulando el archivo       
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void copyFile(String fileName, InputStream in) {
           try {
              //agregando identificador al nombre original
               //String niaFile;//conflicto cuando la evidencia no esta creada
               //niaFile=this.getSelected().getIdinvestigador().getNia()+fileName;
              
                //inputStream para FileOutputStream
                OutputStream out = new FileOutputStream(new File("C:\\evidencias\\" +fileName));
              
                      
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("Nuevo Archivo creado!");
                this.getSelected().setArchivo(fileName);
              
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    
 
    public StreamedContent getFile() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\evidencias\\"+this.getSelected().getArchivo());
        file = new DefaultStreamedContent(stream, "application/pdf", "d_"+this.getSelected().getArchivo());
    
        return file;
    }
     public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
         pdf.setPageSize(PageSize.A4.rotate());
        pdf.open();
        Paragraph titulo = new Paragraph("Instituto de Ciencia, Tecnología e Innovación (ICTI-UFG)");
        Paragraph subti = new Paragraph("Evidencias");
        titulo.setAlignment(Element.ALIGN_CENTER);
        pdf.add(titulo);
        subti.setAlignment(Element.ALIGN_CENTER);
        pdf.add(subti);
        pdf.add(new Paragraph(" ") );
        
       
       
 
       // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String logo = servletContext.getRealPath("")  + File.separator + "imagenes" + File.separator + "ICTI03.jpg";
         
        //pdf.add(Image.getInstance(logo));
    }
}
