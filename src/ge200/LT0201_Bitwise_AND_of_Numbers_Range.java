package ge200;

public class LT0201_Bitwise_AND_of_Numbers_Range
{

    public static void main(String[] args)
    {
//        System.out.println("" + (1 << 30) + "\n" + Integer.MAX_VALUE);
        
//        System.out.println(1 & 2);
        
        int[][] arr2 = {
//                {0,1},{5,7},
//                {1,1},
//                {3,3}
//                {6,7}
//                {1,2}
//                {5,8},
//                {5,7},
//                { 4, 7 }, 
                { 20000, 2147483647 }
        };
        
        LT0201_Bitwise_AND_of_Numbers_Range lt = new LT0201_Bitwise_AND_of_Numbers_Range();
        
        for (int[] arr : arr2)
        {
            System.out.println(lt.Lt0201c(arr[0], arr[1]));
        }
    }
    
    
    
    // 6ms, most are [5, 10]ms
    // 虽然写出来了，但基本是错一个改一个。。这次提交了10次，才通过的。。
    // 而且不清楚为什么可以。。
    
    /* 5ms的其他人的代码
    int i = 0;
    while (m != n) {
        m >>= 1;
        n >>= 1;
        i++;
    }
    return m << i;
    */
    // 看来含义是，[m, n]相同的位必然集中在前面，所以前面相同的部分就是结果。
    
    // 看了别人的代码以后，觉得我这个代码大约是：找出m，n的最大差距的位数，然后m+00001,m+00010,m+00100,这种就是在剔除吧。不知道。。。
    // 觉得m+00001没有什么意义啊，这个只是将最后几位设置为0.。因为m & m+00001，的最后一位必然是0,，m & m+00010 的最后第二位必然是0.。。
    // 所以可以max = Integer.Max_Value， 然后开始 <<, 然后直接return m&max。。，主要还是[m, n]的相同位必然集中在前面。
    private int Lt0201c(int m, int n)
    {
        if (m == 0 || m == n)
            return m;
        int result = m & (m + 1);
        long bit = 1;
        int diff = n - m;
        long max = 1;
        while (max <= diff)
            max <<= 1;      // maybe， max > Integer.Max_Value
        while (bit < max)
        {
            result &= (m + bit);
            bit <<= 1;
        }
        result &= n;
        return result;
    }
    
    @Deprecated
    private int Lt0201b(int m, int n)
    {
        if (m == 0)
            return 0;
        if (m == n)
            return m;
        
        int mBit = 1;
        int nBit = 1;
        while (mBit < m)
            mBit <<= 1;
        while (nBit < m)
            nBit <<= 1;
        
        if (mBit != nBit)
            return 0;
        
        int result = 0;
        mBit >>= 1;
        while (mBit > 0)
        {
            if ((m & mBit) == (n & mBit))
                result += mBit;
            mBit >>= 1;
        }
        
        return result;
    }
    
    @Deprecated
    private int Lt0201a(int m, int n)
    {
        
        int result = 0;
        if (m == 0)
            return result;
        if (m == n)
            return n;
        int minBit = 1;
        int maxBit = 1 << 30;
        int diff = n - m;
        while (minBit <= diff)
        {
            minBit <<= 1;
        }
        minBit >>= 1;
        while (maxBit > n)
        {
            maxBit >>= 1;
        }
//        maxBit <<= 1;
        
        int bit = maxBit;
        while (bit >= minBit)
        {
            if (m < bit)
                return result;
            else
                result += bit;
            bit >>= 1;
        }
        return result;
    }
}
