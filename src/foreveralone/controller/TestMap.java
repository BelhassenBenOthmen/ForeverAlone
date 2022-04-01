package foreveralone.controller;

import java.util.HashMap;
import java.util.Map;

import foreveralone.model.entities.Member;

public class TestMap 
{

	public static void main(String[] args) 
	{
		// VETTORE
		// 0		-> V
		// 1		-> V
		// 2		-> V
		
		
		//	  K   ->  V
		Map<String,String> traduzioni = new HashMap<String,String>();
		
		traduzioni.put("ASKCOMMAND", "Inserisci comando");
		traduzioni.put("ASKID", "Inserisci id");
		
		System.out.println(traduzioni);	
		
		Map<String,Integer> mappaeta = new HashMap<String,Integer>();
		mappaeta.put("Ferdinando", 2500);
		mappaeta.put("Andrea", 27);
		mappaeta.put("Stefano", 26);
		// Prendo il VALORE (V) collegato alla K = Andrea
		System.out.println(mappaeta.get("Andrea"));
		
		Member simone = new Member();
		simone.setNickname("Simone Boh");
		Member ferdinando = new Member();
		ferdinando.setNickname("El hombre ");
		Member eleonora = new Member();
		eleonora.setNickname("Eleonora");

		//	 K   => V
		Map<String,Member> roles = new HashMap<String,Member>();
		roles.put("CEO", eleonora);
		roles.put("PR", eleonora);
		roles.put("DEV", simone);
		roles.put("HEADDEV", ferdinando);
		
		
		System.out.println(roles.get("PR").getNickname());
		
		/*
		 * CEO				=>			eleonora
		 * PR				=>			eleonora
		 * DEV				=>			simone
		 * HEADDEV			=>			ferdinando
		 */
		// SOVRASCRIVO LA VECCHIA COPPIA. LE CHIAVI NON SI POSSONO RIPETERE
		roles.put("CEO", simone);
		System.out.println(roles.get("CEO").getNickname());
		
	}

}
