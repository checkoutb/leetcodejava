package gt000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.LTUtils;

/**
 * 37. Sudoku Solver
 * */
public class LT0037 {

    public static void main(String[] args) {
        
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        
        board = new char[][]{{'.','.','9','7','4','8','.','.','.'},
                            {'7','.','.','.','.','.','.','.','.'},
                            {'.','2','.','1','.','9','.','.','.'},
                            {'.','.','7','.','.','.','2','4','.'},
                            {'.','6','4','.','1','.','5','9','.'},
                            {'.','9','8','.','.','.','3','.','.'},
                            {'.','.','.','8','.','3','.','2','.'},
                            {'.','.','.','.','.','.','.','.','6'},
                            {'.','.','.','2','7','5','9','.','.'}};
        
        board = new char[][]{{'0','0','9','7','4','8','0','0','0'},
            {'7','0','0','6','0','2','0','0','0'},
            {'0','2','0','1','0','9','0','0','0'},
            {'0','0','7','9','8','6','2','4','1'},
            {'2','6','4','3','1','7','5','9','8'},
            {'1','9','8','5','2','4','3','6','7'},
            {'0','0','0','8','6','3','0','2','0'},
            {'0','0','0','4','9','1','0','0','6'},
            {'0','0','0','2','7','5','9','0','0'}};
                            
            
            
            
            
                            
        Lt0037(board);
        
    }

    
    // failed, 没有任何思路。，存在那种，要几个空一起来决定值的，这种情况遍历吧。不好写。。。
    public static void Lt0037(char[][] board)
    {
        int[][] sudoku = new int[board.length][board[0].length];
        int[] intArr = new int[10];
        int i = 0;
        int j = 0;
        boolean flag = true;
        boolean flag2 = true;
        int t = 0;
        int m = 0;
        int n = 0;
        int len = board.length;
//        int len2 = 3;
        int len3 = 0;
        int len4 = 0;
        int count = 0;
//        int result = 0;
        int t3 = 0;
        
        int max = 0;
        List<Integer> maxList = new ArrayList<>();
        int maxArr[] = new int[2];
        
        
        for(i = 0; i < len; i++)
        {
            for(j = 0; j < len; j++)
            {
                if(board[i][j] != '.')
                    sudoku[i][j] = board[i][j] - 48;
            }
        }
        
        
        LTUtils.showArrayOfArrayOneRowOneLine(sudoku);
        
//        flag = true;
//        while(flag2)
//        {
//            for(int maxTemp : maxList)
//            {
//                sudoku[maxArr[0]][maxArr[1]] = maxTemp;
//            }
            
//            if(!maxList.isEmpty())
//            {
//                
//            }
            
            while(flag)
            {
                for(i = 0; i < intArr.length; i++)
                {
                    intArr[i] = -1;
                }
                flag = false;
                for(i = 0; i < len; i++)
                {
                    for(j = 0; j < len; j++)
                    {
                        if(sudoku[i][j] == 0)
                        {
                            t = i * len + j;
                            
                            m = i;
                            count = 0;
                            for(n = 0; n < len; n++)
                            {
                                if(sudoku[m][n] != 0)
                                {
                                    if(intArr[sudoku[m][n]] != t)
                                    {
                                        intArr[sudoku[m][n]] = t;
                                        count++;
                                    }
                                }
                            }
                            
                            n = j;
                            for(m = 0; m < len; m++)
                            {
                                if(sudoku[m][n] != 0)
                                {
                                    if(intArr[sudoku[m][n]] != t)
                                    {
                                        intArr[sudoku[m][n]] = t;
                                        count++;
                                    }
                                }
                            }
                            
                            m = i / 3 * 3;
                            n = j / 3 * 3;
                            len3 = m + 3;
                            len4 = n + 3;
                            
                            
    //                        System.out.println("......." + m + ", " + n + ", " + i + ", " + j);
                            
                            
                            for(; m < len3; m++)
                            {
                                n = j / 3 * 3;
                                for(; n < len4; n++)
                                {
                                    
                                    
                                    
    //                                System.out.println("      " + sudoku[m][n] + ", " + m + ", " + n);
                                    
                                    
                                    
                                    if(sudoku[m][n] != 0)
                                    {
                                        if(intArr[sudoku[m][n]] != t)
                                        {
                                            intArr[sudoku[m][n]] = t;
                                            count++;
                                        }
                                    }
                                }
                            }
                            
                            
                            
//                            System.out.println(count + ", " + t);
    //                        System.out.println(Arrays.toString(intArr));
                            
                            if(count == len - 1)
                            {
                                for(m = 1; m < intArr.length; m++)
                                {
                                    if(intArr[m] != t)
                                    {
                                        flag = true;
                                        sudoku[i][j] = m;
                                        break;
                                    }
                                }
                            }
                            else
                            {
                                if(count > max)
                                {
                                    max = count;
                                    maxArr[0] = i;
                                    maxArr[1] = j;
                                    maxList.clear();
                                    for(m = 1; m < intArr.length; m++)
                                    {
                                        if(intArr[m] != t)
                                        {
                                            maxList.add(m);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
//        }
        
        
        
        LTUtils.showArrayOfArrayOneRowOneLine(sudoku);
        
        for(i = 0; i < len; i++)
        {
            for(j = 0; j < len; j++)
            {
                if(board[i][j] == '.')
                {
                    board[i][j] = (char)(sudoku[i][j] + 48);
                }
            }
        }
        
        LTUtils.showArrayOfArrayOneRowOneLine(board);
    }
    
}
