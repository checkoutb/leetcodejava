package ge100;

import utils.LTUtils;

/**
 * 121. Best Time to Buy and Sell Stock
 * */
public class LT0121
{

    public static void main(String[] args)
    {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        arr = new int[]{7,6,5,4,3,1};
        System.out.println(new LT0121().Lt0121(arr));
    }

    // 2ms
    // just one transaction.
    /*
        other's:
        for(int i=1; i<prices.length; i++){
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
    */
    private int Lt0121(int[] prices)
    {
        if (prices.length == 0)
        {
            return 0;
        }
        int result = 0;
        int max = prices[prices.length - 1];
        int[] maxArr = new int[prices.length];
        maxArr[prices.length - 1] = max;
        for (int i = prices.length - 2; i >= 0; i--)
        {
            maxArr[i] = max;
            if (prices[i] > max)
            {
                max = prices[i];
            }
        }
        
//        LTUtils.showArray(maxArr);
        
        max = maxArr[0] - prices[0]; 
        for (int i = 1; i < prices.length - 1; i++)
        {
            if ((maxArr[i] - prices[i]) > max)
            {
                max = maxArr[i] - prices[i];
            }
        }
        if (max > 0)
        {
            result = max;
        }
        return result;
    }
}
