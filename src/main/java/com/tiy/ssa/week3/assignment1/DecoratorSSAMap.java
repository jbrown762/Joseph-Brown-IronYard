package com.tiy.ssa.week3.assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author thurston
 * @param <K>
 * @param <V>
 */
public class DecoratorSSAMap<K, V> extends SSAMap<K, V>
{
    final Map<K, V> decorated = new HashMap<>();

    @Override
    public V get(Object key)
    {
        return this.decorated.get(key);
    }

    @Override
    public V put(K key, V value)
    {
        return this.decorated.put(key, value);
    }

    @Override
    public V remove(Object key)
    {
        return this.decorated.remove(key);
    }

    @Override
    public Set entrySet()
    {
        return this.decorated.entrySet();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((decorated == null) ? 0 : decorated.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DecoratorSSAMap other = (DecoratorSSAMap) obj;
        if (decorated == null)
        {
            if (other.decorated != null)
                return false;
        } else if (!decorated.equals(other.decorated))
            return false;
        return true;
    }

    
    
}
