package com.tiy.ssa.week2.assignment1;

public class Harambe
{
    private int weight;

    public Harambe(int weight)
    {
        this.weight = weight;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    @Override
    public String toString()
    {
        return "Harambe weight:" + this.weight + "\t";
    }
    
    public String get()
    {
        return "Harambe " + weight + "!";
    }
}
