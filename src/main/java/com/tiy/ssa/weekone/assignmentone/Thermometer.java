package com.tiy.ssa.weekone.assignmentone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Thermometer
{
    static final Logger LOGGER = LogManager.getLogger(Thermometer.class);

	double temperature;
	boolean isFahrenheit;

	public Thermometer(double temperature)
	{
		this(temperature, true);
	}
	
	public Thermometer(double temperature, boolean isFahrenheit)
	{
		this.temperature = temperature;
		this.isFahrenheit = isFahrenheit;
	}

	public int display(boolean userWantsF)
	{
		if (userWantsF == this.isFahrenheit)
			return (int) Math.round(temperature);
		else if (userWantsF)
		{
		    LOGGER.debug((int) temperature + " C --> " + (int) (temperature * 9 / 5 + 32) + " F");
			return (int) Math.round((temperature * 9 / 5 + 32));
		} else
		{
		    LOGGER.debug((int) temperature + " F --> " + (int) (temperature - 32) * 5 / 9 + " C");
			return (int) Math.round((temperature - 32) * 5 / 9);
		}
	}
}