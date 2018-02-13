package gt000;


/**
 * 62. Unique Paths
 * */
public class LT0062 {

    public static void main(String[] args) {
        
        int m = 3;
        int n = 7;
//        m = 1;
//        n = 10;
        m = 2;
        n = 2;
        m = 3;
        n = 3;
        m = 4;
        n = 4;
        
        System.out.println(Lt0062a(m, n));
        
    }

    
    // 毫无头绪。
    public static int Lt0062a(int m, int n)
    {
        int result = 1;
        
        if(m <= 1 || n <= 1)
        {
            return 1;
        }
        
        int m1 = m - 1;
        int n1 = n - 1;
        int i = 0;
        int j = 1;
        
        int count = m1 > n1 ? n1 : m1;
        
        
        
        for(i = 0; i < count; i++)
        {
            result *= (++j); 
        }
        
        
        
        
        return result;
    }
    
    public static int Lt0062(int m, int n)
    {
        int result = 0;
        
        result = (m - 1 > 0 ? m - 1 : 1) * (n - 1 > 0 ? n - 1 : 1);
        
        
        return result;
    }
}
