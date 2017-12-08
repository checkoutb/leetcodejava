package gt000;


/**
 * Implement strStr() 
 * */
public class LT0028 {

    public static void main(String[] args) {
        
        String h = "hello";
        String n = "ll";
        h = "a";
        n = "a";
        h = "mississippi";
        n = "pi";
        
        System.out.println(Lt0028(h, n));
        
    }

    
    // beats 59.6%
    public static int Lt0028(String haystack, String needle)
    {
        if(haystack == null || needle == null || (haystack == "" && needle != ""))
        {
            return -1;
        }
        if(needle.length() == 0)
        {
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int len = haystack.length();
        int len2 = needle.length();
        int len1 = len-len2;
        if(len1 < 0)
        {
            return -1;
        }

        int k = 0;
        boolean flag = true;
        for(int j = 0; j <= len1; j++)              // <=...not <
        {
            if(hay[j] == need[0])
            {
                flag = true;
                for(k = 1; k < len2; k++)
                {
                    if(hay[j+k] == need[k])
                    {
                        continue;
                    }
                    else
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    return j;
                }
            }
        }
        
        return -1;
    }
    
}
