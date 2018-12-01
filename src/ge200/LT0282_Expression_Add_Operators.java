package ge200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LT0282_Expression_Add_Operators
{

    public static void main(String[] args)
    {
        
    }

    
    
    
    // 看了discuss，递归，*的时候可以 前面的结果-x + x*y + 后面的结果-y;
    private List<String> Lt0282b(String num, int target)
    {
        List<String> ansList = new LinkedList<>();
        int i = 1;
        int len1 = num.length() - 1;
        int j = 0;
        while (i <= len1)
        {
//            for (j = 0; j < len1 - i; j++)
//            {
//                
//            }
//            i++;
            
            while (j < i)
            {
                
            }
        }
        
        
        return ansList;
    }
    
    
    
    // 没什么好方法，只能穷举。
    // 这个有最优子结构。比如"11"一共就只能产生那么几种可能。写个map<String, List<Integer/Long>>？
    // 穷举用递归好像不好写，只有最顶层才知道是否==target，不是最底层知道。
    // 有个问题，没有括号，所以需要先*，再其他。
    @Deprecated
    private List<String> Lt0282a(String num, int target)
    {
        List<String> ansList = new LinkedList<>();
        this.functiona1(num, target, ansList);
        return ansList;
    }
    
    private void functiona1(String num, int target, List<String> ansList)
    {
        Map<String, Map<String, Long>> map = new HashMap<>();
        this.recursiona3(num, 0, num.length() - 1, map);
        for (Map.Entry<String, Long> entry : map.get(num).entrySet())
        {
            if (entry.getValue() == target)
            {
                ansList.add(entry.getKey());
            }
        }
    }
    
    private void recursiona3(String num, int s, int e, Map<String, Map<String, Long>> map)       // 觉得会超时吧。
    {
        
        
        for (int i = s; i < e; i++)
        {
            
        }
        
    }
    
//    private void recursiona1(String num, int target, List<String> ansList)
//    {
//        
//    }
    
}
