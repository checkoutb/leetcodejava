package ge200;

public class LT0263_Ugly_Number
{

    public static void main(String[] args)
    {
        int[] arr = {6,8,14};
        LT0263_Ugly_Number lt = new LT0263_Ugly_Number();
        
        for (int a : arr)
        {
            System.out.println(a + " : " + lt.Lt0263a(a));
        }
    }

    
    // 1ms, most are [1, 2]ms.
    /* 先把所有的2除掉。然后所有的3, 所有的5, return num == 1;
    while(num>=2){
        if(num % 2 == 0)
            num /= 2;
        else
            break;
    }
    */
    // return num == 1;的话，就不需要num <= 0了
    
    private boolean Lt0263a(int num)
    {
        if (num <= 0)
            return false;
        while (num > 1)
        {
            if (num % 2 == 0)
            {
                num /= 2;
                continue;
            }
            if (num % 5 == 0)
            {
                num /= 5;
                continue;
            }
            if (num % 3 == 0)
            {
                num /= 3;
                continue;
            }
            return false;
        }
        return true;
    }
    
}
