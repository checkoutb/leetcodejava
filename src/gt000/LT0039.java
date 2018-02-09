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
        int length = candidates.length;
        for(i = length - 1; i >= 0; i--)
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
        
//        if()
        
        
        
        
        
        
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
