package ge300;

public class LT0304_Range_Sum_Query_2D_Immutable
{

    public static void main(String[] args)
    {
        
    }

}



// 86ms, most are [68, 116]ms.
/*  
dp = new int[m + 1][n + 1];
for(int i = 1; i <= m; i++) {
    for(int j = 1; j <= n; j++) {
        dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
    }
}

// ...

return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
*/
// 保存[0, 0] 与 [i, j] 组成的二维数组的 和。

class Lt0304b
{
    class NumMatrix {

        private int[][] arr2;
        
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return;
            arr2 = new int[matrix.length][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < matrix[0].length; j++)
                {
                    arr2[i][j + 1] = arr2[i][j] + matrix[i][j];
                }
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++)
            {
                sum += (arr2[i][col2 + 1] - arr2[i][col1]);
            }
            return sum;
        }
    }
}


@Deprecated          // 11/12, timeout
class NumMatrix {

    private int[][] arr2;
    
    public NumMatrix(int[][] matrix) {
        this.arr2 = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++)
        {
            for (int j = col1; j <= col2; j++)
            {
                sum += arr2[i][j];
            }
        }
        return sum;
    }
}
