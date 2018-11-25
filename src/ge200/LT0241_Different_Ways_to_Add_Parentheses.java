package ge200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LT0241_Different_Ways_to_Add_Parentheses
{

    public static void main(String[] args)
    {
        String[] arr = {"2-1-1", "2*3-4*5"};
        LT0241_Different_Ways_to_Add_Parentheses lt = new LT0241_Different_Ways_to_Add_Parentheses();
        for (String s : arr)
            System.out.println(lt.Lt0241a(s));
    }

    
    // 3ms, [1, 5]ms.
    /*  1ms, 动态规划。。。
    List<Integer>[][] memo = new ArrayList[input.length() + 1][input.length() + 1];
    ...
    if(memo[start][end] != null){
        return memo[start][end];
    }
    */
    private List<Integer> Lt0241a(String input)
    {
        int[] arr = this.pretreatmenta1(input);
        return this.recursiona2(arr, 0, arr.length - 1);
    }
    
    private int[] pretreatmenta1(String s)
    {
        char[] arr = s.toCharArray();
        int[] ans = new int[s.length()];
        int i = 0;
        char ch = '\0';
        int num = 0;
        for (int j = 0; j < s.length(); j++)
        {
            ch = arr[j];
            switch (ch)
            {
            case '+':
                ans[i++] = 1;
                break;
            case '-':
                ans[i++] = 2;
                break;
            case '*':
                ans[i++] = 3;
                break;
            default:
                num = ch - '0';
                for (j++; j < s.length(); j++)
                {
                    if (Character.isDigit(arr[j]))
                        num = num * 10 + (arr[j] - '0');
                    else
                        break;
                }
                j--;
                ans[i++] = num;
                break;
            }
        }
        return Arrays.copyOf(ans, i);
    }
    
    // 看了Discuss。。。
    private List<Integer> recursiona2(int[] arr, int s, int e)
    {
        List<Integer> list = new LinkedList<>();
        if (s == e)
        {
            list.add(arr[s]);
            return list;
        }
        List<Integer> left = null;
        List<Integer> right = null;
        for (int i = s + 1; i < e; i += 2)
        {
            left = this.recursiona2(arr, s, i - 1);
            right = this.recursiona2(arr, i + 1, e);
            for (int le : left)
                for (int ri : right)
                {
                    switch (arr[i])
                    {
                    case 1:
                        list.add(le + ri);
                        break;
                    case 2:
                        list.add(le - ri);
                        break;
                    case 3:
                        list.add(le * ri);
                        break;
                    }
                }
        }
        return list;
    }
    
    @Deprecated
    private void recursiona1(int[] arr, int[] flag, Set<Integer> set, int now, int max)
    {
        if (now == max)
        {
            for (int i = 1; i < max; i++)
            {
                
            }
        }
        for (int i = 1; i < flag.length; i += 2)
        {
            if (flag[i] != 0)
            {
                flag[i] = now;
                recursiona1(arr, flag, set, now + 1, max);
                flag[i] = 0;
            }
        }
    }
    
}
