package ge200;

import java.util.Arrays;

public class LT0268_Missing_Number
{

    public static void main(String[] args)
    {
        
    }

    
    // 累加然后和 (0 + n) / 2 * n 对比下。
    
    // 遍历，和后一个数的差必然是+-1...0和n。。还有第一个和最后一个
    
    // 有序的，所以应该可以二分。也可以定长分割。
    
    // 。。。擦，是无序的。。
    // [0],,,1
    // ...排序以后，可以直接值和下标比较，不想等，就返回下标。。
    
    // 14ms. most are [0, 1]ms.
    /*  0ms
    int[] arr = new int[nums.length + 1];
    for(int i = 0; i < nums.length; i++) {
        arr[nums[i]] = -1;
    }
    for(int i = 0; i < arr.length; i++) {
        if(arr[i] != -1) return i;
    }
    return -1;
    */
    
    private int Lt0268a(int[] nums)
    {
        Arrays.sort(nums);
//        if (nums[0] != 0 && Math.abs(nums[0] - nums[nums.length - 1]) == 2)
//        {
//            return (nums[0] + nums[nums.length - 1]) / 2;
//        }
        if (nums[0] != 0)
            return 0;
        for (int i = 0, len1 = nums.length - 1; i < len1; i++)
        {
            if (Math.abs(nums[i] - nums[i + 1]) == 2)
            {
                return (nums[i] + nums[i + 1]) / 2;
            }
        }
        return nums[nums.length - 1] + 1;
    }
    
}
