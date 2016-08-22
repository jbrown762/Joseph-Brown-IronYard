package com.tiy.ssa.week2.assignment2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weekone.assignmentone.Power;

public class UserTests
{
    static final Logger LOGGER = LogManager.getLogger(UserTests.class);

    List<User> users = new ArrayList<>();

    @Before
    public void setup()
    {
        users.clear();
        users.add(new User("Joe", "Brown", 35));
        users.add(new User("Joe", "Brown", 15));
        users.add(new User("Joe", "Brown", 13));
        users.add(new User("Metta", "World Peace", 16));
        users.add(new User("Jesus", "Christ", 63));
        users.add(new User("Baby", "Jesus", 1));
        users.add(new User("Daniel", "Ethiopia", 38));
    }

    @Test
    public void childrenTest()
    {
        List<Name> usersExpected = new ArrayList<>();
        usersExpected.add(new Name("Joe", "Brown"));
        usersExpected.add(new Name("Baby", "Jesus"));

        for (Name n : children(users))
            LOGGER.debug(n.getFirst() + " " + n.getLast());

        assertEquals(usersExpected, children(users));
    }

    @Test
    public void averageAgeTest()
    {
        assertEquals(39.00, adultAverageAge(users), .01);
    }

    static Collection<Name> children(Collection<? extends User> users)
    {
        Collection<Name> userNames = new ArrayList<>();

        for (User u : users)
        {
            if (u.getAge() < 16 && !userNames.contains(new Name(u.getFirstName(), u.getLastName())))
                userNames.add(new Name(u.getFirstName(), u.getLastName()));
        }
        return userNames;
    }

    static float adultAverageAge(Collection<? extends User> users)
    {
        Float ageSum = 0F;
        Float count = 0F;

        for (User u : users)
            if (u.getAge() > 15)
            {
                ageSum += u.getAge();
                count++;
            }
        return ageSum / count;
    }
}
