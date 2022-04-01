package foreveralone.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import foreveralone.model.entities.Member;

/**
 * un DAO si occupa di leggere e scrivere da file
 * oggetti di un dato TIPO. School NON era un DAO, perchè leggeva
 * e scriveva sia Persone che Good.
 * E' differente anche da Market. Market non si limitava a leggere
 * e a scrivere, market faceva hire e fire, e tante altre cose.
 * DAO -> Data Access Object
 * @author FP80
 *
 */
public interface IMemberDAO 
{
	List<Member> getMembers();
	
	List<String> getImportErrors();
	
	default List<Member> getMembers(Predicate<Member> filter)
	{
		List<Member> res = new ArrayList<Member>();
		for(Member m:getMembers())
			if(filter.test(m))
				res.add(m);
		return res;
	}
	
	default Member getMember(int id)
	{
		for(Member m:getMembers())
			if(m.getId()==id)
				return m;
		return null;
	}
	
}
