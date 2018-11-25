package ge100;

public class LT0198_House_Robber
{

    public static void main(String[] args)
    {
        int[][] arr2 = {
//                {1,2,3,1},{2,7,9,3,1},
//                {2,1},
//                {1,1,1},
                {2,1,1,2}
        };
        
        LT0198_House_Robber lt = new LT0198_House_Robber();
        for (int[] arr : arr2)
        {
            System.out.println(lt.Lt0198a(arr));
        }
    }

    // 应该是一个很标准的动态规划吧。
    // 5ms, most are [3, 5]ms.
    // 动态规划看来就是，本次有多个选择，这些选择和之前的选择有关。
    
    /* 抄个3ms的
    if(nums.length == 0) return 0; 
    int[] dp = new int[nums.length + 1];
    dp[0] = 0; 
    dp[1] = nums[0]; 
    for(int i = 1; i < nums.length; i++) {
        dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]); 
    }
    return dp[nums.length]; 
    */
    
    private int Lt0198a(int[] nums)
    {
        int result = 0;
        if (nums == null || nums.length == 0)
        {
            return result;
        }
        int[] sums = new int[nums.length];
//        boolean robbed = false;
        int t1 = 0;
//        int t2 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (sums[i] > nums[i])
                continue;
            else
                sums[i] = nums[i];
            
//            robbed = false;
            if (i + 1 < nums.length && sums[i + 1] < sums[i])      // ...
                sums[i + 1] = sums[i];              // ...
            for (int j = i + 2; j < nums.length; j++)
            {
                t1 = sums[j - 2] + nums[j];
                
                sums[j] = Math.max(t1, sums[j - 1]);
                
//                if (robbed)
//                {
//                    t1 = sums[j - 2] + nums[j];
//                    t2 = sums[j - 1];
//                }
//                else
//                {
//                    t1 = sums[j - 1] + nums[j];
//                }
            }
            if ((i + 2) >= nums.length)             // ...
                for (int j = i + 1; j < nums.length; j++)
                    if (sums[j] < sums[i])          // ...
                        sums[j] = sums[i];
        }
        
        result = sums[sums.length - 1];
        return result;
    }
    
}
