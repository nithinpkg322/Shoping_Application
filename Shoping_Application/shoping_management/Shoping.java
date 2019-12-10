package shoping_management;

import java.sql.SQLException;
import java.util.Scanner;

import Crude.Connection_manager;


public class Shoping {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
	
       Shoping a=new Shoping();
       a.choice();
       Connection_manager con=new Connection_manager();
}
   void choice() throws ClassNotFoundException, SQLException {
	int n;
	do {
		Scanner s=new Scanner(System.in);
	System.out.println("1)Admin\n2)Agentlogin\n3)exit\n");
	System.out.println("enter the choice");
	 n=s.nextInt();
	
	switch(n)
	{
	case 1:
		Admin admin=new Admin();
		admin.adminData();

		case 2:
		Agent agent=new Agent();
		agent.agentData();
		break;
		case 3:
			System.exit(0);
			break;
	}
}while (n!=0);
	
   }
}


