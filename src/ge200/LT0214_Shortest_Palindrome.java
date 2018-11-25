package ge200;

public class LT0214_Shortest_Palindrome
{

    public static void main(String[] args)
    {
        String[] arr1 = {"aacecaaa", "abcd"};
        
        LT0214_Shortest_Palindrome lt = new LT0214_Shortest_Palindrome();
        for (String s : arr1)
            System.out.println(lt.Lt0214a(s));
    }

    
    // 4 submissions: 372ms, timeout, timeout, 336ms...
    // 2ms: 
    /*
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == s.charAt(j)) { j += 1; }
    }
    if (j == s.length()) { return s; }
    String suffix = s.substring(j);
    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    */
    // shortestPalindrome是自己。
    // ...一个回文，某个位置插入一个字符，然后套用这段代码，是可以的。但不知道具体原理。。
    // abzqbdca
    // awsxswabzqbdca
    // j是把绝对不可能回文的子串分割出来。。wsxsw abqzbdca wsxsw
    
    private String Lt0214a(String s)
    {
        
        if (s == null || s.length() <= 1)
            return s;
        int i = s.length() - 1;
        char[] arr = s.toCharArray();
        for (; i >= 0; i--)
            if (isPalindrome(arr, 0, i))
                break;
        
//        String pre = "";
//        for (int j = i + 1, max = s.length(); j < max; j++)
//        {
//            pre = arr[j] + pre;
//        }
        
        StringBuilder sb = new StringBuilder(s.substring(i + 1)).reverse();     // 运行时间的误差有点大，改成这个以后，317,timeout,226...
        
        return sb.toString() + s;
//        return pre + s;
    }
    
    private boolean isPalindrome(char[] arr, int s, int e)
    {
        int mid = (s + e) / 2;
        int diff = mid - s;
        for (int i = 0; i <= diff; i++)
            if (arr[s + i] != arr[e - i])
                return false;
        return true;
    }
}
