package gt000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pojo.Interval;
import utils.LTUtils;

/**
 * 56. Merge Intervals
 * */
public class LT0056 {

    public static void main(String[] args) {

        int[][] array = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        
        array = new int[][]{{1,4},{0,4}};
        
        LTUtils.showList(Lt0056(LTUtils.convertIntArray2ListInterval(array)));
        
    }

    // beats 54%
    public static List<Interval> Lt0056(List<Interval> intervals)
    {
        if(intervals.isEmpty())
        {
            return Collections.emptyList();
        }
        
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval t1, Interval t2)
            {
                return Integer.compare(t1.start, t2.start);
            }
        });
        
        
        List<Interval> result = new ArrayList<>();
        int len = intervals.size();
        int max = 0;
        int min = 0;
        Interval val = null;
        
        val = intervals.get(0);
        for(int i = 0; i < len;)
        {
//            val = intervals.get(i);
            min = val.start;
            max = val.end;
            
            for(i++; i < len;)
            {
                val = intervals.get(i);
                if(val.start >= min && val.start <= max)
                {
                    if(val.end > max)
                    {
                        max = val.end;
                    }
                    i++;
                }
                else
                {
                    break;
                }
            }
            result.add(new Interval(min, max));
        }
        
        
        return result;
    }
}



/*

Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 

*/