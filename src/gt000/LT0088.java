package gt000;

import utils.LTUtils;

/**
 * 88. Merge Sorted Array
 * */
public class LT0088
{

    public static void main(String[] args)
    {
        int[] nums1 = {1,3,5,5,7,8,0,0,0,0,0,0,0,0,0};
        int[] nums2 = {1,2,3,4,5,10};
        
        nums1 = new int[]{2,0};
        nums2 = new int[]{1};
        
        Lt0088(nums1, 1, nums2, 1);
        LTUtils.showArray(nums1);
    }

    // 6ms, beats 40.8%
    // m, n 是nums1,nums2的元素数，nums1.length是容量。
    public static void Lt0088(int[] nums1, int m, int[] nums2, int n)
    {
        if(n == 0)
        {
            return;
        }
        if(m == 0)
        {
//            nums1 = nums2;        // 这是传值的？传得地址的值？
            for(int i = 0; i < n; i++)
            {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        for(; index >= 0; index--)
        {
            if(i < 0)
            {
                for(; j >= 0; j--)
                {
                    nums1[index] = nums2[j];
                    index--;
                }
                return;
            }
            if(j < 0)               // < not ==...
            {
                return;
            }
            if(nums1[i] >= nums2[j])
            {
                nums1[index] = nums1[i];
                i--;
            }
            else
            {
                nums1[index] = nums2[j];
                j--;
            }
        }
        
    }
}
