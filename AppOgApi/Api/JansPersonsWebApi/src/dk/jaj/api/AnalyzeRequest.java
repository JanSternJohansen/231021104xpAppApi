package dk.jaj.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRequest 
{
	MatchEnum match;
	int id;
	
	public int getId() {
		return id;
	}

	public MatchEnum getMatch() 
	{
		return match;
	}
	
	
	public AnalyzeRequest(String pathInfo) 
	{
		Matcher matcher = Pattern.compile("/Person/([0-9]+)").matcher(pathInfo);
		
		if(matcher.find())
		{
			match = MatchEnum.MatchPersonId;
			id = Integer.parseInt(matcher.group(1));
		}
		else
		{
			matcher = Pattern.compile("/Person").matcher(pathInfo);
			if(matcher.find())
			{
				match = MatchEnum.MatchPerson;
			}
			else
			{
				match = MatchEnum.MatchNo;
			}
		}	
	}
	

}
