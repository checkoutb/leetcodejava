package gt000;


/**
 * 33. Search in Rotated Sorted Array
 * */
public class LT0033 {

    public static void main(String[] args) {
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        
        int result = Lt0033(nums, 5);
        System.out.println(result);
    }

    
    // error...
    @Deprecated
    public static int Lt0033a(int[] nums, int target)
    {
        int result = -1;
        int i = 0;
        int j = nums.length;
        int minIndex = -1;
        int temp = 0;
        
        while(nums[i] > target)
        {
            temp = (i + j + 1) / 2;             //...
            if(nums[temp] > target)
            {
                i = temp + 1;
            }
            else
            {
                i = temp;
            }
        }
        
        while(nums[j] < target)
        {
        }
        
        for(; i < j ; i++)
        {
            
        }
        
        return result;
    }
    
    
    // beats 12%
    public static int Lt0033(int[] nums, int target)
    {
        int result = -1;
        int i = 0;
        for(i = 0; i < nums.length; i++)
        {
            if(nums[i] == target)
                result = i;
        }
        
        return result;
    }
}
