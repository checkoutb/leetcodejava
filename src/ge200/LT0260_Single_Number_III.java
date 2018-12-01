package ge200;

public class LT0260_Single_Number_III
{

    public static void main(String[] args)
    {
        
    }

    
    // ...不会。。只会用Map或set遍历。
    
    /* 抄的discuss的
    // Pass 1 : 
    // Get the XOR of the two numbers we need to find
    int diff = 0;
    for (int num : nums) {
        diff ^= num;
    }
    // Get its last set bit
    diff &= -diff;
    
    // Pass 2 :
    int[] rets = {0, 0}; // this array stores the two numbers we will return
    for (int num : nums)
    {
        if ((num & diff) == 0) // the bit is not set
        {
            rets[0] ^= num;
        }
        else // the bit is set
        {
            rets[1] ^= num;
        }
    }
    return rets;
    */
    // 还是不清楚。
    // diff是两个结果的异或。
    // 001001  000010       2个数
    // 001011  110101  000001        diff  -diff  diff&(-diff)
    // 确实分开了。。。
    
    // 001100  001010
    // 000110  111010  000010
    
    // 思想似乎是：2个只有1次的数，必然不相同，找到最低的不相同的位，用这个位来划分为两组。
    //          异或diff的最低位就是2个数最低的不相同的位。
    //          实际上应该只要用任一一个为1的diff的位，划分成2组就可以了。
    
    
    private int[] Lt0260a(int[] nums)
    {
        int[] ans = null;
        
        return ans;
    }
    
}
