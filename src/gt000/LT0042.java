package gt000;

import java.util.Arrays;

/**
 * 42. Trapping Rain Water
 * */
public class LT0042 {

    public static void main(String[] args) {
        
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        int result = Lt0042c(height);
        System.out.println(result);
        
    }
    
    
    // endless loop, i should ues while, not for.
    @Deprecated
    public static int Lt0042c(int[] height)
    {
        int result = 0;
        int i = 0;
        int j = 0;
        int t = 0;
        int ti = 0;
        int len = height.length;
        int m = 0;
        
        if(len == 0)
        {
            return 0;
        }
        
        int k = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int max = height[0];
        int maxIndex = 0;
        
        for(i = 0; i < len; i++)
        {
            if(height[i] > max)
            {
                max = height[i];
                maxIndex = i;
            }
        }
        
//        t = max;
        t = 0;
        m = maxIndex + 1;
        for(i = maxIndex + 1; i < len; i++)
        {
            t = 0;
            ti = 0;
            for(j = i; j < len; j++)
            {
                if(height[i] > t)
                {
                    t = height[i];
                    ti = i;
                }
            }
            for(j = m; j <= ti; j++)
            {
                if(t - height[j] > 0)
                {
                    result += (t - height[j]);
                }
            }
            m = ti + 1;
            i = ti;
        }
        
        m = maxIndex - 1;
        for(i = maxIndex - 1; i >= 0; i--)
        {
            
            t = 0;
            ti = len;
            
            for(j = i; i >= 0; j--)
            {
                if(height[i] > t)
                {
                    t = height[i];
                    ti = i;
                }
            }
            for(j = m; j >= ti; j--)
            {
                if(t - height[j] > 0)
                {
                    result += (t - height[j]);
                }
            }
            m = ti - 1;
            i = ti;
            
        }
        
        
        
        return result;
    }
    
    
    // beats 1.73% ...
    public static int Lt0042b(int[] height)
    {
        int result = 0;
        int i = 0;
        int j = 0;
        int t = 0;
        int len = height.length;
        int k = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int[] high = new int[len];
        
        for(i = 0; i < len; i++)
        {
            maxLeft = 0;
            maxRight = 0;
            for(j = i + 1; j < len; j++)
            {
                if(height[j] > maxRight)
                {
                    maxRight = height[j];
                }
            }
            for(j = i - 1; j >= 0; j--)
            {
                if(height[j] > maxLeft)
                {
                    maxLeft = height[j];
                }
            }
            
            // lower
            maxLeft = maxLeft > maxRight ? maxRight : maxLeft;
            
            t = maxLeft - height[i];            
            if(t > 0)
            {
                high[i] = t;
            }
        }
        
        System.out.println(Arrays.toString(high));
        
        for(i = 0; i < len; i++)
        {
            result += high[i];
        }
        
        
        return result;
    }
    
    
    @Deprecated
    public static int Lt0042a(int[] height)
    {
        int result = 0;
        int i = 0;
        int j = 0;
        int t = 0;
        int len = height.length;
        int max = 0;
        int indexOfMax = 0;
        
//        for(i = 0; i < len; i++)
//        {
//            if(height[i] > max)
//            {
//                max = height[i];
//                indexOfMax = i;
//            }
//        }
        
        for(i = 0; i < len;)
        {
            if(height[i] >= 0)
            {
                t = height[i];
                for(j = i + 1; j < len; j++)
                {
                    if(height[j] >= t)
                    {
                        
                    }
                }
//                for()
            }
            else
            {
                i++;
            }
        }
        
        
        return result;
    }
    
    @Deprecated
    public static int Lt0042(int[] height)
    {
        int result = 0;
        
        int i = 0;
        int j = 0;
        int len = height.length;
        int max = 0;
        int max2 = 0;
        int left = 0;
        int right = 0;
        int t = 0;
        int t1 = 0;
        int t2 = 0;
        int[][] map = null;
        
        for(i = 0; i < len; i += 2)
        {
            if(height[i] > max)
            {
                max2 = max;
                max = height[i];
                t2 = t1;
                t1 = j;
            }
        }
        
        for(i = 1; i < len; i += 2)
        {
            if(height[i] > max)
            {
                max2 = max;
                max = height[i];
                t2 = t1;
                t1 = j;
            }
        }
        
        for(i = 0; i < len; i++)
        {
            if(height[i] >= 0)
            {
                left = i;
                break;
            }
        }
        
        for(i = len - 1; i >= 0; i--)
        {
            if(height[i] >= 0)
            {
                right = i;
                break;
            }
        }
        
        map = new int[right - left + 1][max2];
        
//        for(i = left; i <= right; i++)
//        {
//            t = height[i];
//            for(j = i; j <= right; j++)
//            {
//                if(t )
//            }
//        }
        
        
        
        
        
        return result;
    }
    
}

/*


Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 

*/