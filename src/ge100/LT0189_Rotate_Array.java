package ge100;

import java.util.Arrays;

public class LT0189_Rotate_Array
{

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7};
        arr = new int[] {-1,-100,3,99};
        int k = 7;
        k = 3;
        LT0189_Rotate_Array lt = new LT0189_Rotate_Array();
        lt.Lt0189a(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    // 1ms, most are [0, 1]ms
    
    // 0ms的代码, 先nums全体反转，然后[0,k-1],[k,nums.length-1]分别反转。。。
    private void Lt0189a(int[] nums, int k)
    {
        int len = nums.length;
        k %= len;
        int j = 0;
        int t = 0;
        int t1 = 0;
        int[] arr1 = Arrays.copyOf(nums, k);            // 不会O(1)..数据会被覆盖掉，所以必须要空间保存啊。。
        for (int i = 0; i < k; i++)
        {
            j = i + k;
            t = arr1[i];
            while (j < len)
            {
                t1 = nums[j];
                nums[j] = t;
                t = t1;
                j += k;
            }
            j %= len;
            while (j < i + k && j < len)        // j < len
            {
                t1 = nums[j];
                nums[j] = t;
                t = t1;
                j += k;
            }
        }
    }
}
