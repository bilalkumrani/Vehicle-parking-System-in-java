
import java.sql.*;
class TotalVehicle {
	
	static Connection connection;
	static Statement statement;
	static ResultSet resultset; 
	int count;
	
		
		
	public int totalNum(){
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String str = "data.accdb";
			String str1 = "jdbc:ucanaccess://"+str;
			connection = DriverManager.getConnection(str1);
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM customer");
			while(resultset.next()){
				count++;
			}
			resultset.close();
			statement.close();
			connection.close();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		return count;
	}
		
		
	}	
