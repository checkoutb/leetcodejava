package gt000;

import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 38. Count and Say
 * */
public class LT0038 {

    public static void main(String[] args) {
        
        int n = 10;
        
        String result = Lt0038a(n);
        System.out.println(" result : " + result);
    }

    
    // beats 27%
    public static String Lt0038a(int n)
    {
        List<Integer> list = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        
//        if(n == 1)
//        {
//            return "1";
//        }
        
//        list.add(1);
        result.add(1);
        
        int count = 0;
        int t = 0;
        
        for(int i = 2; i <= n; i++)
        {
            list.clear();
//            list.addAll(result);
            
            count = 0;
            for(int j : result)
            {
                if(count == 0)
                {
                    count++;
                    t = j;
                }
                else
                {
                    if(t == j)
                    {
                        count++;
                    }
                    else
                    {
                        list.add(count);                // not add(0, t)
                        list.add(t);                    // not add(0, count)
                        t = j;
                        count = 1;
                    }
                }
            }
            
            
            list.add(count);
            list.add(t);
            
            result.clear();
            result.addAll(list);
            
            System.out.println(list);
            System.out.println(result);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(Integer part : result)
        {
            sb.append(part);
        }
        return sb.toString();
    }
    
    
    // n = 10, the result is larger then LONG_MAX.
    public static String Lt0038(int n)
    {
//        StringBuilder sb = new StringBuilder();
//        String[] ShortResult = {"10", "1", "11", "21", "1211", "111221"};
//        if(n < 5)
//        {
//            return ShortResult[n];
//        }
        
        List<Integer> list = new LinkedList<>();
        long result = 1L;
        long temp = 0L;
        int count = 0;
        int t = 0;
        boolean flag = true;
        
        for(int i = 2; i <= n; i++)
        {
            temp = result;
            
            System.out.println("...." + temp + ", " + result);
            
            while(temp > 0)
            {
                list.add(0, ((int)temp) % 10);                  // add 0..so needn't reverse.
                temp /= 10;
            }
            
            System.out.println("      size : " + list.size());
            
            temp = 0L;
            count = 0;
            for(Integer j : list)
            {
                System.out.println("------- " + j);
                
                if(count == 0)
                {
                    t = j;
                    count ++;
                }
                else
                {
                    if(t == j)
                    {
                        count ++;
                    }
                    else
                    {
                        temp *= 10;
                        temp += count;
                        temp *= 10;
                        temp += t;
                        t = j;
                        count = 1;
                    }
                }
            }
            
//            if(count == 1)
//            {
                temp *= 10;
                temp += count;
                temp *= 10;             // if count>10?
                temp += t;
//            }
            
            
//            System.out.println(temp);
//            
//            // reverse 
//            result = 0;
//            while(temp > 0)
//            {
//                result *= 10;
//                result += (temp % 10);
//                temp /= 10;
//            }
            
            result = temp;
                
            System.out.println(result + ", " + temp);
//            LTUtils.showList(list);
            System.out.println(list);
            
            list.clear();
        }
        
//        LTUtils.showList(list);
        
        
        
        return Long.toString(result);
    }
}

/*

1.     1
2.     11
3.     21
4.     1211
5.     111221

*/