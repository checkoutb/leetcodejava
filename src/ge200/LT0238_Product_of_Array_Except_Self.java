package ge200;

public class LT0238_Product_of_Array_Except_Self
{

    public static void main(String[] args)
    {
        
    }

    
    // O(n) 且 不能用除法。。。我。。。
    // 看了discuss。。抄的。
    // 第一遍for保存从0到i-1的积。
    // 第二遍，保存下(i, length)的乘积。然后和[0, i-1]的积相乘。
    private int[] Lt0238a(int[] nums)
    {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int t = 1;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            ans[i] *= t;
            t *= nums[i];
        }
        return ans;
    }
    
}
