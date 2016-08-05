package com.tiy.ssa.weekone.assignmentfour;

import java.util.ArrayList;

public class Knight
{
	Location home;
	Location current;
	ArrayList<Location> path = new ArrayList<>();

	int xDifference = 0;
	int yDifference = 0;
	int xDifferenceAbs = 0;
	int yDifferenceAbs = 0;
	int xMultiplier = 1;
	int yMultiplier = 1;

	public Knight(Location location)
	{
		home = location;
		current = location;
	}

	public boolean isHome()
	{
		return this.home.equals(this.current);
	}

	public boolean isLegal(Location previousLocation)
	{
		int xDistance = Math.abs(current.getX() - previousLocation.getX());
		int yDistance = Math.abs(current.getY() - previousLocation.getY());

		if (xDistance == 1 && yDistance == 2)
			return true;
		else if (xDistance == 2 && yDistance == 1)
			return true;
		System.out.format("INVALID MOVE! (X moved %d, Y moved %d)\n", xDistance, yDistance);
		return false;
	}

	public Location move()
	{
		if (isHome())
		{
			System.out.print("START: ");
			getLocation();
			
			Location offset = randomOffset();
			this.current = this.current.offset(offset.getX(), offset.getY());
			path.add(new Location(current.getX(), current.getY()));

			xDifference = (current.getX() - home.getX());
			yDifference = (current.getY() - home.getY());

			xDifferenceAbs = Math.abs(current.getX() - home.getX());
			yDifferenceAbs = Math.abs(current.getY() - home.getY());

			xMultiplier = 1;
			yMultiplier = 1;

			if (xDifference > 0)
				xMultiplier = -1;
			if (yDifference > 0)
				yMultiplier = -1;
		}

		else if (xDifferenceAbs == 2 && yDifferenceAbs == 1)
		{
			if (path.size() == 1)
			{
				current = current.offset(xMultiplier * 2, yMultiplier * -1);
				path.add(new Location(current.getX(), current.getY()));

			} else if (path.size() == 2)
			{
				current = current.offset(xMultiplier * 2, yMultiplier * 1);
				path.add(new Location(current.getX(), current.getY()));
			} else if (path.size() == 3)
			{
				current = current.offset(xMultiplier * -2, yMultiplier * 1);
				path.add(new Location(current.getX(), current.getY()));
			}
		}

		else if (xDifferenceAbs == 1 && yDifferenceAbs == 2)
		{
			if (path.size() == 1)
			{
				current = current.offset(xMultiplier * 1, yMultiplier * -2);
				path.add(new Location(current.getX(), current.getY()));
			} else if (path.size() == 2)
			{
				current = current.offset(xMultiplier * 1, yMultiplier * 2);
				path.add(new Location(current.getX(), current.getY()));
			} else if (path.size() == 3)
			{
				current = current.offset(xMultiplier * -1, yMultiplier * 2);
				path.add(new Location(current.getX(), current.getY()));
			}
		}
		System.out.format("Move #%d: ", path.size());
		getLocation();
		return current;
	}
	
	private Location randomOffset(){
		ArrayList<Integer> nums = new ArrayList<>(4);
		nums.add(-1);
		nums.add(1);
		nums.add(-2);
		nums.add(2);

		int x = nums.get((int) (Math.random() * 4));
		if (x == 1 || x == -1)
		{
			nums.remove(0);
			nums.remove(0);
		}else{
			nums.remove(2);
			nums.remove(2);
		}
		int y = nums.get((int) (Math.random() * 2));
		return new Location(x, y);
	}

	private Location getLocation()
	{
		System.out.format("(%d, %d)\n", current.getX(), current.getY());
		return current;
	}
}
