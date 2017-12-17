package antoineDemon;

import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="delete")
@SessionScoped
public class DeleteStudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ids;

	public int getIds() {
		return ids;
	}

	public void setIds(int id) {
		ids = id;
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
}