package com.tiy.ssa.weekone.assignmentone;

public class Power
{
	int num;

	public Power(int num)
	{
		this.num = num;
	}

	public int powerOfOne()
	{
		System.out.format("%d to the power of one = %d\n", num, num);
		return num;
	}

	public int squared()
	{
		System.out.format("%d squared = %d\n", num, num * num);
		return num * num;
	}

	public int cubed()
	{
		System.out.format("%d cubed = %d\n", num, num * num * num);
		return num * num * num;
	}
}
