package com.tiy.ssa.week2.assignment3;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.tiy.ssa.week2.assignment2.User;

public class MapTests
{
    @Test
    public void initial()
    {
        Map<SocialSecurityNumber, User> map = new HashMap<>();
        User user = new User("Joe", "Brown");
        map.put(new SocialSecurityNumber("123456789"), user);
        assertEquals("", user, map.get(new SocialSecurityNumber("123456789")));

        User removed = map.remove(new SocialSecurityNumber("123456789"));
        assertEquals("", user, removed);
        assertEquals("", user, map.get(new SocialSecurityNumber("123456789")));

    }

    @Test
    public void stringshash()
    {
        System.err.println("horse".hashCode());
        System.err.println("hoarse".hashCode());

    }

}
