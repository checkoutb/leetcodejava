package gt000;


/**
 * 50. Pow(x, n)
 * */
public class LT0050 {

    public static void main(String[] args) {

        double x = 2.1;
        int n = 3;
        
        x = 34.00515;
        n = -3;

        x = 2.00000;
        n = -2147483648;
        
        System.out.println(Lt0050a(x, n));
        
    }

    
    // beats 6.17%
    public static double Lt0050a(double x, int n)
    {
        double result = 1;
        
        if(x == 1)
        {
            return 1;
        }
        if(x == -1)
        {
            if(n % 2 == 1)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        if(x == 0)
        {
            return 0;
        }
        
        if(n > 0)
        {
            int n2 = n;
            int i = 0;
            int len = 0;
            int t = 0;
            
            double t2 = 0;
            
//            if(n < 0)
//            {
//                n2 = -n2;
//            }
            result = x;
            
            t = 2;
            for(len = 0; len < 32; len++)
            {
                if(t < n2)
                {
                    t *= 2;
                }
                else
                {
                    break;
                }
            }
            
//            System.out.println(len);
            
            t2 = result;
            for(i = 0; i < len; i++)
            {
                result *= result;
                if(t2 == result)
                {
                    return result;
                }
                else
                {
                    t2 = result;
                }
            }
            
            len = n2 - (int) Math.pow(2, len);
            
//            System.out.println(len);
            
            t2 = result;
            for(i = 0; i < len; i++)
            {
                result *= x;
                if(t2 == result)
                {
                    return result;
                }
                else
                {
                    t2 = result;
                }
            }
            
//            if(n < 0)
//            {
//                result = 1.0 / result;
//            }
        }
        else if(n == 0)
        {
            return 1;
        }
        else
        {

            int n2 = n;
            int i = 0;
            int len = 0;
            int t = 0;
            
            double t2 = 0;
            
//            if(n < 0)
//            {
//                n2 = -n2;
//            }
            result = 1.0 / x;
            
            t = -2;
            for(len = 0; len < 32; len++)
            {
                if(t > n2)
                {
                    t *= 2;
                }
                else
                {
                    break;
                }
            }
            
//            System.out.println(len);
            
            t2 = result;
            for(i = 0; i < len; i++)
            {
                result *= result;
                if(t2 == result)
                {
                    return result;
                }
                else
                {
                    t2 = result;
                }
            }
            
            len = n2 + (int) Math.pow(2, len);
            len = -len;
//            System.out.println(len + ", " + result);
            
            t2 = result;
            for(i = 0; i < len; i++)
            {
                result /= x;
                if(t2 == result)
                {
                    return result;
                }
                else
                {
                    t2 = result;
                }
            }
            
//            if(n < 0)
//            {
//                result = 1.0 / result;
//            }
        
        }
        
        return result;
    }
    
    
    // time out
    // 0.00001
    // 2147483647
    public static double Lt0050(double x, int n)
    {
        double result = 1;
        if(n == 0)
        {
            return result;
        }
        if(n > 0)
        {
            result = x;
            for(int i = 1; i < n; i++)
            {
                result *= x;
            }
        }
        else
        {
            result = 1.0 / x;
            n = -n;
            for(int i = 1; i < n; i++)
            {
                result /= x;
            }
        }
        return result;
    }
    
}


/*

0.00001
2147483647

*/