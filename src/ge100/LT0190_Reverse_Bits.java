package ge100;

public class LT0190_Reverse_Bits
{

    public static void main(String[] args)
    {
        int n = 4;
        n = -2;
//        n = -100;
        n = -1;
//        n = 1431655765;
        LT0190_Reverse_Bits lt = new LT0190_Reverse_Bits();
        System.out.println(lt.Lt0190d(n));
    }

    
    @Deprecated
    private int Lt0190d(int n)
    {
//        System.out.println(Integer.toBinaryString(n));
//        System.out.println(new StringBuilder(Integer.toBinaryString(n)).reverse().toString());
        
//        if (Math.abs(n) == 1)
//            return n;
        
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        while (sb.length() < 32)
        {
            sb.append("0");
        }
        if (sb.charAt(0) == '1')
        {
            sb.replace(0, 1, "-");
        }
        
//        System.out.println(sb.toString());
        
        return Integer.valueOf(sb.toString(), 2);
    }
    
    // 2ms.
    private int Lt0190c(int n)
    {
//        System.out.println(Integer.toBinaryString(n));
        
        int t = 1;
        long bit = 0;
        int result = 0;
        for (int i = 0; i < 32; i++)
        {
            bit = n & t;
            if (bit != 0)
                result += 1;
            if (i != 31)
                result <<= 1;
            t <<= 1;
            
//            System.out.println(bit + ", " + result);
        }
        
//        System.out.println(Integer.toBinaryString(result));
        
        return result;
    }
    
    
    // -1 error
    @Deprecated
    private int Lt0190b(int n)
    {
        int result = 0;
        int bit = 0;
        int lastBit = n < 0 ? 1 : 0;
        for (int i = 0; i < 31; i++)
        {
            bit = n % 2;
            n >>= 1;
            result += bit;
            result <<= 1;
        }
        result += lastBit;
        return result;
    }
    
    // 1ms....most are [1, 2]ms
    private int Lt0190a(int n)
    {
        return Integer.reverse(n);
    }
}
