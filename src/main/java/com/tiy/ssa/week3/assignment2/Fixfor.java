package com.tiy.ssa.week3.assignment2;

import java.util.Iterator;

public class Fixfor<T> implements Iterator<T>, Iterable<T>
{

    final Iterator<T> decorated;

    public Fixfor(Iterator<T> decorated)
    {
        this.decorated = decorated;
    }

    @Override
    public Iterator<T> iterator()
    {
        return this;
    }

    @Override
    public boolean hasNext()
    {
        return this.decorated.hasNext();

    }

    @Override
    public T next()
    {
        return this.decorated.next();
    }

    @Override
    public void remove()
    {

        this.decorated.remove();
    }
}
