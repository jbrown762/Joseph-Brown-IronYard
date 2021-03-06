package com.tiy.ssa.weekone.assignmenttwo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.tiy.ssa.weekone.assignmenttwo.Battery;
import com.tiy.ssa.weekone.assignmenttwo.PrecisionBattery;

public class BatteryTests
{

	//@Test
	public void sanity()
	{
		// discharge
		assertEquals("", 0, new Battery(0F).discharge(50F), .1);
		assertEquals("", 69.5, new Battery(70F).discharge(.5F), .1);
		assertEquals("", 40, new Battery(40F).discharge(0F), .1);

		// charge
		assertEquals("", 1, new Battery(1F).charge(10F), .1);
		assertEquals("", 0, new Battery(0F).charge(23F), .1);
		assertEquals("", 800, new Battery(1000F).charge(-200F), .1);
	}

	// @Test
	public void sameBatteryChargeDischarge()
	{
		// charge and discharge same battery multiple times
		Battery b1 = new Battery(125.7F);
		assertEquals("", 75.7, b1.discharge(50F), .1);
		assertEquals("", 96, b1.charge(20.3F), .1);
		assertEquals("", 125.7, b1.charge(203F), .1);
		assertEquals("", 5.7, b1.discharge(120F), .1);
		assertEquals("", 125.7, b1.discharge(-1000F), .1);
	}

	// @Test
	public void howLongTest()
	{
		Battery b2 = new Battery(70);
		b2.discharge(10);
		assertEquals("", 360, b2.howLong(10f), .1);
		b2.discharge(40);
		assertEquals("", 240, b2.howLong(5f), .1);
	}

	@Test
	public void precisionBatteryTest()
	{
		PrecisionBattery b3 = new PrecisionBattery(new BigDecimal(70));

		assertEquals("", new BigDecimal(60), b3.discharge(new BigDecimal(10)));
		assertEquals("", 360, b3.howLong(new BigDecimal(10)), .1);
		assertEquals("", new BigDecimal(20), b3.discharge(new BigDecimal(40)));
		assertEquals("", 240, b3.howLong(new BigDecimal(5)), .1);
		assertEquals("", new BigDecimal(20.5), b3.charge(new BigDecimal(.500)));
	}
}
