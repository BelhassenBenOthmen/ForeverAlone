package foreveralone.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import foreveralone.model.entities.Member;

public class MemberDAOCSV implements IMemberDAO
{
	List<Member> members = new ArrayList<>();
	private List<String> importErrors = new ArrayList<String>();
	
	/**
	 * Prova a caricare un file che si presume corretto.
	 * Se il file non esiste, DEVE dare FileNotFoundException
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public MemberDAOCSV(String filename) throws FileNotFoundException
	{
		Scanner dataReader = new Scanner(new File(filename));
		while(dataReader.hasNextLine())
		{
			String row = dataReader.nextLine();
			try
			{
				String[] parts = row.split(",");
				Member m = 
					new Member
					(
						Integer.parseInt(parts[0]), // posso dare NumberFormatException
						parts[1],
						parts[2],
						parts[3],
						parts[4],
						parts[5].replace(":", ","),
						parts[6].replace(":",",")
					);
				// LA CREO QUI, VERRA' GESTITA SOTTO
				if(!m.isValid())
					throw new RuntimeException("Member "+m+" from row "+row+" not valid. Error: "+m.getErrors());
				
				members.add(m);
				
			}
			catch(NumberFormatException e)
			{
				importErrors.add("Error importing, numberformatexception for "+row+" : "+e.getMessage());
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				importErrors.add("Error importing, arrayindexoutofboundexception for "+row+" : "+e.getMessage());
			}
			catch(RuntimeException e)
			{ // e.getMessage() = "Member "+m+" from row "+row+" not valid"
				importErrors.add(e.getMessage());
			}
		}
		dataReader.close();
	}
	
	@Override
	public List<Member> getMembers() 
	{
		List<Member> copy = new ArrayList<Member>();
		for(Member m:members)
			copy.add(m);
		return copy;
	}

	@Override
	public List<String> getImportErrors() 
	{
		return importErrors;
	}

}