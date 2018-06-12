package gt000;

import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 93. Restore IP Addresses
 * */
public class LT0093
{

    public static void main(String[] args)
    {
        String s = "25525511135";
        s = "1111";
        s = "0000";
        
        String[] sArr = { 
                "25525511135", "1111", 
                "0000", "010010" };
        
        for (String s1 : sArr)
        {
            List<String> result = Lt0093a(s1);
            
            LTUtils.showList(result);
        }
    }

    
    // 4ms, beats 92.7%
    public static List<String> Lt0093a(String s)
    {
        List<String> result = new LinkedList<>();
        int len = s.length();
        if (len < 4 || len > 12)
        {
            return result;
        }
        
        long ipLong = Long.valueOf(String.valueOf(1) + s);          // 0000...need prefix "1"
        if (ipLong < 10000L || ipLong > 1255255255255L)
        {
            return result;
        }
        
        int[] ipArr = new int[len];
        int i = 0;
        long temp = ipLong;
        
        // index == 0 is the first char of s
        for (i = 0; i < len; i++)
        {
            ipArr[len - 1 - i] = (int) temp % 10;
            temp /= 10;
        }
        
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
//        int p4 = len - 1;
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        
        p1 = 0;
//            AAA : 
        while(true)         // while (p1 < len - 3)
        {
            if(p1 >= len -3)
            {
                break;
            }
            t1 = 0;
            
            if(ipArr[0] == 0 && p1 != 0)            // 10.01.1.1
            {
                break;
            }
            
            for (i = 0; i <= p1 && i < len - 3; i++)
            {
                t1 *= 10;
                t1 += ipArr[i];
                if(t1 > 255)
                {
                    break;
                }
            }
            if(t1 > 255)
            {
                break;
            }
            
            p2 = p1 + 1;
            while(true)
            {
                if (p2 >= len - 2)
                {
                    break;
                }
                
                if (ipArr[p1 + 1] == 0 && p2 != p1 + 1)
                {
                    break;
                }
                
                t2 = 0;
                for (i = p1 + 1; i <= p2 && i < len - 2; i++)
                {
                    t2 *= 10;
                    t2 += ipArr[i];
                    if (t2 > 255)
                    {
                        break;
                    }
                }
                if (t2 > 255)
                {
                    break;
                }
                
                p3 = p2 + 1;
                while(true)
                {
                    if (p3 >= len - 1)
                    {
                        break;
                    }
                    if (ipArr[p2 + 1] == 0 && p3 != p2 + 1)
                    {
                        break;
                    }
                    
                    t3 = 0;
                    for (i = p2 + 1; i <= p3 && i < len - 1; i++)
                    {
                        t3 *= 10;
                        t3 += ipArr[i];
                        if (t3 > 255)
                        {
                            break;
                        }
                    }
                    if (t3 > 255)
                    {
                        break;
                    }
                    
//                    p4 = p3 + 1;
//                    if (p4 >= len)
//                    {
//                        break AAA;
////                        break;
//                    }
                    while(true)
                    {
                        t4 = 0;
                        if (ipArr[p3 + 1] == 0 && p3 + 2 != len)
                            break;
                        
                        for(i = p3 + 1; i < len; i++)
                        {
                            t4 *= 10;
                            t4 += ipArr[i];
                            if(t4 > 255)
                            {
                                break;
                            }
                        }
                        if(t4 > 255)
                        {
                            break;
                        }
                        else
                        {
                            // ...
                            
//                            System.out.println(p1 + ", " + p2 + ", " + p3 + ", " + p4);
                            
                            String result1 = s.substring(0, p1 + 1).concat(".").concat(s.substring(p1 + 1, p2 + 1)).concat(".")
                                    .concat(s.substring(p2 + 1, p3 + 1)).concat(".").concat(s.substring(p3 + 1));
                            result.add(result1);
                            break;
                        }
                    }
                    p3++;
                }
                p2++;
            }
            p1++;
        }
        return result;
    }
    
    // where is IP Adress's Regular Expression!
    public static List<String> Lt0093(String s)
    {
        List<String> result = new LinkedList<>();
        int len = s.length();
        if (len < 4 || len > 12)
        {
            return result;
        }
        
        long ipLong = Long.valueOf(s);
        if (ipLong < 1000L || ipLong >= 255255255255L)
        {
            return result;
        }
        
        int[] ipArr = new int[len];
        int i = 0;
        long temp = ipLong;
        
        // index == 0 is the first char of s
        for (i = 0; i < len; i++)
        {
            ipArr[len - 1 - i] = (int) temp % 10;
            temp /= 10;
        }
//        int p1Max = len - 3 >= 3 ? 2 : len - 4;
//        int p1Min = len - 9 > 0 ? len - 10 : 0;
        
        int p1Max = len >= 6 ? 2 : len - 4;     // 3+1+1+1
        int p1Min = len > 10 ? len - 10 : 0;     // (1+)3+3+3, len > 9 == len > 10, because if len == 10, len - 10 == 0...
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p2Max = 0;
        int p2Min = 0;
        int p3Max = 0;
        int p3Min = 0;
        int p4Max = 0;
        int p4Min = 0;

        int p1 = p1Min;
        while (p1 <= p1Max)
        {
//            p2Max = len - p1 - 1 - 3 >= 2 ? p1 + 3 : len - 3;
            
            p2Max = len >= 6 + p1 ? p1 + 3 : len - p1 - 3;
            p2Min = len - p1 - 1 > 6 ? len - 1 - 6 : p1 + 1;
            p2 = p2Min;
            while (p2 <= p2Max)
            {
                p3Max = len - p2 - 1 >= 4 ? p2 + 3 : len - p2 - 2;
                p3Min = len - p2 - 1 > 3 ? len - 1 - 3 : p2 + 1;
                p3 = p3Min;
                while (p3 <= p3Max)
                {
                    p4Max = len - 1;
                    p4Min = len - p3 - 1 > 0 ? len - 1 : p3 + 1;
                    p4 = p3Min;
                    while (p4 <= p4Max)
                    {
                        

                        p4++;
                    }
                    p3++;
                }
                p2++;
            }
            p1++;
        }
        
        
        
        
        return result;
    }
    
    
}
