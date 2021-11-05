package dk.jaj.api.example2;

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
import dk.jaj.api.Person;



public class PersonServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		//response.setContentType(arg0);
		//response.setStatus(arg0);
		
		Person p1 = new Person(1000, "Emirhan", true, 3, "Ny Gammelvej 4", "123412341", "God til mange ting");
		Person p2 = new Person(1001, "Janus", true, 4, "Gammel Torv 8", "45436556", "Programmør");
		Person p3 = new Person(1002, "Haidar", true, 1, "142 Avenue 4 6.tv", "123434545", "Borgmester i Store Væmmelse kommune");
		
		Person[] pArray = {p1, p2, p3};
		
		ArrayList<Person> pList = new ArrayList<Person>(Arrays.asList(pArray));
		
		pList.add(new Person(1003, "Oliver", true, 5, "Vestergade 23", "34653465", "Flutter programmør"));
		
		
		ObjectMapper mapper = new ObjectMapper();
		//String jsonStr = mapper.writeValueAsString(pArray);
		//out.print(jsonStr);
		
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getMatch())
		{
		case MatchPersonId: 
			try {
			out.print(mapper.writeValueAsString(pList.get(analyze.getId())));
			}catch(IndexOutOfBoundsException e)
			{
				response.setStatus(204);
			}
			break;
		case MatchPerson:
			out.print(mapper.writeValueAsString(pList));
			break;
		case MatchNo:
			response.setStatus(204);
			break;		
		}
	}

	

}













