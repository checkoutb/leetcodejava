package gt000;


/**
 * Divide Two Integers
 * */
public class LT0029 {

    public static void main(String[] args) {
        
        int a = 5;
        int b = 3;
        
        System.out.println(Lt0029(a, b));
        
    }

    
    public static int Lt0029(int dividend, int divisor)
    {
        
        int i = 0;
        int temp = 0;
        
        while(temp < dividend)
        {
            temp += divisor;
            i++;
        }
        
        return i-1;
    }
}
