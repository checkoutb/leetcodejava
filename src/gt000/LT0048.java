package gt000;

import utils.LTUtils;

/**
 * 48. Rotate Image
 * */
public class LT0048 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, 
                            { 4, 5, 6 }, 
                            { 7, 8, 9 } };
        matrix = new int[][] { { 5, 1, 9, 11 }, 
                                { 2, 4, 8, 10 }, 
                                { 13, 3, 6, 7 }, 
                                { 15, 14, 12, 16 } };
        
        rotate(matrix);
        
        LTUtils.showArrayOfArray(matrix);
    }

    // 2ms
    public static void rotate(int[][] matrix)
    {
        int len = matrix[0].length;
        int i = 0;
        int j = 0;
        int len2 = 0;
        int len3 = len / 2;
        int len1 = len - 1;
        int t = 0;
        int t1 = 0;
        int t2 = 0;
        
        for(i = 0; i < len3; i++)
        {
            len2 = len1 - i;
            t1 = len1 - i;
            for(j = i; j < len2; j++)
            {
                t2 = len1 - j;
//                t = matrix[t1][j];
//                matrix[t1][j] = matrix[t1][t2];
//                matrix[t1][t2] = matrix[i][t2];
//                matrix[i][t2] = matrix[i][j];
//                matrix[i][j] = t;
                
                t = matrix[t2][i];
                matrix[t2][i] = matrix[t1][t2];
                matrix[t1][t2] = matrix[j][t1];
                matrix[j][t1] = matrix[i][j];
                matrix[i][j] = t;
                
                
//                System.out.println(t1 + ", " + j);
//                System.out.println(t1 + ", " + t2);
//                System.out.println(i + ", " + t2);
//                System.out.println(i + ", " + j);
            }
        }
    }
    
}


/*

rotate the image in-place

对角三角,不，只要遍历1/4

len = matrix.length - 1;
[i,j],[j,len-i],[len-i,len-j],[len-j,i]

len = 2
0,1 1,2 2,1 1,0
0,0 0,2 2,2 2,0

4x4,len=4 - 1;
[1,1],[1,2],[2,2],[2,1]






*/