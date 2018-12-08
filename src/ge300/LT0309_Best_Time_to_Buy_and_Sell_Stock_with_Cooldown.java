package ge300;

import java.util.Arrays;

public class LT0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown
{

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,0,2};        // 3
//        int[] arr = {6,1,3,2,4,7};          // 6
//        int[] arr = {1,4,2};        // 3
//        int[] arr = {6,1,6,4,3,0,2};        // 7
        LT0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown lt = new LT0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        
        System.out.println(lt.Lt0309d(arr));
    }

    
    
    // 19ms, most are [6, 13]ms.
    
    /*  6ms:
    int hold = Integer.MIN_VALUE;
    int sold = 0;
    int preSold = 0;
    for (int i = 0; i < prices.length; i++) { 
        int temp = sold;
        sold = Math.max(sold, hold + prices[i]);
        hold = Math.max(hold, preSold - prices[i]);
        preSold = temp;
    }
    return sold;
    */
    
    /*
    if (prices == null || prices.length == 0) return 0;
    int n = prices.length;
    int[] rest = new int[n+1];
    int[] hold = new int[n+1];
    int[] sold = new int[n+1];
    hold[0] = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        rest[i+1] = Math.max(rest[i], sold[i]);
        sold[i+1] = hold[i] + prices[i];
        hold[i+1] = Math.max(rest[i] - prices[i], hold[i]);
    }
    return Math.max(rest[n], sold[n]);
    */
    
    /*  11ms:
    int sell = 0, buy = 0, prevBuy = 0, prevSell = 0;
    buy = Integer.MIN_VALUE;
    for(int price : prices){
        prevBuy = buy;
        buy = Math.max(prevSell - price, prevBuy);
        prevSell = sell;
        sell = Math.max(prevBuy + price, prevSell);
    }
    return sell;
    */
    
    
    private int Lt0309d(int[] prices)
    {
        
        if (prices.length <= 1)
            return 0;
        int[] arr = new int[prices.length];
        int t1 = 0;
        int i = 0;
        while (++i < prices.length)
            if (prices[i] - prices[i - 1] > 0)
                break;
        for (int first = --i; i < prices.length; i++)
        {
            t1 = Math.max(0, prices[i] - prices[first]);
            for (int j = 2; j <= i; j++)
            {
                t1 = Math.max(t1, arr[j - 2] + prices[i] - prices[j]);
            }
            if (i >= 1)
                t1 = Math.max(t1, arr[i - 1]);
            arr[i] = t1;
        }
        
        return arr[arr.length - 1];
    }
    
    private int Lt0309test(int[] prices)
    {
        int[] arr = new int[prices.length];
        int ans = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] - prices[i - 1] > 0)
                ans += (prices[i] - prices[i - 1]);
        }
        return ans;
    }
    
    @Deprecated
    private int Lt0309c(int[] prices)
    {
        
        int t1 = 0;
        int t2 = 0;
        int ans = 0;
        boolean flag2 = true;           // 上次，true:非降低
        int i = 1;
        while (i < prices.length)
        {
            if (prices[i] - prices[i - 1] > 0)
                break;
            i++;
        }
        for (; i < prices.length; i++)
        {
            if (prices[i] - prices[i - 1] >= 0)
            {
                if (flag2)
                {
                    ans += (prices[i] - prices[i - 1]);
                }
                else
                {
                    if (prices[i - 2] - prices[i - 3] >= 0)
                    {
                        t1 = prices[i - 2] - prices[i - 3];
                        t2 = prices[i] - prices[i - 1];
                        ans += Math.max(0, t2 - t1);
                    }
                    else
                    {
                        ans += (prices[i] - prices[i - 1]);
                    }
                    flag2 = true;
                }
            }
            else
            {
                flag2 = false;
            }
        }
        return ans;
    }
    
    @Deprecated
    private int Lt0309b(int[] prices)
    {
        int[] arr1 = new int[prices.length];
        int t = 0;
        for (int i = 0; i < prices.length; i++)
        {
            t = Math.max(0, Math.max(prices[i] - prices[i - 1] + arr1[i - 1], arr1[i - 2]));
        }
        return arr1[arr1.length - 1];
    }
    
    @Deprecated
    private int Lt0309a(int[] prices)
    {
        int[] arr1 = new int[prices.length];
        int[] arr2 = new int[prices.length];
        int max = 0;
        arr2[0] = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            arr2[i] = prices[i];
            max = arr1[i - 1];
            for (int j = 1; j < i; j++)
            {
                if (arr2[i] + arr2[i] - arr2[j + 1] > max)
                {
                    max = arr2[j] + arr2[i] - arr2[j + 1];
                }
            }
            arr1[i] = max;
        }
        
        System.out.println(Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
        
        return arr1[arr1.length - 1];
    }
    
}
