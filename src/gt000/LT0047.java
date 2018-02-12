package gt000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import utils.LTUtils;

/**
 * 47. Permutations II
 * */
public class LT0047 {

    public static void main(String[] args) {
        
        int[] nums = {1,1,2};
        
        LTUtils.showListOfList(new LT0047().Lt0047a(nums));
        
        
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(2);
//        
//        List<Integer> list2 = new ArrayList<>();
////        list2.addAll(list1);
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//        list2.add(2);
//        
////        Set<List<Integer>> 
//        System.out.println(list1.hashCode() + ", " + list2.hashCode());         // same
//        
//        Set<List<Integer>> set = new HashSet<>();
//        set.add(list2);
//        set.add(list1);
//        System.out.println(set + "\n" + set.size());          // 1
        
    }

    
    
    // beats 6.11%...used 169ms, most of others is 6ms-11ms....how they did it?....
    public List<List<Integer>> Lt0047a(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        
        boolean[] ifUsed = new boolean[nums.length];
        
        
        permuteRecursion2(nums, ifUsed, null, result);
        
//        LTUtils.showListOfList(result);
        
        return new ArrayList<>(new HashSet<>(result));
    }
    
    private void permuteRecursion2(int[] nums, boolean[] ifUsed, List<Integer> used, List<List<Integer>> result)
    {
        int i = 0;
        int len = nums.length;
        if(used == null)
        {
            used = new ArrayList<>(len);
        }
        if(used.size() == len)
        {
            result.add(used);
        }
        boolean[] ifUsed2 = new boolean[len];
        List<Integer> used2 = null;
        int j = 0;
        
        for(i = 0; i < len; i++)
        {
            if(!ifUsed[i])
            {
//                ifUsed[i] = true;
//                used.add(nums[i]);
                
                used2 = new ArrayList<>(len);
                used2.addAll(used);
                used2.add(nums[i]);
                
                for(j = 0; j < len; j++)
                {
                    ifUsed2[j] = ifUsed[j];
                }
                ifUsed2[i] = true;
                
                permuteRecursion2(nums, ifUsed2, used2, result);
            }
        }
        
    }
    
    
    
    
    
    
    
    // failed
    public List<List<Integer>> Lt0047(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        
//        List<Integer> not = new ArrayList<>(nums.length);
        
//        for(int i : nums)
//        {
//            not.add(i);
//        }
        
//        permuteRecursion(result, null, not);
        
        
        int len = nums.length;
        
        int[] used = new int[len];
        
        List<Integer> numsList = new ArrayList<>(nums.length);
        for(int num : nums)
        {
            numsList.add(num);
        }
        
        permuteRecursion2(null, numsList, result);
        
        
        
        
        return new LinkedList<>(new HashSet<>(result));
    }
    
    // failed
    private void permuteRecursion2(List<Integer> used, List<Integer> not, List<List<Integer>> result)
    {
        if(used == null)
        {
            used = new ArrayList<>();
        }
        
        if(not.size() == 0)
        {
//            System.out.println(used);
            result.add(used);
        }
        
        for(Integer in : not)
        {
            List<Integer> used2 = new ArrayList<>(used.size() + 1);         // 都要放里面。。
            used2.addAll(used);
            used2.add(in);
            List<Integer> not2 = new ArrayList<>(not.size());
            for(Integer in2 : not)
            {
                if(in != in2)
                {
                    not2.add(in2);
                }
            }
            permuteRecursion2(used2, not2, result);
        }

    }
    
//    public static void permuteRecursion(Set<List<Integer>> result, List<Integer> used, List<Integer> not)
//    {
//        if(used == null)
//        {
//            used = new ArrayList<>(not.size());
//        }
//        
//        for(Integer i : not)
//        {
//            
//        }
//        
//    }
}


/*

[1,1,2] have the following unique permutations:

[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/