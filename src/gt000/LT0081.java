package gt000;


/**
 * 81. Search in Rotated Sorted Array II
 * */
public class LT0081
{
    public static void main(String[] args)
    {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        nums = new int[]{1, 1, 3, 1};
        target = 3;
        
        System.out.println(Lt0081(nums, target));
    }
    
    // 1,1,1,1,1,3,1....1,3,1,1,1,1,1 就知道首末和中间3个值完全没办法二分。。
    // 要么转成没重复的，不过这种和遍历一边没什么区别。
    // 要么选下标的时候要选到最后/最前一个相同值。。。应该是这种吧。。。以后吧。
    public static boolean Lt0081(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        boolean result = false;
        int low = 0;
        int high = nums.length - 1;
        int t;
        
        while(low < high)
        {
            t = (low + high) / 2;
            if(nums[low] < nums[t])
            {
                if(nums[t] < target || nums[low] > target)
                {
                    low = t + 1;
                }
                else
                {
                    high = t;
                }
            }
            else if(nums[low] == nums[t])
            {
                if(nums[t] == target)
                {
                    return true;
                }
                if (low != t)
                {
                    if(nums[high] > nums[t])
                    {
                        low = t + 1;
                    }
                    else
                    {
                        high = t;
                    }
                }
                else
                {
                    {
                        low = t + 1;
                    }
                }
            }
            else
            {
                if(nums[t] < target && nums[low] > target)
                {
                    low = t + 1;
                }
                else
                {
                    high = t;
                }
            }
        }
        
        result = nums[high] == target;
        return result;
    }
    
}
