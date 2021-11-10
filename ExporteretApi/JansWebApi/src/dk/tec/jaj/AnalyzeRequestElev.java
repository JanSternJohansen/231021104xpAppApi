package dk.tec.jaj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalyzeRequestElev 
{
	MatchEnum level;
	int id;
	
	
	public MatchEnum getLevel() {
		return level;
	}


	public int getId() {
		return id;
	}


	public AnalyzeRequestElev(String pathInfo) 
	{
	    Matcher matcher = Pattern.compile("/Elev/([0-9]+)").matcher(pathInfo);
	    
	    if(matcher.find()) 
	    {
	    	level = MatchEnum.MatchElevId;
	    	id = Integer.parseInt(matcher.group(1));	    	
	    }
	    else
	    {
	    	matcher = Pattern.compile("(?i)/Elev/??$").matcher(pathInfo);  // (?i) ignore case begynd, (?-i) slut f.eks "(?i)/Elev(?-i)[/]??$"  /? betyder ingen eller 1 /

	    	if(matcher.find())
	    	{
	    		level = MatchEnum.MatchElev;
	    	}
	    	else
	    	{
	    		level = MatchEnum.MatchNo;
	    	}
	    }
	}
}






