package gt000;

import java.util.HashSet;
import java.util.Set;

import utils.LTUtils;

/**
 * 73. Set Matrix Zeroes
 * */
public class LT0073 {

    public static void main(String[] args) {
        
        int[][] matrix = {{1,0},{2,3}};
        
        Lt0073a(matrix);
        
        LTUtils.showArrayOfArrayOneRowOneLine(matrix);
    }
    
    
    // 1ms, beats 79.1%
    public static void Lt0073a(int[][] matrix)
    {
        int i = 0;
        int j = 0;
        int lenI = matrix.length;
        int lenJ = matrix[0].length;
        
//        Set<Integer> zeroRow = new HashSet<>();
//        Set<Integer> zeroCol = new HashSet<>();
        
//        int[] zeroRow = new int[lenI];
//        int[] zeroCol = new int[lenJ];
        
        boolean[] zeroRow = new boolean[lenI];
        boolean[] zeroCol = new boolean[lenJ];
        
        
        for(i = 0; i < lenI; i++)
        {
            for(j = 0; j < lenJ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        
        for(i = 0; i < lenI; i++)
        {
            if(zeroRow[i])
            {
                for(j = 0; j < lenJ; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(j = 0; j < lenJ; j++)
        {
            if(zeroCol[j])
            {
                for(i = 0; i < lenI; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    
    }

    // 5ms, beats 6.3%
    public static void Lt0073(int[][] matrix)
    {
        int i = 0;
        int j = 0;
        int lenI = matrix.length;
        int lenJ = matrix[0].length;
        
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();
        
        for(i = 0; i < lenI; i++)
        {
            for(j = 0; j < lenJ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        
        for(Integer i2 : zeroRow)
        {
            for(j = 0; j < lenJ; j++)
            {
                matrix[i2][j] = 0;
            }
        }
        
        for(Integer j2 : zeroCol)
        {
            for(i = 0; i < lenI; i++)
            {
                matrix[i][j2] = 0;
            }
        }
        
    }
}
