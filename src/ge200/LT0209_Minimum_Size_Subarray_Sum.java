package ge200;

import java.util.LinkedList;
import java.util.Queue;

public class LT0209_Minimum_Size_Subarray_Sum
{

    public static void main(String[] args)
    {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        
        System.out.println(new LT0209_Minimum_Size_Subarray_Sum().Lt0209a(s, nums));
    }

    // 这题长得真像动态规划。。
    // 5ms, most are [2, 3]ms.
    // 似乎可以不用Queue，用2个指针就可以了。
    // 2ms, 一个指针就可以了，还有一个指针i是送的。while(left<=i && sum >= s)
    private int Lt0209a(int s, int[] nums)
    {
        int result = 0;
        Queue<Integer> que = new LinkedList<>();
        int sum = 0;
        int t1 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (sum < s)
            {
                que.add(nums[i]);
                sum += nums[i];
            }
            while (sum >= s)
            {
                t1 = que.size();
                if (t1 < result || result == 0)
                    result = t1;
                sum -= que.poll();
            }
        }
        return result;
    }
}
