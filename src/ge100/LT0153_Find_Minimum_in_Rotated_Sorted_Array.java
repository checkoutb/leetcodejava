package ge100;

public class LT0153_Find_Minimum_in_Rotated_Sorted_Array
{

    public static void main(String[] args)
    {
        int[][] arr = {{3,4,5,1,2},{4,5,6,7,0,1,2}};
        
        LT0153_Find_Minimum_in_Rotated_Sorted_Array lt = new LT0153_Find_Minimum_in_Rotated_Sorted_Array();
        for (int[] nums : arr)
        {
            System.out.println(lt.Lt0153a(nums));
        }
    }

    // 0ms, 90% are 0ms.
    // 太狠了，直接for循环找最小值，还有个更狠的，Arrays.sort...
    private int Lt0153a(int[] nums)
    {
        
        int result = 0;
        result = recursiona1(nums, 0, nums.length - 1);
        return result;
    }
    
    private int recursiona1(int[] nums, int s, int e)
    {
        if (s == e)
        {
            return nums[s];
        }
        int m = (s + e) / 2;
        
        if (nums[s] < nums[e])
        {
            return nums[s];
        }
        else
        {
            if (nums[s] < nums[m])
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
