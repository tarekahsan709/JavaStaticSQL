import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main 
{
	public static int price = 0;

	public static void main(String[] args)
	{
		//--------------------taking the input---------------------------
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the serial number range to see customer");
		try
		{
			price=sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Please input a valid number of range "+e.getMessage());
			return;
		}
		
		//--------------------Dynamic SQL. ? is use for the placeholder of input --------------
		

		String sql="SELECT customerNumber"
				+ " FROM customers"
				+ " Where customerNumber <=?";
		
		//--------------------Establishing the Connection with tha Database----------------------
		
		Connection conn=null;
		PreparedStatement stmnt=null;
		ResultSet rs=null;
		
		try 
		{
			conn=DatabaseConnection.getConnection(DatabaseType.MySQL);
			//System.out.println("Connected Suessfully");
			
		//----------------TYPE_SCROLL_INSENSITIVE use to go any row without maintaining sequence---------
		
			stmnt=conn.prepareStatement(sql,rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			stmnt.setInt(1, price);		
			rs=stmnt.executeQuery();
			
		//--------------Passing the result to display user desire  format-------------------------------- 	
			DisplayData.getData(rs);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}


	}

}
