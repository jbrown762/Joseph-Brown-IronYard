package com.tiy.ssa.weekone.assignmentfour;

public class Maths
{

	public static int squareRoot(int num)
	{
		for (int i = 0; i <= num; i++)
			if (i * i > num)
				return i - 1;
			else if (i * i == num)
				return i;

		return 0;
	}

	public static int cubeRoot(int num)
	{
		int newNum = num;
		if (num < 0)
			newNum = -num;
		int i = 0;
		while (true)
		{
			if (i * i * i > newNum)
				return num < 0 ? -i + 1 : i - 1;
			else if (i * i * i == newNum)
				return num < 0 ? -i : i;
			i++;
		}
	}

	public static int logTwo(int num)
	{
		int reduced = num;
		for (int i = 0; i < num; i++)
		{
			if (reduced == 1)
				return i;
			reduced = reduced / 2;
		}
		return 0;
	}

	public static int logThree(int num)
	{
		int counter = 0;
		while (true)
		{
			if (num == 1)
				return counter;

			num = num / 3;
			counter++;
		}
	}

}
