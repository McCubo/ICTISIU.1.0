package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Detallemedicion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detallemedicionController")
@ViewScoped
public class DetallemedicionController extends AbstractController<Detallemedicion> {

    @Inject
    private MedicionController idmedicionController;

    public DetallemedicionController() {
        // Inform the Abstract parent controller of the concrete Detallemedicion?cap_first Entity
        super(Detallemedicion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idmedicionController.setSelected(null);
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
}
