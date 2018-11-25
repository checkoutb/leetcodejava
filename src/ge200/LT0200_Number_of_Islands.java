package ge200;

public class LT0200_Number_of_Islands
{

    public static void main(String[] args)
    {
        char[][][] arr3 = { { 
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' }, 
            { '1', '1', '0', '0', '0' }, 
            { '0', '0', '0', '0', '0' } }, 
                {
                { '1', '1', '0', '0', '0' }, 
                { '1', '1', '0', '0', '0' }, 
                { '0', '0', '1', '0', '0' }, 
                { '0', '0', '0', '1', '1' } } };
        
        LT0200_Number_of_Islands lt = new LT0200_Number_of_Islands();
        for (char[][] arr : arr3)
        {
            System.out.println(lt.Lt0200a(arr));
        }
    }

    
    // 4ms, most are [3, 8]ms.
    private int Lt0200a(char[][] grid)
    {
        
        int result = 0;
        
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return result;
        
        result = filla1(grid);
        
        return result;
    }
    
    private int filla1(char[][] grid)
    {
        int result = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        for (int i = 0; i < rowSize; i++)
            for (int j = 0; j < colSize; j++)
            {
                if (grid[i][j] == '1')
                {
                    result++;
                    filla3(grid, i, j);
                }
            }
        
        return result;
    }
    
    private void filla3(char[][] grid, int i, int j)
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] != '1')
            return;
        grid[i][j] = 'Z';
        
        filla3(grid, i + 1, j);
        filla3(grid, i - 1, j);
        filla3(grid, i, j + 1);
        filla3(grid, i, j - 1);
    }
    
    @Deprecated
    private void filla2(char[][] grid, int i, int j)
    {
        int m = 0;
        int n = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        
        for (m = i; m < rowSize; m++)
        {
            for (n = j; n < colSize; n++)
            {
                
            }
            for (n = j - 1; n >= 0; n--)
            {
                
            }
        }
        
        for (m = i - 1; m >= 0; m--)
        {
            for (n = j; n < colSize; n++)
            {
                
            }
            for (n = j - 1; n >= 0; n--)
            {
                
            }
        }
    }
}
