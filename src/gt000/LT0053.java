package gt000;


/**
 * 53. Maximum Subarray
 * */
public class LT0053 {

    public static void main(String[] args) {
        
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        nums = new int[]{-1};
        
        nums = new int[]{-2, -1};
        
        System.out.println(Lt0053(nums));
    }
    
    
    // beats 1.45%...
    public static int Lt0053(int[] nums)
    {
        int result = 0;
        int i = 0;
        int j = 0;
        int len = nums.length;
        int max = 0;

        if(len == 1)
        {
            return nums[0];
        }
        if(len == 0)
        {
            return 0;
        }
        
        len--;
        while(len >= 0 && nums[len] < 0)
        {
            len--;
        }
        len++;
        
        if(len > 0)
        {
            for(i = 0; i < len; i++)
            {
                if(nums[i] <= 0)
                {
                    continue;
                }
                else
                {
                    max = 0;
                    for(j = i; j < len; j++)
                    {
                        max += nums[j];
                        if(max > result)
                        {
                            result = max;
                        }
                    }
                }
            }
        }
        else
        {
            len = nums.length;
            result = nums[0];
            for(i = 0; i < len; i++)
            {
                if(nums[i] > result)
                {
                    result = nums[i];
                }
            }
            
        }
        return result;
    }

}
