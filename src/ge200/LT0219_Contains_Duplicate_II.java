package ge200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LT0219_Contains_Duplicate_II
{

    public static void main(String[] args)
    {
//        int[] nums = {1,2,3,1,2,3};
//        int k = 2;
        
        int[] nums = {1,0,1,1};
        int k = 1;
        
        LT0219_Contains_Duplicate_II lt = new LT0219_Contains_Duplicate_II();
        
        System.out.println(lt.Lt0219a(nums, k));
    }

    // 有下标的限制，不能set了，但是map没有问题吧。
    
    
    // 14ms..most are [0, 26]ms...
    
    /* 21ms set
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++){
        if(set.contains(nums[i])){
            return true;
        }
        set.add(nums[i]);
        if(set.size() > k){
            set.remove(nums[i - k]);
        }
    }
    return false;
    
    9ms set
    for (int i = 0; i < nums.length; i++) {
    if (i > k) {
        set.remove(nums[i- k- 1]);
    }
    if (!set.add(nums[i])) {
        return true;
    }
    */
    // 看到这个才想起了 单调栈。。。
    
    /*  3ms
    if (nums == null || nums.length < 2 || k < 1) {
        return false;
    }
    int low = 0;
    int high = 0;
    int len = nums.length - 1;
    while (low < len) {
        if (nums[low] == nums[high] && low != high) {
            return true;
        }
        if (high - low < k && high < len) {
            ++high;
        } else {
            ++low;
        }
    }
    return false;
    */
    // 怎么觉得这个是错的呢。。++low后，应该有high = low + 1;吧。high默认初始为low+1的话，就不需要&& low != high这个判断了。
    
    private boolean Lt0219a(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        for (int i = 0; i < nums.length; i++)
        {
            n = nums[i];
            if (map.containsKey(n))
            {
                if (i - map.get(n) <= k)
                    return true;
                map.put(n, i);
            }
            else
            {
                map.put(n, i);
            }
        }
        return false;
    }
}
