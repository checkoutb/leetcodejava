package gt000;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 39. Combination Sum
 * */
public class LT0039 {

    public static void main(String[] args) {
        
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        
        candidates = new int[]{1};
        target = 1;
        
        candidates = new int[]{2};
        target = 1;
        
        candidates = new int[]{1,2};
        target = 3;
        
        candidates = new int[]{2,3,5};
        target = 6;
        
        List<List<Integer>> result = Lt0039(candidates, target);
        
        LTUtils.showListOfList(result);
    }

    public static List<List<Integer>> Lt0039(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> part = null;
        
//        Collections.sort(candidates, new Comparator<Integer>(){
//            public int compare(Integer o1, Integer o2)
//            {
//                return o1.compareTo(o2);
//            }
//        });
        
//        Arrays.sort(candidates, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
        
        Arrays.sort(candidates);
        
//        if()
        int i = 0;
        int length = candidates.length - 1;
        for(i = length; i >= 0; i--)
        {
            if(candidates[i] <= target)
            {
                length = i;
                break;
            }
        }
        
        if(candidates[length] == target)
        {
            part = new LinkedList<>();
            part.add(target);
            result.add(part);
            length--;
        }
        
        int maxCount = target / candidates[0];
        
        
        
        int[] count = null;
        boolean flag = true;
        int j = 0;
        int sum = 0;
        for(i = 2; i <= maxCount; i++)
        {
            count = new int[i];
            flag = true;
            while(flag)
            {
                
                
                System.out.println(Arrays.toString(count));
                
                
                
                flag = false;
                for(j = 0; j < i; j++)          // ...
                {
                    System.out.print(j + ", ");
                    if(count[j] != length)
                    {
                        flag = true;
                        break;
                    }
                }
                
                sum = 0;
                
                
                
//                System.out.println(i + ", " + count.length);
                
                
                
                
                for(j = 0; j < i; j++)
                {
                    sum += candidates[count[j]];
                }
                if(sum == target)
                {
                    part = new LinkedList<>();
                    for(j = 0; j < i; j++)
                    {
                        part.add(candidates[count[j]]);
                    }
                    
//                    System.out.println(Arrays.toString(count));
                    
                    result.add(part);
                }
//                if(sum > target)
//                {
//                    break;
//                }
                for(j = i - 1; j >= 0; j--)
                {
                    if(count[j] < length)
                    {
                        if(j == 0)
                        {
                            count[j]++;
                            break;
                        }
                        else
                        {
                            if(count[j] >= count[j - 1])
                            {
                                count[j]++;
                                break;
                            }
                        }
                    }
                }
                
                
            }
        }
        
        
        
        
        return result;
    }
}


/*

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]


*/
