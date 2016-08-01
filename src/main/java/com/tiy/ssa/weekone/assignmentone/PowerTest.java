package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTest
{

	@Test
	public void testPowerOne()
	{
		assertEquals(1, new Power(1).powerOfOne());
		assertEquals(3, new Power(3).powerOfOne());
		assertEquals(5, new Power(5).powerOfOne());
	}

	@Test
	public void testPowerTwo()
	{
		assertEquals(16, new Power(4).squared());
		assertEquals(25, new Power(5).squared());
		assertEquals(4, new Power(2).squared());
	}

	@Test
	public void testPowerThree()
	{
		assertEquals(8, new Power(2).cubed());
		assertEquals(125, new Power(5).cubed());
		assertEquals(27, new Power(3).cubed());
	}

}
