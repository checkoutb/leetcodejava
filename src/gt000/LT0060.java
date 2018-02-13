package gt000;

import java.util.Arrays;

/**
 * 60. Permutation Sequence
 * */
public class LT0060 {

    public static void main(String[] args) {
        
        int n = 3;
        int k = 2;
        k = 1;
        k = 4;
        System.out.println(Lt0060a(n, k));
        
        
//        int f = 1;
//        for(int i = 1; i < 11; i++)
//        {
//            f = f * i;
//            System.out.println(f);
//        }
        
    }

    // beats 53%
    public static String Lt0060a(int n, int k)
    {
        String result = null;
        
        boolean[] used = new boolean[n + 2];
        
        int[] factorial = {1,1,2,6,24,120,720,5040,40320,362880};
        int t = 0;
        int i = 0;
        int index = 0;
        int j = 0;
        int t2 = 0;
        int m = n - 1;
        k--;                // why?...
        for(i = 0; i < n; i++)
        {
            t = k / factorial[m];
            k %= factorial[m];
            m--;
            
            index = 1;
            for(j = 0; j <= t;)
            {
                if(!used[index++])
                {
                    j++;
                }
            }
            index--;
            t2 *= 10;
            t2 += index;
            used[index] = true;
        }
        
        
        
        
        
        result = Integer.toString(t2);
        return result;
    }
    
    // failed
    public static String Lt0060(int n, int k)
    {
        String result = null;
        
        boolean[] used = new boolean[n + 2];
        
        int m = 1;
        int t = 2;
        int i = 0;
        int j = 0;
        int t1 = 0;
        boolean tb = false;
        int t2 = 0;
        
        while(m < k)            // ... !!
        {
            t = m + 1;
            m *= t;
        }
        
        m /= t;
        m++;
        t = 0;
        for(i = 0; i < n; i++)
        {
            t = k / m;
            k %= m;
            
            tb = used[1];
            for(j = 1, t1 = 1;j <= t;)
            {
                if(!tb)
                {
                    j++;
                    tb = used[++t1];
                    continue;
                }
                else
                {
                    tb = used[++t1];
                    continue;
                }
            }
            t1--;
            
            
            
            t2 += t1;
            used[t1] = true;
            t2 *= 10;
            
        }
        
        t2 /= 10;
        result = Integer.toString(t2);
        return result;
    }
}
