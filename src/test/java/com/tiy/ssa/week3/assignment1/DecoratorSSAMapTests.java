package com.tiy.ssa.week3.assignment1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class DecoratorSSAMapTests
{

    @Test
    public void test()
    {

        DecoratorSSAMap<String, Integer> map = new DecoratorSSAMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        map.replace("a", 22);

        assertTrue(map.containsKey("b"));
        assertTrue(map.containsValue(new Integer(22)));

        assertEquals(new Integer(22), map.get("a"));
        assertEquals(new Integer(2), map.remove("b"));
        assertEquals(3, map.size());

        
        
        List<Integer> list = new ArrayList<>();
        list.add(22);
        list.add(3);
        list.add(4);
        assertEquals(list, map.values());

        Map<String, Integer> tempMap = new HashMap<>();
        tempMap.put("z", 99);
        tempMap.put("y", 88);

        map.putAll(tempMap);

        Map<String, Integer> tempMap2 = new HashMap<>();
        tempMap2.put("a", 22);
        tempMap2.put("c", 3);
        tempMap2.put("d", 4);
        tempMap2.put("z", 99);
        tempMap2.put("y", 88);

        assertEquals(tempMap2, map);

        
        
        
        Set<String> keySet = new HashSet<>();

        keySet.add("a");
        keySet.add("c");
        keySet.add("d");
        keySet.add("z");
        keySet.add("y");

        List<Integer> valueList = new ArrayList<>();

        valueList.add(22);
        valueList.add(3);
        valueList.add(4);
        valueList.add(88);
        valueList.add(99);

        assertEquals(map.keySet(), keySet);
        assertEquals(map.values(), valueList);

        
        
        
        map.clear();
        assertTrue(map.isEmpty());

    }

}
