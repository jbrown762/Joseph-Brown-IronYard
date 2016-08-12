package com.tiy.ssa.week2.assignment4;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Map.Entry;

import org.junit.Test;

public class FactorialTests
{

    @Test
    public void test()
    {
        Factorial.factorial(11);
        
        
        assertEquals(BigInteger.valueOf(39916800), Factorial.cache.get(11));
        
        for(BigInteger e : Factorial.cache.values())
            System.out.println(e);
    }

}
