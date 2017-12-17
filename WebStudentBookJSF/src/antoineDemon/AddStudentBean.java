package antoineDemon;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AddStudentBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Student student = new Student();
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student student){
		this.student=student;
	}
	
	public void AddStudent() throws ClassNotFoundException, SQLException{
		
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";

		String username = "root";
		String password = "root";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException ex){
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}
		
		String FName = student.getFirstName();
		String LName = student.getLastName();
		String Email = student.getEmail();
		
		PreparedStatement pstmt=connect.prepareStatement("INSERT INTO student (firstName, lastName, email) VALUES('" + FName + "','" + LName + "','" + Email + "')");
		pstmt.executeUpdate();
		
		
		pstmt.close();
		connect.close();
	}

}
