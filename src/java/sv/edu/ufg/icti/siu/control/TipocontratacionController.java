package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Tipocontratacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipocontratacionController")
@ViewScoped
public class TipocontratacionController extends AbstractController<Tipocontratacion> {

    @Inject
    private InvestigadorController investigadorListController;

    public TipocontratacionController() {
        // Inform the Abstract parent controller of the concrete Tipocontratacion?cap_first Entity
        super(Tipocontratacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Investigador entities
     * that are retrieved from Tipocontratacion?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Investigador page
     */
    public String navigateInvestigadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Investigador_items", this.getSelected().getInvestigadorList());
        }
        return "/investigador/index";
    }

}
