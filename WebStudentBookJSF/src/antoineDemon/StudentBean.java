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

@ManagedBean(name="studentb")
@SessionScoped

public class StudentBean implements Serializable {
	
	private static final long serialVersionUID = 6081417964063918994L;
	private Student student = new Student();
	private int ids;
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student student){
		this.student = student;
	}
	
	public int getIds(){
		return ids;
	}
	
	public void setIds(int id){
		ids = id;
	}
	
	public List<Student> getStudents() throws ClassNotFoundException, SQLException{
		
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";// + "?verifyServerCertificate=true" + "&useSSL=true" + "&requireSSL=true";
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
		
		List<Student> students= new ArrayList<Student>();
		PreparedStatement pstmt=connect.prepareStatement("select id, firstname, lastname, email from student");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			int id = rs.getInt("id");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");
			Student student= new Student(id, firstname, lastname, email);
			
			students.add(student);
			
		}
		
		rs.close();
		pstmt.close();
		connect.close();
		
		return students;
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

	public void deleteStudent() throws ClassNotFoundException, SQLException {
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";

		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		int ID = ids;

		PreparedStatement pstmt = connect.prepareStatement("DELETE FROM student WHERE id = " + ID);
		pstmt.executeUpdate();

		pstmt.close();
		connect.close();
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