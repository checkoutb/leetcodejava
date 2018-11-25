package ge200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LT0217_Contains_Duplicate
{

    public static void main(String[] args)
    {
        int[][] arr2 = { { 1, 2, 3, 1 }, { 1, 2, 3, 4 }, { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, { 9, 7, 5, 3, 1, 2, 4, 6, 7, 8 } };
//        int[][] arr2 = {{6,4,2,3,4,7}};
        LT0217_Contains_Duplicate lt = new LT0217_Contains_Duplicate();
        for (int[] arr1 : arr2)
        {
            System.out.println(lt.Lt0217c(arr1));
            System.out.println(lt.Lt0217a(arr1));
            System.out.println(lt.Lt0217d(arr1));
            System.out.println(lt.Lt0217b(arr1));           // 排序的得放最后。不然arr1顺序就变了。
            System.out.println("------------");
        }
    }
    
    
    // 试下冒泡途中退出,,不过最坏得O(n^2)....速度不乐观。。
    // ....2 submissions, timeout, 559ms...............
    // Arrays.sort() 双支点快速排序,,,,,不过代码 稍微有点长长长长长长长长长长长长长长长长长长长长。
    // 突然觉得选择排序应该比冒泡快。。算了。。肯定 快不过双支点+遍历。
    private boolean Lt0217d(int[] nums)
    {
        int len1 = nums.length - 1;
        int i = 0;
        int j = 0;
        int t = 0;
        for (; i < len1; i++)
            for (j = i + 1; j <= len1; j++)
            {
                if (nums[i] > nums[j])
                {
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
                else if (nums[i] == nums[j])
                    return true;
            }
        return false;
    }
    

    // HashSet..size
    // sort，再遍历一边对比前后2个数。
    // 其他想不出了。。。
    // 好吧，看了discuss，map算一个吧。。
    // HashSet.contains...
    
    // 3 submissions, 23ms, 11ms, 22ms..
    // most are [4, 27]ms....快的是排序后遍历，慢点的是set，map。
    // 最快的是冒泡。。冒泡的途中对比下。。不是冒泡
    /*  1ms
    for (int i = 1; i < nums.length; i++) {
        for(int j = i - 1; j >= 0; j--){
            if(nums[i] > nums[j]) 
                break; 
            if(nums[i] == nums[j]) 
                return true;
        }
    }
    */
    // 代码就是这样的，但是觉得是错的吧。9, 7, 5,3,1,2,4,6, 7, 8 .. i指向第二个7时，j指向6,nums[i] > nums[j]，break。。
    // 嗯，错的。。
    @Deprecated
    private boolean Lt0217c(int[] nums)
    {
        if (nums == null || nums.length < 2 ) {
            return false; 
        }
        for (int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]) 
                    break; 
                if(nums[i] == nums[j]) 
                    return true;
            }
        }
        return false;
    }
    
    /*  2ms
    boolean[] bool = new boolean[max - min + 1];
    for (int num : nums) {
        if (bool[num - min] == true)
            return true;
        bool[num - min] = true;
    }
    */
    // 有点狠，，但是好像。。。要是max-min是40亿就爆炸了。。或者max=Integer.MAX_VALUE, min = 0....
    // 这个就是set，不会有hash冲突的set。。冲突就是相同，直接return。。。
    
    private boolean Lt0217a(int[] nums)
    {
        boolean result = false;
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            if (set.contains(i))
                return true;
            else
                set.add(i);
        return result;
    }
    
    // 2 submissions, 5ms, 8ms.
    private boolean Lt0217b(int[] nums)
    {
        if (nums == null || nums.length <= 1)
            return false;
        Arrays.sort(nums);
        int last = nums[0] + 1;         // Integer.MAX_VALUE + 1 ?.....
        int now = nums[0];
        for (int i : nums)
        {
            now = i;
            if (last == now)
                return true;
            last = now;
        }
        return false;
    }
}
