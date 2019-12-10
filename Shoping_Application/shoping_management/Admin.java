package shoping_management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.PreparedStatement;

import Crude.Connection_manager;

public class Admin {
	//private static final String Statement = null;
	Connection_manager con=new Connection_manager();


	public void adminData() throws SQLException, ClassNotFoundException {
		Scanner s=new Scanner(System.in);
		Connection_manager c3=new Connection_manager();
		c3.getConnection();
		int op1;

		System.out.println("enter username");
		String user=s.next();
		   System.out.println("enter password");
		String pass=s.next();
		     
		       boolean cu = false;
		       String query = "SELECT * FROM adminlogin WHERE username =?";
		           PreparedStatement    ps = (PreparedStatement) c3.getConnection().prepareStatement(query);
		           ps.setString(1,user);
		           
		           ResultSet   rs = ps.executeQuery();
		           
		           if(rs.next())
		           {
		               cu = true;
		           }
		       
		        if(cu==true)
		        System.out.println("Successfully logged in");
		        else
		        System.out.println("User name or password does't exist");
		       
		       
		        do {
		System.out.println("Choose option\n1.)Add Product\n2.)Display\n3.)Remove\n4.)Update\n5.)Exit");
		op1=s.nextInt();
		switch(op1)
		{
		case 1:
		System.out.println("Enter the product id");
		int id=s.nextInt();
		System.out.println("Enter the product Name");
		String name=s.next();
		System.out.println("Enter the quantity");
		int quant=s.nextInt();
		System.out.println("Enter the price");
		String price=s.next();

		PreparedStatement st=(PreparedStatement) c3.getConnection().prepareStatement("insert into addproduct(id,name,quantity,price)values(?,?,?,?)");
		st.setInt(1, id);
		st.setString(2, name);
		st.setInt(3, quant);
		st.setString(4, price);
		st.executeUpdate();
		System.out.println("Product added Successfully");
		break;
		case 2:
		{
		//c3.getConnection();
		Statement st1=(Statement) c3.getConnection().createStatement();
		ResultSet r=st1.executeQuery("select * from addproduct");
		System.out.println("********************");
		while(r.next())
		{
		System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+" "+r.getString(4));
		}
		System.out.println("********************");
		//c.getConnection().close();
		break;
		}
		case 3:
		{
		//c3.getConnection();
		//Statement st1=(Statement) c3.getConnection().createStatement();
		System.out.println("Enter the id do you want delete");
		int s1=s.nextInt();
		PreparedStatement st3=(PreparedStatement) c3.getConnection().prepareStatement("DELETE from addproduct where id="+s1);
		st3.executeUpdate();
		System.out.println("Deleted Successfully");
		break;
		}
		case 4:
		{
		Statement st1=(Statement) c3.getConnection().createStatement();
		ResultSet r=st1.executeQuery("select * from addproduct");
		System.out.println("********************");
		while(r.next())
		{
		System.out.println(r.getInt(1)+" "+r.getString(2));
		}
		Statement st2=(Statement) c3.getConnection().createStatement();
		ResultSet r1=st1.executeQuery("select * from addproduct");
		int qu=0;
		System.out.println("Enter the id do you want update");
		int a=s.nextInt();

		System.out.println("Enter the quantity");
		int quantity=s.nextInt();
		while(r1.next())
		{
		if(a==r1.getInt(1))
		{
		qu=r1.getInt(3);
		}
		PreparedStatement st4=(PreparedStatement) c3.getConnection().prepareStatement("update addproduct set quantity=? where id=?");
		int q=qu+quantity;
		   st4.setInt(1,q);
		   st4.setInt(2, a);
		   st4.executeUpdate();
		   }
		break;
		}
		case 5:
		Shoping sh=new Shoping();
		sh.main(null);
		System.out.println("Admin Acoount Logout");
		}
		}
		while(op1!=5);

		       
		}

	}



	
		


	
