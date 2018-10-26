package ge100;

public class LT0154_Find_Minimum_in_Rotated_Sorted_Array_II
{

    public static void main(String[] args)
    {
        int[][] arr = { 
                { 1, 1 }, { 2, 2, 2, 0, 1 },  
                { 3, 3, 1, 3 }  
        };
        
        LT0154_Find_Minimum_in_Rotated_Sorted_Array_II lt = new LT0154_Find_Minimum_in_Rotated_Sorted_Array_II();
        for (int[] nums : arr)
        {
            System.out.println(lt.Lt0154a(nums));
        }
    }

    
    // 这个没办法像153那样，根据3个点确定递归哪一部分。
    // 1ms. 68% are 0ms, 27% are 1ms.
    // while (s < e)
    private int Lt0154a(int[] nums)
    {
        
        int result = 0;
        result = recursiona1(nums, 0, nums.length - 1);
        return result;
    }
    
    private int recursiona1(int[] nums, int s, int e)
    {
        if (s >= e)
        {
            return nums[s];
        }
        int m = (s + e) / 2;
        if (nums[s] < nums[e])
        {
            return nums[s];
        }
        else if (nums[s] == nums[e])
        {
            int t1 = this.recursiona1(nums, s, m - 1);
            int t2 = this.recursiona1(nums, m, e - 1);
            return t1 > t2 ? t2 : t1;
        }
        else
        {
            if (nums[s] <= nums[m])
            {
                return this.recursiona1(nums, m + 1, e);
            }
            else
            {
                return this.recursiona1(nums, s + 1, m);
            }
        }
        
    }
}
