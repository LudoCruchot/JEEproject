package antoineDemon;

import javax.naming.*;
import javax.sql.DataSource;

public class StudentDbUtil {
	
	public DataSource getDataSource() throws NamingException{
		
		String jndi="java:comp/env/jdbc/studentdb" ;
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(jndi);
		return dataSource;
	}
}
