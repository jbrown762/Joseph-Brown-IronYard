package com.tiy.ssa.weekone.assignmentthree;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tiy.ssa.weekone.assignmentthree.PigLatin;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PigLatinTests
{
	@Test
	public void aVowel()
	{
		System.out.println("ENGLISH ---> PIG LATIN\n");
		assertEquals("airway", new PigLatin("air").translate());
		assertEquals("uway", new PigLatin("u").translate());
		assertEquals("oopsway", new PigLatin("oops").translate());
	}
	
	@Test
	public void bOneConsonant()
	{
		assertEquals("igpay", new PigLatin("pig").translate());
		assertEquals("ananabay", new PigLatin("banana").translate());
		assertEquals("pay", new PigLatin("p").translate());
	}
	
	@Test
	public void cTwoConsonant()
	{
		assertEquals("oomblay", new PigLatin("bloom").translate());
		assertEquals("ooptray", new PigLatin("troop").translate());
	}
	
	@Test
	public void dPhrase()
	{
		assertEquals("igpay atinlay isway ardhay otay eakspay", new PigLatin("Pig Latin is hard to speak").translate());
		assertEquals("onesthay appyhay omeshay", new PigLatin("honest happy homes").translate());
		assertEquals("eakspay easyway", new PigLatin("speak easy").translate());
	}
}