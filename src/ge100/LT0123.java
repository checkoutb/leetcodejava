package ge100;

import java.util.Arrays;

/**
 * 123. Best Time to Buy and Sell Stock III
 * */
public class LT0123
{

    public static void main(String[] args)
    {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };     // 6
//        arr = new int[] { 1, 2, 3, 4, 5 };          // 4
//        arr = new int[] { 7, 6, 5, 2 };           // 0
//        arr = new int[] { 6, 1, 3, 2, 4, 7 };     // 7
//        arr = new int[] { 8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6 };
        arr = new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };     // 13
        System.out.println(new LT0123().Lt0123b(arr));
    }

    // 驻点有点用，但没有写代码之前想象的神挡杀神那般无敌。。。
    // 4ms..most are [2, 5]ms
    /*
        。。。差距有点大。。。
        int buyOne = Integer.MAX_VALUE;
        int SellOne = 0;
        int buyTwo = Integer.MAX_VALUE;
        int SellTwo = 0;
        for(int p : prices) {
            buyOne = Math.min(buyOne, p);
            SellOne = Math.max(SellOne, p - buyOne);
            buyTwo = Math.min(buyTwo, p - SellOne);
            SellTwo = Math.max(SellTwo, p - buyTwo);
        }
        
        1,2,1,3
        
        1,0,1,0
        1,1,1,1
        1,1,0,1
        1,2,0,3
        
        大意是：一次遍历，保存最低股价buyone，计算并保存第一次交易的最大收益sellone，
                        计算并保存第二次交易的最低初始价值(现在的股价 - 第一次交易赚的钱)，计算并保存两次交易的最大收益。
        吊吊吊吊吊。
    */
    private int Lt0123b(int[] prices)
    {
        int result = 0;
        if (prices.length <= 1)
        {
            return result;
        }
        prices = this.pretreatmenta2(prices);
        if (prices.length <= 1)
        {
            return result;
        }
        prices = this.pretreatmentb1(prices);
        if (prices.length <= 1)
        {
            return result;
        }
        
        result = function4(prices, 0, prices.length - 1, 2);
        
        return result;
    }
    
    private int function4(int[] arr, int start, int end, int ... args)
    {
        int times = args[0];
        int shift = args.length == 1 ? 0 : args[1];
        int result = 0;
        int result2 = 0;
        int[][] indexArr = this.findIndexOfMaxMinValue(arr, start + shift, end - shift);

        for (int maxIndex : indexArr[1])
        {
            for (int minIndex : indexArr[0])
            {
                if (times == 1)
                {
                    if (maxIndex < minIndex)
                    {
                        int[][] arr1 = this.findIndexOfMaxMinValue(arr, start, maxIndex);
                        int[][] arr2 = this.findIndexOfMaxMinValue(arr, maxIndex + 1, minIndex - 1);
                        int[][] arr3 = this.findIndexOfMaxMinValue(arr, minIndex, end);
                        int t1 = arr1[0].length == 0 ? 0 : arr[arr1[1][0]] - arr[arr1[0][0]];
                        int t2 = arr2[0].length == 0 ? 0 : arr[arr2[1][0]] - arr[arr2[0][0]];
                        int t3 = arr3[0].length == 0 ? 0 : arr[arr3[1][0]] - arr[arr3[0][0]];
                        result = t1 > t2 ? t1 > t3 ? t1 : t3 : t2 > t3 ? t2 : t3;
                    }
                    else
                    {
                        result = arr[maxIndex] - arr[minIndex];
                    }
                }
                else
                {
                    if (maxIndex < minIndex)
                    {
                        int t1 = function4(arr, start, maxIndex, 1);
                        int t2 = function4(arr, maxIndex + 1, minIndex - 1, 1);
                        int t3 = function4(arr, minIndex, end, 1);
                        result = (t1 + t2 + t3);
                        result -= (t1 > t2 ? t2 > t3 ? t3 : t2 : t1 > t3 ? t3 : t1);
                    }
                    else
                    {
                        int t1 = function4(arr, start, minIndex - 1, 1);
                        int t2 = function4(arr, maxIndex + 1, end, 1);
                        int t11 = arr[maxIndex] - arr[minIndex] + (t1 > t2 ? t1 : t2);
                        int t12 = function4(arr, minIndex, maxIndex, 2, 1);
                        result = t11 > t12 ? t11 : t12;
                    }
                }
                if (result > result2)
                {
                    result2 = result;
                }
            }
        }
        return result2;
    }
    
    private int[] pretreatmentb1(int[] arr)
    {
        int i = 1;
        int j = 0;
        if (arr[0] < arr[1])
        {
            arr[j++] = arr[0];
        }
        for (; i < arr.length - 1; i++)
        {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1])
            {
                arr[j++] = arr[i];
            }
            else if (arr[i] < arr[i + 1] && arr[i] < arr[i - 1])
            {
                arr[j++] = arr[i];
            }
        }
        if (arr[i] > arr[i - 1])
        {
            arr[j++] = arr[i];
        }
        return Arrays.copyOf(arr, j);
    }
    
    // [start, end]
    private int[][] findIndexOfMaxMinValue(int[] arr, int start, int end)
    {
        if (start > end)
        {
            return new int[][] { {}, {} };
        }
        int maxValue = arr[start];
        int minValue = maxValue;
        int maxIndex = start;
        int minIndex = start;
        for (int i = start + 1; i <= end; i++)
        {
            if (arr[i] > maxValue)
            {
                maxValue = arr[i];
                maxIndex = i;
            }
            else if (arr[i] < minValue)
            {
                minValue = arr[i];
                minIndex = i;
            }
        }
        int[][] result = new int[2][];
        int[] tempMin = new int[arr.length];
        int[] tempMax = new int[arr.length];
        maxIndex = 0;
        minIndex = 0;
        for (int i = start; i <= end; i++)
        {
            if (arr[i] == minValue)
            {
                tempMin[minIndex++] = i;
            }
            if (arr[i] == maxValue)
            {
                tempMax[maxIndex++] = i;
            }
        }
        result[0] = Arrays.copyOf(tempMin, minIndex);
        result[1] = Arrays.copyOf(tempMax, maxIndex);
        return result;
    }
    
    // remove duplicate
    private int[] pretreatmenta2(int[] prices)
    {
//        if (prices.length <= 1)
//        {
//            return prices;
//        }
        int i = 1;
        int j = 0;
        for (; i < prices.length; i++)
        {
            if (prices[i] == prices[j])
            {
                continue;
            }
            prices[++j] = prices[i];
        }
        return Arrays.copyOf(prices, j + 1);
    }
    
    // not complete...
    @Deprecated
    private int Lt0123a(int[] prices)
    {
        int result = 0;
        
        prices = this.pretreatmenta2(prices);
        
        int[][] arr = this.pretreatmenta1(prices);
        
        if (arr[0].length == 0)
        {
            return result;
        }
        if (arr[0].length == 2)
        {
            return arr[1][2] - arr[0][2];
        }
        if (arr[0].length == 4)
        {
            return arr[1][2] - arr[0][2] + arr[3][2] - arr[2][2];
        }
        
        int[] arr2 = this.function1(arr);
        
//        result = this.function2(arr2);
        
        int oneMax = function3(arr2);
        int twoMax = 2;
        
        
        return result;
    }
    
    private int function3(int[] arr)
    {
        int max = arr[0];
        int total = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 0)
            {
                continue;
            }
            total = arr[i];
            if (total > max)
            {
                max = total;
            }
            for (int j = i + 1; j < arr.length; j++)
            {
                total += arr[j];
                if (arr[j] < 0)
                {
                    continue;
                }
                if (total > max)
                {
                    max = total;
                }
            }
        }
        return max;
    }
    
