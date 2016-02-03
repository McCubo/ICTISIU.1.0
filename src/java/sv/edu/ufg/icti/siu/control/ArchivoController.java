package sv.edu.ufg.icti.siu.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import sv.edu.ufg.icti.siu.entidades.Archivo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;

@Named(value = "archivoController")
@ViewScoped
//Este control es para efectos de agregar mas de un archivo vinculado a una evidencia
//apoyarse en la el control EvidenciaController que dispone de metodos para subir y bajar archivos
public class ArchivoController extends AbstractController<Archivo> {

    @Inject
    private EvidenciaController idevidenciaController;

    public ArchivoController() {
        // Inform the Abstract parent controller of the concrete Archivo?cap_first Entity
        super(Archivo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idevidenciaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Evidencia controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdevidencia(ActionEvent event) {
        if (this.getSelected() != null && idevidenciaController.getSelected() == null) {
            idevidenciaController.setSelected(this.getSelected().getIdevidencia());
        }
    }
    public void guardarArchivo(FileUploadEvent event){
        FacesMessage msg = new FacesMessage("ok! ", event.getFile().getFileName() + " esta guardado.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void copyFile(String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File("C:\\evidencias\\" + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("Nuevo Archivo creado!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
}
