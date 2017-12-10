package antoineDemon;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class AddStudentBean implements Serializable {
	
	private static final long serialVersionUID = 6081417964063918994L;
	
	public void AddStudent() throws ClassNotFoundException, SQLException{
		
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/studentdb?useSSL=true";// + "?verifyServerCertificate=true" + "&useSSL=true" + "&requireSSL=true";
		// deuxieme url "jdbc:mysql://localhost:3306/studentdb?useSSL=true"

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
		
		// donner aux 3 strings les valeurs rentrées dans AddStudent.xhtml
		String FName;
		String LName;
		String Email;
		
		PreparedStatement pstmt=connect.prepareStatement("insert into student(firstname, lastname, email) values("+FName+","+LName+","+Email);
		ResultSet rs = pstmt.executeQuery();
		
		
		rs.close();
		pstmt.close();
		connect.close();
	}

}
