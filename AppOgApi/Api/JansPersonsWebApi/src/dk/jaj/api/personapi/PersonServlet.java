package dk.jaj.api.personapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.jaj.api.AnalyzeRequest;
import dk.jaj.api.DBTool;
import dk.jaj.api.Person;



public class PersonServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		
		DBTool db = new DBTool();
		//db.connect();
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getMatch())
		{
		case MatchPersonId: 
			try {
			   int id = analyze.getId();
			   Person p = db.getPersonById(id);
			   out.print(mapper.writeValueAsString(p));
			   
			}catch(IndexOutOfBoundsException e)
			{
				response.setStatus(204);
			}
			break;
		case MatchPerson:
			
			break;
		case MatchNo:
			response.setStatus(204);
			break;		
		}
	}

	

}













