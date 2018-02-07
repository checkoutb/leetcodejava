package gt000;


/**
 * 35. Search Insert Position
 * */
public class LT0035 {

    public static void main(String[] args) {
        
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        target = 2;
        target = 7;
        target = 0;
        target = 6;
        
        
        int result = Lt0035(nums, target);
        
        System.out.println(result);
        
    }
    
    // beats 43%
    public static int Lt0035(int[] nums, int target)
    {
        int result = 0;
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        
        if(nums[i] >= target)
        {
            return 0;
        }
        if(nums[j] < target)
        {
            return j + 1;
        }
        else if(nums[j] == target)
        {
            return j;
        }
        
        while(i < j)
        {
            temp = (i + j) / 2;
            
            
            
//            System.out.println(i + ", " + temp + ", " + j);
            
            
            
            if(nums[temp] < target)
            {
                i = temp + 1;
            }
            else
            {
                j = temp;
            }
        }
        
        result = i;
        
        return result;
    }
}



/*

Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 1:
Input: [1,3,5,6], 0
Output: 0


*/