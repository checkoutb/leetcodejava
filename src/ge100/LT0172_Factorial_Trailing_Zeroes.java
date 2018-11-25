package ge100;

import java.math.BigDecimal;

public class LT0172_Factorial_Trailing_Zeroes
{

    public static void main(String[] args)
    {
        LT0172_Factorial_Trailing_Zeroes lt = new LT0172_Factorial_Trailing_Zeroes();
        
        System.out.println(lt.factorial(30));
        // 2.5
        // 10
        // 4.15
        // 20
        // 6.25
        // 30
        // 25 * 4 == 10000000000000000000000000
        // 25 = 5 * 5................
        // 75 = 5.5.3
        // 125 = 5.5.5
        // 625 = 5.5.5.5
    }

    
    private BigDecimal factorial(int n)
    {
        if (n == 0)
            return BigDecimal.ONE;
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= n; i++)
        {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
    
    
    // 17ms, most are [16, 25]ms.
    // 直接n/5直到n为0.不需要five。
    private int Lt0172a(int n)
    {
        int result = 0;
        long five = 1;
        while (five <= n)
        {
            five *= 5;
        }
        five /= 5;
        
        while (five > 1)
        {
            result += n / five;         // 625肯定能再被125,25,5整除，所以只要这样的循环就可以了。。75不是five，但会被25,5整除。
            five /= 5;
        }
        
        return result;
    }
}
