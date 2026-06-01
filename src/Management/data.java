package Management;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class data {

	Connection connection;
	Statement statement;
	
	public data() {
		
		try {
			
			connection = DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/hotel_Management?useSSL=false&allowPublicKeyRetrieval=true",
				    "root",
				    "31205"
				);
			statement = connection.createStatement();
			
		}catch(Exception e){
			
		}
	}

}
