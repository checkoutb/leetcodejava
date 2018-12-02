package ge200;

import java.util.HashMap;
import java.util.Map;

public class LT0299_Bulls_and_Cows
{

    public static void main(String[] args)
    {
//        int[] secArr = {1807,1123};
//        int[] gueArr = {7810,0111};
//        String[] secArr = {"1807","1123"};
//        String[] gueArr = {"7810","0111"};
        String[] secArr = {"1122"};
        String[] gueArr = {"2211"};
        LT0299_Bulls_and_Cows lt = new LT0299_Bulls_and_Cows();
        
        for (int i = 0; i < secArr.length; i++)
        {
            System.out.println(lt.Lt0299a(String.valueOf(secArr[i]), "" + gueArr[i]));
        }
        
    }

    
    // 11ms, most are [1, 2]ms.
    // 只有数字，所以可以int[10]保存个数。
    // 可以2个int[]，也可以一个int[]，两个的话，最后累加每对元素的min，一个int数组就不需要了，不过它可以有负数。
    private String Lt0299a(String secret, String guess)
    {
        String ans = "";
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();
        int i, j;
        i = 0;
        j = 0;
        int numA = 0;
        int numB = 0;
        for (; i < arr1.length; i++)
        {
            if (arr1[i] == arr2[i])
            {
                numA++;
                arr1[i] = arr2[i] = 'A';
            }
        }
        
        Map<Character, Integer> secMap = new HashMap<>();
        for (i = 0; i < arr1.length; i++)
        {
            if (arr1[i] != 'A')
            {
                secMap.put(arr1[i], secMap.getOrDefault(arr1[i], 0) + 1);
            }
        }
        
        for (i = 0; i < arr2.length; i++)
        {
            if (arr2[i] != 'A' && (j = secMap.getOrDefault(arr2[i], -1)) > 0)
            {
                numB++;
                secMap.put(arr2[i], j - 1);
            }
        }
        ans = String.valueOf(numA) + "A" + numB + "B";
        return ans;
    }
    
}
