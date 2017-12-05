package gt000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import utils.LTUtils;

/**
 * 4Sum
 * */
public class LT0018 {

    public static void main(String[] args) {
        
        int[] s = {1, 0, -1, 0, -2, 2};
        int t = 0;

        s = new int[]{0,0,0,0};
        t = 1;
        
        s = new int[]{-3,-2,-1,0,0,1,2,3};
        t = 0;
        
        s = new int[]{0,0,0,0,0};

        s = new int[]{-1,0,1,2,-1,-4};
        t = -1;

//        QuickSort.quickSort(s, 0, s.length - 1);
//        LTUtils.showArray(s);
        
        LTUtils.showList(Lt0018c(s, t));
    }

    
    // beats 11%
    public static List<List<Integer>> Lt0018c(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        List<Integer> intList = new ArrayList<>();
        if(nums.length <= 3)
        {
            return result;
        }
        
        Arrays.sort(nums);
        
        int sum,i,j,k,m,n;
        int tar;
        int len3 = nums.length - 3;
        int len2 = nums.length - 2;
        int len1 = nums.length - 1;
        
        for(i = 0; i < len3; i++)
        {
            for(j = i+1; j < len2; j++)
            {
                n = len1;
                for(k = j+1; k < len1; k++)
                {
                    tar = target - nums[i] - nums[j] - nums[k];
                    for(m = n; m > k; m--)
                    {
                        if(nums[m] == tar)
                        {
                            intList.add(nums[i]);
                            intList.add(nums[j]);
                            intList.add(nums[k]);
                            intList.add(nums[m]);
                            if(!resultSet.contains(intList))
                            {
                                resultSet.add(intList);
                                result.add(intList);
                            }
                            intList = new ArrayList<>();
                            n = m;
                            break;
                        }
                        else
                        {
                            if(nums[m] < tar)
                            {
                                n = m;
                                break;
                            }
                            else                //......
                            {
                                n = m;
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
/*

copy from net. accepted...

        List<List<Integer>> st = new ArrayList<List<Integer>>();  
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();  
        if(nums.length <= 3) return st;  
          
        Arrays.sort(nums);  
        int sum;  
        for(int i = 0; i < nums.length - 3; i++){  
            for(int j = i + 1; j < nums.length - 2; j++ ){  //j要从i+1开始，否则会出现重复，并且hashset检测不出来  
                int low = j + 1;    //从j + 1开始  
                int high = nums.length - 1;  
                  
                while(low < high){  
                    sum = nums[i] + nums[j] + nums[low] + nums[high];  
                      
                    if(sum == target){  
                        ArrayList<Integer> a = new ArrayList<Integer>();  
                        a.add(nums[i]);  
                        a.add(nums[j]);  
                        a.add(nums[low]);  
                        a.add(nums[high]);  
                        if(!set.contains(a)){ //只会检测每一位都一模一样的 比如1,0,-1和-1, 0, 1就检测不出来  
                            set.add(a);  
                            st.add(a);  
                        }  
                        low ++;  
                        high --;  
                    }  
                    else{  
                        if(sum < target){  
                            low ++;  
                        }  
                        else{  
                            high --;  
                        }  
                    }  
                }  
            }  
        }  
        return st;  

*/

    
    // 281/282 limited time out.
    public static List<List<Integer>> Lt0018b(int[] nums, int target)
    {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> intList = new ArrayList<>();
        
        int len3 = nums.length - 3;
        int len2 = nums.length - 2;
        int len1 = nums.length - 1;

        int i,j,k,m,n;
        int tar;
        
        for(i = 0; i < len3; i++)
        {
            if(i > 0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(j = i+1; j < len2; j++)
            {
                if(nums[j]==nums[j-1] && j>i+1)
                {
                    continue;
                }
                n = len1;

                for(k = j+1; k < len1; k++)
                {
                    if(nums[k]==nums[k-1] && k>j+1)
                    {
                        continue;
                    }
                    tar = target - nums[i] - nums[j] - nums[k];
                    for(m = n; m > k; m--)
                    {
                        if(m < len1 && nums[m]==nums[m+1])
                        {
                            n=m;
                            continue;
                        }
                        if(nums[m] == tar)
                        {
                            intList.add(new Integer(nums[i]));
                            intList.add(new Integer(nums[j]));
                            intList.add(new Integer(nums[k]));
                            intList.add(new Integer(nums[m]));
                            result.add(intList);
                            intList = new ArrayList<>();
                            n=m;
                            break;
                        }
                        else if(nums[m] < tar)
                        {
                            n=m;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    
    
    // 245/282 limited time out...
    public static List<List<Integer>> Lt0018(int[] nums, int target)
    {
        QuickSort.quickSort(nums, 0, nums.length-1);
        
//        Arrays.sort(nums);
        
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> intList = new ArrayList<>();
        
        int i, j, k, m;
        int length = nums.length;
        for(i = 0; i < length; i++)
        {
            if(i > 0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(j = i+1; j < length; j++)
            {
                if(j > i+1 && nums[j] == nums[j-1])
                {
                    continue;
                }
                for(k = j+1; k < length; k++)
                {
                    if(k > j+1 && nums[k] == nums[k-1])
                    {
                        continue;
                    }
                    for(m = length-1; m > k; m--)
                    {
                        if(m < length-1 && nums[m] == nums[m+1])
                        {
                            continue;
                        }
//                        System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k] + ", " + nums[m]);
                        if(nums[i] + nums[j] + nums[k] + nums[m] == target)
                        {
//                            System.out.println(".... " + i + ", " + j + ", " + k + ", " + m);
                            intList.add(new Integer(nums[i]));
                            intList.add(new Integer(nums[j]));
                            intList.add(new Integer(nums[k]));
                            intList.add(new Integer(nums[m]));
                            result.add(intList);
                            intList = new ArrayList<>();
                        }
                    }
                }
            }
        }
        return result;
    }
}


class QuickSort
{
    public static void quickSort(int[] nums, int s, int e)
    {
        if(s >= e)
        {
            return;
        }
        int tag = nums[s];
        int i = s;
        int j = e;
        while(i < j)
        {
            while(i < j && nums[j] >= tag)
            {
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= tag)
            {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = tag;
        quickSort(nums, s, i-1);
        quickSort(nums, i+1, e);
    }

}



/*

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]



*/