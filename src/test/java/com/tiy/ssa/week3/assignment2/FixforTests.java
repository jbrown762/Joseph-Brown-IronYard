package com.tiy.ssa.week3.assignment2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class FixforTests
{

    @Test
    public void test()
    {
        Iterator<String> it;
        it = Arrays.asList("ts", "tsts").iterator();

        for (String s : new Fixfor<>(it))
        {
            System.out.println(s);
        }

    }
    
    @Test
    public void setAdd()
    {
        Map<String, Integer> map = new HashMap<>();
        //Set<String> set = map.keySet();
        
        map.keySet().add("potato");
    }

}
