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

public class StudentBean implements Serializable {
	
	public List<Student> getStudents() throws ClassNotFoundException, SQLException{
		
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/studentdb";

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
		
		List<Student> students= new ArrayList<Student>();
		PreparedStatement pstmt=connect.prepareStatement("select id, firstname, lastname, email from student");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			Student student= new Student();
			student.setStudentID(rs.getInt("id"));
			student.setFirstName(rs.getString("firstname"));
			student.setLastName(rs.getString("lastname"));
			student.setEmail(rs.getString("email"));
			
			students.add(student);
			
		}
		
		rs.close();
		pstmt.close();
		connect.close();
		
		return students;
	}

}