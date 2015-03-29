import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection 
{
	//----------------------to connect with database we need provide database this field-----

	private static String userName="root";
	private static String pass="user";
	private static String hCon="jdbc:hsqldb:data/explorecalifornia";
	private static String mCon="jdbc:mysql://localhost:3306/classicmodels";
	
	public static Connection getConnection(DatabaseType dbType) throws SQLException
	{
		switch (dbType) {
		case MySQL:			
			return DriverManager.getConnection(mCon, userName, pass);
        case HyperSQL:			
			return DriverManager.getConnection(hCon, userName, pass);
		}
	return null;
		
	}

}
