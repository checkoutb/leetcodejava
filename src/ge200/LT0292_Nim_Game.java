package ge200;

public class LT0292_Nim_Game
{

    public static void main(String[] args)
    {
        
    }

    
    // 1-3个，我先。
    // 拼成4？。。可以缩减4的倍数。..我先。
    // 岂不是1/4的几率输，3/4的几率赢？ 减去4的倍数后，只可能[0, 3]。0是必输，[1, 3]必赢。
    // 0ms, all are 0ms.
    private boolean Lt0292a(int n)
    {
//        boolean ans = false;
//        n = n - (n / 4 * 4);
        n %= 4;
        
        return n > 1;
    }
    
}
