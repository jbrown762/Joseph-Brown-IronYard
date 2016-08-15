package com.tiy.ssa.week3.assignment1;

import java.util.HashMap;
import java.util.Map;

public class MapUtil<K, V>
{
    Map<K, V> map = new HashMap<>();
    
    void add(K key, V value){
        map.put(key, value);
    }

    public V mapHelper(K key, V defaultReturn)
    {
        V retValue = this.map.get(key);
        if (retValue != null)
            return retValue;
        return defaultReturn;
    }
    
}
