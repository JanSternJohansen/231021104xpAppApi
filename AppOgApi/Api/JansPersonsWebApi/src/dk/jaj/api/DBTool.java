package dk.jaj.api;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTool 
{
	private String connectionStr = "jdbc:sqlserver://localhost;databaseName=PersonApiDB";
	private Connection conn;
	private Statement stmt;
	
	public DBTool()
	{
		Logger logger = Logger.getLogger("DBTool");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			logger.log(Level.SEVERE, "Det gik godt load class");
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, "Det gik ikke godt load class. " + e.getMessage());
			e.printStackTrace();
		}	
	}
	
	public void connect()
	{
		Logger logger = Logger.getLogger("DBTool");
		try {
			conn = DriverManager.getConnection(connectionStr, "sa", "1234");
			stmt = conn.createStatement();
			
			logger.log(Level.SEVERE, "Connection gik godt");
			
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Connection gik godt. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public Person getPersonById(int id)
	{
		connect();
		Person p = null;
		
		String selectStr = "Select * from Person where id = " + id;
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			if(result.next())
			{
				p = new Person();
				
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setFavorit(result.getBoolean("favorit"));
				p.setHairColor(result.getInt("hairColor"));
				p.setAddress(result.getString("address"));
				p.setPhone(result.getString("phone"));
				p.setNote(result.getString("note"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
		
	}

}













