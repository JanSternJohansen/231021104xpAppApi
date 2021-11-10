package dk.tec.jaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.*;

public class DBTools 
{	
	//private String connectionStr = "jdbc:sqlserver://TEC-5210-LA0030\\JANSSQLSERVER;databaseName=PersonApiDB";
	
	//private String connectionStr = "jdbc:sqlserver://94.18.194.45:1433;databaseName=PersonApiDB";
	
	// Virker fra Eclipse-Apache på min PC
	// Virker fra Apache på min PC
	// Virker ikke fra Apache på Proxmox
	//private String connectionStr = "jdbc:sqlserver://94.18.194.45\\JANSSQLSERVER:1433;databaseName=PersonApiDB";
	
	// Login i management studio:
	// 94.18.194.45\\JANSSQLSERVER      // Virker ikke
	// 94.18.194.45\JANSSQLSERVER,1433  // Virker
	// 94.18.194.45\\JANSSQLSERVER,1433 // Virker
	// 94.18.194.45,1433				// Virker
	// 94.18.194.45						// Virker
	
	//private String connectionStr = "jdbc:sqlserver://localhost:1433;databaseName=PersonApiDB";
	//private String connectionStr = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PersonApiDB";
	
	
	//OK fra JAJvirtual 150.45 Apache
	//private String connectionStr = "jdbc:sqlserver://192.168.150.116:1433;databaseName=PersonApiDB";
	
	private String connectionStr = "jdbc:sqlserver://localhost;databaseName=PersonApiDB";
	
	private Connection con;
	private Statement stmt;
	
	Logger logger = Logger.getLogger("DBTools");
	
	private void connect()
	{
		logger.log(Level.SEVERE, "I DBTools Connect!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			con= DriverManager.getConnection(connectionStr, "sa", "1234");
			
			stmt = con.createStatement();
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage() + " I DBTools Connect ClassNotFound!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage() + " I DBTools Connect SqlException!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}	
	}
	
	public Person getPersonById(int id) // doGet
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
				p.setAddress(result.getString("address"));
				p.setFavorit(result.getBoolean("favorit"));
				p.setHairColor(result.getInt("hairColor"));
				p.setPhone(result.getString("phone"));
				p.setNote(result.getString("note"));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return p;
	}
	
	
	public ArrayList<Person> getAllPerson()
	{
		ArrayList<Person> persons = new ArrayList<Person>();
		
		connect();
		Person p = null;
		
		String selectStr = "Select * from Person";
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			while(result.next())
			{
				p = new Person();
				
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setAddress(result.getString("address"));
				p.setFavorit(result.getBoolean("favorit"));
				p.setHairColor(result.getInt("hairColor"));
				p.setPhone(result.getString("phone"));
				p.setNote(result.getString("note"));	
				persons.add(p);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return persons;
	}

	
	public void addNewPerson(Person p) 
	{
		connect();
		String insertStr= "Insert into Person values(?,?,?,?,?,?)";
		try {
			PreparedStatement prep = con.prepareStatement(insertStr);
			prep.setString(1, p.getName());
			prep.setBoolean(2, p.isFavorit());
			prep.setInt(3, p.getHairColor());
			prep.setString(4, p.getAddress());
			prep.setString(5, p.getPhone());
			prep.setString(6, p.getNote());
			
			int result = prep.executeUpdate();
			System.out.println("Inserted Antal rows: " + result);
			
			con.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	
	public void updatePerson(Person p) 
	{
		connect();
		String updateStr= "Update Person set name = ?, favorit = ?, haircolor = ?, address = ?, phone = ?, note = ? where id = ?";
		try {
			PreparedStatement prep = con.prepareStatement(updateStr);
			prep.setString(1, p.getName());
			prep.setBoolean(2, p.isFavorit());
			prep.setInt(3, p.getHairColor());
			prep.setString(4, p.getAddress());
			prep.setString(5, p.getPhone());
			prep.setString(6, p.getNote());
			
			prep.setInt(7, p.getId());
			
			int result = prep.executeUpdate();
			System.out.println("Updated antal rows: " + result);
			
			con.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void deletePerson(int id) 
	{
		connect();
		String updateStr= "Delete Person where id = ?";
		try {
			PreparedStatement prep = con.prepareStatement(updateStr);
			
			prep.setInt(1, id);
			
			int result = prep.executeUpdate();
			System.out.println("Deleted antal rows: " + result);
			
			con.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}



