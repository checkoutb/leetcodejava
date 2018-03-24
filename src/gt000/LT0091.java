package gt000;


/**
 * 91. Decode Ways
 * */
public class LT0091
{

    public static void main(String[] args)
    {
        // 3981312
        String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
        s = "0";
        s = "11";
        
        long time = System.nanoTime();          // 纳秒。10亿分之1秒
        System.out.println(Lt0091b(s));
        
//        System.out.println(System.nanoTime() - time);
        
//        System.out.println('A' + 'B');      // 131
    }

    // 看了2ms的代码，应该是个变种Fibonacci,应该是，看自己和前面一位，如果只有一种解码方式，那么总数不变
    // 如果有2种解码方式，那么就是前一位+前前一位的解码方式之和。。。大意就是这样。完全想不到。
    // 8ms, beats 7.3%
    public static int Lt0091b(String s)
    {
        if(s == null || s.length() <= 0)
        {
            return 0;
        }
        int result = 0;
        char[] chArr = s.toCharArray();
        if(chArr[0] == '0')
        {
            return 0;
        }
        result = 1;
        int i = 0;
        int len = s.length();
        int t = 1;
        int j = 0;
        
        for(i = 0; i < len; i++)
        {
            if(chArr[i] > 50)
            {
//                if(result == 0)
//                    result = 1;
                continue;
            }
            else
            {
                // 连续两个[3,9]
                for(j = i + 1; j < len; j++)
                {
                    if(chArr[j - 1] > 50 && chArr[j] > 50)
                    {
                        t = Recursion(s.substring(i, j).toCharArray(), 0);
//                        if(result == 0)
//                            result = t;
//                        else
                            result *= t;
                        break;
                    }
                }
                if(j >= len)            // ...
                {
                    t = Recursion(s.substring(i, j).toCharArray(), 0);
                    result *= t;
                }
                i = j;
            }
        }
//        if(i > j + 1)
//        {
//            t = Recursion()
//        }
        
        return result;
    }
    

    public static int Recursion(char[] s, int start)
    {
        if (start >= s.length)
        {
//            result++;
//            System.out.println(result + ", ");
            return 1;
        }
        int result = 0;
        int count = 0;
        
        int chInt = -1;
        for(int i = 1; i < 3; i++)
        {
            switch(i)
            {
            case 1:
                chInt = Integer.valueOf(String.valueOf(s[start]));          // 不写valueOf就是ascii码,还得转string，不然是valueOf(int )
                break;
            case 2:
                if(start + 1 < s.length)
                    chInt = Integer.valueOf(String.valueOf(s[start]) + s[start + 1]);
                break;
            }
            
            if(chInt >= 1 && chInt <= 26)
            {
                count = Recursion(s, start + i);
            }
            else
            {
                return result;
            }
            result += count;
            chInt = -1;
        }
        return result;
    }
    
    
    /**
     * 应该是要分割开来，毕竟[3,9]组成的string，必然唯一。其他就要判断有多少种方法，然后相乘。
     * */
    @Deprecated
    public static int Lt0091a(String s)
    {
        if(s == null || s.length() <= 0)
            return 0;
        
        int result = 0;
        
        char[] chArr = s.toCharArray();
        int i = 0;
        int len = s.length();
        int t = 0;
        
        for(i = 0; i < len; i++)
        {
            t = chArr[i] - 48;
            if(t > 2)
            {
                
            }
            else
            {
                if(t == 1)
                {
                    
                }
                else if(t == 2)
                {
                    
                }
            }
        }
        
        return result;
    }
    
    
    // 224/259 timeout...
    public static int Lt0091(String s)
    {
        if(s == null || s.length() <= 0)
            return 0;
        int result = 0;
        char[] chArr = s.toCharArray();
        result = Recursion(chArr, 0);
        
        return result;
    }
    
}
