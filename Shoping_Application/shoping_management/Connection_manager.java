package shoping_management;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Connection_manager {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Shoping","root","");
	if(con!=null)//connection checking
	{
	return con;
	}
	else
	{
	return null;
	}
	}

}
	


