import java.util.*;
import java.lang.*;

class NQueens
{
    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> resultSet=new ArrayList<List<String>>();
        List<Integer> combination=new ArrayList<Integer>();
        _solveNQueens(0, n, combination, resultSet);
        return resultSet;
    }

    public static void _solveNQueens(int row, int n, List<Integer> queenPlacement, List<List<String>> resultSet)
    {
        if(row==n)
        {
            //Constructing the required output type
            ArrayList<String> solvedBoard=new ArrayList<String>();
            for(int col: queenPlacement)
            {
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<n;i++)
                {
                    if(i==col)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                solvedBoard.add(sb.toString());
            }
            resultSet.add(solvedBoard);
        }
        else
        {
            for(int column=0;column<n;column++)
            {
                queenPlacement.add(column);
                if(isValid(queenPlacement))
                    _solveNQueens(row+1, n, queenPlacement, resultSet);
                queenPlacement.remove(queenPlacement.size()-1);
            }
        }
    }

    public static boolean isValid(List<Integer> queenPlacement)
    {
        int rowsFilled=queenPlacement.size()-1;
        for(int i=0;i<rowsFilled;i++)
        {
            int diff=Math.abs(queenPlacement.get(i)-queenPlacement.get(rowsFilled));
            if (diff==0 || diff==rowsFilled-i)
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        List<List<String>> resultSet=new ArrayList<List<String>>();

        int n=4;
        resultSet=solveNQueens(4);

        int i=1;
        for(List<String> solvedBoard: resultSet)
        {
            System.out.println("Solution "+i+" : "+Arrays.toString(solvedBoard.toArray()));
            i++;
        }
    }

}
