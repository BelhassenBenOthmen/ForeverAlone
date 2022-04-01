package foreveralone.view;

import java.util.HashMap;
import java.util.Map;

public abstract class LanguageFactory 
{

	static Map<String, ILanguage> languages = new HashMap<String,ILanguage>();
	
	static
	{
		languages.put("ITA", new Italian());
		languages.put("ENG", new English());
	}
	
	public static ILanguage getLanguage(String language)
	{
		return	languages.containsKey(language) 			?
				languages.get(language)  					:
				languages.get("ENG")						;
	}
	
	
}
