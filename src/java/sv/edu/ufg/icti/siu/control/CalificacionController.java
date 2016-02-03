package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Calificacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "calificacionController")
@ViewScoped
public class CalificacionController extends AbstractController<Calificacion> {

    @Inject
    private EvaluacionController evaluacionListController;

    public CalificacionController() {
        // Inform the Abstract parent controller of the concrete Calificacion?cap_first Entity
        super(Calificacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Evaluacion entities that
     * are retrieved from Calificacion?cap_first and returns the navigation
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

}
