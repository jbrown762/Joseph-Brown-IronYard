package com.tiy.ssa.week3.assignment4;

import java.time.LocalDate;

public class Foo
{
    public void foo(LocalDate date)
    {
        System.err.println("foo (LD) called");
    }
    
    public void foo(Object obj){
        System.err.println("foo (Obj) called");
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
