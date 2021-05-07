package tn.esprit.spring.controler;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ServiceUser;

@Scope(value = "session")
@Controller(value = "UserController")
@ELBeanName(value = "UserController")
@Join(path = "/", to = "login.jsf")
public class UserController {
	private static final Logger L=LogManager.getLogger(UserController.class);
	@Autowired
ServiceUser seru;
	
	private long id;
	private String name;
	private String email;
	private String password;
	private User user;
	private User authenticatedUser;
	private Boolean loggedIn;
	public ServiceUser getSeru() {
		return seru;
	}
	public void setSeru(ServiceUser seru) {
		this.seru = seru;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static Logger getL() {
		return L;
	}
	public Role[] getRoles() { return Role.values(); }
	
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser =seru.authenticate(email, password);
		if (authenticatedUser != null && authenticatedUser.getRole() ==
		Role.ADMINISTRATEUR) {
		navigateTo = "/admin/gererEvent.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}

		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}
	
}
