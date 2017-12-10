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
public class Student{
	//private static final long serialVersionUID = 1L;

	int studentID;
	String FirstName;
	String LastName;
	String Email;
	
	public Student(){
		
	}
	
	public Student(int id, String firstName, String lastName, String email){ 
		this.studentID=id;
		this.FirstName=firstName;
		this.LastName=lastName;
		this.Email=email;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return FirstName;
	}
	public void setLastName(String lastName) {
		this.FirstName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
}
