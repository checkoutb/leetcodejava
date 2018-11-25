package ge100;

public class LT0191_Number_of_1_Bits
{

    public static void main(String[] args)
    {
        int n = 11;
        System.out.println(new LT0191_Number_of_1_Bits().Lt0191a(n));
    }

    // 1ms, most are [1, 1]ms
    private int Lt0191a(int n)
    {
        int result = 0;
        int bit = 0;
        int t = 1;
        for (int i = 0; i < 32; i++)
        {
            bit = n & t;
            if (bit != 0)
                result++;
            t <<= 1;
        }
        return result;
    }
}
