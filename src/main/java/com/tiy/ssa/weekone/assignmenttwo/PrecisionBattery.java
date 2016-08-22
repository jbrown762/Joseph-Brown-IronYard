package com.tiy.ssa.weekone.assignmenttwo;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrecisionBattery
{
    static final Logger LOGGER = LogManager.getLogger(PrecisionBattery.class);

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
            LOGGER.debug(
					"{} minutes remaining for a device with {} power using a battery with {} kw leftover\n",
					getRemaining() / (power.floatValue()) * 60, power, leftOver);
			return (int) (getRemaining() / (power.intValue())) * 60;
		}
	}

	private void printBatteryInfo()
	{
        LOGGER.debug("Battery capacity: {}, battery left over: {}\n", capacity, leftOver);
	}
}
