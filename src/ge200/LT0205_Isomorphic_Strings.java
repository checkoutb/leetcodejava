package ge200;

import java.util.HashMap;
import java.util.Map;

public class LT0205_Isomorphic_Strings
{

    public static void main(String[] args)
    {
        String s = "egg";
        String t = "add";
        
        System.out.println(new LT0205_Isomorphic_Strings().Lt0205a(s, t));
        
    }

    // 32ms, most are [2, 22]ms
    // 2ms：用2个char[]做一个转换，第一次都是零，然后把string里的char(char能默认转int)作为下标，保存的是另一个string里的char。
    /*
    for(int i=0; i<s.length(); i++){
        char sChar = sStr[i];
        char tChar = tStr[i];
        if(sm[sChar]==0 && tm[tChar]==0){
            sm[sChar] = tChar;
            tm[tChar] = sChar;
        }
        else{
            if(sm[sChar]!=tChar || tm[tChar]!=sChar) return false;
        }      
    }
    return true;
    */
    
    private boolean Lt0205a(String s, String t)
    {
        
        if (s == t)
            return true;
        if (s.length() != t.length())
            return false;
        
        int len = s.length();
        StringBuilder ss = new StringBuilder(len);
        StringBuilder tt = new StringBuilder(len);
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Integer tag = 0;
        for (int i = 0; i < len; i++)
        {
            if ((tag = map.get(chs[i])) == null)
            {
                map.put(chs[i], (tag = map.size() + 1));
            }
            ss.append(tag);
        }
        map.clear();
        for (int i = 0; i < len; i++)
        {
            if ((tag = map.get(cht[i])) == null)
                map.put(cht[i], (tag = map.size() + 1));
            tt.append(tag);
        }
        return tt.toString().equals(ss.toString());
    }
}
