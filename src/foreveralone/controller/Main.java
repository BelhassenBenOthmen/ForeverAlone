package foreveralone.controller;
import static com.generation.common.Console.ask;
import static com.generation.common.Console.print;

import java.io.FileNotFoundException;
import java.util.List;

import foreveralone.model.dao.IMemberDAO;
import foreveralone.model.dao.MemberDAOFactory;
import foreveralone.model.entities.Member;
import foreveralone.view.ILanguage;
import foreveralone.view.LanguageFactory;

public class Main 
{

	// dichiarato ma non inizializzato
	static IMemberDAO dao;
	static ILanguage language = LanguageFactory.getLanguage("ITA");
	
	public static void main(String[] args) 
	{

		dao = _askSource();
		if(dao==null)
		{
			print("Unable to open the specified source");
			return;
		}
		
		String cmd="", res ="";
		do
		{
			cmd = ask(language.translate("ASKCOMMAND"));
			switch(cmd)
			{
				case "getmember":
					res = _getMember();
				break;
				case "asklanguage":
					String languagecode = ask(language.translate("ASKLANGUAGE"));
					language = LanguageFactory.getLanguage(languagecode);
				break;
				default:
					res = "BADCOMMAND";
			}
			print(res);
		}while(!cmd.equals("bye"));
		
	}
	
	private static String _getMember() 
	{
		try
		{
			int id = Integer.parseInt(ask(language.translate("ASKID")));
			Member m = dao.getMember(id);
			return m==null ? "NOT FOUND " : m.toString();
		}
		catch(NumberFormatException e)
		{
			return "BADID";
		}
	}

	private static String _getCompatibilities()
	{
		try
		{
			int id = Integer.parseInt(ask(language.translate("ASKID")));
			Member m = dao.getMember(id);
			if(m==null)
				return language.translate("MEMBERNOTFOUND");
			List<Member> matches = dao.getMembers((p)->(m.getCompatibility(p)>0));
			//return renderer.render(matches);// STESSO DISCORSO DELLA VISTA	
			return matches.toString();
		}
		catch(NumberFormatException e)
		{
			return language.translate("BADID");
		}
		
	}
	
	private static IMemberDAO _askSource()
	{
		String filename = ask("Insert file name");
		try
		{
			IMemberDAO res =  MemberDAOFactory.getMemberDAO(filename);
			if(res.getImportErrors().size()>0)
			{
				print("File opened with errors:");
				for(String error:res.getImportErrors())
					print(error);
			}
			print("Imported "+res.getMembers().size()+" successfully");
			return res;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
