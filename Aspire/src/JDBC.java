import java.sql.*;
import java.lang.*;
public class JDBC {
	
	void addUserDetails(String firstName,String lastName,int uniqueNumber,int userAge ,float acctBalance )
	{

		try {
		String url = "jdbc:mysql://localhost:3306/Bank";
		String userName="root";
		String password="94843477";
		
		Class.forName("com.mysql.jdbc.Driver"); //static field 
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection=DriverManager.getConnection(url, userName, password);
		PreparedStatement addUser=connection.prepareStatement("insert into userdetails values(?,?,?,?,?)");
		addUser.setString(1,firstName);
		addUser.setString(2,lastName);
		addUser.setInt(3,uniqueNumber);
		addUser.setInt(4,userAge);
		addUser.setFloat(5, 0.0f);
		addUser.executeUpdate();
		
		connection.close();
	
		
		}
		catch (Exception exception)
		{
			System.out.println(exception);
		}

}
	
	void setAcctBalance(int uniqueId,float acctBalance)
	{
		try {
			String url = "jdbc:mysql://localhost:3306/Bank";
			String userName="root";
			String password="94843477";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url, userName, password);
			PreparedStatement setAcctBalance=connection.prepareStatement("update userdetails set AcctBalance=? where uniqueid = ?");
			
			setAcctBalance.setFloat(1, acctBalance);
			setAcctBalance.setInt(2,uniqueId);
			setAcctBalance.executeUpdate();
			
			connection.close();
			}
			catch (Exception exception)
			{
				System.out.println(exception);
			}

		
	}
	
}
