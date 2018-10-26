package ge100;

import java.util.Arrays;

/**
 * 125. Valid Palindrome
 * */
public class LT0125
{

    public static void main(String[] args)
    {
        String[] strArr = {"A man, a plan, a canal: Panama", "race a car"};
        
        LT0125 lt = new LT0125();
        for (String str : strArr)
        {
             System.out.println(".....result : " + lt.Lt0125(str));
        }
    }
    
    private final char Empty_Flag = ' ';

    // 7ms, most are [4, 7]ms
    // 看到一种解法， 不修改s，直接首尾指针读到各自的下一个字母数字，对比且2个指针移位。这样的话，如果一个超长string，第一个字母就不是回文，可以减少很多时间。
    // 读到各自的下一个字母数字，现在想来有2种：看到的是，for(){if指针1是否 不 指向字母数字{移动} else if指针2是否 不是 字母数字{移动} else 对比2个指针是否回文}
    // 想到的另一种是：for(){ for{找到指针1的下一个位置，} for{找到指针2的下一个位置} 对比}
    private boolean Lt0125(String s)
    {
        boolean result = true;
        char[] arr = s.toCharArray();
        arr = this.convertToAlphanumericIngorecase(arr);
        
//        System.out.println(Arrays.toString(arr));
        
        result = this.isPalindrome(arr);
        return result;
    }
    
    private boolean isPalindrome(char[] arr)
    {
        int i = 0;
        int last = arr.length - 1;
        int max = arr.length / 2;
        for (; i < max; i++)
        {
            if (arr[i] != arr[last - i])
            {
                return false;
            }
        }
        return true;
    }
    
    private char[] convertToAlphanumericIngorecase(char[] arr)
    {
        int i = 0;
        int j = 0;
        char ch;
        for (; i < arr.length; i++)
        {
            if ((ch = this.ignorecase(arr[i])) != this.Empty_Flag)
            {
                arr[j++] = ch;
            }
        }
        return Arrays.copyOf(arr, j);
    }

    private char ignorecase(char ch)
    {
        if (Character.isDigit(ch))
        {
            return ch;
        }
        if (Character.isAlphabetic(ch))
        {
            return Character.toLowerCase(ch);
        }
        return this.Empty_Flag;
    }
}
