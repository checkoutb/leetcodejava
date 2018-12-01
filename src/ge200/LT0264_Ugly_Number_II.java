package ge200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT0264_Ugly_Number_II
{

    public static void main(String[] args)
    {
        LT0264_Ugly_Number_II lt = new LT0264_Ugly_Number_II();
        
        for (int i = 10; i < 20; i++)
        {
            System.out.println(lt.Lt0264b(i));
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    // 看了hint。。
    // 187ms... most are [2, 8]ms.
    /* 2ms:
    int[] ugly = new int[n];
    ugly[0] = 1;
    int index2 = 0, index3 = 0, index5 = 0;
    int factor2 = 2, factor3 = 3, factor5 = 5;
    for(int i=1;i<n;i++){
        int min = Math.min(Math.min(factor2,factor3),factor5);
        ugly[i] = min;
        if(factor2 == min)
            factor2 = 2*ugly[++index2];
        if(factor3 == min)
            factor3 = 3*ugly[++index3];
        if(factor5 == min)
            factor5 = 5*ugly[++index5];
    }
    return ugly[n-1];
    */
    // 数组而不是队列，因为第n个丑数，所以能确定数组长度。
    // 3个下标都是从0开始，且各自独立变化。
    // 
//    2,3,5   1,2
//    4,3,5   1,2,3
//    4,6,5   1,2,3,4
//    6,6,5   1,2,3,4,5
//    6,6,10  1,2,3,4,5,6
//    8,8,10
    
    // 丑数必然是丑数*(2,3,5)。所以用3个独立的下标指向将要乘以2,3,5的最小值。
    
    private int Lt0264b(int n)
    {
        if (n < 7)
            return n;
        
        long ans = 0;
        
//        int t1 = 2;
//        int t2 = 3;
//        int t3 = 5;
        
        Queue<Long> que = new LinkedList<>();
        que.offer(2L);
        que.offer(3L);
        que.offer(4L);
        que.offer(5L);
        long min5 = 2 * 5;
        long max = 5;
        long t = 0;
        
        int i = 0;
        for (; i < n - 5; i++)
        {
            while (min5 <= max)
            {
                que.remove();
                min5 = 5 * que.peek();
            }
            
            t = max * 2;
            for (long ele : que)
            {
                if (ele * 2 > max && ele * 2 < t && !que.contains(ele * 2))
                {
                    t = ele * 2;
                    continue;
                }
                if (ele * 3 > max && ele * 3 < t && !que.contains(ele * 3))
                {
                    t = ele * 3;
                    continue;
                }
                if (ele * 5 > max && ele * 5 < t && !que.contains(ele * 5))
                {
                    t = ele * 5;
                    continue;
                }
//                break;
                continue;
            }
            ans = t;
            max = t;
            que.offer(t);
        }
        
        return (int) ans;
    }
    
    

    // ...穷举[1, Integer.MAX_VALUE]
    
    // 不能是其他素数的倍数，那就是7的倍数都是丑数。11的也是。不清楚nth个丑数需要判断多少个素数。
    // 前推一个素数，当ans大于这个素数时，就要加入到判断中。
    
    // 229/596， timeout...
    @Deprecated
    private int Lt0264a(int n)
    {
        if (n < 7)
            return n;
        int ans = 0;
        
        List<Integer> primeList = new ArrayList<>();
//        primeList.add(2);
//        primeList.add(3);
        primeList.add(7);
        primeList.add(11);
        int t1 = 6;
        int maxPrime = 11;
        for (int i = 7; i <= Integer.MAX_VALUE; i++)
        {
            if (i > maxPrime)
            {
                maxPrime = this.nextPrime(primeList);
            }
            
            AAA:
            {
                for (int p : primeList)
                {
                    if (p > i)
//                        continue;
                        break;
                    if (i % p == 0)
                    {
                        break AAA;
                    }
                }
                t1++;
            }
            
            if (t1 == n)
            {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
    
    
    private int nextPrime(List<Integer> arr)
    {
        int prime = arr.get(arr.size() - 1);
        int i = 0;
        AAA:
        for (i = prime + 2; i <= Integer.MAX_VALUE; i += 2)
        {
            if ((i % 3 == 0) || (i % 5 == 0))
                continue;
            for (int p : arr)
            {
                if (i % p == 0)
                {
                    continue AAA;
                }
            }
            arr.add(i);
            break;
        }
        return i;
    }
    
}
