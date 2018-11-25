package ge100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LT0187_Repeated_DNA_Sequences
{

    public static void main(String[] args)
    {
        // "AA AA AA AA AA A"
        String[] arr = {"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "AAAAAAAAAAAAA"};
        
        LT0187_Repeated_DNA_Sequences lt = new LT0187_Repeated_DNA_Sequences();
        for (String s : arr)
            System.out.println(lt.Lt0187b(s));
    }
    
    
    // 看了discuss，一个是双set(或者set，list)，一个set保存出现过的，然后每次会搜索这个set，是否已经出现过，出现过就加到结果中，没有出现过就加到set。
    //                  set.add(str),add会返回一个boolean，之前不存在过就是true，所以可以缩短代码。这个得双set。
    
    //      还有一个，对string做了转换，觉得有点画蛇添足？看不懂那个转换的意义。。
    //                 可能是 hashCode，String的hashCode 挺繁琐的(s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1])，for循环h = 31 * h + val[i];
    //                                 Integer的hashCode直接就是值。
    /*
    转换 for循环10次
    v <<= 2;
    v |= map[s.charAt(j) - 'A'];
    
    2个都是set，由于&&，所以第一次碰到的时候，第一个add返回true，!true，所以后半个不会执行，，
                    第二次碰到的时候，第一个add返回false,!false,第二个add执行返回true，这样就加到结果的list里去了。。
                    第三次碰到，后半个是false，不会添加到list。
    if(!words.add(v) && doubleWords.add(v))
    
    */
    
    
    
    // timeout.
    @Deprecated
    private List<String> Lt0187b(String s)
    {
        Set<String> set = new HashSet<>();
        String str = null;
        for (int i = 0; i < s.length() - 9; i++)
        {
            str = s.substring(i, i + 10);
            if (set.contains(str))
                continue;
            if (s.lastIndexOf(str) != i)
                set.add(str);
        }
        return new ArrayList<>(set);
    }
    
    // timeout, 31/32.
    @Deprecated
    private List<String> Lt0187a(String s)
    {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < s.length() - 9; i++)
            if (s.substring(i + 1).contains(s.substring(i, i + 10)))
                result.add(s.substring(i, i + 10));
        return new ArrayList<>(new HashSet<>(result));
    }
    
    
    
}
