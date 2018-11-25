package ge200;

public class LT0242_Valid_Anagram
{

    public static void main(String[] args)
    {
        String s = "anagram";
        String t = "nagaram";
        
        System.out.println(new LT0242_Valid_Anagram().Lt0242b(s, t));
    }

    // 2ms, most are [1, 9] U [17, 45]ms....前面没用HashMap，后面的用HashMap。
    // 
    /*  2ms
    int[] count = new int[26];
    for (char c: s.toCharArray()) {
        count[c-'a']++;
    }
    for (char c: t.toCharArray()) {
        if (--count[c-'a'] < 0){
            return false;   
        }
    }
    return s.length() == t.length();
    */
    
    /*  9ms
    char[] sArr = s.toCharArray();
    Arrays.sort(sArr);
    char[] tArr = t.toCharArray();
    Arrays.sort(tArr);

    return Arrays.equals(sArr, tArr);
    */
    // Arrays.equals
    
    private boolean Lt0242b(String s, String t)
    {
        if (s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] arr11 = new int[26];
        int[] arr22 = new int[26];
        
        for (char ch : arr1)
            arr11[ch - 'a']++;
        for (char ch : arr2)
            arr22[ch - 'a']++;
        for (int i = 0; i < 26; i++)
            if (arr11[i] != arr22[i])
                return false;
        return true;
    }
    
    // StringBuilder.reverse
    // 看错了，以为是倒序，结果是乱序。
    @Deprecated
    private boolean Lt0242a(String s, String t)
    {
        if (s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        for (int i = 0; i < s.length(); i++)
            if (arr1[i] != arr2[s.length() - i - 1])
                return false;
        return true;
    }
    
}
