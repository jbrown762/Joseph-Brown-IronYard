package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThermometerTest
{

	@Test
	public void isEqualTest()
	{
		assertEquals("", 78, new Thermometer(78, true).display(true));
		assertEquals("", 8, new Thermometer(8, false).display(false));
	}

	@Test
	public void intConvertTest()
	{
		assertEquals("", 537, new Thermometer(999, true).display(false));
		assertEquals("", 104, new Thermometer(40, false).display(true));
		assertEquals("", 4, new Thermometer(40, true).display(false));		
	}

	@Test
	public void decimalConvertTest()
	{
		assertEquals("", 26, new Thermometer(78.3, true).display(false));
		assertEquals("", 174, new Thermometer(78.9, false).display(true));
		assertEquals("", 213, new Thermometer(100.65, false).display(true));
		assertEquals("", 100, new Thermometer(99.8, false).display(false));
	}

}
