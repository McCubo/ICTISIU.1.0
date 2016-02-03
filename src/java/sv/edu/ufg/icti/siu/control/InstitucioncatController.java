package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Institucioncat;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "institucioncatController")
@ViewScoped
public class InstitucioncatController extends AbstractController<Institucioncat> {

    @Inject
    private InstitucionController institucionListController;

    public InstitucioncatController() {
        // Inform the Abstract parent controller of the concrete Institucioncat?cap_first Entity
        super(Institucioncat.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Institucion entities that
     * are retrieved from Institucioncat?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Institucion page
     */
    public String navigateInstitucionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Institucion_items", this.getSelected().getInstitucionList());
        }
        return "/institucion/index";
    }
     public void onChangeInstitucioncat(ActionEvent event){
        this.getSelected().setIdinsticat(this.getSelected().getIdinsticat());
    }

}
