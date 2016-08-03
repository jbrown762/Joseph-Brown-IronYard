package com.tiy.ssa.weekone.assignmenttwo;

import java.math.BigDecimal;

public class PrecisionBattery
{

	final BigDecimal capacity;
	BigDecimal leftOver; // cannot be > than capacity && cannot be < 0
	BigDecimal bd;

	public PrecisionBattery(BigDecimal capacity)
	{
		if (capacity.compareTo(new BigDecimal(0)) == -1)
			capacity = new BigDecimal(0);
		this.capacity = capacity;
		this.leftOver = capacity;
	}

	public BigDecimal discharge(BigDecimal dischargeAmount)
	{
		if (dischargeAmount.compareTo(new BigDecimal(0)) == -1)
			return charge(dischargeAmount.multiply(new BigDecimal(-1)));
		else
		{
			leftOver = leftOver.subtract(dischargeAmount);
			if (leftOver.compareTo(new BigDecimal(0)) == -1)
				leftOver = new BigDecimal(0);
			printBatteryInfo();
			return leftOver;
		}
	}

	public BigDecimal charge(BigDecimal chargeAmount)
	{
		if (chargeAmount.compareTo(new BigDecimal(0)) == -1)
			return discharge(chargeAmount.multiply(new BigDecimal(-1)));
		else
		{
			leftOver = leftOver.add(chargeAmount);
			if (leftOver.compareTo(capacity) == 1)
				leftOver = capacity;
			printBatteryInfo();
			return leftOver;
		}
	}

	public float getCapacity()
	{
		return capacity.floatValue();
	}

	public float getRemaining()
	{
		return leftOver.floatValue();
	}

	public int howLong(BigDecimal power)
	{
		if (power.compareTo(new BigDecimal(0)) == 0)
			return 0;
		else
		{
			System.out.format(
					"%.0f minutes remaining for a device with %.0f power using a battery with %.0f kw leftover\n",
					getRemaining() / (power.floatValue()) * 60, power, leftOver);
			return (int) (getRemaining() / (power.intValue())) * 60;
		}
	}

	private void printBatteryInfo()
	{
		System.out.format("Battery capacity: %.1f, battery left over: %.1f\n", capacity, leftOver);
	}
}
