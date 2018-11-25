package ge200;

import java.util.LinkedList;
import java.util.List;

public class LT0204_Count_Primes
{

    public static void main(String[] args)
    {
        System.out.println(new LT0204_Count_Primes().Lt0204a(499979));
    }

    
    // 226ms...1,set应该比list好，主要是forEach的时候，list是有序的。所以可以从2开始。2.p*p>i提前退出。
    // most are [12, 28]ms
    // 基本都是boolean[n]做一个辅助的，保存是不是质数。1肯定不是，for从2开始i，下标为i的倍数设置为不是。最后for一下看几个是。
    private int Lt0204a(int n)
    {
        int result = 0;
//        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        boolean isPrime = false;
        for (int i = 2; i < n; i++)
        {
//            System.out.println(i + ", " + set.size());
            isPrime = true;
            for (int p : list)
            {
                if (i % p == 0)
                {
                    isPrime = false;
                    break;
                }
                if (p * p > i)
                    break;
            }
            if (isPrime)
                list.add(i);
        }
        
        result = list.size();
        return result;
    }
}
