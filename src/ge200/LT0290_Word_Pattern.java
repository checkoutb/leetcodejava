package ge200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LT0290_Word_Pattern
{

    public static void main(String[] args)
    {
        String[] pArr = {"abba","abba","aaaa","abba"};
        String[] strArr = {"dog cat cat dog","dog cat cat fish","dog cat cat dog","dog dog dog dog"};
        LT0290_Word_Pattern lt = new LT0290_Word_Pattern();
        
        for (int i = 0; i < pArr.length; i++)
        {
            System.out.println(lt.Lt0290a(pArr[i], strArr[i]));
        }
    }

    
    // 2ms. most are [1, 2]ms.
    private boolean Lt0290a(String pattern, String str)
    {
//        boolean ans = false;
        String[] arr = str.split(" ");
//        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        if (arr.length != pattern.length())
            return false;
        char ch;
        for (int i = 0; i < pattern.length(); i++)
        {
            ch = pattern.charAt(i);
            if (!map.getOrDefault(ch, arr[i]).equals(arr[i]))
            {
                return false;
            }
            if (!map.containsKey(ch))
            {
                if (map.containsValue(arr[i]))
                    return false;
                map.put(ch, arr[i]);
            }
        }
        return true;
    }
    
}
