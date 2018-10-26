package ge100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 128. Longest Consecutive Sequence
 * */
public class LT0128
{
    
    public static void main(String[] args)
    {
        int[][] arr = {{100, 4, 200, 1, 3, 2}, };
        
        LT0128 lt = new LT0128();
        for (int[] arr2 : arr)
        {
            System.err.println("........result : " + lt.Lt0128b(arr2));
        }
    }
    
    // 28ms... 肯定不是O(n)的。。差不多是O(nlogn)?
    // 看到一个O(n)的，不过比Arrays.sort的都慢。。主要是用了Set的原因吧。不过用了Set，就应该不能算是O(n)了吧。。不然我这也算O(n)..
    // 把所有的数放进set，for循环，对每个数都做2个while循环，一个--，一个++，看这些值是否存在，存在就长度++,且删除这个值。不存在就跳出while
    //                  然后和现有的最长值 Math.max一下。
    private int Lt0128b(int[] nums)
    {
        int result = 0;
        
        Helper2 helper2 = new Helper2();
        
        for (int num : nums)
        {
            helper2.insert(num);
        }
        result = helper2.max();
        return result;
    }
    
    class Helper2
    {
        List<Helper> list = new LinkedList<>();
        
        void insert(int num)
        {
            Helper helper = null;
            for (Helper h : list)
            {
                if ((num + 1) >= h.start && (num - 1) <= h.end)
                {
                    helper = h;
                    break;
                }
            }
            if (helper == null)
            {
                helper = new Helper();
                helper.start = num;
                helper.end = num;
                list.add(helper);
            }
            else
            {
                if (num + 1 == helper.start)
                {
                    helper.start = num;
                }
                else if (num - 1 == helper.end)
                {
                    helper.end = num;
                }
            }
            
            //
            Helper hpStart = null;
            Helper hpEnd = null;
            int start = helper.start;
            int end = helper.end;
            for (Helper h : list)
            {
                if (h == helper)
                {
                    continue;
                }
                if (h.start == end + 1)
                {
                    hpStart = h;
                }
                if (h.end == start - 1)
                {
                    hpEnd = h;
                }
                if (hpStart != null && hpEnd != null)
                {
                    break;
                }
            }
            
            if (hpStart != null)
            {
                int temp = hpStart.end;
                list.remove(hpStart);
                helper.end = temp;
            }
            if (hpEnd != null)
            {
                int temp = hpEnd.start;
                list.remove(hpEnd);
                helper.start = temp;
            }
//            System.out.println(list);
        }
        
        int max()
        {
            int max = 0;
            for (Helper h : list)
            {
                if (h.end - h.start + 1 > max)
                {
                    max = h.end - h.start + 1;
                }
            }
            return max;
        }
        
        class Helper
        {
            int start;
            int end;
            
            public String toString()
            {
                return "[" + start + ", " + end + "] ";
            }
        }
    }
    
    @Deprecated
    // O(n)....一/数遍完成，how???
    private int Lt0128a(int[] nums)
    {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        
        for (int num : nums)
        {
            if (numCountMap.containsKey(num))
            {
                
            }
            else
            {
                
            }
        }
        int result = 0;
        for (int count : numCountMap.values())
        {
            if (count > result)
            {
                result = count;
            }
        }
        return result;
    }
}
