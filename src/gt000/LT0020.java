package gt000;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Valid Parentheses
 * */
public class LT0020 {

    public static void main(String[] args) {

        String s = "()[]{}";
        
//        System.out.println((int)('('));     // 40
//        System.out.println((int)(')'));     // 41
//        System.out.println((int)('['));     // 91
//        System.out.println((int)(']'));     // 93
//        System.out.println((int)('{'));     // 123
//        System.out.println((int)('}'));     // 125
        
        
        System.out.println(Lt0020(s));
    }

    
    // beats 12%
    public static boolean Lt0020(String s)
    {
        if(s == null || s.length() == 0)
        {
            return true;
        }
        if(s.length() % 2 != 0)
        {
            return false;
        }
        char[] chArr = s.toCharArray();

        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');
        
        Deque<Character> chDeque = new ArrayDeque<>();
        
        chDeque.push(chArr[0]);
        char top;
        int difference;
        for(int i = 1; i < s.length(); i++)
        {
            if(left.contains(chArr[i]))
            {
                chDeque.push(chArr[i]);
            }
            else
            {
                top = chDeque.peekFirst();
                difference = chArr[i] - top - top / 80;
                if(difference == 1)
                {
                    chDeque.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return chDeque.isEmpty();
    }
}
