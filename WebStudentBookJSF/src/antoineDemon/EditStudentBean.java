package antoineDemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EditStudentBean {
	
	private Student student = new Student();
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student student){
		this.student=student;
	}
	
	public void EditStudent() throws ClassNotFoundException, SQLException{
			
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
			
			int ID=student.getStudentID();
			String FName=student.getFirstName();
			String LName=student.getLastName();
			String Email=student.getEmail();

			PreparedStatement pstmt=connect.prepareStatement("UPDATE student SET firstname='" + FName + "', lastname='" + LName + "', email='" + Email + "' where id=" + ID);
			pstmt.executeUpdate();

			pstmt.close();
			connect.close();
		}	
}