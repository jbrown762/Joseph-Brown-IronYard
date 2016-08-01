package com.tiy.ssa.weekone.assignmentone;

public class Thermometer
{

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
			System.out.println((int) temperature + " C --> " + (int) (temperature * 9 / 5 + 32) + " F");
			return (int) Math.round((temperature * 9 / 5 + 32));
		} else
		{
			System.out.println((int) temperature + " F --> " + (int) (temperature - 32) * 5 / 9 + " C");
			return (int) Math.round((temperature - 32) * 5 / 9);
		}
	}
}