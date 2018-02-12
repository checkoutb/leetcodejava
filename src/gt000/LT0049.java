package gt000;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.LTUtils;

/**
 * 49. Group Anagrams
 * */
public class LT0049 {

    public static void main(String[] args) {
        
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        LTUtils.showList(new LT0049().Lt0049a(strs));
        
    }

    // 看了答案，Arrays.sort(ca);。。。是对每个str先排序，这样能保证乱序的str就是一样的了。。。
    // 第二个答案是，26个元素的数组来保存对应的26个字母的出现次数。然后作为特征值。。tmd，没看见最下面的All inputs will be in lower-case.
    // beats 3.92%...
    public List<List<String>> Lt0049a(String[] strs)
    {
        List<List<String>> result = new LinkedList<>();
        
        int len = strs.length;
//        int[][] sums = new int[len][2];
        char[] chars = null;
//        char[] chars2 = null;
        int i = 0;
        int j = 0;
        int sum = 0;
//        int sumIndex = 0;
        int len2 = 0;
        int k = 0;
//        List<String> part = null;
        Map<Character, Integer> map = new TreeMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        Integer temp = null;
        
        String[] eigen = new String[len];
        StringBuilder sb = new StringBuilder();
        
        for(i = 0; i < len; i++)
        {
            map.clear();
            chars = strs[i].toCharArray();
            len2 = chars.length;
            for(j = 0; j < len2; j++)
            {
                if(map.containsKey(chars[j]))
                {
                    temp = map.get(chars[j]);
                    temp++;
                    map.put(chars[j], temp);
                }
                else
                {
                    map.put(chars[j], 1);
                }
            }
            
            sb.delete(0, sb.length());
            for(Map.Entry<Character, Integer> entry : map.entrySet())
            {
                sb.append(entry.getKey()).append(entry.getValue());
            }
            eigen[i] = sb.toString();
        }
        
        for(i = 0; i < len; i++)
        {
            if(!map2.containsKey(eigen[i]))
            {
                map2.put(eigen[i], new LinkedList<String>());
            }
            map2.get(eigen[i]).add(strs[i]);
        }
        
        result.addAll(map2.values());
        
        return result;
    }
    
    
    // failed.
    public List<List<String>> Lt0049(String[] strs)
    {
        List<List<String>> result = new LinkedList<>();
        
        int len = strs.length;
        int[][] sums = new int[len][2];
        char[] chars = null;
        char[] chars2 = null;
        int i = 0;
        int j = 0;
        int sum = 0;
        int sumIndex = 0;
        int len2 = 0;
        int k = 0;
        List<String> part = null;
        
        for(i = 0; i < len; i++)
        {
            sums[i][0] = i;
        }
        
        for(i = 0; i < len; i++)
        {
            sum = 0;
            chars = strs[i].toCharArray();
            len2 = chars.length;
            for(j = 0; j < len2; j++)
            {
                sum += chars[j];
            }
            sums[i][1] = sum;
        }
        
        
//        LTUtils.showArrayOfArrayOneRowOneLine(sums);
        
        
        sort(sums, 0, len - 1);
        
        
//        LTUtils.showArrayOfArrayOneRowOneLine(sums);
        
//        sum = sums[0][1];
//        sumIndex = sums[0][0];
        i = 0;
        while(i < len)
        {
            j = i + 1;
            sum = sums[i][1];
            
            part = new LinkedList<>();
            result.add(part);
            
            while(j < len)
            {
                if(sums[j][1] != sum)
                {
                    break;
                }
                j++;
            }
//            j--;        // [i, j] are same
            
            if(i + 1 != j)
            {
                for(k = i; k < j; k++)      // [i,j)
                {
                    
                }
            }
            else
            {
//                part.add(e)
            }
            
            i = j;
        }
        
        return result;
    }
    
    private void sort(int[][] sums, int left, int right)
    {
        if(left >= right)
            return;
        
        int pivot = sums[right][1];
        int tail = left;
        int t1 = 0;
        int t2 = 0;
        
        for(int i = left; i < right; i++)
        {
            if(sums[i][1] <= pivot)
            {
                t1 = sums[i][0];
                t2 = sums[i][1];
                sums[i][0] = sums[tail][0];
                sums[i][1] = sums[tail][1];
                sums[tail][0] = t1;
                sums[tail][1] = t2;
                tail++;
            }
        }
        t1 = sums[right][0];
        t2 = sums[right][1];
        sums[right][0] = sums[tail][0];
        sums[right][1] = sums[tail][1];
        sums[tail][0] = t1;
        sums[tail][1] = t2;
        
        sort(sums, left, tail - 1);
        sort(sums, tail + 1, right);
        
    }
    
}


/*

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*/