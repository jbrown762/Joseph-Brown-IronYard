package org.ssa.ironyard.sudoku;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Square
{
    int row, column;
    Cell[][] cells = new Cell[3][3];

    public Square(int row, int column)
    {
        this.row = row;
        this.column = column;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = new Cell(i, j, 0, false);
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public int getCellValue(int row, int column)
    {
        return cells[row][column].getValue();
    }
    
    public Cell getCell(int row, int column)
    {
        return cells[row/3][column/3];
    }

    public void setCell(int row, int column, int value, boolean isFixed)
    {
        try{
            //System.out.println(row%3 + " " + column%3);
        cells[row%3][column%3].setCell(row, column, value, isFixed);
        }catch(Exception e)
        {
            System.out.println(row + " " + column + "|||||||||||||||||||||||||||||||||");
        }
    }

    public boolean validateSquare()
    {
        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j].getValue() != 0)
                    for (int k = j + 1; k < cells[i].length - k; k++)
                        if (cells[i][j] == cells[i][k])
                            return false;
        return true;
    }

    public Set<Integer> getSquareValues()
    {
        HashSet<Integer> values = new HashSet<Integer>();

        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j].getValue() != 0)
                    values.add(cells[i][j].getValue());
        
        return values;
    }
    
}
