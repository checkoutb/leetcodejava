package gt000;


/**
 * 74. Search a 2D Matrix
 * */
public class LT0074 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
//        matrix = new int[][]{{1}};
        int target = 11;
//        matrix = new int[][] { { 1, 3 } };
//        target = 3;
        
        System.out.println(Lt0074(matrix, target));
    }

    
    
    // 11ms, beats 32.5%
    public static boolean Lt0074a(int[][] matrix, int target)
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        
        int i = 0;
        int j = 0;
        int lenI = matrix.length;
        int lenJ = matrix[0].length;
        
        for(i = 0; i < lenI; i++)
        {
            if(matrix[i][0] > target)
            {
                break;
            }
        }
        i--;
        
        if(i < 0)
        {
            return false;
        }
        
        for(j = 0; j < lenJ; j++)
        {
            if(matrix[i][j] > target)
            {
                break;
            }
        }
        j--;
        
        if(j < 0)
        {
            return false;
        }
        
        
        return matrix[i][j] == target;
    }
    
    
    // failed...
    public static boolean Lt0074(int[][] matrix, int target)
    {
        boolean result = false;
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return result;
        }
        
        int i = 0;
        int j = 0;
        int lenI = matrix.length;
        int lenJ = matrix[0].length;
        
        int i2 = lenI - 1;
        int j2 = lenJ - 1;
        int t = 0;
        
        while(i < i2)
        {
            t = (i + i2) / 2;
            if(matrix[t][0] >= target)
            {
                if(matrix[t][0] == target)
                {
                    return true;
                }
                i2 = t - 1;
            }
            else
            {
                i = t + 1;
            }
        }
        
        if(i >= lenI)
        {
            if(matrix[i - 1][lenJ - 1] < target)
                return false;
            else
                i--;
        }

        while(j < j2)
        {
            t = (j + j2) / 2;
            if(matrix[i][t] >= target)
            {
                if(matrix[i][t] == target)
                {
                    return true;
                }
                j2 = t - 1;
            }
            else
            {
                j = t + 1;
            }
        }
        
        
        if(j >= lenJ)
        {
            return false;
        }
//        System.out.println(i + ", " + j);
        
        if(matrix[i][j] == target)
        {
            result = true;
        }
        
        return result;
    }
    
}
