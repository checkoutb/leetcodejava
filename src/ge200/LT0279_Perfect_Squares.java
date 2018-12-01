package ge200;

public class LT0279_Perfect_Squares
{

    public static void main(String[] args)
    {
//        System.out.println(Math.pow(16, 0.5));
//        System.out.println(Math.pow(15, 0.5));
//        System.out.println((int) Math.pow(15, 0.5));
//        System.out.println(Math.pow(Integer.MAX_VALUE, 0.5));
//        System.out.println((int) Math.pow(Integer.MAX_VALUE, 0.5));
        
        int[] arr = {
                0, 4, 
                12, 13, 
                7168,
                48};
        LT0279_Perfect_Squares lt = new LT0279_Perfect_Squares();
        
        for (int n : arr)
        {
            System.out.println(lt.Lt0279c(n));
        }
        
    }

    
    
    
    
    
    
    
    
    
    private int Lt0279d(int n)
    {
        int ans = 0;
        
        
        return ans;
    }
    
    
    @Deprecated     // error
    private int Lt0279c(int n)
    {
        
        int ans = 0;
        int t = n;
        int p = 0;
        while (t > 0)
        {
            p = (int) Math.pow((int) Math.pow(t, 0.5), 2);
            t -= p;
            ans++;
        }
        ans += (n == 0 ? 1 : 0);
        ans = this.recursionc1(n, ans, 0, (int) Math.pow(n, 0.5));
        return ans + (n == 0 ? 1 : 0);
    }
    
    private int recursionc1(int n, int lim, int count, int pLim)
    {
        if (count >= lim)
            return lim;
        if (n == 0)
            return count;
        int p = (int) Math.pow(n, 0.5);

        int t = lim;
        int t1 = 0;
        if ((n % (int) Math.pow(p, 2)) == 0)
        {
            return (count + n / (int) Math.pow(p, 2)) > lim ? lim : (count + n / (int) Math.pow(p, 2));
        }
        if (pLim <= p)
            return lim;
        for (; p > 0; p--)
        {
            if ((n / (int) Math.pow(p, 2)) + count > lim)
                break;
            if ((t1 = this.recursionc1((int) (n - Math.pow(p, 2)), lim, count + 1, pLim)) < t)
            {
                t = t1;
            }
        }
        return t;
        
    }
    
//    private int Lt0279b(int n)
//    {
//        int ans = 0;
//        while (true)
//        {
//            int t2 = 0;
//            int t = n;
//            int p = 0;
//            while (t > 0)
//            {
//                p = (int) Math.pow((int) Math.pow(t, 0.5), 2);
//                t -= p;
//                t2++;
//            }
//            if (t2 <= ans || ans == 0)
//            {
//                ans = t2;
//            }
//        }
//        return ans + (n == 0 ? 1 : 0);
//    }
    
    
    @Deprecated   // 12: 9,1,1,1。。。总不能穷举吧。。
    private int Lt0279a(int n)
    {
        int ans = 0;
        int t = n;
        int p = 0;
        while (t > 0)
        {
            p = (int) Math.pow((int) Math.pow(t, 0.5), 2);
            t -= p;
            ans++;
        }
        
        return ans + (n == 0 ? 1 : 0);
    }
    
}
