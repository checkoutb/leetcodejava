package gt000;


/**
 * 58. Length of Last Word
 * */
public class LT0058 {

    public static void main(String[] args) {
        
        String s = "Today is a nice day";
        
        System.out.println(Lt0058a(s));
        
    }
    
    
    // beats 39%
    public static int Lt0058a(String s)
    {
        int result = 0;
        if(s == null || s.length() == 0)
        {
            return result;
        }
        
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int max = 0;
        
        for(int i = 0; i < len; i++)
        {
            if(chArr[i] == ' ')
            {
                if(max != 0)
                {
                    result = max;
                }
                max = 0;
            }
            else
            {
                max++;
            }
        }
        
        if(max != 0)
        {
            result = max;
        }
        
        return result;
    }

    // failed
    // ... return the longest length of string's words...not lenth of last...
    public static int Lt0058(String s)
    {
        int result = 0;
        if(s == null || s.length() == 0)
        {
            return result;
        }
        
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int max = 0;
        
        for(int i = 0; i < len; i++)
        {
            if(chArr[i] == ' ')
            {
                if(max > result)
                {
                    result = max;
                }
                max = 0;
            }
            else
            {
                max++;
            }
        }
        
        if(max > result)
        {
            result = max;
        }
        
        return result;
    }
}
