package ge200;

import java.util.Random;

public class LT0278_First_Bad_Version
{
    
    public static void main(String[] args)
    {
//        int n = 5;
        int n = 2126753390;

        System.out.println(new LT0278_First_Bad_Version().Lt0278a(n));
    }

    boolean isBadVersion(int version)
    {
//        return (new Random().nextInt() > new Random().nextInt());
        return version >= 1702766719;
    }
    
    
    // 就是二分啊。。
    
    // 12ms, most are [12, 15]ms.
    /*  12ms:
    while(lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if(isBadVersion(mid)) hi = mid;
        else lo = mid + 1;
    }
    */
    // hilo.
    
    private int Lt0278a(int n)
    {
        return recursiona1(1, n);
    }
    
    private int recursiona1(int s, int e)
    {
        if (s == e)
            return s;
//        int m = (s + e) / 2;            // int m = s + (e - s) / 2;     后者不会因为s+e而溢出。
        int m = s + (e - s) / 2;        // 还真发生了。。。
        if (this.isBadVersion(m))
        {
            return recursiona1(s, m);
        }
        else
        {
            return recursiona1(m + 1, e);
        }
    }
}
