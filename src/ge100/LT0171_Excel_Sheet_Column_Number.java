package ge100;

public class LT0171_Excel_Sheet_Column_Number
{

    public static void main(String[] args)
    {
        String[] arr = {"A","AB","ZY"};
        
        LT0171_Excel_Sheet_Column_Number lt = new LT0171_Excel_Sheet_Column_Number();
        for (String s : arr)
        {
            System.out.println(lt.Lt0171a(s));
        }
    }

    // 0ms, most are [0, 1]ms
    // 看见一个从0开始的，差不多行数。。和前面那个题目真的天壤之别。。。
    private int Lt0171a(String s)
    {
        int result = 0;
        long t = 1;
        char[] chArr = s.toCharArray();
        for (int i = chArr.length - 1; i >= 0; i--)
        {
            result += (chArr[i] - 'A' + 1) * t; 
            t *= 26;
        }
        return result;
    }
}
