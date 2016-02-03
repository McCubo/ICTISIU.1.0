package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Institucion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "institucionController")
@ViewScoped
public class InstitucionController extends AbstractController<Institucion> {

    @Inject
    private EvidenciaController evidenciaListController;
    @Inject
    private InstitucioncatController idinsticatController;

    public InstitucionController() {
        // Inform the Abstract parent controller of the concrete Institucion?cap_first Entity
        super(Institucion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idinsticatController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Evidencia entities that
     * are retrieved from Institucion?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Institucioncat controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdinsticat(ActionEvent event) {
        if (this.getSelected() != null && idinsticatController.getSelected() == null) {
            idinsticatController.setSelected(this.getSelected().getIdinsticat());
        }
    }
    public void onChangeInstitucioncat(ActionEvent event){
        this.getSelected().setIdinsticat(this.getSelected().getIdinsticat());
    }
}
