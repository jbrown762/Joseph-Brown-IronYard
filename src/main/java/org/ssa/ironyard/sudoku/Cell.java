package org.ssa.ironyard.sudoku;

public class Cell
{

    boolean isFixed;
    int row, column, value;
    
    
    public Cell(int row, int column, int value, boolean isFixed)
    {
        this.isFixed = isFixed;
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public void setCell(int row, int column, int value, boolean isFixed)
    {
        this.isFixed = isFixed;
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public boolean isFixed()
    {
        return isFixed;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public int getValue()
    {
        return value;
    }
    
    

}
