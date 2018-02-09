package gt000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. First Missing Positive
 * */
public class LT0041 {

    public static void main(String[] args) {
        
        int[] nums = { 1, 2, 0 };
        nums = new int[]{3,4,-1,1};
        nums = new int[]{};
        nums = new int[]{0,2,2,1,1};
        nums = new int[]{1,1};
        nums = new int[]{0};
        nums = new int[]{7,2,2,2,-7,8,8,3,3,5,-1,18,-1,-3,-7,-9,8,1,4};
        nums = new int[]{-3,14,16,1,-4,7,8,15,4,16,-7,4,17,9,-7,0,0,-3,14,18};
        
        int result = Lt0041a(nums);
        System.out.println(result);
        
    }

    // beats 3.7%...
    public static int Lt0041a(int[] nums)
    {
        int result = 0;
        int i = 0;
        int len = nums.length;
        int j = 0;
        int t = 0;
        
        if(len == 0)
        {
            return 1;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(i = 0; i < len; i++)
        {
            if(nums[i] > 0)
            {
                set.add(nums[i]);
            }
        }
        
        Integer[] nums2 = set.toArray(new Integer[0]);          // new Integer[0].
        int len2 = nums2.length;
        
        Arrays.sort(nums2);
        
        System.out.println(Arrays.toString(nums2) + "\n" + len2);
        
        if(len2 == 0 || nums2[len2 - 1] <= 0 || nums2[0] > 1)
        {
            return 1;
        }
        
        
        j = 1;
        for(i = 0; i < len2; i++, j++)
        {
            if(nums2[i] != j)
            {
                return j;
            }
        }
        
        result = j;
        return result;
    }
    
    // beats 10%.
    public static int Lt0041(int[] nums)
    {
        int result = 0;
        
//        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums);
        
//        System.out.println(Arrays.toString(nums));
        
        int i = 0;
        int len = nums.length;
        int j = 0;
        int t = 0;
        if(len == 0 || nums[len - 1] <= 0 || nums[0] > 1)
        {
            return 1;
        }
        
        // find > 0
        i = 0;
        j = len - 1;
        while(i < j)
        {
            t = (i + j) / 2;
            if(nums[t] <= 0)
            {
                i = t + 1;
            }
            else
            {
                j = t;
            }
        }
        
//        System.out.println(nums[j] + ", " + i + ", " + j);
        
        j = 1;
        for(; i < len; i++, j++)
        {
            
            
//            System.out.println(nums[i] + ", " + j);
            
            if(nums[i] != j)
            {
                if(nums[i] != nums[i - 1])              // 0,1,1,1,1,1,2,2
                    return j;
                else
                    j--;
            }
        }
        
        result = nums[i - 1] + 1;
        
        
        
        return result;
    }
}


/*

Given [1,2,0] return 3,
and [3,4,-1,1] return 2. 

*/