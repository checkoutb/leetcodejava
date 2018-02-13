package gt000;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pojo.Interval;
import utils.LTUtils;

/**
 * 57. Insert Interval
 * */
public class LT0057 {

    public static void main(String[] args) {
        
        int[][] arr1 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[][] insert = { { 4, 9 } };
        
        arr1 = new int[][]{{1,3}, {6,9}};
        insert = new int[][]{{2,5}};
        
        System.out.println(Lt0057(LTUtils.convertIntArray2ListInterval(arr1), LTUtils.convertIntArray2ListInterval(insert).get(0)));
    }

    // beats 38%
    public static List<Interval> Lt0057(List<Interval> intervals, Interval newInterval)
    {
        
        List<Interval> result = new LinkedList<>();
        
        if(intervals.isEmpty())
        {
            result.add(newInterval);
            return result;
        }
        
        Iterator<Interval> ite = intervals.iterator();
        Interval val = null;
        
        int start = newInterval.start;
        int end = newInterval.end;
        
        int max = end;
        int min = start;
        
//        result.add(newInterval);
        boolean flag = true;
        
        if(start < intervals.get(0).start)
        {
            result.add(newInterval);
            flag = false;
        }
        
        while(ite.hasNext())
        {
            val = ite.next();
            
            if(val.end >= start && val.start <= end)
            {
                if(val.start < min)
                {
                    min = val.start;
                    newInterval.start = min;
                }
                if(val.end > max)
                {
                    max = val.end;
                    newInterval.end = max;
                }
                
                if(flag)
                {
                    result.add(newInterval);
                    flag = false;
                }
            }
            else
            {
                if(flag && val.end > end)
                {
                    result.add(newInterval);
                    flag = false;
                }
                result.add(val);
            }
        }
        
        if(flag)
        {
            result.add(newInterval);
            flag = false;
        }
        
        return result;
    }
}
