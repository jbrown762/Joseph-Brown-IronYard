package com.tiy.ssa.week2.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.tiy.ssa.week2.assignment3.SocialSecurityNumber;

public class Registry
{

    final Map<SocialSecurityNumber, Person> peopleMap = new HashMap<>();

    public boolean add(Person person)
    {
        if (peopleMap.containsValue(person))
            return false;

        peopleMap.put(person.getSsn(), person);

        return true;
    }

    public Person get(SocialSecurityNumber ssn)
    {
        return this.peopleMap.get(ssn);
    }

    public Person progenitor(SocialSecurityNumber ssn)
    {
        Person p = get(ssn);

        if (p.parentI != null && p.parentII != null)
        {
            Person oldLeft = progenitor(p.parentI.getSsn());
            Person oldRight = progenitor(p.parentII.getSsn());

            if (oldLeft.age() > oldRight.age())
                return oldLeft;
            else
                return oldRight;

        } else if (p.getParentI() == null && p.getParentII() != null)
            return progenitor(p.parentII.getSsn());
        else if (p.getParentI() != null && p.getParentII() == null)
            return progenitor(p.parentI.getSsn());
        else
            return p;
    }

    public Person oldestLivingRelative(SocialSecurityNumber ssn)
    {
        Person p = get(ssn);
        Person oldLeft;
        Person oldRight;
        if (p.parentI != null && p.parentII != null)
        {
            oldLeft = oldestLivingRelative(p.getParentI().getSsn());
            oldRight = oldestLivingRelative(p.getParentII().getSsn());

            if (oldLeft.age() > oldRight.age() && oldLeft.isAlive())
                return oldLeft;
            else if (oldRight.isAlive())
                return oldRight;
        }

        else if (p.parentI != null && p.parentII == null)
        {
            oldLeft = oldestLivingRelative(p.getParentI().getSsn());
            return oldLeft;
        } else if ((p.parentI == null && p.parentII != null))
        {
            oldRight = oldestLivingRelative(p.getParentII().getSsn());
            return oldRight;
        }

        return p;

    }

    public List<Person> ancestors(SocialSecurityNumber ssn)
    {
        List<Person> ancestors = new ArrayList<>();
        Person p = get(ssn);

        if (p.parentI != null && p.parentII != null)
        {
            ancestors.add(p.getParentI());
            ancestors.add(p.getParentII());
            ancestors.addAll(ancestors(p.getParentI().getSsn()));
            ancestors.addAll(ancestors(p.getParentII().getSsn()));

            return ancestors;

        } else if (p.getParentI() != null && p.getParentII() == null)
        {
            ancestors.add(p.getParentI());
            ancestors.addAll(ancestors(p.getParentI().getSsn()));
            return ancestors;
        } else if (p.getParentI() == null && p.getParentII() != null)
        {
            ancestors.add(p.getParentII());
            ancestors.addAll(ancestors(p.getParentII().getSsn()));
            return ancestors;
        } else
            return ancestors;
    }

    public List<Person> descendants(SocialSecurityNumber ssn)
    {
        List<Person> descendants = new ArrayList<>();
        Person p = get(ssn);

        if (p.getChildren().size() > 0)
        {
            for (Person child : p.getChildren())
            {
                descendants.add(child);
                descendants.addAll(descendants(child.getSsn()));
            }
            return descendants;

        } else
            return descendants;
    }

    public Person youngestDescendant(SocialSecurityNumber ssn)
    {
        List<Person> descendants = new ArrayList<>();
        Person p = get(ssn);

        if (p.getChildren().size() > 0)
        {
            for (Person child : p.getChildren())
            {
                descendants.add(child);
                descendants.add(youngestDescendant(child.getSsn()));
            }

            descendants.sort((s1, s2) -> (s1.age() - s2.age()));

            return descendants.get(0);

        } else
        {
            return p;
        }
    }

    public boolean areRelated(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        List<Person> oneA = ancestors(one);
        oneA.add(get(one));

        List<Person> twoA = ancestors(two);
        twoA.add(get(two));

        for (Person p : oneA)
            if (twoA.contains(p))
                return true;
        return false;
    }

    public Relationship related(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        if (areRelated(one, two))
        {
            if (Objects.equals(get(one).parentI, get(two)) || Objects.equals(get(one).parentII, get(two)))
            {

                return Relationship.PARENT;
            }
            if (Objects.equals(get(two).parentI, (get(one))) || Objects.equals(get(two).parentII, (get(one))))
            {
                return Relationship.CHILD;
            }

            if (get(one).getParentI() != null || get(one).getParentII() != null)
            {
                if (Objects.equals(get(one).getParentI().getParentI(), (get(two)))
                        || Objects.equals(get(one).parentI.getParentII(), (get(two)))
                        || Objects.equals(get(one).parentII.getParentI(), (get(two)))
                        || Objects.equals(get(one).parentII.getParentII(), get(two)))
                {
                    return Relationship.GRANDPARENT;

                }
            }
            if (get(two).getParentI() != null || get(two).getParentII() != null)
            {
                if (Objects.equals(get(two).parentI.getParentI(), (get(one)))
                        || Objects.equals(get(two).parentI.getParentII(), get(one))
                        || Objects.equals(get(two).parentII.getParentI(), (get(one)))
                        || Objects.equals(get(two).parentII.getParentII(), get(one)))
                {
                    return Relationship.GRANDCHILD;
                }
            }
            if (Objects.equals(get(one).getParentI(), get(two).getParentI())
                    || Objects.equals(get(one).getParentI(), get(two).getParentII()))
            {

                return Relationship.SIBLING;
            }
            if (get(one).getParentI() != null || get(one).getParentII() != null)
            {
                if (related(two, get(one).parentI.getSsn()).equals(Relationship.GRANDPARENT)
                        || related(two, get(one).parentII.getSsn()).equals(Relationship.GRANDPARENT))
                {
                    return Relationship.NIBLING;
                }
            }
            if (get(two).getParentI() != null || get(two).getParentII() != null)
            {
                if (Objects.equals(related(one, get(two).parentI.getSsn()), Relationship.GRANDPARENT)
                        || Objects.equals(related(one, get(two).parentII.getSsn()), (Relationship.GRANDPARENT)))
                {
                    return Relationship.AUNCLE;
                }
            }
            if (get(one).getParentI() != null || get(one).getParentII() != null)
            {
                if (Objects.equals(related(two, get(one).parentI.getSsn()), Relationship.AUNCLE)
                        || Objects.equals(related(two, get(one).parentII.getSsn()), Relationship.AUNCLE))
                {
                    return Relationship.COUSIN;
                }
            }
        }
        return Relationship.NONE;
    }

    public int size()
    {
        return peopleMap.size();
    }

    public static enum Relationship
    {
        PARENT, CHILD, GRANDPARENT, GRANDCHILD, COUSIN, SIBLING, NIBLING, AUNCLE, NONE;
    }
}
