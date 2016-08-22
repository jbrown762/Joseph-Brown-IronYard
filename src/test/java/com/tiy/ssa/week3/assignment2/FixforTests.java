package com.tiy.ssa.week3.assignment2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class FixforTests
{
    static final Logger LOGGER = LogManager.getLogger(FixforTests.class);

    @Test
    public void test()
    {
        Iterator<String> it;
        it = Arrays.asList("ts", "tsts").iterator();

        for (String s : new Fixfor<>(it))
        {
            LOGGER.debug(s);
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
