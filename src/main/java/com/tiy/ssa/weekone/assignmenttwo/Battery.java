package com.tiy.ssa.weekone.assignmenttwo;

public class Battery
{

	final float capacity;
	float leftOver; // cannot be > than capacity && cannot be < 0

	public Battery(float capacity)
	{
		if (capacity < 0)
			capacity = 0;
		this.capacity = capacity;
		this.leftOver = capacity;
	}

	public float discharge(float dischargeAmount)
	{
		if (dischargeAmount < 0)
			return charge(-dischargeAmount);

		if ((leftOver -= dischargeAmount) < 0)
			leftOver = 0;
		printBatteryInfo();
		return leftOver;
	}

	public float charge(float chargeAmount)
	{
		if (chargeAmount < 0)
			return discharge(-chargeAmount);
		else
		{
			leftOver += chargeAmount;
			if (leftOver > capacity)
				leftOver = capacity;
			printBatteryInfo();
			return leftOver;
		}
	}

	public int howLong(float power)
	{
		if (power == 0)
			return 0;
		else
		{
			System.out.format(
					"%.0f minutes remaining for a device with %.0f power using a battery with %.0f kw leftover\n",
					leftOver / (power) * 60, power, leftOver);
			return (int) (leftOver / (power)) * 60;
		}
	}

	private void printBatteryInfo()
	{
		System.out.format("Battery capacity: %.1f, battery left over: %.1f\n", capacity, leftOver);
	}
}