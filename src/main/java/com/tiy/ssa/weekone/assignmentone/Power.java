package com.tiy.ssa.weekone.assignmentone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Power
{
    static final Logger LOGGER = LogManager.getLogger(Power.class);

	int num;

	public Power(int num)
	{
		this.num = num;
	}

	public int powerOfOne()
	{
	    LOGGER.debug("{} to the power of one = {}\n", num, num);
		return num;
	}

	public int squared()
	{
	    LOGGER.debug("{} squared = {}\n", num, num * num);
		return num * num;
	}

	public int cubed()
	{
	    LOGGER.debug("{} cubed = {}\n", num, num * num * num);
		return num * num * num;
	}
}
