package foreveralone.model.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import foreveralone.model.dao.IMemberDAO;
import foreveralone.model.dao.MemberDAOCSV;

class MemberDAOCSVTest 
{

	@Test
	void testConstructor() 
	{
		try
		{
			new MemberDAOCSV("pippo.csv");
			fail("Non doveva arrivare qui!");
		}
		catch(FileNotFoundException e)
		{
			// se invece sono qui è ok
		}
		// ok. eccezione testata
		
		try
		{
			IMemberDAO dao = new MemberDAOCSV("members.csv");
			assert(dao.getMembers().size()==3);
			assert(dao.getImportErrors().size()==2);
		}
		catch(FileNotFoundException e)
		{
			fail("Mi aspettavo che funzionasse");
		}
	}

}
