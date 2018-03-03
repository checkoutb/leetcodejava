package gt000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.LTUtils;

/**
 * Letter Combinations of a Phone Number
 * */
public class LT0017 {

    public static void main(String[] args) {
        
        String d = "23";
        d = "22";
        
        LTUtils.showList(Lt0017(d));
    }

    
    // beats 23%.
    public static List<String> Lt0017(String digits)
    {
        if("".equals(digits))
        {
            return Collections.emptyList();
        }
        char[][] chArray = new char[][]{
            {' '},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };
        
        int[] chNum = new int[]{1,0,3,3,3,3,3,4,3,4};
        
        int[] dig = new int[digits.length()];
        
        int digit = Integer.parseInt(digits);
        
        int i = dig.length - 1;
        while(digit != 0)
        {
            dig[i] = digit%10;
            digit /= 10;
            i -= 1;
        }
        
        
        //test
        LTUtils.showArray(dig);
        
        
        int sumCount = 1;
        for(int d : dig)
        {
            if(d == 1)
            {
                continue;
            }
            sumCount *= chNum[d];
        }

        System.out.println(sumCount);
        
        List<String> result = new ArrayList<>((int)(sumCount*1.5));
        
        int j = 0;
        i = 0;
        int t = 0;
        StringBuilder sb = new StringBuilder();
        while(i < sumCount)
        {
            System.out.println(i);
            t = i;
            for(j = 0; j < digits.length(); j++)
            {
                System.out.print("   " + chArray[dig[j]][t%chNum[dig[j]]] + ", " + t + ", " + j);
                sb.append(chArray[dig[j]][t%chNum[dig[j]]]);
                t /= chNum[dig[j]];
            }
            System.out.println();
            result.add(sb.toString());
            sb.delete(0, sb.length());
            i += 1;
        }
        
        System.out.println(sb);
        
        return result;
        
    }
}


/*

1:null
2:abc
3:def
4:ghi
5:jkl
6:mno
7:pqrs
8:tuv
9:wxyz
0:blank






*/