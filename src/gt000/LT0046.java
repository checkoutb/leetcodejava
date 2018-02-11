package gt000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 46. Permutations
 * */
public class LT0046 {

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4};
        
        LT0046 lt = new LT0046();
        
        LTUtils.showListOfList(lt.permute2(nums));
        
//        boolean bo[] = new boolean[2];            // false
//        System.out.println(Arrays.toString(bo));
        
//        List<Integer> list = new ArrayList<>(5);
//        System.out.println(list.size() + ", ");           // 0
        
    }

    
    
    
    // beats 24%
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        int len = nums.length;
        
        int[] used = new int[len];
        
        List<Integer> numsList = new ArrayList<>(nums.length);
        for(int num : nums)
        {
            numsList.add(num);
        }
        
        permuteRecursion2(null, numsList, result);
        
        return result;
    }
    
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
    
    // failed
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        int len = nums.length;
        int i = 0;
        boolean[] numsUsed = new boolean[len];
        List<Integer> list = null;
//        for(i = 0; i < len; i++)
//        {
//            list = new ArrayList<>(len);
//            numsUsed[i] = true;
//            list.add(i);
//            permuteRecursion(list, numsUsed);
//        }
        
        permuteRecursion(nums, numsUsed, list);
        
        
        return result;
    }
    
    private void permuteRecursion(int[] nums, boolean[] numsUsed, List<Integer> result)
    {
        boolean[] numsUsed2 = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            numsUsed2[i] = numsUsed[i];
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!numsUsed2[i])
            {
                numsUsed2[i] = true;
                if(result == null)
                {
                    result = new ArrayList<>(nums.length);
                }
                result.add(nums[i]);
                permuteRecursion(nums, numsUsed2, result);
            }
        }
        boolean flag = true;
        for(int i = 0; i < nums.length; i++)
        {
            if(!numsUsed2[i])
            {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            System.out.println(result);
            numsUsed2[0] = false;
        }
    }
    
}
