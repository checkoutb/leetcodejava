package gt000;


/**
 * Divide Two Integers
 * */
public class LT0029 {

    public static void main(String[] args) {
        
        int a = 5;
        int b = 3;
        
        a = 1;
        b = 1;
//        
        a = -1;
        b = 1;
//        
        a = 1;
        b = -1;
//        
        a = -2147483648;            //.... MAX_VALUE is 2147483647.....-Integer.MIN_VALUE == Integer.MIN_VALUE...
        b = -1;
        
//        a = 10;
//        b = 3;
//        int c = 0-a;
//        System.out.println(c);
//        
//        System.out.println(a + ", " + b);
//        System.out.println(Integer.MIN_VALUE);
        
        
        // 1024 is 1 and ten 0... not 1 and nine 0...
        
//        int i = 1;
//        for(int j = 0; j < 13; j++)
//        {
//            i = (int)Math.pow(2, j) - 1;
//            System.out.println(Integer.bitCount(i) + ",    " + i);
//        }
//        
//        System.out.println(Integer.highestOneBit(1023));        // 512
//        
//        System.out.println(Integer.highestOneBit(Integer.MIN_VALUE));       // -214783648...
//        
//        System.out.println(Integer.bitCount(a));
//        System.out.println(Integer.bitCount(1023));
//        System.out.println(Integer.bitCount(1));
//        System.out.println(Math.pow(2, 10));
//        
//        System.out.println(Integer.lowestOneBit(514));      //2
//        
//        System.out.println(Integer.highestOneBit(-5));  //-2147483648
        
        
        System.out.println(Lt0029a(a, b));
    }

    
    // 987/988...-2147483648, -1
    // ...
    public static int Lt0029a(int dividend, int divisor)
    {
        
        //.......
        if(dividend == -2147483648 && divisor == -1)
        {
            return Integer.MAX_VALUE;
        }
        
        
        if(dividend == 0 || divisor == 0)
        {
            return 0;
        }
        if(dividend == divisor)
        {
            return 1;
        }
        
        long result = 0;

        boolean same = true;
        
        if(dividend > 0 && divisor > 0)
        {
            dividend = -dividend;
            divisor = -divisor;
        }
        else if(dividend < 0 && divisor > 0)
        {
            same = false;
            divisor = - divisor;
        }
        else if(dividend > 0 && divisor < 0)
        {
            same = false;
            dividend = - dividend;
        }
        
        if(dividend > divisor)
        {
            return 0;
        }


        int i = 0;
        long t1 = divisor;

        System.out.println(dividend + ", " + divisor);
        
        
        int t2 = 0;
        int diff = dividend;
        while(t2 > dividend)
        {
            t1 = divisor;
            diff = dividend - t2;
            
            System.out.println(t2 + " , " + diff + ", " + t1);
            i = 0;
            if(t1 < diff)
            {
                break;
            }
            while(t1 >= diff)
            {
                t1 = t1 * 2;
                i++;
            }
            i--;
            result += (long) Math.pow(2, i);
            
            System.out.println("         ----- " + result + ", " + i);
            
            
            t1 /= 2;
            t2 += t1;
        }
        
        System.out.println(result + ", " + i);
        
        
        if(!same)
        {
            result = -result;
        }
        return (int)result;
    }
    
    
    //...
    public static int Lt0029(int dividend, int divisor)
    {
        if(dividend == Integer.MIN_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        if(dividend == 0)
        {
            return 0;
        }
        boolean same = true;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
        {
            same = false;
        }
        
        if(dividend < 0)
        {
            dividend = -dividend;
        }
        if(divisor < 0)
        {
            divisor = -divisor;
        }
        
//        System.out.println(dividend + ", " + divisor);
        
        int i = 0;
        int temp = 0;
        boolean flag = false;
        
        while(temp <= dividend)
        {
            flag = true;
            temp += divisor;
            i++;
            if(i >= Integer.MAX_VALUE)
            {
                return i;
            }
        }
        
//        System.out.println(i + ", flag: " + flag + ", same: " + same);
        
        if(flag)
        {
            i--;
        }
        if(!same)
        {
            i = -i;
        }
        
        return i;
    }
}
