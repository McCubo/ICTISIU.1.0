package sv.edu.ufg.icti.siu.convert;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.edu.ufg.icti.siu.beans.GradoacademicoFacade;
import sv.edu.ufg.icti.siu.control.util.JsfUtil;
import sv.edu.ufg.icti.siu.entidades.Gradoacademico;

@FacesConverter(value = "gradoacademicoConverter")
public class GradoacademicoConverter implements Converter {

    @Inject
    private GradoacademicoFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Gradoacademico) {
            Gradoacademico o = (Gradoacademico) object;
            return getStringKey(o.getIdgrado());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Gradoacademico.class.getName()});
            return null;
        }
    }

}
