package ge200;

import java.util.Arrays;

public class LT0287_Find_the_Duplicate_Number
{

    public static void main(String[] args)
    {
        int[][] arr2 = { { 1, 3, 4, 2, 2 }, { 3, 1, 3, 4, 2 } };
        LT0287_Find_the_Duplicate_Number lt = new LT0287_Find_the_Duplicate_Number();
        
        for (int[] arr : arr2)
        {
            System.out.println(lt.Lt0287e(arr));
        }
    }

    
    // 看过其他人的答案，只看了个大概意思。
    // 0ms...能用b的那种空间换时间的，应该都能用这个。
    private int Lt0287e(int[] nums)
    {
        int i, j;
        for (i = 0, j = 0; i < nums.length; i++)
        {
            if (nums[nums[i]] == -i)
            {
                return nums[i];
            }
            else
            {
                j = nums[nums[i]];
                nums[nums[i]] = -i;
                nums[i] = j;
                i--;
            }
        }
        return -1;
    }
    
    // 看到Set。
    
    // 4ms..竟然是这种更快，看来寻址是非常非常非常非常快的(和赋值对比)。。
    // 好像也是，寻址是做一个加法，然后找这个位置。赋值是要写入内存的(不知道写入前，要不要先擦除，应该不要。)。
    private int Lt0287d(int[] nums)
    {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return -1;
    }
    
    // 6ms...
    private int Lt0287c(int[] nums)
    {
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == last)
                return last;
            last = nums[i];
        }
        return -1;
    }
    
    
    // 想起来，之前做其他题目看到的一个，用空间换时间的方法，试下。
    // boolean[] arr 也可以。
    // 1ms. most are [0, 5]ms.
    // ...不是O(1)空间。。。
    private int Lt0287b(int[] nums)
    {
        int[] arr = new int[nums.length];
        for (int i : nums)
        {
            if (arr[i] != 0)
                return i;
            arr[i]++;
        }
        return -1;
    }
    
    
    // duplicate: 是重复一次，还是说可以重复n次。
    // 只重复一次的话，直接累加。
    // 重复n次，只能Arrays.sort,然后二分。。二分可能不行，可能重复n次的话，就不能二分，因为一共 a+1个数，都属于[1, a];重复n次的话，就意味着不是满射(？好像没有描述这种的，)？
    @Deprecated          // [2,2,2,2,2]
    private int Lt0287a(int[] nums)
    {
        long sum = 0;
        for (int n : nums)
        {
            sum += n;
        }
        return (int) (sum - (long) (nums.length - 1) * (nums.length) / 2);
    }
    
}
