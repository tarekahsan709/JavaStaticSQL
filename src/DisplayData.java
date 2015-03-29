import java.sql.ResultSet;
import java.sql.SQLException;


public class DisplayData 
{
     
	
	public static void getData(ResultSet rs) throws SQLException
	{
		while(rs.next())
		{
			StringBuffer bf=new StringBuffer();
			bf.append("Customer serial is"+rs.getInt("customerNumber")+"-");
			bf.append("Customer name:"+rs.getString("customerName")+" ");
			bf.append("and phone number :"+rs.getString("phone"));

			
			System.out.println(""+bf.toString());
			
			
			
			
		}
	}

}
