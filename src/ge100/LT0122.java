package ge100;

import java.util.Arrays;

import utils.LTUtils;

/**
 * 122. Best Time to Buy and Sell Stock II
 * */
public class LT0122
{

    public static void main(String[] args)
    {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        arr = new int[] { 1, 2, 3, 4, 5 };
        arr = new int[] { 7, 6, 5, 3, 1 };
        arr = new int[] { 1 };
        System.out.println(new LT0122().Lt0122(arr));
    }

    // many transactions
    // 4ms...most are 1ms...
    // ......other's solution................... if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
    // 我。。。还在找驻点。。。
    private int Lt0122(int[] prices)
    {
        int result = 0;
        if (prices.length <= 1)
        {
            return result;
        }
        prices = this.pretreatment(prices);
        if (prices.length <= 1)
        {
            return result;
        }
        
        int[] pointArr1 = new int[prices.length];       // max
        int[] pointArr2 = new int[prices.length];       // min
        int index1 = 0;
        int index2 = 0;
        
        if (prices[0] < prices[1])
        {
            pointArr2[index2++] = 0;
        }
        
        if (prices[0] > prices[1])
        {
            pointArr1[index1++] = 0;
        }
        
        for (int i = 1; i <= prices.length - 2; i++)
        {
            if (prices[i] > prices[i + 1] && prices[i] > prices[i - 1])
            {
                pointArr1[index1++] = i;
            }
            if (prices[i] < prices[i + 1] && prices[i] < prices[i - 1])
            {
                pointArr2[index2++] = i;
            }
        }
        
        if (prices[prices.length - 1] > prices[prices.length - 2])
        {
            pointArr1[index1++] = prices.length - 1;
        }
        if (prices[prices.length - 1] > prices[prices.length - 2])
        {
            pointArr2[index2++] = prices.length - 1;
        }
        
//        LTUtils.showArray(pointArr1);
//        LTUtils.showArray(pointArr2);
        
        int i = 0;
        int temp = 0;
        AAA:
        for (int j = 0; j < index2; j++)
        {
//            System.out.println(j);
            temp = pointArr2[j];
            for (; i < index1; i++)
            {
                if (pointArr1[i] > temp)
                {
//                    System.out.println(pointArr1[i] + ",,," + pointArr2[j]);
                    result += (prices[pointArr1[i]] - prices[pointArr2[j]]);
                    for (j++; j < index2; j++)
                    {
                        if (pointArr2[j] > pointArr1[i])
                        {
                            j--;
                            continue AAA;
                        }
                    }
                    j--;
                    continue AAA;
                }
            }
        }
        
        return result;
    }
    
    private int[] pretreatment(int[] arr)
    {
        int[] arr2 = new int[arr.length];
        
        arr2[0] = arr[0];
        int last = arr[0];
        int j = 1;
        int i = 1;
        for (; i < arr.length; i++)
        {
            if (arr[i] == last)
            {
                continue;
            }
            arr2[j++] = arr[i];
            last = arr[i];
        }
        
        int[] result = Arrays.copyOf(arr2, j);
        return result;
    }
}
