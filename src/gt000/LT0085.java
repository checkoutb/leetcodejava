package gt000;

import utils.LTUtils;

/**
 * 85. Maximal Rectangle
 * */
public class LT0085
{

    public static void main(String[] args)
    {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        matrix = new char[][]{{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
        matrix = new char[][]{{'1','0','1','1','0','1'},{'1','1','1','1','1','1'},{'0','1','1','0','1','1'},{'1','1','1','0','1','0'},{'0','1','1','1','1','1'},{'1','1','0','1','1','1'}};
        
        System.out.println(Lt0085b(matrix));
    }

    // 24ms, beats 71.5%
    public static int Lt0085b(char[][] matrix)
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return 0;
        }
        int result = 0;
        int i = 0;
        int j = 0;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int m = -1;
        int n = -1;
        int t = 0;
        int t2 = 0;
        int[][] lenOf1 = new int[rowSize][colSize];
        int[][] lenOf1V = new int[rowSize][colSize];
        
        for(i = 0; i < rowSize; i++)
        {
            n = 0;
            m = -1;
            for(j = 0; j < colSize; j++)
            {
                if(matrix[i][j] == '1')
                {
                    n++;
                    if(m == -1)
                    {
                        m = j;
                    }
                }
                else
                {
                    if(m != -1)
                    {
                        t = m + n;
                        for(; m < t; m++)
                        {
                            lenOf1[i][m] = (t - m);
                        }
                        
                        n = 0;
                    }
                }
                
                if((m + n) == colSize && m != -1)
                {
                    t = m + n;
                    for(; m < t; m++)
                    {
                        lenOf1[i][m] = (t - m);
                    }
                    n = 0;
                }
                if(m != -1 && matrix[i][j] == '0')
                {
                    m = -1;
                }
            }
        }
        
        for(j = 0; j < colSize; j++)
        {
            m = -1;
            n = 0;
            for(i = 0; i < rowSize; i++)
            {
                if(matrix[i][j] == '1')
                {
                    if(m == -1)
                    {
                        m = i;
                    }
                    n++;
                }
                else
                {
                    if(m != -1)
                    {
                        t = m + n;
                        for(; m < t; m++)
                        {
                            lenOf1V[m][j] = (t - m);
                        }
                        n = 0;
                    }
                }
                
                if((m + n) == rowSize && m != -1)
                {
                    for(; m < rowSize; m++)
                    {
                        lenOf1V[m][j] = (rowSize - m);
                    }
                }
                
                if(m != -1 && matrix[i][j] == '0')
                {
                    m = -1;
                }
            }
        }
        
//        LTUtils.showArrayOfArrayOneRowOneLine(matrix);
//        LTUtils.showArrayOfArrayOneRowOneLine(lenOf1);
//        LTUtils.showArrayOfArrayOneRowOneLine(lenOf1V);
        
        int jMax = 0;
        int t3 = 0;
        for(i = 0; i < rowSize; i++)
        {
            j = 0;
            t2 = -1;
            for(; j < colSize; j++)
            {
                if((t = lenOf1[i][j]) != 0)
                {
                    m = i;
                    n = j;          //
                    jMax = j + t;
                    for(; j < jMax; j++)
                    {
                        if(j == n)
                        {
                            t2 = lenOf1V[i][j];
                        }
                        else
                        {
                            t2 = lenOf1V[i][j] > t2 ? t2 : lenOf1V[i][j];
                        }
                        t3 = (j - n + 1) * t2;
                        result = t3 > result ? t3 : result;
                        
//                        System.out.print(i + ", " + j);
//                        System.out.println(": " + j + ", " + n + ", " + t2);
                        
                    }
                    j = n;
                }
                else
                {
                    if(t2 != -1)
                    {
                        t2 = -1;
                    }
                }
            }
        }
        
        return result;
    }
    
    
    @Deprecated
    public static int Lt0085a(char[][] matrix)
    {
        int result = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int i = 0;
        int j = 0;
        int t = 0;
        char ch = 0;
        int m = 0;
        int n = 0;
//        int 
        
        for(i = 0; i < rowLen; i++)
        {
            for(j = 0; j < colLen; j++)
            {
                if((ch = matrix[i][j]) == '1')
                {
                    for(m = i + 1; m < rowLen; m++)
                    {
                        if(matrix[m][j] != '1')
                        {
                            break;
                        }
                    }
                    for(n = j + 1; n < rowLen; n++)
                    {
                        if(matrix[i][n] != '1')
                        {
                            break;
                        }
                    }
                    if((m - i) * (n - j) < t)
                    {
                        continue;
                    }
                    
                }
            }
        }
        
        result = t;
        return result;
    }
    
    
    @Deprecated
    public static int Lt0085(char[][] matrix)
    {
        int result = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int i = 0;
        int j = 0;
        int t = 0;
        
        int[] rowSize = new int[rowLen];
        
        for(i = 0; i < rowLen; i++)
        {
            t = 0;
            for(j = 0; j < colLen; j++)
            {
                
            }
        }
        
        
        return result;
    }
}
