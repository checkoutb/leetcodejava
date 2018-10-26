package ge100;

public class LT0162_Find_Peak_Element
{

    public static void main(String[] args)
    {
        
    }

    // 4ms...most are [3, 4]ms
    // 看了代码，大部分都是二分，用mid和mid+1比较。细节各不相同，有的二分到low>=high,有的会某些情况和mid-1比较从而提前退出。
    private int Lt0162a(int[] nums)
    {
        
        if (nums.length == 1)
        {
            return 0;
        }
        int result = 0;
        if (nums[0] > nums[1])
        {
            return result;
        }
        for (result = 1; result < nums.length - 1; result++)
        {
            if (nums[result] > nums[result - 1] && nums[result] > nums[result + 1])
            {
                return result;
            }
        }
        return result;
        
    }
}
