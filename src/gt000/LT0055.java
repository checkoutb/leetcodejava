package gt000;


/**
 * 55. Jump Game
 * */
public class LT0055 {

    public static void main(String[] args) {

        int[] nums = { 2, 3, 1, 1, 4 };
        nums = new int[]{3,2,1,0,4};
        nums = new int[]{2,0};
        nums = new int[]{1,2,3};
        nums = new int[]{1,1,1,0};
        
        System.out.println(Lt0055(nums));
    }

    // beats 23%
    public static boolean Lt0055(int[] nums)
    {
        boolean result = true;
        
        int len = nums.length;
        
        if(len == 0)
        {
            return true;
        }
        
        int max = nums[0];
        int i = 0;
        int t = 0;
        
        if(max >= len - 1)
        {
            return true;
        }
        
        
        while(i < max && max < len)
        {
            t = max;
            for(; i <= max; i++)
            {
                if((i + nums[i]) > t)
                {
                    t = (i + nums[i]);
                }
            }
            i--;
//            System.out.println(t);
            
            if(t > max)
            {
                max = t;
            }
        }
        
//        System.out.println(max + ", " + len);
        
        if(max >= len - 1)
        {
            result = true;
        }
        else
        {
            result = false;
        }
        
        return result;
    }
}


/*

A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 

*/