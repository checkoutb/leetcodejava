package ge200;

import java.lang.reflect.Method;

public class LT0233_Number_of_Digit_One
{

    public static void main(String[] args)
    {
        // 1,10,11,12,..19
        int[] arr = {
//                2,
                20, 
                101, 
                999};
        LT0233_Number_of_Digit_One lt = new LT0233_Number_of_Digit_One();
        
        for (int i : arr)
            System.out.println(lt.Lt0233z(i));
    }

    
    private int Lt0233z(int n)
    {
        int ones = 0;
        for(long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            ones += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        } 
        return ones;
    }
    
    // 0ms, 97.5% are 0ms...
    // 开始还以为很简单，结果差点翻车，幸好我一把把把把住了。。
    /* 0ms
    int ones = 0;
    for(long m = 1; m <= n; m *= 10) {
        long a = n / m, b = n % m;
        ones += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
    } 
    return ones;
    */
    // (a + 8) / 10 就是0,1 == 0,其他等于1.
    // 。。。从低位开始，(a + 8) / 10 和 a % 10 == 1， == 我这里的 t2的赋值和判断 和 t1。。。(a + 8) / 10 是当前位和前面的所有位。
    //      (a + 8) / 10 == a / 10 + (a % 10 + 8) / 10..    a/10 就是 t1.
    //                b == 我的t3..... * m == 我的* m....
    private int Lt0233c(int n)
    {
        int t1, t2, t3;
        int ans = 0;
        int m = 1;
        t1 = n / 10;
        while (t1 > 0)
        {
            m *= 10;
            t1 /= 10;
        }
        while (m > 0)
        {
            t1 = (n / m) / 10;
            t3 = (n % m);
            t2 = (n / m) % 10;
//            System.out.println(m + "        " + t1 + ", " + t2 + ", " + t3);
//            ans += (t2 == 0 ? 1 : t2 == 1 ? (t3 + 1) : m) * (t1 + (t2 == 0 ? 0 : 1));
//            ans += (t1 * m + (t2 == 0 ? 0 : 1) * (t3 + 1));
            ans += (t1 * m + (t2 > 1 ? m : t2 == 1 ? (t3 + 1) : 0));
            m /= 10;
        }
        return ans;
    }
    
    @Deprecated
    private int Lt0233b(int n)
    {
        int t1, t2, t3;
        int ans = 0;
        int m = 1;
        t1 = n / 10;
        while (t1 > 0)
        {
            m *= 10;
            t1 /= 10;
        }
        t3 = 1;
        while (m > 0)
        {
            t1 = n % m;
//            System.out.println(t1 + ", " + m);
            t2 = (n / m) % 10;
            ans += (t2 > 1 ? m : t2 == 1 ? (t1 + 1) : 0) * t3;
            t3 = n / m;
            m /= 10;
//            t1 %= m;
        }
        
        return ans;
    }
    
    @Deprecated
    private int Lt0233a(int n)
    {
        int t1, t2, t3;
        int ans = 0;
        int m = 1;
        t3 = 0;
        while (n > 0)
        {
            t1 = n % 10;
            t2 = n / 10;
            if (ans == 0)
                ans += (t1 >= 1 ? 1 : 0) + t2;
            else
                ans += (t1 > 1 ? m : t1 == 1 ? t3 : 0) * t2;
            t3 += ((t1 + 1) * m);
            n = t2;
            m *= 10;
        }
        return ans;
    }
    
}
