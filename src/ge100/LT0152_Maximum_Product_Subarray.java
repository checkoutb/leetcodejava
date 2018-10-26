package ge100;

public class LT0152_Maximum_Product_Subarray
{

    public static void main(String[] args)
    {
        int[][] arr = { { 2, 3, -2, 4 }, { -2, 0, -1 } };
        
        LT0152_Maximum_Product_Subarray lt = new LT0152_Maximum_Product_Subarray();
        for (int[] nums : arr)
        {
            System.out.println(lt.Lt0152(nums));
        }
    }

    
    // 184/184 timeout or 191ms...
    // 动态规划实在是。。。
    // 其他人：一遍for，保存之前的最大值，最小值，计算本次的最大值最小值。
    private int Lt0152(int[] nums)
    {
        int result = Integer.MIN_VALUE;
        int t = 0;
        for (int i = 0; i < nums.length; i++)
        {
            t = nums[i];
            if (t > result)
            {
                result = t;
            }
            for (int j = i + 1; j < nums.length; j++)
            {
                t *= nums[j];
                if (t > result)
                {
                    result = t;
                }
            }
        }
        return result;
    }
}
