package ge100;

import java.util.List;

import utils.LTUtils;

/**
 * 120. Triangle
 * */
public class LT0120
{

    public static void main(String[] args)
    {
        List<List<Integer>> triangle = LTUtils.convertArrayArray2ListList(new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } });
        
        int[][] array = { { -1 }, { -2, -3 } };
        
        triangle = LTUtils.convertArrayArray2ListList(array);
        
        LTUtils.showListOfList(triangle);
        
        System.out.println(new LT0120().Lt0120(triangle));
    }

    // 42/43, timeout...
    @Deprecated
    private int Lt0120(List<List<Integer>> triangle)
    {
        int result = 0;
        
//        int sum3 = pretreatment(triangle);          // ... { { -1 }, { -2, -3 } }
        
//        System.out.println(sum3);
        
        int sum3 = 0;
        result = this.recursion(triangle, sum3, 1, 0, triangle.get(0).get(0));
        
        return result;
    }
    
    private int recursion(List<List<Integer>> triangle, int sum3, int rowIndex, int lastColIndex, int sum)
    {
//        if (sum3 <= sum)
//        {
//            return sum;
//        }
        if (rowIndex >= triangle.size())
        {
            return sum;
        }
        
//        System.out.println(rowIndex + ", " + triangle.size() + ", " + lastColIndex);
        
        List<Integer> ele = triangle.get(rowIndex);
        int total1 = this.recursion(triangle, sum3, rowIndex + 1, lastColIndex, sum + ele.get(lastColIndex));
        int total2 = this.recursion(triangle, sum3, rowIndex + 1, lastColIndex + 1, sum + ele.get(lastColIndex + 1));
        
        if (total1 < total2)
        {
            return total1;
        }
        else
        {
            return total2;
        }
    }
    
    // greedy
    private int pretreatment(List<List<Integer>> triangle)
    {
        List<Integer> ele = triangle.get(0);
        int index = 0;
        int min = ele.isEmpty() ? 0 : ele.get(0);
        for (int i = 1; i < ele.size(); i++)
        {
            if (ele.get(i) < min)
            {
                min = ele.get(i);
                index = i;
            }
        }
        int sum = min;
        for (int i = 1; i < triangle.size(); i++)
        {
            ele = triangle.get(i);
            if (ele.get(index) > ele.get(index + 1))
            {
                sum += ele.get(index + 1);
                index += 1;
            }
            else
            {
                sum += ele.get(index);
            }
        }
        return sum;
    }
}
