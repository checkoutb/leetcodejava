package ge100;

public class LT0168_Excel_Sheet_Column_Title
{

    public static void main (String[] args)
    {
        int[] arr = { 
//                1, 28, 701, 26, 
                27,
                1000000001 };
        
//        arr = new int[] { 26 };
//        arr = new int[] { 1000000001 };
        LT0168_Excel_Sheet_Column_Title lt = new LT0168_Excel_Sheet_Column_Title();
        for (int n : arr)
        {
            System.out.println(lt.Lt0168a(n));
        }
    }
    
    
    
    private String Lt0168a(int n)
    {
        String result = "";
        long t = 1;
        while (n / t > 0)
        {
            t = t * 26 + (t == 1 ? 1 : t);
        }
        t = t == 27 ? t / 27 : t / 27;
        
        while (n > 0)
        {
            result += this.converta1(n / t);
            n %= t;
            t /= 26;
        }
        
        return result;
    }
    
    private char converta1(long a)
    {
        return (char) (a + 64);
    }
}
