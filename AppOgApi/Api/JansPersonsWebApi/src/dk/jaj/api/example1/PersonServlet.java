package dk.jaj.api.example1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.jaj.api.AnalyzeRequest;


@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		out.print("ContextPath: " + request.getContextPath());
		out.print("<br/>ServletPath: " + request.getServletPath());
		out.print("<br />PathInfo: " + request.getPathInfo());
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getMatch())
		{
		case MatchPersonId: 
			out.print("<br />Match på Person og id: " + analyze.getId());
			break;
		case MatchPerson:
			out.print("<br />Match på Person");
			break;
		case MatchNo:
			out.print("<br />Ingen match");
			break;		
		}
	}

	

}













