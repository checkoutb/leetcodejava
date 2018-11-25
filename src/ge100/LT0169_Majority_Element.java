package ge100;

import java.util.Arrays;

public class LT0169_Majority_Element
{

    public static void main(String[] args)
    {
        
    }

    
    // 1. map，如果大于一半，就直接退出。应该有其他方法提前退出。
    // 2. sort以后，nums[nums.length / 2]
    
    /*      count约等于生命值，相同数+1，不同数-1,由于某个数占总体比例>1/2，所以那个数总能活到最后。。。不知道他们怎么想出来的。。
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else if (nums[i] != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
    */
    
    /*      上面那个的简化版
    int maj = nums[0], count = 0;
    for(int x : nums){
        if(x==maj) count++;
        else if(count==0){
            count=1;
            maj=x;
        }
        else count--;
    }
    return maj;
    */
    
    // 5ms, most are [3, 7]ms
    private int Lt0169a(int[] nums)
    {
        int result = 0;
        Arrays.sort(nums);
        result = nums[nums.length / 2];
        return result;
    }
}
