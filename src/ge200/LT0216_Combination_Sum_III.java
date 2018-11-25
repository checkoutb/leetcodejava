package ge200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LT0216_Combination_Sum_III
{

    public static void main(String[] args)
    {
        int[] kArr = {3,3};
        int[] nArr = {7,9};
        
        LT0216_Combination_Sum_III lt = new LT0216_Combination_Sum_III();
        for (int i = 0; i < kArr.length; i++)
        {
            System.out.println(lt.Lt0216a(kArr[i], nArr[i]));
        }
    }

    // 0ms, most are [0, 1]ms.
    // 基本全是递归.
    private List<List<Integer>> Lt0216a(int k, int n)
    {
        List<List<Integer>> result = new LinkedList<>();
        if (n > 45)
            return result;
        
        int[] arr = new int[k];
        for (int i = 1; i <= 9; i++)
        {
            arr[0] = i;
            this.recursiona1(k - 1, i, n - i, result, arr);
        }
        
        return result;
    }
    
    private void recursiona1(int k, int prev, int need, List<List<Integer>> result, int[] arr)
    {
        if ((need - prev * k) < 0)
            return;
        if (k == 0)
        {
            if (need == 0)
            {
                List<Integer> list = new ArrayList<>(arr.length);
                for (int i : arr)
                    list.add(i);
                result.add(list);
            }
            return;
        }
        
        for (int i = prev + 1; i <= 9; i++)
        {
            arr[k] = i;
            this.recursiona1(k - 1, i, need - i, result, arr);
        }
    }
}
