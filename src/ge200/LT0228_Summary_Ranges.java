package ge200;

import java.util.LinkedList;
import java.util.List;

public class LT0228_Summary_Ranges
{

    public static void main(String[] args)
    {
        int[][] arr2 = {{0,1,2,4,5,7},{0,2,3,4,6,8,9}};
        
        LT0228_Summary_Ranges lt = new LT0228_Summary_Ranges();
        
        for (int[] arr1 : arr2)
            System.out.println(lt.Lt0228a(arr1));
    }

    // 遍历，二分，step？
    // 呃。。。1ms, most are [1, 2]ms.
    private List<String> Lt0228a(int[] nums)
    {
        List<String> ans = new LinkedList<>();
        int s = 0;
        for (int i = 0; i < nums.length; i++)
        {
            s = nums[i];
            while (++i < nums.length && nums[i] == nums[i - 1] + 1)
            {
                ;
            }
            i--;
            if (nums[i] == s)
                ans.add(String.valueOf(s));
            else
                ans.add(s + "->" + nums[i]);
        }
        return ans;
    }
}
