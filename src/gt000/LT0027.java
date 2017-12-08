package gt000;


/**
 * Remove Element
 * */
public class LT0027 {

    public static void main(String[] args) {
        
        int[] nums = {3,2,2,3};
        int val = 3;
        
        
        int a = 1;
        a = a;
        
        System.out.println(Lt0027(nums, val));
    }


    // before coding, i have seen 26's solution...
    // beats 25%
    public static int Lt0027(int[] nums, int val)
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int i = 0;
        int len = nums.length;
        for(int j = 0; j < len; j++)
        {
            if(nums[j] != val)
            {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
