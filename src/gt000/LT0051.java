package gt000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 51. N-Queens
 * */
public class LT0051 {

    public static void main(String[] args) {
        
        int n = 4;
        
        LTUtils.showList(new LT0051().Lt0051(n));
    }

    
    // beats 6.33%.
    // 不清楚 为什么 会产生重复的值，需要HashSet来过滤一遍。。。
    public List<List<String>> Lt0051(int n)
    {
        List<List<String>> result = new LinkedList<>();
        
        
        nQueue(null, n, result);
        
        return new LinkedList<>(new HashSet<>(result));
    }
    
    private void nQueue(List<String> part, int n, List<List<String>> result)
    {
        if(part == null)
        {
            part = new ArrayList<>(n);
        }
        if(part.size() == n)
        {
            result.add(part);
            return;
        }
        
        if(part.size() == 0)
        {
            for(int i = 0; i < n; i++)
            {
                char[] char2 = new char[n];
                for(int j = 0; j < n; j++)
                {
                    char2[j] = '.';
                }
                char2[i] = 'Q';
                
                String s = "";
                for(int j = 0; j < n; j++)
                {
                    s += char2[j];
                }
                
//                part.add(Arrays.toString(char2));
                
//                part.add(s);
                List<String> part2 = new ArrayList<>(n);
                part2.addAll(part);
                part2.add(s);
                nQueue(part2, n, result);
            }
        }
        
        char[][] chars = new char[n][part.size() + 1];
        for(int i = 0; i < part.size(); i++)
        {
            chars[i] = part.get(i).toCharArray();
        }
        boolean[] not = new boolean[n];
        for(int i = 0; i < part.size(); i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(chars[i][j] == 'Q')
                {
                    not[j] = true;
                    if(part.size() - i + j < n)
                    {
                        not[part.size() - i + j] = true;
                    }
                    if(j - (part.size() - i) >= 0)
                    {
                        not[j - (part.size() - i)] = true;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(!not[i])
            {
                char[] char2 = new char[n];
                for(int j = 0; j < n; j++)
                {
                    char2[j] = '.';
                }
                char2[i] = 'Q';
                String s = "";
                for(int j = 0; j < n; j++)
                {
                    s += char2[j];
                }
                
//                part.add(Arrays.toString(char2));
                
//                part.add(s);
                List<String> part2 = new ArrayList<>(n);
                part2.addAll(part);
                part2.add(s);
                
                nQueue(part2, n, result);
            }
        }
    }
}
