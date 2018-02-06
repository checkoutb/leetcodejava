package gt000;

import java.util.Arrays;

/**
 * 34. Search for a Range
 * */
public class LT0034 {

    public static void main(String[] args) {
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        nums = new int[]{1};
        target = 1;
        nums = new int[]{2, 2};
        target = 3;
        
        int[] result = Lt0034(nums, target);
        System.out.println(Arrays.toString(result));
    }

    
    // beats 22%
    public static int[] Lt0034(int[] nums, int target)
    {
        int[] result = {-1, -1};
        if(nums == null || nums.length == 0)
        {
            return result;
        }
        int i = 0;
        int j = nums.length;
        int temp = 0;
        while(i != j)
        {
            temp = (i + j) / 2;
            if(nums[temp] < target)
            {
                i = temp + 1;
            }
            else
            {
                j = temp;
            }
        }
        
        
//        System.out.println(nums[j] + ", " + i + ", " + j);            // indexOutOfRange.
        
        if(i >= 0 && i < nums.length && nums[i] == target)
        {
            while(i >= 0 && nums[i] == target)
            {
                i--;
            }
            result[0] = i + 1;
            
            while(j < nums.length && nums[j] == target )
            {
                j++;
            }
            result[1] = j - 1;
        }
        
        
        
        return result;
    }
}
