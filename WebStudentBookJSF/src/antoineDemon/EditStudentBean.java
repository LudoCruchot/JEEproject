package antoineDemon;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="edit")
@SessionScoped
public class EditStudentBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Student student = new Student();
	private int ids;
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student student){
		this.student=student;
	}
	
	public int getIds(){
		return ids;
	}
	
	public void setIds(int id){
		ids = id;
	}
	
	public void editStudent() throws ClassNotFoundException, SQLException{
			
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

			PreparedStatement pstmt=connect.prepareStatement("UPDATE student SET firstname='" + FName + "', lastname='" + LName + "', email='" + Email + "' where id=" + ids);
			pstmt.executeUpdate();

			pstmt.close();
			connect.close();
		}	

}