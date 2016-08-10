package com.tiy.ssa.week2.assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class SocialSecurityTests
{

    @Test
    public void test()
    {
        assertEquals("", "1234", new SocialSecurityNumber("9998881234").last4Digits());
    }

}
