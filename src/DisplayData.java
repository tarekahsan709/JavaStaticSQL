import java.sql.ResultSet;
import java.sql.SQLException;


public class DisplayData 
{
     
	
	public static void getData(ResultSet rs) throws SQLException
	{
		int numRows=0;
		
		//----------------------------go to the last row-------------------------------
		rs.last();
		
		//----------------------------take the number of rows--------------------------
		numRows=rs.getRow();		
		if(numRows==0)
		{
			System.out.println("No serial hs found number between 1 to "+Main.price+" range");
		}
		else
		{
		//-----------------------move to first from last to show result ---------------
			rs.first();
			while(rs.next())
			{
				StringBuffer bf=new StringBuffer();
				bf.append("Customer serial number is :"+rs.getInt("customerNumber")+"");						
				System.out.println(""+bf.toString());						
			}
			
		}
		
	}

}
