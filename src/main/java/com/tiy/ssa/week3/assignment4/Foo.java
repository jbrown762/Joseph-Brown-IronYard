package com.tiy.ssa.week3.assignment4;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tiy.ssa.weekone.assignmentone.Power;

public class Foo
{
    static final Logger LOGGER = LogManager.getLogger(Power.class);

    public void foo(LocalDate date)
    {
        LOGGER.debug("foo (LD) called");
    }
    
    public void foo(Object obj){
        LOGGER.debug("foo (Obj) called");
    }
    
    public static void main(String[] args)
    {
        Foo f = new Foo();
        LocalDate now = LocalDate.now();
        f.foo(now);
        Object o = now;
        f.foo(o);
    }
}
