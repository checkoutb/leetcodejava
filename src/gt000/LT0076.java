package gt000;

import java.util.HashSet;
import java.util.Set;

/**
 * 76. Minimum Window Substring
 * */
public class LT0076 {

    public static void main(String[] args) {
        
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(Lt0076(s, t));
    }

    
    // 应该要用TreeMap按value排序
    public static String Lt0076a(String s, String t)
    {
        String result = "";
        char[] tChArr = t.toCharArray();
        char[] sChArr = s.toCharArray();
        boolean[] tBool = new boolean[tChArr.length];
        boolean[] sBool = new boolean[sChArr.length];
        
        int i = 0;
        int j = 0;
        
        int start = -1;
        int end = -1;
        
        int lenS = s.length();
        int lenT = t.length();
        
//        List<Integer> index = new LinkedList<>();
        
        Set<Character> tSet = new HashSet<>();
        for(i = 0; i < lenT; i++)
        {
            tSet.add(tChArr[i]);
        }
        
        for(i = 0; i < lenS; i++)
        {
            if(tSet.contains(sChArr[i]))
            {
                sBool[i] = true;
            }
        }
        
        for(i = 0; i < lenS; i++)
        {
            if(sBool[i])
            {
                if(start == -1)
                {
                    start = i;
                }
                
            }
        }
        
        
        
        
        
        
        return result;
    }
    
    
    public static String Lt0076(String s, String t)
    {
        String result = "";
        
        char[] tChArr = t.toCharArray();
        char[] sChArr = s.toCharArray();
        boolean[] tBool = new boolean[tChArr.length];
        
        
        int i = 0;
        int j = 0;
        int lenT = t.length();
        int lenS = s.length();
        char ch;
        
        int count = 0;
        int len = 0;
        
        int start = -1;
        int end = -1;
        
        Set<Character> tSet = new HashSet<>();
        for(i = 0; i < lenT; i++)
        {
            tSet.add(tChArr[i]);
        }
        
        for(i = 0; i < lenS; i++)
        {
            ch = sChArr[i];
            for(j = 0; j < lenT; j++)
            {
                if(tBool[j])
                {
                    continue;
                }
                if(tChArr[j] == ch)
                {
                    if(start == -1)
                    {
                        start = i;
                    }
                    tBool[j] = true;
                    count++;
                }
            }
            if(count == lenT)
            {
                break;
            }
        }
        end = i;
        
        if(count < lenT)
        {
            return "";
        }
        
        len = end - start;
        
        ch = sChArr[start];
        
        while(true)
        {
            for(; i < lenS; i++)
            {
                if(sChArr[i] == ch)
                {
                    end = i;
                    
                    for(j = start + 1; j < i; j++)
                    {
                        if(tSet.contains(sChArr[j]))
                        {
                            
                        }
                    }
                    
                    break;
                }
            }
            if(i >= lenS)
            {
                break;
            }
        }
        
        return result;
    }
    
}
