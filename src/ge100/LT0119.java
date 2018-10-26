package ge100;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * */
public class LT0119
{

    public static void main(String[] args)
    {
        int rowIndex = 5;
        System.out.println(new LT0119().Lt0119(rowIndex));
    }

    // 0ms... zhege gongshi you dian diao.
    private List<Integer> Lt0119(int rowIndex)
    {
        List<Integer> result = new ArrayList<>(++rowIndex);
        long s = 1;
        result.add(1);
        
        for (int j = 1; j <= rowIndex - 2; j++)
        {
            result.add((int)(s = (rowIndex - j) * s / j));
        }
        
        if (rowIndex > 1)
        {
            result.add(1);
        }
        return result;
    }
}
