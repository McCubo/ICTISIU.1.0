package sv.edu.ufg.icti.siu.control;

import sv.edu.ufg.icti.siu.entidades.Users;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import sv.edu.ufg.icti.siu.control.util.StringMD;

@Named(value = "usersController")
@ViewScoped
public class UsersController extends AbstractController<Users> {

    public UsersController() {
        // Inform the Abstract parent controller of the concrete Users?cap_first Entity
        super(Users.class);
    }
public void EncriptaPassword(ActionEvent event){
        String pass = this.getSelected().getPassword();
        System.out.println("Imprimo el pass:"+pass);
        String npass = StringMD.getStringMessageDigest(pass, StringMD.MD5);
        System.out.println("Pass encriptado:"+npass);
        this.getSelected().setPassword(npass);
        System.out.println("en el objeto:"+this.getSelected().getPassword());
        
    }
}
