package ge100;

import java.util.HashMap;
import java.util.Map;

public class LT0166_Fraction_to_Recurring_Decimal
{

    public static void main(String[] args)
    {
        int[][] arr = { { 1, 2 }, { 2, 1 }, { 4, 3 }, { 1, 11 }, { 7, -12 }, { -1, -2147483648 }, { -2147483648, -1 } };
        
        System.out.println(-2147483648 >= 0);
        
        LT0166_Fraction_to_Recurring_Decimal lt = new LT0166_Fraction_to_Recurring_Decimal();
        for (int[] arr2 : arr)
        {
            System.out.println(lt.Lt0166a(arr2[0], arr2[1]));
        }
    }

    // 8ms, most are [3, 5]ms.
    // 方法都差不多，应该是StringBuilder 和 String 连接字符串效率的问题。..而且StringBuilder有insert.
    private String Lt0166a(int numerator, int denominator)
    {
        
        long numerator2 = numerator;
        long denominator2 = denominator;
        if (numerator2 % denominator2 == 0)
        {
            return String.valueOf(numerator2 / denominator2);
        }
        boolean negate = (numerator >= 0) ^ (denominator >= 0);
        numerator2 = Math.abs(numerator2);
        denominator2 = Math.abs(denominator2);
        String result = (negate ? "-" : "") + String.valueOf(numerator2 / denominator2) + ".";
        long t = numerator2 % denominator2;
        Map<Long, Integer> map = new HashMap<>();
        int i = 0;
        int cut = -1;
        map.put(t, i++);
        while (t != 0)
        {
            result += String.valueOf(t * 10 / denominator2);
            t = t * 10 % denominator2;              // ...
            if (map.containsKey(t))
            {
                cut = map.get(t);
                break;
            }
            else
            {
                map.put(t, i++);
            }
        }
        
        if (cut != -1)
        {
            cut += result.indexOf(".") + 1;
            result = result.substring(0, cut) + "(" + result.substring(cut, result.length()) + ")";
        }
        
        return result;
    }
}
