package gt000;

/**
 * Container With Most Water
 * */
public class LT11 {

    public static void main(String[] args) {
        
        int[] h = {1,3,4,6,3};
        h = new int[]{1,2};
        h = new int[]{0,2};
        h = new int[]{2,3,4,5,18,17,6};
        
        System.out.println(Lt11(h));
        
        
    }

    // 49/49 time out...
    // unbelievable! it can beats 95%,87%,95%.
    // i forgot what changed between time out and beats 90%...maybe the comment is the change
    public static int Lt11(int[] height)
    {
        int htemp = height[0];
        if(height[0] > height[height.length - 1])
        {
            htemp = height[height.length - 1];
        }
        int result = htemp * (height.length-1);
        int end = height.length;
        int temp = 0;
        int ht2 = 0;
        int ht3 = 0;
        
        for(int i = 0; i < end; i++)
        {
            if(height[i] < htemp || height[i] < ht3 || height[i] == 0)          // this
            {
                continue;
            }
            ht3 = height[i];
            for(int j = height.length-1; j > i+result/height[i]; j--)           // this
            {
                if(height[i] > height[j])
                {
                    ht2 = height[j];
                }
                else
                {
                    ht2 = height[i];
                }
                temp = ht2 * (j-i);
                if(temp > result)
                {
                    result = temp;
                    htemp = ht2;
                }
            }
        }
        
        return result;
    }
}


/*


            6
            |
        4   |
    3   |   |   3
    |   |   |   |
1   |   |   |   |
|   |   |   |   |
-----------------------
0   1   2   3   4

(4-1)*3

*/