package com.tiy.ssa.week3.assignment4;

public class DiamondInheritance implements Goo, Hoo
{

    @Override
    public boolean isHappy()
    {
        
        return Goo.super.isHappy();
    }

}
