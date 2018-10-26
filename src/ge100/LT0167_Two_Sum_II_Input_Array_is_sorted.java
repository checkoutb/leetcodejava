package ge100;

import java.util.Arrays;

public class LT0167_Two_Sum_II_Input_Array_is_sorted
{

    public static void main(String[] args)
    {
        int[] arr = { 2, 7, 11, 15 };
        int t = 9;
        arr = new int[] { 5, 25, 75 };
        t = 100;
        System.out.println(Arrays.toString(new LT0167_Two_Sum_II_Input_Array_is_sorted().Lt0167a(arr, t)));
    }

    
    // 1ms, most are [0, 1]ms
    // while i < j..... flag没有意义。。。 a,b ... m,n, a+n>t,a+m<t, b+m<t b+n==t...这无法成立，b>a,所以最后一个等式不能成立。
    // a+n>t的情况下，b+n>t必然成立，所以a+m<t时，不必再计算b+n和t的关系。
    private int[] Lt0167a(int[] numbers, int target)
    {
        
        int[] result = new int[2];
        
        int low = 0;
        int high = numbers.length - 1;
        int t = 0;
        boolean flag = false;
        while (true)
        {
            t = numbers[low] + numbers[high];
            if (t == target)
            {
                break;
            }
            
            if (t > target)
            {
                high--;
                flag = false;
                continue;
            }
            else
            {
                if (flag)
                {
                    high++;
                }
                else
                {
                    low++;
                }
                flag = true;
            }
        }
        result[0] = low + 1;
        result[1] = high + 1;
        return result;
        
    }
}
