package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Gradoacademico;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "gradoacademicoController")
@ViewScoped
public class GradoacademicoController extends AbstractController<Gradoacademico> {

    @Inject
    private InvestigadorController investigadorListController;

    public GradoacademicoController() {
        // Inform the Abstract parent controller of the concrete Gradoacademico?cap_first Entity
        super(Gradoacademico.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Investigador entities
     * that are retrieved from Gradoacademico?cap_first and returns the
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
