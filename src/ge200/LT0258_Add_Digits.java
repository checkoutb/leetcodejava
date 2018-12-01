package ge200;

public class LT0258_Add_Digits
{

    public static void main(String[] args)
    {
        int num = 38;
        
        System.out.println(new LT0258_Add_Digits().Lt0258a(num));
    }

    
    // 不循环且O(1)。。不会。。
    
    // 1ms, most are [1, 2]ms.
    
    // return 1 + (num - 1) % 9;
    // https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
    private int Lt0258a(int num)
    {
        int ans = num;
        
        while (ans >= 10)
        {
            int t = 0;
            while (ans > 0)
            {
                t += (ans % 10);
                ans /= 10;
            }
            ans = t;
        }
        
        return ans;
    }
    
}
