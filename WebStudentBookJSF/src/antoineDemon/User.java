package antoineDemon;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean //register the class student as JSF resource
@RequestScoped // creates an instance of Student for each user request
public class User implements Serializable{
	int userID;
	String name;
	String role;
	
	public User(){ 
		
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole(){
		return role;
	}
	public void setRole(String role){
		this.role=role;
	}
}
