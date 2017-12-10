package antoineDemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EditStudentBean {
	
	private Student student = new Student();
	
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
			
			String FName=student.getFirstName();
			String LName=student.getLastName();
			String Email=student.getEmail();
			
			System.out.println(FName);
			System.out.println(LName);
			System.out.println(Email);
			
		
			PreparedStatement pstmt=connect.prepareStatement("UPD into student (firstName, lastName, email) values('" + FName + "','" + LName + "','" + Email + "')");
			pstmt.executeUpdate();
			
			
			pstmt.close();
			connect.close();
		}	
}
