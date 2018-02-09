package gt000;

import java.util.Arrays;

import utils.LTUtils;

/**
 * 43. Multiply Strings
 * */
public class LT0043 {

    public static void main(String[] args) {
        
        String num1 = "13";
        String num2 = "8";
        
        num1 = "9";
        num2 = "9";
        
        num1 = "0";
        num2 = "0";
        
        num1 = "123";
        num2 = "456";
        
        String result = Lt0043a(num1, num2);
        System.out.println(result);
        
    }

    
    
    
    // beats 21%
    public static String Lt0043a(String num1, String num2)
    {
        StringBuilder sb = new StringBuilder();

        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        
        int[] in1 = null;        // multiplicand  ±»³ËÊý
        int[] in2 = null;        // multiplier  ³ËÊý
        int in1Len = 0;
        int in2Len = 0;
        int i = 0;
        int j = 0;
        int t = 0;
        int t2 = 0;
        int m = 0;
        
//        if(char1.length > char2.length)
//        {
//            in1 = new int[char1.length];
//            in2 = new int[char2.length];
//            in1Len = in1.length;
//            in2Len = in2.length;
//            for(i = 0; i < in1Len; i++)
//            {
//                in1[i] = char1[i] - 48;
//            }
//            for(i = 0; i < in2Len; i++)
//            {
//                in2[i] = char2[i] - 48;
//            }
//        }
//        else
//        {
//            in1 = new int[char2.length];
//            in2 = new int[char1.length];
//            in1Len = in1.length;
//            in2Len = in2.length;
//            for(i = 0; i < in1Len; i++)
//            {
//                in1[i] = char2[i] - 48;
//            }
//            for(i = 0; i < in2Len; i++)
//            {
//                in2[i] = char1[i] - 48;
//            }
//        }

        in1 = new int[char1.length];
        in2 = new int[char2.length];
        in1Len = in1.length;
        in2Len = in2.length;
        
        for(i = 0; i < in2Len; i++)
        {
            in2[i] = char2[i] - 48;
        }
        
        for(i = 0; i < in1Len; i++)
        {
            in1[i] = char1[i] - 48;
        }
        
        
        int[][] temp = new int[char2.length][char1.length + 1];
        
        
        
        
//        int minLen = in1Len > in2Len ? in2Len : in1Len;
        
        for(j = in2Len - 1; j >= 0; j--)
        {
            for(i = in1Len - 1; i >= 0; i--)
            {
                t = in1[i] * in2[j];
                if(t >= 10)
                {
                    t2 = t % 10;
                    t /= 10;
                    temp[j][i] += t;
                    temp[j][i + 1] += t2;
                    
//                    System.out.println("..." +Arrays.toString(temp[j]));
                    
                }
                else
                {
                    temp[j][i + 1] += t;
                }
                if(temp[j][i + 1] >= 10)
                {
                    t2 = temp[j][i + 1] / 10;
                    temp[j][i + 1] %= 10;
                    temp[j][i] += t2;
                }
            }
        }
        
        int[] result = new int[char1.length + char2.length];
        
        
        
        LTUtils.showArrayOfArrayOneRowOneLine(temp);
        System.out.println(temp.length + ", " + temp[0].length);
        
        
        t = result.length - 1;
        int k = result.length - 1;
        for(j = in2Len - 1; j >= 0; j--)
        {
//            t2 = 1;
//            for(m = 0; m < t; m++)
//            {
//                t2 *= 10;
//            }
            k = t;
            for(i = in1Len; i >= 0; i--)
            {
                
                result[k] += temp[j][i];
                
                
//                System.out.println("... " + result[k] + ", " + temp[j][i]);
                
                
                if(result[k] >= 10)
                {
                    t2 = result[k] / 10;
                    result[k] %= 10;
                    result[k-1] += t2;
//                    k++;
                }
                k--;
                
                
                System.out.println(Arrays.toString(result));
                
            }
            t--;
        }
        
        
        
        
        LTUtils.showArray(result);
        
        
        
        for(i = 0; i < result.length; i++)
        {
            if(result[i] != 0)
            {
                break;
            }
        }
        
        for(; i < result.length; i++)
        {
            sb.append(result[i]);
        }
        
        if(sb.length() == 0)
        {
            sb.append("0");
        }
        
        
        return sb.toString();
    }
    
    
    // this is num1[i] * nums2[i]... not num1 * num2
    @Deprecated
    public static String Lt0043(String num1, String num2)
    {
        String result = null;
        StringBuilder sb = new StringBuilder();
        
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        
        int[] in1 = new int[char1.length];
        int[] in2 = new int[char2.length];
        
        int i = 0;
        int j = 0;
        int in1Len = in1.length;
        int in2Len = in2.length;
        int t = 0;
        int t2 = 0;
        int m = 0;
        int minLen = in1Len > in2Len ? in2Len : in1Len;
        
        for(i = 0; i < in1Len; i++)
        {
            in1[i] = char1[i] - 48;
        }
        for(i = 0; i < in2Len; i++)
        {
            in2[i] = char2[i] - 48;
        }
        
//        m = minLen;
        j = in2Len - 1;
        i = in1Len - 1;
        while(i >= 0 && j >= 0)
        {
            t = in1[i] * in2[j];
            
            while(t >= 10)
            {
                t2 = t % 10;
                t /= 10;
                sb.insert(0, t2);           // should add to next, not insert
            }
            sb.insert(0, t);
            
            i--;
            j--;
//            m--;
        }
        
        if(in2Len > in1Len)
        {
//            for(j = in2Len; j > i; j--)
//            {
////                sb.insert(0, minLen)
//            }
            sb.insert(0, char2, 0, in2Len - in1Len);
        }
        else
        {
//            for(; i < in1Len; i++)
//            {
//                
//            }
            sb.insert(0, char1, 0, in1Len - in2Len);
        }
        
        result = sb.toString();
        return result;
    }
    
}


/*


The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.


*/