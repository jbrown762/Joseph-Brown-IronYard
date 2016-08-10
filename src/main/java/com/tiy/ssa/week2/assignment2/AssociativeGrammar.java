package com.tiy.ssa.week2.assignment2;

public class AssociativeGrammar
{

    String originalInput;
    String newString;

    public AssociativeGrammar(String originalInput)
    {
        this.originalInput = originalInput;
        this.newString = originalInput;
    }

    /**
     * 
     * @return the 'program' source - the input that needs to be compiled
     */

    public String getSource()
    {
        return this.originalInput;
    }

    /**
     * @param operator
     *            - one of '(', '{', '[', ')', '}', ']' - any other value is illegal
     * @return the 'program'
     */
    public String addOperator(char operator)
    {
        return newString += operator;
    }

    /**
    *  @return whether the 'program' is valid
    */
    public boolean compiles(){
        char[] charArray = newString.toCharArray();
        for (int i = 0; i < newString.length(); i++)
        {
            if(!isLeftOperator(charArray[i])){
                //    newString.substring(, i);
            }
        }
        return false;
    }

    private boolean isLeftOperator(char c)
    {
        String lefts = "({[";
        if (lefts.indexOf(c) != -1)
            return true;

        return false;

    }

}
