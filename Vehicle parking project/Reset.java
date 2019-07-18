
import javax.swing.*;
import java.sql.*;

class Reset extends JFrame
{
	
	static Connection connection;
	static Statement statement;
	static ResultSet resultset;

	
	Reset()
	{
		database();
		JOptionPane.showMessageDialog(this,"Software is Reseted");
	}
	
	
		public static void database(){
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String str = "data.accdb";
			String str1 = "jdbc:ucanaccess://"+str;
			connection = DriverManager.getConnection(str1);
			statement = connection.createStatement();
			int a = statement.executeUpdate("delete * from customer");
			statement.close();
			connection.close();
			}
			catch(Exception ae){
				ae.printStackTrace();
			}
	}
		
}



