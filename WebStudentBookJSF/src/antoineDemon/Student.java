package antoineDemon;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean //register the class student as JSF resource
@RequestScoped // creates an instance of Student for each user request
public class Student{
	//private static final long serialVersionUID = 1L;

	int studentID;
	String firstName;
	String lastName;
	String email;
	
	public Student(){
		
	}
	
	public Student(int id, String firstName, String lastName, String email){ 
		this.studentID=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		return firstName + " " + lastName + " " + email;
	}

}
