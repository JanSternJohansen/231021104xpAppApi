package dk.tec.jaj.webproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.DBTools;
import dk.tec.jaj.MatchEnum;
import dk.tec.jaj.Person;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		PrintWriter out	= response.getWriter();
	   
	    ObjectMapper mapper = new ObjectMapper();
	   
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		DBTools db = new DBTools();
		
		//out.println(request.getPathInfo());
		
		switch(analyze.getLevel())
		{
		case MatchPersonId:
			//out.println("Match på Person + " + analyze.getId());
			
			Person p = db.getPersonById(analyze.getId());
			
			out.println(mapper.writeValueAsString(p));
				
			break;
		case MatchPerson:
			ArrayList<Person> persons = db.getAllPerson();
			out.println(mapper.writeValueAsString(persons));
			break;
		case MatchNo:
			out.println("No Match!!!!!!");
			//response.setStatus(400);
			break;
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("In doPost");
		
		BufferedReader reader = request.getReader();
		String jsonStr = reader.readLine();
		
		Person p = null;
		
		DBTools db = new DBTools();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		p = mapper.readValue(jsonStr, Person.class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.setStatus(400);
			return;
		}
		
		if(p != null)
		{
			//out.println("Name: " + p.getName());
			db.addNewPerson(p);
			
		}
		
		//Ved flere linier JSON
		//String personJSONStr = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("In doDelete");
		
		BufferedReader reader = request.getReader();
		String jsonStr = reader.readLine();
		
		Person p = null;
		
		DBTools db = new DBTools();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		p = mapper.readValue(jsonStr, Person.class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.setStatus(400);
			return;
		}
		
		if(p != null)
		{
			//out.println("Name: " + p.getName());
			db.updatePerson(p);			
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("In doDelete");
		
		DBTools db = new DBTools();
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		if(analyze.getLevel() == MatchEnum.MatchPersonId)
		{
			int id = analyze.getId();
			db.deletePerson(id);
		}
		else
		{
			out.println("Bad URL");
			response.setStatus(400);
		}
	}
}








