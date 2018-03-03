package gt000;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * */
public class LT0080
{

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,2,2,3};
        
        System.out.println(Lt0080(nums));
        System.out.println(Arrays.toString(nums));
    }

    // ... 要得出长度n，并且 前n个要改变的。
    // 1,2ms
    public static int Lt0080(int[] nums)
    {
        int len;
        if(nums == null || (len = nums.length) == 0)
        {
            return 0;
        }
        int temp = nums[0];
        int index = 0;
        int result = 0;
        int t = 0;
        int j = 0;
        
        for(int i = 1; i < len; i++)
        {
            if(nums[i] == temp)
            {
                ;
            }
            else
            {
                t = (i - index) >= 2 ? 2 : 1;
                for(j = 0; j < t; j++)
                {
                    nums[result + j] = temp;
                }
                temp = nums[i];
                index = i;
                result += t;
            }
        }
        
        t = (len - index) >= 2 ? 2 : 1;
        for(j = 0; j < t; j++)
        {
            nums[result + j] = temp;
        }
        result += t;
        
        return result;
    }
}
