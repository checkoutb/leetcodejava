package ge300;

public class LT0300_Longest_Increasing_Subsequence
{

    public static void main(String[] args)
    {
        int[] arr = {10,9,2,5,3,7,101,18};          // 4
        LT0300_Longest_Increasing_Subsequence lt = new LT0300_Longest_Increasing_Subsequence();
        
        System.out.println(lt.Lt0300a(arr));
    }

    
    // 最优子结构。。
    // 20ms, most are [0, 2] U [13, 23]ms.
    
    /* 1ms
    int[] lis = new int[nums.length];
    int size = 0;
    for(int num : nums) {
        int i = 0, j = size;
        while(i != j) {
            int mid = (i + j) / 2;
            if(lis[mid] < num) {
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }
        lis[i] = num;
        if(i == size) {
            size++;
        }
    }
    return size;
    */
    // ...看不懂。。。
    
    private int Lt0300a(int[] nums)
    {
        if (nums.length <= 1)
            return nums.length;
        int ans = 0;
        int[] arr = new int[nums.length];
        int i = 0;
        int j = 0;
        int t1 = 0;
        arr[nums.length - 1] = 1;
        for (i = nums.length - 1; i >= 0; i--)
        {
            t1 = 1;
            for (j = i + 1; j < nums.length; j++)
            {
                if (nums[i] < nums[j] && t1 <= arr[j])
                {
                    t1 = arr[j] + 1;
                }
            }
            arr[i] = t1;
            if (ans < t1)
                ans = t1;
        }
        return ans;
    }
    
}
