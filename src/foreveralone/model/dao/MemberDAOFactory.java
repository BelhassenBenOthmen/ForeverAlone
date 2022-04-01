package foreveralone.model.dao;

import java.io.FileNotFoundException;

// IO SONO UNA FABBRICA DI MemberDAO
public abstract class MemberDAOFactory 
{

	public static IMemberDAO getMemberDAO(String filename) throws FileNotFoundException
	{
		filename = filename.toLowerCase();
		if(filename.endsWith("csv"))
			return new MemberDAOCSV(filename);
		
		if(filename.endsWith("txt"))
			return new MemberDAOTXT(filename);
		
		return null;
	
	}
	
	
}
