package gt000;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import utils.LTUtils;

/**
 * 32. Longest Valid Parentheses
 * */
public class LT0032 {

    public static void main(String[] args) {

        String s = "(()";
        s = ")()())";
        s = "()(()";                //....
        s = "()";
//        s = ")()())()()(";
//        s = ")(())))(())())";
//        s = "((((((((((((((";
//        s = ")(";
        s = ")(((((()())()()))()(()))(";
        s = "(()())";
        int max = Lt0032a(s);
        System.out.println(max);
    }

    
    // 229/229 timeout..
    public static int Lt0032a(String s)
    {

        int result = 0;
        int temp = 0;
        int NOT = -8;
        int max = 0;
        int i = 0;
        int j = 0;
        char Left = '(';
        char Right = ')';

        char[] charArr = null;
        char[] charArr2 = s.toCharArray();
        
        int i1 = -1;
        int i2 = -1;
        int i3 = -1;
        int sumRight = 0;
        int sumLeft = 0;
        int sumMin = 0;
        for(i = 0; i < charArr2.length; i++)
        {
            if(i1 == -1 && Left == charArr2[i])         //...
            {
                i1 = i;
            }
            if(Right == charArr2[i] && i2 == -1)
            {
                i2 = i;
                i3 = i;
            }
            if(Right == charArr2[i])        // last of )
            {
                i3 = i;
            }
//            if(Right == charArr2[i])
//            {
//                sumRight++;
//            }
//            else
//            {
//                sumLeft++;
//            }
        }
        
//        sumMin = sumLeft > sumRight ? sumRight : sumLeft;

        System.out.println(i1 + ", " + i2 + ", " + i3);
        System.out.println(sumMin);
        
        if(i1 < 0 || i2 < 0)
        {
            return 0;
        }
//        if(Math.abs(i1 - i2) - 1 > sumMin)            // error ((((((((()
//        {
//            return 0;
//        }
        
        i = i1;
        if(i3 < i)      // )(
        {
            return 0;
        }
        
        if(i != 0)
        {
            charArr = new char[i3 - i + 1];                     // +1.
            System.arraycopy(charArr2, i, charArr, 0, i3 - i + 1);
        }
        else
        {
            charArr = charArr2;
        }
        
        System.out.println(Arrays.toString(charArr));

        int[] intArr = new int[charArr.length];
        Map<Integer, Integer> iiMap = new HashMap<>();

        temp = 0;
        for(i = 0; i < charArr.length; i++)
        {
            if(charArr[i] == Left)          // (
            {
                if(temp < 1)
                {
                    temp = 0;
                }
                temp++;
//                max = temp > max ? temp : max;
                intArr[i] = temp;
                if(iiMap.containsKey(temp))
                {
                    iiMap.put(temp, iiMap.get(temp) + 1);
                }
                else
                {
                    iiMap.put(temp, 1);
                }
            }
            else                // )
            {
                intArr[i] = temp;
                if(iiMap.containsKey(temp))
                {
                    iiMap.put(temp, iiMap.get(temp) + 1);
                }
                else
                {
                    iiMap.put(temp, 1);
                }
                temp--;
                
            }
        }
        LTUtils.showArray(intArr);
        System.out.println(iiMap);
        
        for(Map.Entry<Integer, Integer> entry : iiMap.entrySet())
        {
            if(entry.getValue() % 2 == 1)
            {
                for(i = intArr.length - 1; i >= 0; i--)
                {
                    if(intArr[i] == entry.getKey())
                    {
                        break;
                    }
                }
                intArr[i] = NOT;
            }
        }
        
        LTUtils.showArray(intArr);
        
        temp = 0;
        for(i = 0; i < intArr.length; i++)
        {
            if(intArr[i] >= 1)
            {
                temp++;
            }
            else
            {
                result = result > temp ? result : temp;
                temp = 0;
            }
        }
        result = result > temp ? result : temp;
        
        return result;
    }
    
    public static int Lt0032(String s)
    {
        int result = 0;
        int max = 0;
        char[] charArr = s.toCharArray();
        char Left = '(';
        char Right = ')';
        
//        Set<Character> set = new HashSet<>();
//        set.add(Left);
//        set.add(Right);
        
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        for(i = 0; i < charArr.length; i++)
        {
            if(charArr[i] == Left)      // (
            {
                stack.push(Left);
//                result++;
            }
            else            // )
            {
                if(!stack.isEmpty())
                {
                    if(stack.peek() == Left)
                    {
                        stack.pop();
                        result += 2;
                    }
                    else
                    {
                        max = result > max ? result : max;
                        result = 0;
                        stack.clear();
                    }
                }
                else
                {
                    max = result > max ? result : max;
                    result = 0;
                    stack.clear();
                }
            }
        }
        max = result > max ? result : max;
        
        return max;
    }
}






/*

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 

[(, (, ), ), ), ), (, (, ), ), (, ), )]
 1, 2, 2, 1, 0,-1, -1,0, 0, -1,-1,-1,-2, 










*/