package ge100;

import utils.LTUtils;

/**
 * 130. Surrounded Regions
 * */
public class LT0130
{

    public static void main(String[] args)
    {
        int a = 6;
        System.out.println(a & 1);
        System.out.println(a & 2);
        System.out.println(a & 4);
        System.out.println(a & 5);      // 4
        System.out.println(1 | 2 | 4);      // 7
        System.out.println(1 | 2 | 8);      // 11
        System.out.println(0 | 2 | 4);      // 6
        
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X', } };

        board = new char[][] { { 'O', 'O', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' },
                { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'O', 'O' } };
        LTUtils.showArrayOfArrayOneRowOneLine(board);
        new LT0130().Lt0130c(board);
        LTUtils.showArrayOfArrayOneRowOneLine(board);
    }
    
    
    // 6ms, most are [4, 9]ms
    // 突然想到，不被包围就必然和最外圈的O相连接。
    private void Lt0130c(char[][] board)
    {
        if (board.length == 0 || board[0].length == 0)
        {
            return;
        }
        int len1 = board.length - 1;
        int len2 = board[0].length - 1;
        
        for (int i = 0; i <= len1; i++)
        {
            if (board[i][0] == 'O')
            {
                fill(board, i, 0, (i == len1 ? 0 : 1) | (i == 0 ? 0 : 2) | 4);
            }
            if (board[i][len2] == 'O')
            {
                fill(board, i, len2, (i == len1 ? 0 : 1) | (i == 0 ? 0 : 2) | 8);
            }
        }
        
        for (int j = 0; j <= len2; j++)
        {
            if (board[0][j] == 'O')
            {
                fill(board, 0, j, 1 | 4 | 8);
            }
            if (board[len1][j] == 'O')
            {
                fill(board, len1, j, 2 | 4 | 8);
            }
        }
        
        LTUtils.showArrayOfArrayOneRowOneLine(board);
        
        for (int i = 0; i <= len1; i++)
        {
            for (int j = 0; j <= len2; j++)
            {
                switch (board[i][j])
                {
                case 'X':
                    break;
                case 'Z':
                    board[i][j] = 'O';
                    break;
                case 'O':
                    board[i][j] = 'X';
                    break;
                }
            }
        }
    }
    
    // 1:i++, 2:i--, 4:j++, 8:j--;
    private void fill(char[][] board, int i, int j, int direct)
    {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
        {
            return;
        }
        board[i][j] = 'Z';
//        if ((direct & 1) == 1)        // this is error, so comment out
//        {
            fill(board, i + 1, j, direct);
//        }
//        if ((direct & 2) == 2)
//        {
            fill(board, i - 1, j, direct);
//        }
//        if ((direct & 4) == 4)
//        {
            fill(board, i, j + 1, direct);
//        }
//        if ((direct & 8) == 8)
//        {
            fill(board, i, j - 1, direct);
//        }
    }
    
    @Deprecated
    private void Lt0130b(char[][] board)
    {
        if (board.length == 0 || board[0].length == 0)
        {
            return;
        }
        int len1 = board.length;
        int len2 = board[0].length;
//        char o = 'O';
//        char x = 'X';
        for (int i = 0; i < len1; i++)
        {
            for (int j = 0; j < len2; j++)
            {
                if (board[i][j] != 'O')
                {
                    continue;
                }
                else
                {
                    
                }
            }
        }
        
        for (int i = 0; i < len1; i++)
        {
            for (int j = 0; j < len2; j++)
            {
                if (board[i][j] == 'Z')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void recursionb(char[][] board, int i, int j)
    {
        
    }
    
    
    // 58/59 ... timeout ...
    @Deprecated
    private void Lt0130a(char[][] board)
    {
        if (board.length == 0 || board[0].length == 0)
        {
            return;
        }
        boolean[][] arr = convertArray(board);
        
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                if (arr[i][j])      // X
                {
                    continue;
                }
                if (isSurrounded(arr, i, j))
                {
                    flushBoard(board, i, j);
                }
                flushArr(arr, i, j);
            }
        }
    }
    
    private void flushBoard(char[][] board, int i, int j)
    {
        int rowNum = board.length;
        int colNum = board[0].length;
        if (i < 0 || i >= rowNum || j < 0 || j >= colNum)
        {
            return;
        }
        if (board[i][j] == 'O')
        {
            board[i][j] = 'X';
            flushBoard(board, i + 1, j);
            flushBoard(board, i - 1, j);
            flushBoard(board, i, j + 1);
            flushBoard(board, i, j - 1);
        }
    }
    
    private void flushArr(boolean[][] arr, int i, int j)
    {
        int rowNum = arr.length;
        int colNum = arr[0].length;
        if (i < 0 || i >= rowNum || j < 0 || j >= colNum)
        {
            return;
        }
        if (!arr[i][j])
        {
            arr[i][j] = true;
            flushArr(arr, i, j - 1);
            flushArr(arr, i, j + 1);
            flushArr(arr, i - 1, j);
            flushArr(arr, i + 1, j);
        }
    }
    
    private boolean isSurrounded(boolean[][] arr, int i, int j)
    {
        int rowNum = arr.length;
        int colNum = arr[0].length;
        
        if (i < 0 || i >= rowNum || j < 0 || j >= colNum)
        {
            return false;
        }
        
        if (arr[i][j])
        {
            return true;
        }
        arr[i][j] = true;
        boolean result = true;
        if (!isSurrounded(arr, i + 1, j))
        {
            result = false;
        }
        if (result && !isSurrounded(arr, i - 1, j))
        {
            result = false;
        }
        if (result && !isSurrounded(arr, i, j + 1))
        {
            result = false;
        }
        if (result && !isSurrounded(arr, i, j - 1))
        {
            result = false;
        }
        arr[i][j] = false;
        return result;
    }
    
    private boolean[][] convertArray(char[][] arr)
    {
        boolean[][] result = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                if ('X' == arr[i][j])
                {
                    result[i][j] = true;
                }
            }
        }
        return result;
    }
}
