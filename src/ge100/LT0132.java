package ge100;

/**
 * 132. Palindrome Partitioning II
 * */
public class LT0132
{

    public static void main(String[] args)
    {
        String[] arr = { "aab", "aaabaa" };
        
        LT0132 lt = new LT0132();
        for (String str : arr)
        {
            System.out.println(lt.Lt0132a(str));
        }
    }
    
    
    // 28/29 error...没有思路。错误的那个返回281,答案是273,这个都不好找划分的差别是哪几个。。
    // 可能是一个/多个连续字符 被左/右回文共用，这种情况下要做出选择。。。。不知道怎么选择啊。
    
    // 看了网上的解法，用一个二维数组来保存行数-列数是否是一个回文。
    // 网上是双重循环，这里只是正向，反向2次。。。且网上用一个数组来保存该列到最后最小的划分次数。
    @Deprecated
    private int Lt0132a(String s)
    {
        
        int result = 0;
        if (s == null || s.length() == 0)
        {
            return result;
        }
        
        int[] arr2 = this.pretreatmenta1(s.toCharArray());
        int temp = arr2[0];
        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] > temp)
            {
                result++;
                temp = arr2[i];
            }
        }
        
        arr2 = this.pretreatmenta1(new StringBuffer(s).reverse().toString().toCharArray());
        temp = arr2[0];
        int temp2 = 0;
        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] >temp)
            {
                temp2++;
                temp = arr2[i];
            }
        }
        if (temp2 < result)
        {
            result = temp2;
        }
        return result;
    }
    
    private int[] pretreatmenta1(char[] arr)
    {
        int[] arr2 = new int[arr.length];
        int last = 0;
        for (int i = 0; i < arr.length; i++)
        {
            last = this.findLangestPalindromea(arr, i);
            for (int j = i; j <= last; j++)
            {
                arr2[j] = last;
            }
            i = last;
        }
        
        return arr2;
    }
    
    private int findLangestPalindromea(char[] arr, int s)
    {
        for (int i = arr.length - 1; i > s; i--)
        {
            if (isPalindrome(arr, s, i))
            {
                return i;
            }
        }
        return s;
    }
    
    private boolean isPalindrome(char[] arr, int s, int e)
    {
        int len = (e - s + 1) / 2;
        for (int i = 0; i < len; i++)
        {
            if (arr[s + i] != arr[e - i])
            {
                return false;
            }
        }
        return true;
    }
    
}
