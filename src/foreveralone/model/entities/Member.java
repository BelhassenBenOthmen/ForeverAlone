package foreveralone.model.entities;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Member implements foreveralone.common.Validable
{
	// int è un primitivo, non può essere nullo
	// Integer è un oggetto che contiene un int
	// ma è un oggetto. Può essere nullo!!
	// diremo che Integer è il tipo "BOXATO"
	// "avvolto" di int. Integer "AVVOLGE" un int.
	Integer id;
	String nickname;
	String gender;
	
	Set<String> interests =
			new HashSet<String>();
	
	Set<String> looksfor = 
			new HashSet<String>();
	
	Set<String> taboo =
			new HashSet<String>();
	
	String dob;
	
	public Member() {}
	
	public Member
	(
		Integer id, String nickname, String gender, String dob,
		String looksforCSV, String interestsCSV, String tabooCSV
	)
	{
		this.id = id;
		this.nickname = nickname;
		this.dob = dob;
		String[] parts = interestsCSV.split(",");
		for(String part:parts)
			interests.add(part);
		this.gender = gender;
		parts = looksforCSV.split(",");
		for(String part:parts)
			looksfor.add(part);
		parts = tabooCSV.split(",");
		for(String part:parts)
			taboo.add(part);
	}
	
	public Set<String> getInterests()
	{
		return interests;
	}
	
	/**
	 * getCompatibility esprime l'interesse di this verso other.
	 * se this e other sono uguali restituisco 0					  	// NO SELF LOVE
	 * se other ha un genere che non mi interessa restituisco 0			// WRONG GENDER
	 * se other ha un interesse che per me è un taboo restituisco 0		// TABOO
	 * altrimenti restituisco il numero degli interessi comuni * 100
	 * e sottrarrò la differenza di età moltiplicata per 10				// OK
	 * @param other
	 * @return
	 */
	public int getCompatibility(Member other)
	{
		if(this==other)
			return 0;
		
		if(!looksfor.contains(other.gender))
			return 0;
		
		Set<String> otherInterests = new HashSet<String>();
		otherInterests.addAll(other.interests);
		otherInterests.retainAll(this.taboo);
		if(otherInterests.size()>0)
			return 0;
		
		Set<String> commonInterests = new HashSet<String>();
		commonInterests.addAll(this.interests);
		commonInterests.retainAll(other.interests); // INTERSEZIONE FRA I MIEI E I SUOI
		
		return 	(commonInterests.size() * 100) -
				(Math.abs(this.getAge()-other.getAge())*10);
	}
	
	public int getAge()
	{
		return 	Calendar.getInstance().get(Calendar.YEAR) 
				-
				Integer.parseInt(dob.split("/")[2]);	
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<String> getLooksfor() {
		return looksfor;
	}

	public void setLooksfor(Set<String> looksfor) {
		this.looksfor = looksfor;
	}

	public Set<String> getTaboo() {
		return taboo;
	}

	public void setTaboo(Set<String> taboo) {
		this.taboo = taboo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setInterests(Set<String> interests) {
		this.interests = interests;
	}

	@Override
	public String getErrors() 
	{
		String res = "";
		if(id==null || id<=0)
			res+=" BADID";
		
		return res;
	}
}
