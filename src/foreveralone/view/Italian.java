package foreveralone.view;

import java.util.HashMap;
import java.util.Map;

public class Italian implements ILanguage
{

	Map<String,String> translations = new HashMap<String,String>();
	
	
	public Italian()
	{
		translations.put("ASKCOMMAND", "Inserisci comando");
		translations.put("ASKID", "Inserisci id");
		translations.put("ASKLANGUAGE", "Inserire codice della lingua");
	}
	
	@Override
	public String translate(String code) // code = ASKCOMMAND, code= ASKID, code=... il codice è la K
	{
		return	translations.containsKey(code)  		?
				translations.get(code) 					:
				code									;
	}
	
	

}
