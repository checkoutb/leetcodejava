package ge200;

public class LT0231_Power_of_Two
{

    public static void main(String[] args)
    {
        int[] arr = {1,16,218};
        LT0231_Power_of_Two lt = new LT0231_Power_of_Two();
        
        for (int i : arr)
            System.out.println(lt.Lt0231a(i));
    }

    // 这题有负数。。
    // 2ms, most are [1, 2]ms.
    /*  1ms...
    return n>0 && Integer.bitCount(n) == 1;
    */
    // 长知识了。。。bitCount挺厉害的，因为看不懂。
    
    /*  2ms
    if( n==0 )
        return false;
    while( n>1 && n%2==0 )
        n/=2;
    return n==1;
    */
    
    private boolean Lt0231a(int n)
    {
        if (n <= 0)
            return false;
        int t = 0;
        while (n != 0)
        {
            t = n % 2;
            n >>= 1;
            if (t == 1)
                return n == 0;
        }
        return false;
    }
}
