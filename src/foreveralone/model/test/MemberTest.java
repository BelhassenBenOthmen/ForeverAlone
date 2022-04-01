package foreveralone.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import foreveralone.model.entities.Member;


class MemberTest 
{

	@Test
	void testGetCompatibility() 
	{
		Member ferdinando = new Member
		(
			null,
			"Java & Amore",
			"M",
			"05/02/1980",
			"F",
			"Java,Moto,Scacchi,SF5,MMA",
			"Oroscopo,Omeopatia,Inter"
		);		
		// testo il caso NO SELF LOVE per il metodo getCompatibility
		assert(ferdinando.getCompatibility(ferdinando)==0);
		Member bestfriend = new Member
		(
			null,
			"Amico ideale",
			"M",
			"05/02/1980",
			"F",
			"Java,Moto,Scacchi,SF5,MMA",
			"Oroscopo,Omeopatia,Inter"
		);		
		// caso WRONG GENDER
		assert(ferdinando.getCompatibility(bestfriend)==0);
		
		Member potreiamartima = new Member
		(
			null,
			"CaraTiAmo",
			"F",
			"05/02/1980",
			"M",
			"Java,Moto,Scacchi,SF5,MMA,Oroscopo",
			"Calzini bianchi"
		);		
		// CASO TABOO
		assert(ferdinando.getCompatibility(potreiamartima)==0);
		
		Member donnaideale = new Member
		(
			null,
			"Cettina",
			"F",
			"05/02/1985",
			"M",
			"SF5",
			"Oroscopo"
		);		
		
		assert(ferdinando.getCompatibility(donnaideale)==50);
		
		
	}

}
