package ge100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * */
public class LT0131
{

    public static void main(String[] args)
    {
        String[] arr = { "aab" };
        
        LT0131 lt = new LT0131();
        for (String str : arr)
        {
            System.out.println(lt.Lt0131a(str));
        }
    }

    // [start, end]回文的[start-n, end-n]子串必然也是回文，如果[start, start-n]是回文，那么[end-n, end]也是回文。
    // 最优子结构？。那就可以动态规划。。可惜，我只会穷举。。。
    // 看了几个代码，都是穷举递归，这个能动态规划？
    // 想到的是写一个map，key：字符+下标，value是List<Integer>,升序保存了以key为起始的所有可能的回文的最后一个字符的下标。
    // 计算可能的回文的时候，可以看前面的那些字符的回文。。。这步(看前面字符的回文来判断自己的回文)可能比直接递归更慢。。。
    
    // 7ms，most are [4, 10]ms
    private List<List<String>> Lt0131a(String s)
    {
        List<List<String>> listList = new LinkedList<>();
        if (s == null || s.length() == 0)
        {
            return listList;
        }
        List<String> list = new LinkedList<>();
        char[] arr = s.toCharArray();
        
        recursiona1(listList, list, arr, 0);
        
        return listList;
    }
    
    private void recursiona1(List<List<String>> ll, List<String> list, char[] arr, int s)
    {
        if (s >= arr.length)
        {
//            ll.add(list);     // 15ms
            
            ll.add(new ArrayList<>(list));
            
            return;
        }
//        List<String> list2 = null;
        for (int i = s; i < arr.length; i++)
        {
            if (isPalindrome(arr, s, i))
            {
                // 看其他人的代码后删除这段，这段是15ms。
//                list2 = new LinkedList<>(list);
//                list2.add(new String(arr, s, i - s + 1));
//                recursiona1(ll, list2, arr, i + 1);
                // 15ms 结束。
                
                list.add(new String(arr, s, i - s + 1));
                recursiona1(ll, list, arr, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(char[] arr, int s, int e)
    {
        if (arr[s] != arr[e])
        {
            return false;
        }
        int len = (e - s + 1) / 2;
        for (int i = 1; i < len; i++)
        {
            if (arr[s + i] != arr[e - i])
            {
                return false;
            }
        }
        return true;
    }
}
