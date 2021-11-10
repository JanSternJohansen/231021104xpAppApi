package dk.tec.jaj.example2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequestElev;
import dk.tec.jaj.Elev;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   
		
		PrintWriter out	= response.getWriter();
	   
	   Elev elev1 = new Elev(1001, "Andreas 1", 23, "Cykle i sne");
	   elev1.addSkill("G�");
	   elev1.addSkill("Kravle");
	   
	   Elev elev2 = new Elev(1002, "Andreas 2", 23, "G� i sne");
	   elev2.addSkill("Spise");
	   elev2.addSkill("Drik smeltevand");
	   
	   Elev elev3 = new Elev(1003, "Martin", 59, "Cykle bagl�ns");
	   elev3.addSkill("V�lte");
	   elev3.addSkill("Programmere");
	   
	   ArrayList<Elev> elever = new ArrayList<Elev>();
	   elever.add(elev1);
	   elever.add(elev2);
	   elever.add(elev3);
			   
	   ObjectMapper mapper = new ObjectMapper();
	   
		AnalyzeRequestElev analyze = new AnalyzeRequestElev(request.getPathInfo());
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			out.println("Match p� Elev + " + analyze.getId());
			int id = analyze.getId();
			
			boolean found = false;
			for(Elev e : elever)
			{
				if(e.getId() == id)
				{
					
					out.println(mapper.writeValueAsString(e));
					response.setStatus(200);
					found = true;
					break;
				}
			}
			
			if(!found)
			{
				out.println("No Id");
				response.setStatus(204);	
			}
				
			break;
		case MatchElev:
			//out.println("Match p� Elev");
			out.println(mapper.writeValueAsString(elever));
			break;
		case MatchNo:
			out.println("No Match");
			response.setStatus(400);
			break;
		}
		
	}


	

}
