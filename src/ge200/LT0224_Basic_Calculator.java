package ge200;

import java.util.Stack;

public class LT0224_Basic_Calculator
{

    public static void main(String[] args)
    {
        String[] arr = {"1 + 1", " 2-1 + 2 ", "(1+(4+5+2)-3)+(6+8)", "2147483647"};
        LT0224_Basic_Calculator lt = new LT0224_Basic_Calculator();
        
        for (String s : arr)
        {
            System.out.println(lt.Lt0224a(s));
        }
    }

    // 22ms. most are [3, 26]ms.
    // 慢在substring上，如果自己*10+的话，应该会快很多。而且不需要j，直接i后移就可以了。
    private int Lt0224a(String s)
    {
        int ans = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int flag = 1;
        stack.push(1);
        stack.push(1);
        int flag2 = 1;
        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            switch (arr[i])
            {
            case ' ':
                continue;
            case '+':
                flag2 = flag;
                break;
            case '-':
                flag2 = flag * -1;
                break;
            case '(':
                if (i > 0)
                    stack.push(flag = (arr[i - 1] == '-' ? -1 * flag : 1 * flag));
                break;
            case ')':
                stack.pop();
                flag = stack.peek();
                break;
            default:
                for (j = i + 1; j < arr.length; j++)
                    if (!Character.isDigit(arr[j]))
                        break;
                ans += Integer.parseInt(s.substring(i, j)) * flag2;
                i = j - 1;
                break;
            }
        }
        return ans;
    }
    
}
