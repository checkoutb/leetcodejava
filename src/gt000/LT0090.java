package gt000;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utils.LTUtils;

/**
 * 90. Subsets II
 * */
public class LT0090
{

    public static void main(String[] args)
    {
        int[] nums = {1,1,2,2};
        
        LTUtils.showListOfList(Lt0090b(nums));
    }

    // 47ms..mostly are 4ms-5ms...
    public static List<List<Integer>> Lt0090b(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        List<Integer> list = null;
        int[] flag = new int[len];
        result.add(Collections.emptyList());
        
        for(i = 0; i < len; i++)
        {
            if(list == null)
                list = new LinkedList<>();
            list.add(nums[i]);
            if(result.contains(list))
            {
                list.clear();
                continue;
            }
            else
            {
                result.add(list);
                flag[i] = 1;
                Recursion3(1, list, result, flag, nums);
                list = null;
            }
        }
        
        return result;
    }
    
    // 数组也是址传递。
    public static void Recursion3(int i2, List<Integer> list, List<List<Integer>> result, int[] flag, int[] nums)
    {
        int len = nums.length;
        
//        if(list.size() == 1 && list.contains(2))
//        {
//            System.out.println("debug");
//        }
        
        int flag2[] = new int[flag.length];
        for(int i = 0; i < len; i++)
        {
            flag2[i] = flag[i];
        }
        int max = list.get(list.size() - 1);            //
//        if(i2 > len)
//        {
//            return;
//        }
        List<Integer> list2 = null;
        for(int i = 0; i < len; i++)
        {
            if(flag[i] == 1)
            {
                continue;
            }
            if(nums[i] < max)               //
            {
                continue;
            }
            if(list2 == null)
                list2 = new LinkedList<>(list);
            list2.add(nums[i]);
            if(result.contains(list2))
            {
                list2.remove(i2);
                continue;
            }
            else
            {
                result.add(list2);
                flag2[i] = 1;
                Recursion3(i2 + 1, list2, result, flag2, nums);
                list2 = null;           //
            }
        }
    }
    
    // failed
    @Deprecated
    public static List<List<Integer>> Lt0090a(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        
        int len = nums.length;
        int i = 0;
        result.add(Collections.emptyList());
        List<Integer> list = null;
        
        
        Map<Integer, Integer> map = new HashMap<>();
//        int i = 0;
        
        for(i = 0; i < len; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], (map.get(nums[i])) + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        
        int[][] numOfEle = new int[map.keySet().size()][2]; 
        i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            numOfEle[i][0] = entry.getKey();
            numOfEle[i][1] = entry.getValue();
            i++;
        }
        
        int lenOfEle = numOfEle.length;
        
        for(i = 0; i < lenOfEle; i++)
        {
            list = new LinkedList<>();
            list.add(numOfEle[i][0]);
//            if(!result.contains(list))
            {
                result.add(list);
                numOfEle[i][1]--;
                Recursion2(result, numOfEle);
            }
        }
        
        return result;
    }
    
    public static void Recursion2(List<List<Integer>> result, int[][] numOfEle)
    {
        
    }
    
    // failed
    @Deprecated
    public static List<List<Integer>> Lt0090(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        
        for(i = 0; i < len; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], (map.get(nums[i])) + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        
        Recursion(result, map);
        
        return result;
    }
    
    public static void Recursion(List<List<Integer>> result, Map<Integer, Integer> map)
    {
//        int key = 0;
//        int value = 0;
        boolean flag = true;
        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 0)
            {
                list.add(entry.getKey());
                if(result.contains(list))
                {
                    list.remove(entry.getKey());
                }
                else
                {
                    flag = false;
                    result.add(list);
                    Recursion(result, map);
                }
            }
        }
        if(flag)
        {
            return;
        }
    }
}
