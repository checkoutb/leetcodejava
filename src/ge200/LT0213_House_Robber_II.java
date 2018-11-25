package ge200;

import java.util.Arrays;

public class LT0213_House_Robber_II
{

    public static void main(String[] args)
    {
        int[][] arr2 = {{2,3,2},{1,2,3,1}, {1}, {0,0}};
        for (int[] arr1 : arr2)
            System.out.println(new LT0213_House_Robber_II().Lt0213a(arr1));
    }

    
    // 5ms, most are [3, 5]ms.
    // 呃，看不懂。。
    private int Lt0213a(int[] nums)
    {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int len = nums.length;
        int len1 = len - 1;
        int[][] arr1 = new int[2][len];         // 0: rob final house, 1: not rob 
        arr1[0][0] = 0;
        arr1[1][0] = nums[0];
        arr1[0][1] = nums[1];
        arr1[1][1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len1; i++)
        {
            arr1[1][i] = Math.max(arr1[1][i - 1], arr1[1][i - 2] + nums[i]);
            if (i == len1 - 1)
                break;
            arr1[0][i] = Math.max(arr1[0][i - 1], arr1[0][i - 2] + nums[i]);
        }
        
        arr1[0][len1] = arr1[0][len1 - 2] + nums[len1];
        arr1[1][len1] = arr1[1][len1 - 1];
        
//        System.out.println(Arrays.toString(arr1[0]) + "\n" + Arrays.toString(arr1[1]));
        
        return arr1[0][len1] > arr1[1][len1] ? arr1[0][len1] : arr1[1][len1];
    }
    
}
