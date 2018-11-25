package ge200;

public class LT0221_Maximal_Square
{

    public static void main(String[] args)
    {
//        char[][] arr = {{'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
        
        char[][] arr = {{'1','0','1','0','0'},
                         {'1','0','1','1','1'},
                         {'1','1','1','1','1'},
                         {'1','0','0','1','0'}};

        
        System.out.println(new LT0221_Maximal_Square().Lt0221a(arr));
    }

    
    // 10ms, most are [7, 14]ms.
    // 看代码，全部动态规划。。每个点等于上，左，左上3个点的最小值+1.
    // 也有用一个一维数组来动态规划的。
    private int Lt0221a(char[][] matrix)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int ans = 0;
        int t1 = 0;
        boolean has1 = false;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == '1')
                {
                    if (!has1)
                        has1 = true;
                    t1 = this.functiona1(matrix, i, j, ans);
                    ans = Math.max(ans, t1);
                }
        
        return has1 ? (ans + 1) * (ans + 1) : 0;
    }
    
    private int functiona1(char[][] arr, int i, int j, int len)
    {
        if (!isAll1(arr, i, j, len))
            return 0;
        
        while (isAll1_2(arr, i, j, len + 1))
        {
            len++;
        }
        return len;
    }
    
    private boolean isAll1_2(char[][] arr, int i, int j, int step)
    {
        if (i + step >= arr.length)
            return false;
        if (j + step >= arr[0].length)
            return false;
        for (int m = i; m <= i + step; m++)
            if (arr[m][j + step] != '1')
                return false;
        for (int n = j; n < j + step; n++)
            if (arr[i + step][n] != '1')
                return false;
        return true;
    }
    
    private boolean isAll1(char[][] arr, int i, int j, int step)
    {
        if (i + step >= arr.length)
            return false;
        if (j + step >= arr[0].length)
            return false;
        for (int ii = i; ii <= i + step; ii++)
            for (int jj = j; jj <= j + step; jj++)
                if (arr[ii][jj] != '1')
                    return false;
        return true;
    }
}
