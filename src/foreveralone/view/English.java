package foreveralone.view;

import java.util.HashMap;
import java.util.Map;

public class English implements ILanguage
{

Map<String,String> translations = new HashMap<String,String>();
	
	
	public English()
	{
		translations.put("ASKCOMMAND", "Insert command");
		translations.put("ASKID", "Insert id");
		translations.put("ASKLANGUAGE", "Insert language code");
	}
	
	@Override
	public String translate(String code) // code = ASKCOMMAND, code= ASKID, code=... il codice è la K
	{
		return	translations.containsKey(code)  		?
				translations.get(code) 					:
				code									;
	}
	
	
}
