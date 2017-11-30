package ge500;

/**
 * Contiguous Array
 * 
 * */
public class LT525 {

    public static void main(String[] args) {
        
        
        int[] nums = {0,1,0};
        nums = new int[]{0,1,1,1,1,1,0,0,0,0,0,0,0,0,0};
        nums = new int[]{0,0,1,0,0,0,1,1};
        System.out.println(Lt525(nums));
    }


    
    
    // ...leetCode上只显示到500ms，这个试了两次，一次700ms，一次1000ms。。大部分都是50-100ms的。。。怎么弄的。。
    // 这么快的，应该只是遍历一遍的吧。反正他们的应该是O(n)的吧。我这个好像O(n^2)或者O(logN)了。
    public static int Lt525(int[] nums)
    {
        int[] sums = new int[nums.length + 1];
        
//        System.out.println(sums.length);
        
        int sum = 0;
        sums[0] = 0;
        for(int i = 1; i < sums.length; i++)
        {
            if(nums[i-1] == 0)
            {
                sum--;
            }
            else
            {
                sum++;
            }
            sums[i] = sum;
        }
        
        
//        for(int i = 0; i < sums.length; i++)
//        {
//            System.out.print(sums[i] + ", ");
//        }
//        System.out.println();
        
        int result = 0;
        int flag = sums[0];
        int length = 0;

        for(int i = 0; i < sums.length-result; i++)
        {
            for(int j = sums.length-1; j>(i+result); j--)           //...;j>i; limit time out, ;j>(i+result); accepted
            {
                if(sums[i] == sums[j])
                {
                    length = j - i;
//                    System.out.println(i + ", " + j + ", " + sums[i] + ", " + sums[j]);
                    if(length > result)
                    {
                        result = length;
                    }
                    break;
                }
            }
        }
        
        return result;
    }
}
