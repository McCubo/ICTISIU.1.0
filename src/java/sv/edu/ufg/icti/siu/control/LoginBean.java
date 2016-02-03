/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.control;

import java.io.Serializable;
import java.security.Principal;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {
private String username;
	private String password;
    
    public LoginBean() {
    }
    public String login() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		try {
			//Servlet 3.0
			request.login(username, password);
                        System.out.println("entre al pass");
			//  Principal 
			Principal principal = request.getUserPrincipal();

			// checkeamos roles
			if (request.isUserInRole("ADMIN")) {
				String msg = "Usuario: " + principal.getName() + ", Rol: Administrador";
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
                                
				return "index";
			} else if (request.isUserInRole("CONSEJO")) {
				String msg = "Usuario: " + principal.getName() + ", Rol: Consejo";
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
				return "consejo/index";
			} 
			return "Definir roles";	//pendiente por si se nos va un rol no especificado
		} catch (ServletException e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Un error ha ocurrido: falla Login", null));
			e.printStackTrace();
		}
		return "loginError";
	}

	public void logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "/login.xhtml");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
       /* para recuperar el nombre del usuario
        public String usuario(){
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
            //aqui hay que llenar el principal y luego tomar el nombre del usuario y retornarlo
        luego en el appmenu llamar este managedbean con el control
            
        }*/
    
}
