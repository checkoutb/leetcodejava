package gt000;

/**
 * ZigZag Conversion
 * */
public class LT6 {

    public static void main(String[] args) {
        
        String s = "PAYPALISHIRING";
        int r = 3;
        
        s = "A";
        r = 1;
        System.out.println(Lt6(s, r));
    }

    // beats 9%
    // convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
    // StringBuilder will be faster.
    public static String Lt6(String s, int numRows)
    {
        int r = numRows-1;
        int size = (numRows-1) * 2;
        
        if(size == 0)               //...."A",1...
        {
            size = 1;
        }
        
        String result = "";
        int[] step = new int[2];
        for(int i = 0; i < numRows; i++)
        {
            if(i == 0 || i == r)
            {
//                System.out.println(i);
                for(int j = i; j < s.length(); j += size)
                {
                    // which is faster? the first? or same speed?
                    result += s.charAt(j);
//                    result.concat(((Character)s.charAt(j)).toString());
                    
//                    System.out.println(result);
                }
            }
            else
            {
                step[0] = size - (i*2);
                step[1] = i*2;
                boolean flag = true;
                for(int j = i; j < s.length();)
                {
                    result += s.charAt(j);
//                    System.out.println(result);
                    if(flag)
                    {
                        j += step[0];
                        flag = !flag;
                    }
                    else
                    {
                        j += step[1];
                        flag = !flag;
                    }
                }
            }
        }
        return result;
    }
}

/*
p a h n
aplsiig
y i r

p  i  n
a ls ig
ya hr
p  i

p   h
a  si
y i r
pl  ig
a   n

0   8
1  79
2 6
35
4

0 4 8
13579
2 6

0  6
1 57
24 8
3  9


index + (Rows-2)*2 + 2
index + (Rows-1)*2







*/