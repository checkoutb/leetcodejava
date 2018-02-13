package gt000;

import utils.LTUtils;

/**
 * 59. Spiral Matrix II
 * */
public class LT0059 {

    public static void main(String[] args) {
        
        int n = 3;
        n = 1;
        n = 5;
        n = 0;
        
        LTUtils.showArrayOfArrayOneRowOneLine(Lt0059(n));
        
    }

    // 2,3ms 
    public static int[][] Lt0059(int n)
    {
        int[][] result = new int[n][n];
        
        int direct = 0;
        int len = n * n;
        int i = 0;
        int j = 0;
        int count = 1;
        while(count <= len)
        {
            switch(direct)
            {
            case 0:
                if((j) < n && result[i][j] == 0)
                {
                    result[i][j] = count;
                    count++;
                    j++;
                }
                else
                {
                    i++;
                    j--;
                    direct = 1;
                }
                break;
            case 1:
                if(i < n && result[i][j] == 0)
                {
                    result[i][j] = count;
                    count++;
                    i++;
                }
                else
                {
                    i--;
                    j--;
                    direct = 2;
                }
                break;
            case 2:
                if(j >= 0 && result[i][j] == 0)
                {
                    result[i][j] = count;
                    count++;
                    j--;
                }
                else
                {
                    j++;
                    i--;
                    direct = 3;
                }
                break;
            case 3:
                if(i >= 0 && result[i][j] == 0)
                {
                    result[i][j] = count;
                    count++;
                    i--;
                }
                else
                {
                    j++;
                    i++;
                    direct = 0;
                }
                break;
            }
//            count++;
        }
        
        
        return result;
    }
}
