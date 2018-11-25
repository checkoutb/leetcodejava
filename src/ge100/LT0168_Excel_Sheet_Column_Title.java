package ge100;

public class LT0168_Excel_Sheet_Column_Title
{

    public static void main (String[] args)
    {
        int[] arr = { 
//                1, 
//                28, 701, 
                26, 
                27,
                18278,
                1000000001 };
        // A,AB,ZY,Z
        
//        arr = new int[] { 26 };
//        arr = new int[] { 1000000001 };
        LT0168_Excel_Sheet_Column_Title lt = new LT0168_Excel_Sheet_Column_Title();
        for (int n : arr)
        {
            System.out.println(lt.Lt0168d(n));
        }
    }
    
    
    // ...........................
    
    
    // 0-25  1-26
    // 0%26  26%26
    private String Lt0168e(int n)
    {
        String result = "";
        
        long t2 = 1;
        long t1 = 26;
        long n2 = n;
        long t3 = 0;
        while (n > 0)
        {
            
        }
        
        return result;
    }
    
//    private String converte1(long n, long t)
//    {
//        long t2 = n / t;
//        
//    }
    
    @Deprecated
    private String Lt0168d(int n)
    {
        String result = "";
        
        int t = 26;
        
        do
        {
            result = this.convertd1(n % t) + result;
            
        } while (n > 0);
        
        return result;
    }
    
    private char convertd1(long t)
    {
        if (t == 0)
        {
            return 'Z';
        }
        else
        {
            return (char) (t + 64);
        }
    }
    
    @Deprecated
    private String Lt0168c(int n)
    {
        String result = "";
        
        long n2 = n;
        long t1 = 1L;
        long t2 = 26L;
        
        while (n2 / t2 > 0)
        {
            t1 = t2;
            t2 *= 26;
        }
        
        while (n2 > 0)
        {
            if (n2 / t2 != 0)
            {
                result += this.converta1(n2 / t2);
                n2 %= t2;
            }
            t2 = t1;
            t1 /= 26;
        }
        
        
        return result;
    }
    
    // 1, 26, 702, 18278
    @Deprecated
    private String Lt0168b(int n)
    {
        String result = "";
        
        long t = 1L;
        long t2 = 1L;
        boolean flag1 = true;
        while (n / t > 1 || ((n / t == 1) && (n % t != 0)))
        {
            t2 *= 26;
            if (flag1)
            {
                t = t2;
                flag1 = false;
            }
            else
            {
                t += t2;
            }
            
//            t2 = t;
//            t = (t * 26);
//            if (flag1)
//            {
//                t *= 26;
//                flag1 = false;
//            }
//            else
//            {
//                t *= 27;
//            }
        }
        if (t > 26)
        {
            t -= t2;
            t2 /= 26;
        }
        else
        {
            t = 1;
            t2 = 1;
        }
        
        while (t2 > 0)
        {
            result += this.converta1(n / (t2 + 1));
            n = (int) (n - (n / (t2+1) * t2));
//            t /= 26;
            t -= t2;
            t2 /= 26;
        }
        
        return result;
    }
    
    @Deprecated
    private String Lt0168a(int n)
    {
        String result = "";
        long t = 1;
        while (n / t > 0)
        {
            t = t * 26 + (t == 1 ? 1 : t);
        }
        t = t == 27 ? t / 27 : t / 27;
        
        while (n > 0)
        {
            result += this.converta1(n / t);
            n %= t;
            t /= 26;
        }
        
        return result;
    }
    
    private char converta1(long a)
    {
        return (char) (a + 64);
    }
}
