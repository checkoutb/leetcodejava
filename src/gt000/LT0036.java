package gt000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * */
public class LT0036 {

    public static void main(String[] args) {
        
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},
                            {'2','.','.','.','.','.','.','.','.'},
                            {'3','.','.','.','.','.','.','.','.'},
                            {'4','.','.','.','.','.','.','.','.'},
                            {'5','.','.','.','.','.','.','.','.'},
                            {'6','.','.','.','.','.','.','.','.'},
                            {'7','.','.','.','.','.','.','.','.'},
                            {'8','.','.','.','.','.','.','.','.'},
                            {'9','.','.','.','.','.','.','.','.'}};
        
        board = new char[][]{{'.','.','.','.','.','.','.','.','.'},
                            {'4','.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','6','.','.'},
                            {'.','.','.','3','8','.','.','.','.'},
                            {'.','5','.','.','.','6','.','.','1'},
                            {'8','.','.','.','.','.','.','6','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'.','.','7','.','9','.','.','.','.'},
                            {'.','.','.','6','.','.','.','.','.'}};
        
        board = new char[][]{{'.','8','7','6','5','4','3','2','1'},
                            {'2','.','.','.','.','.','.','.','.'},
                            {'3','.','.','.','.','.','.','.','.'},
                            {'4','.','.','.','.','.','.','.','.'},
                            {'5','.','.','.','.','.','.','.','.'},
                            {'6','.','.','.','.','.','.','.','.'},
                            {'7','.','.','.','.','.','.','.','.'},
                            {'8','.','.','.','.','.','.','.','.'},
                            {'9','.','.','.','.','.','.','.','.'}};
                            
        board = new char[][] { { '.', '9', '.', '.', '4', '.', '.', '.', '.' },
                                { '1', '.', '.', '.', '.', '.', '6', '.', '.' }, 
                                { '.', '.', '3', '.', '.', '.', '.', '.', '.' },
                                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                                { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
                                { '3', '.', '.', '.', '5', '.', '.', '.', '.' }, 
                                { '.', '.', '7', '.', '.', '4', '.', '.', '.' },
                                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                                { '.', '.', '.', '.', '7', '.', '.', '.', '.' } };  
                            
                            
        boolean result = Lt0036a(board);
        
        System.out.println(result);
    }

    
    // beats 20%... at first, i think that Lt0036a will faster then Lt0036...
    public static boolean Lt0036a(char[][] board)
    {
        boolean result = true;
        
        Set<Character>[] rowArr = new HashSet[9];
        Set<Character>[] colArr = new HashSet[9];
        Set<Character>[] partArr = new HashSet[9];
        
        int i = 0;
        int j = 0;
        int length = board.length;
        char ch;
        int k = 0;

        for(i = 0; i < rowArr.length; i++)
        {
            rowArr[i] = new HashSet<>();
        }
        for(i = 0; i < colArr.length; i++)
        {
            colArr[i] = new HashSet<>();
        }
        for(i = 0; i < partArr.length; i++)
            partArr[i] = new HashSet<>();
        
        
        Out:
        for(i = 0; i < length; i++)
        {
            for(j = 0; j < length; j++)
            {
                ch = board[i][j];
                if(ch == '.')
                    continue;
                if(rowArr[i].contains(ch))
                {
                    
                    System.out.println("1/3 : " + i + ", " + j);
                    
                    result = false;
                    break Out;
                }
                else
                    rowArr[i].add(ch);
                if(colArr[j].contains(ch))
                {
                    
                    System.out.println("2/3 : " + i + ", " + j);
                    
                    result = false;
                    break Out;
                }
                else
                    colArr[j].add(ch);
                
                k = i / 3 * 3 + j / 3;
                if(partArr[k].contains(ch))
                {
                    
                    System.out.println("3/3 : " + i + ", " + j + ", " + k);
                    
                    result = false;
                    break Out;
                }
                else
                    partArr[k].add(ch);
            }
        }
        
        
        return result;
    }
    
    
    // beats 75%
    public static boolean Lt0036(char[][] board)
    {
        boolean result = true;
        
        int[] flag = new int[10];       // 0-9,use 1-9
        
        int i = 0;
        int j = 0;
        int length = board.length;
        int len = length / 3;
        int k = 0;
        
        if(length != 9 || board[0].length != 9)
        {
            return false;
        }
        
        for(i = 1; i < flag.length; i++)
        {
            flag[i] = -1;
        }
        
        Out:
        {
            for(i = 0; i < length; i++)
            {
                for(j = 0; j < length; j++)
                {
                    if(board[i][j] == '.')
                    {
                        continue;
                    }
                    k = board[i][j] - 48;
                    if(k >0 && k <= 9)
                    {
                        if(flag[k] == i)
                        {
                            
                            
                            System.out.println(i + ", " + j + ", " + flag[k] + ", " + k);
                            
                            
                            result = false;
                            break Out;
                        }
                        else
                        {
                            flag[k] = i;
                        }
                    }
                    else
                    {
                        result = false;
                        break Out;
                    }
                }
            }
            
            for(i= 1; i < flag.length; i++)
            {
                flag[i] = -1;
            }
            
            
            System.out.println(" 1 / 3 ");
            System.out.println(Arrays.toString(flag));
            
            
            
            
            for(j = 0; j < length; j++)
            {
                for(i = 0; i < length; i++)
                {
                    if(board[i][j] == '.')
                    {
                        continue;
                    }
                    k = board[i][j] - 48;
                    if(flag[k] == j)
                    {
                        result = false;
                        break Out;
                    }
                    else
                    {
                        flag[k] = j;
                    }
                }
            }
            
            for(i = 1; i < flag.length; i++)
            {
                flag[i] = -1;
            }
            
            
            System.out.println(" 2 / 3 ");
            
            
            
            
            int m = 0;
            int n = 0;
            int mLen = 0;
            int nLen = 0;
            int q = 0;
            
            for(i = 0; i < len; i++)
            {
                for(j = 0; j < len; j++)
                {
                    m = i * 3;
                    q = i * 3 + j;
                    
                    for(mLen = m + 3; m < mLen; m++)
                    {
                        n = j * 3;
                        for(nLen = n + 3; n < nLen; n++)
                        {
                            if(board[m][n] == '.')
                            {
                                continue;
                            }
                            k = board[m][n] - 48;
                            if(flag[k] == q)
                            {
                                result = false;
                                break Out;
                            }
                            else
                            {
                                flag[k] = q;
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
}
