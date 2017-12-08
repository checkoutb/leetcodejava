package gt000;

import java.util.ArrayList;
import java.util.List;

import utils.LTUtils;

/**
 * Generate Parentheses
 * */
public class LT0022 {

    public static void main(String[] args) {
        
        int n = 3;
        System.out.println(Lt0022(n));
    }

    // 5ms, beats 18.7%...
    // StringBuilder is 5ms, String is 9ms.
    // List<String>.size() is a Catalan number?
    public static List<String> Lt0022(int n)
    {
        List<String> result = new ArrayList<>();
        
        int d = n * 2;
        
        int[] left = new int[n + 1];
        int i = 0;
        for(; i < n; i++)
        {
            left[i] = i + 1;        // 1 2 3 4 5
        }
        left[n] = -1;
        
        int[] top = new int[n];
        for(i = 0; i < n; i++)
        {
            top[i] = i*2 + 1;       // 1 3 5 7 9
        }
        
//        StringBuilder sb = new StringBuilder("(");
        String sb = "(";
        
        int len1 = n-1;
        int d1 = d - 1;
        int j;
        boolean flag = true;
        
        while(flag)
        {
            j = 1;
            for(i = 2; i <= d1; i++)
            {
                if(left[j] == i)
                {
//                    sb.append("(");
                    sb += "(";
                    j++;
                }
                else
                {
//                    sb.append(")");
                    sb += ")";
                }
            }
//            sb.append(")");
            sb += ")";
            
//            result.add(sb.toString());
//            sb = new StringBuilder("(");
            result.add(sb);
            sb = "(";
            
            
            for(i = len1; i > 0; i--)
            {
                if(left[i] < top[i])
                {
                    left[i]++;
                    for(j = i+1; j < n; j++)
                    {
                        left[j] = left[i] + j - i;
                    }
                    break;
                }
            }
            if(i == 0)
            {
                flag = false;
            }
        }
        return result;
    }
}


/*

For example, given n = 3, a solution set is:

[
  "((()))",     123     012
  "(()())",     124     013
  "(())()",     125     014
  "()(())",     134
  "()()()"      135
]

(())            12
()()            13

()

(((())))        ((())())
((()()))        ((()))()
(()(()))        
((())())
()((()))
((()))()
(()()())
()()()()
...

()()()()()      13579
(())()()()      
()(())()()     
()()(())()

(())()(())
(()())()()

((((()))))      12345






*/