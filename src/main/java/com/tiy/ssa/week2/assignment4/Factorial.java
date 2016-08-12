package com.tiy.ssa.week2.assignment4;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Factorial
{

    static final Map<Integer, BigInteger> cache = new HashMap<>();

    private Factorial()
    {
    }

    public static BigInteger factorial(int input){
        if(input < 0)
            throw new IllegalArgumentException("Input must be >= 0");
        
        BigInteger big;
        
        if(input == 0)
            return BigInteger.ONE;
        
        big = BigInteger.valueOf(input).multiply(factorial(input-1));
        
        cache.put(input, big);
        
        return big;
    }
}
