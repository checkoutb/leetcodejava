package ge200;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LT0220_Contains_Duplicate_III
{

    public static void main(String[] args)
    {
//        int[][] numss = {{1,5,9,1,5,9},{1,2,3,1},{1,0,1,1}};
//        int[] k = {2,3,1};
//        int[] t = {3,0,2};
        
//        int[] nums = {-1,2147483647};
//        int k = 1;
//        int t = 2147483647;
//        int[] nums = {0};
//        int t;
//        int k = t = 0;
        
        int[] nums = {7,2,8};
        int k = 2;
        int t = 1;
        
        LT0220_Contains_Duplicate_III lt = new LT0220_Contains_Duplicate_III();
        
        System.out.println(lt.Lt0220b(nums, k, t));
        
//        for (int i = 0; i < k.length; i++)
//        {
//            System.out.println(lt.Lt0220b(numss[i], k[i], t[i]));
//        }
        
        
//        PriorityQueue<Long> que1 = new PriorityQueue<>();           // 1 - n
//        PriorityQueue<Long> que2 = new PriorityQueue<>((a, b) -> (int)(b - a));     // n - 1
//        
//        for (long i = 0; i < 10; i++)
//        {
//            que1.add(i);
//            que2.add(i);
//        }
//        System.out.println(que1 + "\n" + que2);
//        while (!que1.isEmpty())
//        {
//            System.out.println(que1.poll());
//            System.out.println("     " + que2.poll());
//        }
        
        // ....这个内部实现有点吊。直接print像颗树。。代码里有siftup.siftdown...
        // sift:SIFT，即尺度不变特征变换（Scale-invariant feature transform，SIFT），是用于图像处理领域的一种描述。这种描述具有尺度不变性，可在图像中检测出关键点，是一种局部特征描述子。
        // ....第一眼以为是shift。。。不知道优先队列的sift是不是SIFT的意思。。
        // shift还好说，SIFT就。。。
        
    }

    
    // 看了discuss
    /*
    final Integer floor = values.floor(nums[ind] + t);
    final Integer ceil = values.ceiling(nums[ind] - t);
    */
    // TreeSet，第一次知道还有这种方法。。
    
    // HashMap也可以的。。
    
    
    // 40/41 timeout
    @Deprecated
    private boolean Lt0220b(int[] nums, int k, int t)
    {
        Helper3 h3 = new Helper3(k, t);
        for (int num : nums)
            if (h3.insertAndCheck(num))
                return true;
        return false;
    }
    
    
    // 40/41 timeout.
    @Deprecated
    private boolean Lt0220a(int[] nums, int k, int t)
    {
        Helper2 h2 = new Helper2(k, t);
        for (int num : nums)
            if (h2.insertAndCheck(num))
                return true;
        return false;
    }
    
}

class Helper3
{
    private List<Long> list;
    private int maxSize;
    private int t;
    private long max;
    private long min;
    private PriorityQueue<Long> priQue;
    private PriorityQueue<Long> priQue2;
    public Helper3(int k, int t)
    {
        this.list = new LinkedList<>();
        this.priQue = new PriorityQueue<>();
        this.priQue2 = new PriorityQueue<>((a, b) -> (int)(b - a));
        this.maxSize = k;
        this.t = t;
        this.max = -1;
        this.min = 1;
    }
    
    public boolean insertAndCheck(long num)
    {
        if (num >= min && num <= max)
        {
            long numt = num + t;
            long numt2 = num - t;
            for (long i : priQue)
            {
                if (numt2 > i)
                    continue;
                if (numt < i)
                    break;
                if (Math.abs(i - num) <= t)
                    return true;
            }
        }
        list.add(num);
        priQue.add(num);
        priQue2.add(num);
        max = Math.max(max, num + t);
        min = Math.min(min, num - t);
        if (list.size() > maxSize)
        {
            long t1 = list.remove(0);
            priQue.remove(t1);
            priQue2.remove(t1);
            if (!priQue.isEmpty())
            {
                long min2 = priQue.peek();
                long max2 = priQue2.peek();
                if (t1 < min2)
                {
                    min = min2 - t;
                }
                if (t1 > max2)
                {
                    max = max2 + t;
                }
            }
            else
            {
                min = 1;
                max = -1;
            }
        }
        return false;
    }
}

class Helper2
{
    private List<Long> list = null;
    
    private int maxSize = 0;
    
    private int t = 0;
    
    public Helper2(int k, int t)
    {
        this.list = new LinkedList<>();
        this.maxSize = k;
        this.t = t;
    }
    
    public boolean insertAndCheck(long num)
    {
        for (long i : list)
            if (Math.abs(i - num) <= t)
                return true;
        list.add(num);
        if (list.size() > maxSize)
            list.remove(0);
        return false;
    }
    
}