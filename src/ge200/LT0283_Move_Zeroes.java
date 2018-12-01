package ge200;

import java.util.Arrays;

public class LT0283_Move_Zeroes
{

    public static void main(String[] args)
    {
        int[] arr = {0,1,0,3,12};
        arr = new int[] {1};
        new LT0283_Move_Zeroes().Lt0283a(arr);
        System.out.println(Arrays.toString(arr));
    }

    
    // 2ms, most are [1, 2]ms.
    private void Lt0283a(int[] nums)
    {
        int i, j;
        int len1 = nums.length - 1;
        for (j = 0, i = 0; i <= len1; i++)
        {
            if (nums[i] != 0)
            {
                if (i != j)
                    nums[j] = nums[i];
                j++;
            }
        }
        for (; j <= len1; j++)
        {
            nums[j] = 0;
        }
    }
    
}
