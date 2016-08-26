package org.ssa.ironyard.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Board
{
    // List<Square> squares = new ArrayList<Square>(9);
    int[] boardArray = new int[81];
    int[] solution = new int[81];
    Square[][] squares = new Square[3][3];
    Square[][] solutionSquares = new Square[3][3];

    String gameID;
    String startState;

    public void parseFile(File file) throws IOException
    {
        BufferedReader reader = null;

        String path = file.getAbsolutePath();
        Path p = file.toPath();
        gameID = p.getFileName().toString().replace(".txt", "");
        try
        {
            reader = Files.newBufferedReader(Paths.get(path), Charset.defaultCharset());
            // parse file
            startState = reader.readLine();

            for (int i = 0; i < startState.length(); i++)
            {
                boardArray[i] = Character.digit(startState.charAt(i), 10);
                System.err.println(boardArray[i]);
            }
        }

        catch (IOException iex)
        {
            throw iex;
        } finally
        {
            if (null != reader)
                reader.close();
        }

        solution = Arrays.copyOf(boardArray, boardArray.length);
    }

    public void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                squares[i][j] = new Square(i, j);

        for (int col = 0; col < 9; col += 3)
            for (int i = 0; i < boardArray.length; i = +9)
                for (int j = i; j < 3; j++)
                    squares[i / 27][i / 3].setCell(boardArray[j] / 9, boardArray[j] % 9, boardArray[j], true);
    }

    public boolean checkRows()
    {
        for (int i = 0; i < 3; i++)
        {
            HashSet<Integer> row = new HashSet<Integer>();
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                {
                    if (row.contains(squares[i][j].getCellValue(i, k)))
                        return false;
                    if (squares[i][j].getCellValue(i, k) != 0)
                        row.add(squares[i][j].getCellValue(i, k));
                }
        }
        return true;
    }

    public Set<Integer> getRowValues(int row)
    {

        HashSet<Integer> rowSet = new HashSet<Integer>();
        for (int j = 0; j < 3; j++)
            for (int k = 0; k < 3; k++)
            {
                if (squares[row][j].getCellValue(row, k) != 0)
                    rowSet.add(squares[row][j].getCellValue(row, k));
            }
        return rowSet;
    }

    public boolean checkColumns()
    {
        for (int i = 0; i < 3; i++)
        {
            HashSet<Integer> column = new HashSet<Integer>();

            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    if (column.contains(squares[j][i].getCellValue(k, i)))
                        return false;
                    if (squares[j][i].getCellValue(k, i) != 0)
                        column.add(squares[j][i].getCellValue(k, i));
                }
            }
        }
        return true;
    }

    public Set<Integer> getColValues(int col)
    {
        HashSet<Integer> column = new HashSet<Integer>();

        for (int j = 0; j < 3; j++)
            for (int k = 0; k < 3; k++)
                if (squares[j][col].getCellValue(k, col) != 0)
                    column.add(squares[j][col].getCellValue(k, col));

        return column;
    }

    public void solve()
    {
        
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                HashSet<Integer> restrictedValues = new HashSet<Integer>();
                restrictedValues.addAll(getRowValues(i));
                restrictedValues.addAll(getColValues(j));
                restrictedValues.addAll(solutionSquares[i / 3][j / 3].getSquareValues());

                for (int value = 1; value < 10; value++)
                {
                    if(!restrictedValues.contains(value)){
                        solutionSquares[i / 3][j / 3].setCell(i, j, value, false);
                        break;
                    }
                }
                
            }
        }
        
        solutionSquaresToString();
    }
    
    private void solutionSquaresToString()
    {
        for (int i = 0; i < 9; i++)
        {
            int j = 0;
            for (int value : getRowValues(i))
            {
                solution[i*9 + j] = value;
                j++;
            }
        }
        
    }

    public static void main(String[] args) throws IOException
    {
        Board b = new Board();
        b.parseFile(new File("C:/Users/admin/Downloads/easy-11.txt")); // input from user
        b.initializeBoard();
        b.solutionSquares = Arrays.copyOf(b.squares, b.squares.length);
        b.solve();
        
        System.out.println(b.solution);

    }
}
