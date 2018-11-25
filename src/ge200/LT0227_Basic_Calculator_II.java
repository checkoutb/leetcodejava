package ge200;

import java.util.Arrays;
import java.util.Stack;

public class LT0227_Basic_Calculator_II
{

    public static void main(String[] args)
    {
        String[] arr = {"3+2*2"," 3/2 "," 3+5 / 2 "};
        
        LT0227_Basic_Calculator_II lt = new LT0227_Basic_Calculator_II();
        
        for (String s : arr)
        {
            System.out.println(lt.Lt0227a(s));
        }
    }

    
    // 34ms. most are [4, 66]ms.
    /*
    if(sign=='/'){
        stack.push(stack.pop()/num);
    }
    sign = s.charAt(i);
    */
    
    // 保存 上个数字 和 operator，下个数字来的时候进行操作。。。。怪不得觉得不对。。题目里没有要求()。。。
    private int Lt0227a(String s)
    {
        int[] arr = this.pretreatmenta1(s);
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int i = 0;
        for (int ii = 0; ii < arr.length; ii++)
        {
            i = arr[ii];
            switch(i)
            {
            case -1:
            case -2:
            default:
                stack.push(i);
                break;
            case -3:
                t1 = stack.pop();
                t2 = arr[++ii];
                stack.push(t1 * t2);
                break;
            case -4:
                t1 = stack.pop();
                t2 = arr[++ii];
                stack.push(t1 / t2);
                break;
            case -5:
                stack.push(i);
                break;
            case -6:
                t3 = 0;
                while ((t1 = stack.pop()) != -5)
                {
                    if (t1 > 0)
                        t2 = stack.pop();
                    if (t2 == -2)
                        t1 = 0 - t1;
                    t3 += t1;
                    if (t2 == -5)
                        break;
                }
                if ((t1 = stack.peek()) <= -3)
                {
                    stack.pop();
                    t2 = stack.pop();
                    if (t1 == -3)
                        t3 *= t2;
                    else
                        t3 = t2 / t3;
                }
                stack.push(t3);
                break;
            }
        }
        
        while (stack.size() > 1)
        {
            t1 = stack.pop();
            t2 = stack.pop();
            ans += ((t2 == -2 ? -1 : 1) * t1);
        }
        
        ans += stack.pop();
        return ans;
    }
    
    private int[] pretreatmenta1(String s)
    {
        int[] ans = new int[s.length()];
        int i = 0;
        int j = -1;
        char[] arr = s.toCharArray();
        int t = 0;
        while (++j < arr.length)
        {
            switch (arr[j])
            {
            case ' ':
                break;
            case '+':
                ans[i++] = -1;
                break;
            case '-':
                ans[i++] = -2;
                break;
            case '*':
                ans[i++] = -3;
                break;
            case '/':
                ans[i++] = -4;
                break;
            case '(':
                ans[i++] = -5;
                break;
            case ')':
                ans[i++] = -6;
                break;
            default:
                t = arr[j] - '0';
                while (++j < arr.length && Character.isDigit(arr[j]))
                    t = t * 10 + (arr[j] - '0');
                ans[i++] = t;
                j--;
                break;
            }
        }
        ans = Arrays.copyOf(ans, i);
        return ans;
    }
    
}
