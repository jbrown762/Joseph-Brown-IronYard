package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathsTests
{

	@Test
	public void rootTests()
	{
		for (int i = 0; i < 100; i++)
		{
			assertEquals((int) Math.sqrt(i), Maths.squareRoot(i));
			assertEquals((int) Math.cbrt(i), Maths.cubeRoot(i));
		}
		assertEquals((int) Math.cbrt(-27), Maths.cubeRoot(-27));
	}

	@Test
	public void logTests()
	{
		assertEquals((int) 3, Maths.logTwo(8));
		assertEquals((int) 4, Maths.logTwo(30));
		assertEquals((int) 6, Maths.logTwo(100));

		assertEquals((int) 2, Maths.logThree(11));
		assertEquals((int) 3, Maths.logThree(30));
		assertEquals((int) 4, Maths.logThree(100));
	}
	
	@Test
	public void stringy()
	{
		String abc = "ABC";
		String lower = abc.toLowerCase();
		//assertEquals("", "abc", abc);
		assertEquals("", "abc", lower);
	}
}
