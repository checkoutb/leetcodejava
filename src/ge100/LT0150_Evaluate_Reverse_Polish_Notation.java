package ge100;

import java.util.Stack;

public class LT0150_Evaluate_Reverse_Polish_Notation
{

    public static void main(String[] args)
    {
        String[][] arr = { { "2", "1", "+", "3", "*" }, { "4", "13", "5", "/", "+" },
                { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" } };
        
        LT0150_Evaluate_Reverse_Polish_Notation lt = new LT0150_Evaluate_Reverse_Polish_Notation();
        for (String[] tokens : arr)
        {
            System.out.println(lt.Lt0150(tokens));
        }
    }

    // 8ms, most are [6, 11]ms.
    private int Lt0150(String[] tokens)
    {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int a = 0;
        int b = 0;
        for (String s : tokens)
        {
            switch (s)
            {
            case "+":
                a = stack.pop();
                b = stack.pop();
                a += b;
                stack.push(a);
                break;
            case "-":
                a = stack.pop();
                b = stack.pop();
                b -= a;
                stack.push(b);
                break;
            case "*":
                a = stack.pop();
                b = stack.pop();
                a *= b;
                stack.push(a);
                break;
            case "/":
                a = stack.pop();
                b = stack.pop();
                b /= a;
                stack.push(b);
                break;
            default:
                stack.push(Integer.parseInt(s));
                break;
            }
        }
        result = stack.pop();
        return result;
    }
}
