package ge300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LT0301_Remove_Invalid_Parentheses
{

    public static void main(String[] args)
    {
        String[] arr1 = {"()())()","(a)())()",")(","()))((()"};
        LT0301_Remove_Invalid_Parentheses lt = new LT0301_Remove_Invalid_Parentheses();
        
        for (String s : arr1)
        {
            System.out.println(lt.Lt0301b(s));
        }
    }
    
    
    // 看了hint。
    // 33ms, most are [1, 7] U [56, 70]ms.
    // 递归时传递StringBuilder，而不是boolean[], 不要isValid，只要indexs，i，r就能判断是否添加到 结果。还有一个int代表最后一个是(还是)..
    private List<String> Lt0301b(String s)
    {
        List<String> list = new LinkedList<>();
        if (s == null || s.length() == 0)           // s == "n", so cannot <= 1...
        {
            if (s == null)
                return list;
            list.add("");
            return list;
        }
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = true;
        int i = 0;
        int l = 0;
        int r = 0;
        char[] chArr = s.toCharArray();
        int t1 = 0;
        for (i = 0; i < chArr.length; i++)
        {
            switch(chArr[i])
            {
            case '(':
                t1++;
                l++;
                break;
            case ')':
                t1--;
                l = l > 0 ? l - 1 : 0;
                if (t1 < r)
                    r = t1;
                break;
            default:
                break;
            }
        }
        r = 0 - r;
        this.recursionb1(chArr, arr, list, l, r, 0);
        return new ArrayList<>(new HashSet<>(list));
    }
    
    private void recursionb1(char[] chArr, boolean[] arr, List<String> list, int l, int r, int index)
    {
        if (l == 0 && r == 0)
        {
            if (isValid(chArr, arr))
            {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i])
                    {
                        sb.append(chArr[i]);
                    }
                }
                list.add(sb.toString());
            }
            return;
        }
        if (index >= chArr.length)
            return;
        
        switch (chArr[index])
        {
        case '(':
            if (l > 0)
            {
                arr[index] = false;
                this.recursionb1(chArr, arr, list, l - 1, r, index + 1);
                arr[index] = true;
            }
            this.recursionb1(chArr, arr, list, l, r, index + 1);
            break;
        case ')':
            if (r > 0)
            {
                arr[index] = false;
                this.recursionb1(chArr, arr, list, l, r - 1, index + 1);
                arr[index] = true;
            }
            this.recursionb1(chArr, arr, list, l, r, index + 1);
            break;
        default:
            this.recursionb1(chArr, arr, list, l, r, index + 1);
            break;
        }
        
    }
    
    private boolean isValid(char[] chArr, boolean[] arr)
    {
        int j = 0;
        for (int i = 0; i < chArr.length; i++)
        {
            if (arr[i])
            {
                switch (chArr[i])
                {
                case '(':
                    j++;
                    break;
                case ')':
                    j--;
                    if (j < 0)
                        return false;
                    break;
                default:
                    break;
                }
            }
        }
        return j == 0;
    }
    
    // (), 从头开始遍历，(的数量必须>=）的数量，当)多的时候，必须删除掉前面的某个)。
    // 再反序遍历，)的数量必须>=（。
    // 有字母，应该意味着 a(b 不能删除中间的 ( ? 先不管。
    @Deprecated
    private List<String> Lt0301a(String s)
    {
        List<String> list = new LinkedList<>();
        char[] chArr = s.toCharArray();
        int[] arr1 = new int[chArr.length];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int t1 = 0;
        for (i = 0; i < chArr.length; i++)
        {
            if (chArr[i] != '(' && chArr[i] != ')')
            {
                arr1[i] = Integer.MAX_VALUE;
                continue;
            }
            if (chArr[i] == '(')
            {
                arr1[i] = ++j;
            }
            if (chArr[i] == ')')
            {
                arr1[i] = --j;
            }
        }
        j = 0;
        t1 = 0;
        for (i = 0; i < arr1.length; i++)
        {
            if (arr1[i] < j)
            {
                
            }
        }
        
        
        return list;
    }
    
}
