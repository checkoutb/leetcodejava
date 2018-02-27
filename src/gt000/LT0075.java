package gt000;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * */
public class LT0075 {

    public static void main(String[] args) {

        int[] nums = { 0, 2, 1, 1, 2, 2, 0, 1, 2, 1, 1, 0, 2 };

        Lt0075(nums);

        System.out.println(Arrays.toString(nums));
    }

    // 不清楚这道题目的意义，看了其他人的答案以后，可能这道题目是用来考验3个指针的？每种颜色一个下标，然后一遍就完成。
    // 0ms, beats 39%
    public static void Lt0075(int[] nums)
    {
        int numRed = 0;
        int numWhite = 0;
        int numBlue = 0;
        
        int i = 0;
        int len = nums.length;
        
        for(i = 0; i < len; i++)
        {
            switch(nums[i])
            {
            case 0:
                numRed++;
                break;
            case 1:
                numWhite++;
                break;
            case 2:
                numBlue++;
                break;
            default:
                break;
            }
        }
        
        i = 0;
        for(; i < numRed; i++)
        {
            nums[i] = 0;
        }
        for(len = numRed + numWhite; i < len; i++)
        {
            nums[i] = 1;
        }
        for(len += numBlue; i < len; i++)
        {
            nums[i] = 2;
        }
    }
    
}
