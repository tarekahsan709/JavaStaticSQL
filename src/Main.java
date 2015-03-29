import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main 
{

	public static void main(String[] args)
	{
		Connection conn=null;
		Statement stmnt=null;
		ResultSet rs=null;
		try 
		{
			conn=DatabaseConnection.getConnection(DatabaseType.MySQL);
			System.out.println("Connected Suessfully");
			stmnt=conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			rs=stmnt.executeQuery("SELECT customerNumber,customerName,phone "
					            + "FROM customers");
			DisplayData.getData(rs);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}


	}

}
