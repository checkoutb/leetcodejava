package gt000;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * */
public class LT0054 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        
        matrix = new int[][]{{2, 3}};           //...
        
        System.out.println(Lt0054(matrix));
        
    }

    // 2,3,4ms..
    public static List<Integer> Lt0054(int[][] matrix)
    {
        int rowLen = matrix.length;
        if(rowLen == 0)
        {
            return new ArrayList<>();
        }
        int colLen = matrix[0].length;
        
        int count = rowLen * colLen;
        
        List<Integer> result = new ArrayList<>(count);
        
        int rowMin = 0;
        int rowMax = rowLen - 1;
        int colMin = 0;
        int colMax = colLen - 1;
        
        int i = 0;
//        int j = 0;
        
//        int row = 0;
//        int col = 0;
        
        while(true)
        {
            for(i = colMin; i <= colMax; i++)
            {
                result.add(matrix[rowMin][i]);
            }
            rowMin++;
            
            if(result.size() == count)
            {
                break;
            }
            
            for(i = rowMin; i <= rowMax; i++)
            {
                result.add(matrix[i][colMax]);
            }
            colMax--;
            
            if(result.size() == count)
            {
                break;
            }
            
            for(i = colMax; i >= colMin; i--)
            {
                result.add(matrix[rowMax][i]);
            }
            rowMax--;
            
            if(result.size() == count)
            {
                break;
            }
            
            for(i = rowMax; i >= rowMin; i--)
            {
                result.add(matrix[i][colMin]);
            }
            colMin++;
            
            if(result.size() == count)
            {
                break;
            }
            
        }
        
        
        return result;
    }
    
}
