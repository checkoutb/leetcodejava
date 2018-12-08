package ge300;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LT0303_Range_Sum_Query_Immutable
{

    public static void main(String[] args)
    {
        
    }

    
    
    
}


@Deprecated         // 15/16 timeout.
class LT0303a
{
    class NumArray {
        
        private int[] arr;
        
        private Map<Integer, Map<Integer, Integer>> mapMap;
        
        public NumArray(int[] nums) {
            this.arr = nums;
//            this.mapMap = new TreeMap<>((k1, k2) -> k1 == k2 ? 0 : k1 > k2 ? -1 : 1);
            this.mapMap = new TreeMap<>(Collections.reverseOrder());
        }
        
        public int sumRange(int i, int j) {
            Map<Integer, Integer> map = mapMap.getOrDefault(i, new HashMap<>());
            Integer ss = map.get(j);
            if (ss != null)
                return ss;
            int sum = 0;
            int ii = i - 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if (entry.getKey() <= j)
                {
                    ii = entry.getKey();
                    sum = entry.getValue();
                    break;
                }
            }
            for (ii++; ii <= j; ii++)
            {
                sum += arr[ii];
            }
            return sum;
        }
    }
}


// 790ms. beats 10%. most are [111,266]ms.
/*  
private int[] sums;
public NumArray(int[] nums) {
    sums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        if (i == 0)
            sums[i] = nums[i];
        else {
            sums[i] = sums[i - 1] + nums[i];
        }
    }
}
public int sumRange(int i, int j) {
    if (i > 0)
        return sums[j] - sums[i - 1];
    
    return sums[j - i];
}
*/

/*  
int res[];
public NumArray(int[] nums) {
    res = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        res[i+1] = res[i] + nums[i];
    }
}
public int sumRange(int i, int j) {
    return res[j+1] - res[i];
}
*/
// .....

class NumArray {
    
    private int[] arr;
    
    public NumArray(int[] nums) {
        this.arr = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int ii = i; ii <= j; ii++)
        {
            sum += arr[ii];
        }
        return sum;
    }
}