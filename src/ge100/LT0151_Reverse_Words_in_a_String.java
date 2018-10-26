package ge100;

public class LT0151_Reverse_Words_in_a_String
{

    public static void main(String[] args)
    {
        String[] arr = { " the sky is blue " };
        
        LT0151_Reverse_Words_in_a_String lt = new LT0151_Reverse_Words_in_a_String();
        for (String s : arr)
        {
            System.out.println(lt.Lt0151a(s));
        }
    }

    // 74ms... most are [2, 10]ms
    // 好像是StringBuilder的关系。
    private String Lt0151a(String s)
    {
        String result = "";
        String[] arr = s.split(" ");
        String temp = null;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            temp = arr[i];
            if (temp.length() > 0)
            {
                result += temp;
                result += " ";
            }
        }
        if (result.length() > 1)
        {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
