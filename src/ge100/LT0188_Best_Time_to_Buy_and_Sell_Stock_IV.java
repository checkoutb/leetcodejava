package ge100;

public class LT0188_Best_Time_to_Buy_and_Sell_Stock_IV
{

    public static void main(String[] args)
    {
        
    }

    // 。。。不知道。。看了一眼discuss，看到Math.max就知道坏了---动态规划。。以后了。
    private int Lt0188a(int k, int[] prices)
    {
        int result = 0;
        
        
        
        return result;
    }
    
    private int howManyRise(int[] arr)
    {
        boolean flag = true;
        int count = 0;
        for (int i = 1 ; i < arr.length; i++)
            if (arr[i - 1] < arr[i])
                if (flag)
                    flag = count++ < -1;
            else
                if (!flag && arr[i - 1] > arr[i])
                    flag = true;
        return count;
    }
    
}
