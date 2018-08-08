package gt000;


/**
 * 97. Interleaving String
 * */
public class LT0097
{

    public static void main(String[] args)
    {
        String[][] strArr = {{"aabcc","dbbca","aadbbcbcac"},{"aabcc","dbbca","aadbbbaccc"}};
        
        for(int i = 0; i < strArr.length; i++)
        {
            System.out.println(Lt0097(strArr[i][0], strArr[i][1], strArr[i][2]));
        }
        
    }

    // 1261ms.......
    public static boolean Lt0097(String s1, String s2, String s3)
    {
        if(s1.length() + s2.length() != s3.length())
        {
            return false;
        }
        
        boolean result = true;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        
        result = recursion(ch1, ch2, ch3, 0, 0, 0);
        
        return result;
    }
    
    private static boolean recursion(char[] ch1, char[] ch2, char[] ch3, int x1, int x2, int x3)
    {
        boolean result = false;
        if((x1 + x2) >= ch3.length)
        {
            return true;
        }
        
        if(x1 < ch1.length && ch1[x1] == ch3[x3])
        {
            result = recursion(ch1, ch2, ch3, x1 + 1, x2, x3 + 1);
            if(result)
            {
                return result;
            }
        }
        
        if(x2 < ch2.length && ch2[x2] == ch3[x3])
        {
            result = recursion(ch1, ch2, ch3, x1, x2 + 1, x3 + 1);
            if(result)
            {
                return result;
            }
        }
        
        return false;
    }
    
}
