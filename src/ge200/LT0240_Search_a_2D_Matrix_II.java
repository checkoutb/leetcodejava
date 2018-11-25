package ge200;

public class LT0240_Search_a_2D_Matrix_II
{

    public static void main(String[] args)
    {
//        int[][] arr2 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int t = 5;
        
        int[][] arr2 = { { 1, 4 }, { 2, 5 } };
        int t = 2;

        System.out.println(new LT0240_Search_a_2D_Matrix_II().Lt0240a(arr2, t));
    }

    
    // 14ms...most are [6, 12]ms..
    /* 6ms
    while (row < m && col >= 0) {
        if (target == matrix[row][col]) return true;
        else if (target > matrix[row][col]) row++;
        else col--;
    }
    */
    /* 7ms...
    for(int i=0;i<m;i++)
        if(Arrays.binarySearch(matrix[i],target)>=0)
            return true;
    */
    private boolean Lt0240a(int[][] matrix, int target)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        if (matrix[0][0] > target)
            return false;
        int x1, y1, x2, y2;
        x1 = 1; y1 = 1; x2 = -1; y2 = -1;
        int rowMax = matrix.length - 1;
        int colMax = matrix[0].length - 1;
        if (matrix[rowMax][colMax] < target)
            return false;
        boolean has1st = false;
        for (int i = 0; i <= colMax; i++)
        {
            if (matrix[0][i] <= target && matrix[rowMax][i] >= target)
            {
                if (!has1st)
                {
                    y1 = i;
                    has1st = true;
                }
                y2 = i;
                continue;
            }
            if (matrix[0][i] > target)
                break;
        }
        
        has1st = false;
        for (int i = 0; i <= rowMax; i++)
        {
            if (matrix[i][0] <= target && matrix[i][colMax] >= target)
            {
                if (!has1st)
                {
                    x1 = i;
                    has1st = true;
                }
                x2 = i;
                continue;
            }
            if (matrix[i][0] > target)
                break;
        }
        
        for (int i = x1; i <= x2; i++)
        {
            for (int j = y1; j <= y2; j++)
            {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target)
                    break;
            }
        }
        
        return false;
    }
    
}
