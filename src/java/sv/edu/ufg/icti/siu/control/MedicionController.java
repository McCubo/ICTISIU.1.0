package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Medicion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "medicionController")
@ViewScoped
public class MedicionController extends AbstractController<Medicion> {

    @Inject
    private EvidenciaController evidenciaListController;
    @Inject
    private DetallemedicionController detallemedicionListController;
    @Inject
    private CategoriaController idcateController;

    public MedicionController() {
        // Inform the Abstract parent controller of the concrete Medicion?cap_first Entity
        super(Medicion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idcateController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Evidencia entities that
     * are retrieved from Medicion?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Detallemedicion entities
     * that are retrieved from Medicion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Detallemedicion page
     */
    public String navigateDetallemedicionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Detallemedicion_items", this.getSelected().getDetallemedicionList());
        }
        return "/detallemedicion/index";
    }

    /**
     * Sets the "selected" attribute of the Categoria controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdcate(ActionEvent event) {
        if (this.getSelected() != null && idcateController.getSelected() == null) {
            idcateController.setSelected(this.getSelected().getIdcate());
        }
    }
}