//    private int function2(int[] arr)
//    {
//        int result = 0;
//        
////        int minIndex = 0;
////        int i = 1;
////        for (; i < arr.length; i++)
////        {
////            if (arr[minIndex] > arr[i])
////            {
////                minIndex = i;
////            }
////        }
//        
//        return result;
//    }
    
    private int[] function1(int[][] arr)
    {
        int[] result = new int[arr[0].length - 1];
        for (int i = 1; i < arr[0].length; i++)
        {
            result[i - 1] = arr[i + 1][2] - arr[i][2];
        }
        return result;
    }
    
    // Stationary Point
    private int[][] pretreatmenta1(int[] prices)
    {
        if (prices.length <= 1)
        {
            return new int[3][0];
        }
        int[][] arr = new int[3][prices.length];
        int index = 0;
        if (prices[0] < prices[1])
        {
            arr[index][0] = 0;              // index of prices
            arr[index][1] = -1;             // -1: min/concave; 1: max/convexity.
            arr[index++][2] = prices[0];    // prices
        }
        int i = 1;
        for (; i < prices.length - 1; i++)
        {
            if (prices[i] > prices[i - 1] && prices[i] > prices[i + 1])
            {
                arr[index][0] = i;
                arr[index][1] = 1;
                arr[index++][2] = prices[i];
            }
            else if (prices[i] < prices[i - 1] && prices[i] < prices[i + 1])
            {
                arr[index][0] = i;
                arr[index][1] = -1;
                arr[index++][2] = prices[i];
            }
        }
        if (prices[i] > prices[i - 1])
        {
            arr[index][0] = i;
            arr[index][1] = 1;
            arr[index++][2] = prices[i];
        }
        int[][] result = new int[3][];
        result[0] = Arrays.copyOf(arr[0], index);
        result[1] = Arrays.copyOf(arr[1], index);
        result[2] = Arrays.copyOf(arr[2], index);
        return result;
    }
    
}
