package gt000;

import java.util.Arrays;

/**
 * 45. Jump Game II
 * */
public class LT0045 {

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        
        nums = new int[]{2,1};
        
//        nums = new int[]{1,2,3};
        
//        nums = new int[]{1};
        
        nums = new int[]{0};
        
//        nums = new int[]{1,1,3,1,1};
        
        LT0045 lt = new LT0045();
        
        System.out.println(lt.jump3(nums));
        
    }

    
    
    // beats 83%!!!
    public int jump3(int[] nums)
    {
        int result = 0;
        
        int len = nums.length;
        int len1 = len - 1;
        int i = 0;
        int j = 0;
        int t = 0;
        int max = 0;
        
        
        if(len == 1)            // 
        {
            return 0;
        }
        
        
        max = nums[0];
        result++;
        i = 1;
        
        while(max < len1)
        {
            t = max;
            for(; i <= t; i++)
            {
                if(nums[i] + i > max)
                {
                    max = nums[i] + i;
                }
            }
            result++;
        }
        
        
        return result;
    }
    
    
    // failed
    public int jump2(int[] nums)
    {
        int result = 1;                     //...
        
        int len = nums.length;
        int len1 = len - 1;
        int i = 0;
        int j = 0;
        int t = 0;
        int max = 0;
//        int indexOfMax = 0;
        
        
//        i += nums[0];               // ...
//        t = i + nums[0];
//        max = 0;
        t = nums[0];
        
        while(max < len1)
//        do
        {
            result++;
            if(t < len1)
            {
                for(j = max + 1; j <= t; j++)
                {
                    if((nums[j] + j) > max)
                    {
                        max = nums[j] + j;
                    }
                }
    //            i = max;
                t = max + nums[max];
            }
            else
            {
                break;
            }
        }
//        while(max < len1 && t < len1);
        
        
        return result;
    }
    
    
    // beats 3.35%...
    public int jump(int[] nums) {
        int result = 0;
        
        int len = nums.length;
        
//        result = jumpRecursion(nums);
        
        int i = 0;
        for(i = 0; i < len; i++)
        {
            nums[i] += i;
        }
        
        
        
//        System.out.println(Arrays.toString(nums));
        
        
        
        
        int j = 0;
//        int t = len;
        for(i = len - 1; i > 0;)
        {
            // 贪心
            for(j = 0; j < len; j++)
            {
                if(nums[j] >= i)
                {
                    result++;
                    i = j;
                    break;
                }
            }
        }
        
        return result;
    }
    
//    public int jumpRecursion(int[] nums)
//    {
//        int result = 0;
//        
//        
//        return result;
//    }
}
