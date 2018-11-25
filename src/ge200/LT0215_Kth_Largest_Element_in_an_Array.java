package ge200;

import java.util.Stack;

public class LT0215_Kth_Largest_Element_in_an_Array
{

    public static void main(String[] args)
    {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;      // 5
        
//        nums = new int[] {3,2,3,1,2,4,5,5,6};
//        k = 4;          // 4
//
//        nums = new int[] { 7, 6, 5, 4, 3, 2, 1 };
//        k = 2;      // 6
        
        System.out.println(new LT0215_Kth_Largest_Element_in_an_Array().Lt0215b(nums, k));
    }

    
    // 3ms, most are [2, 10]ms..
    // 看了discuss，知道快速排序，结果自己写快速排序，错了n^n次。。。
    //          现在看来，主要是discuss里的 方法名quickSearch 和 递归 起了主导，直接quickSort了。
    // 一种代码：把递归改成while循环，while(low < high)，对[low ,high]中的进行二分，返回二分的标准所在的下标，
    //          然后看这个下标和k比较，修改low 或 high，继续while循环。
    // 这个应该改过测试案例，[2, 10], [35, 43] 2个集中区域。
    private int Lt0215b(int[] nums, int k)
    {
        
        this.quickSearch(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }
    
    private void quickSearch(int[] nums, int s, int e, int k)
    {
        int flag = nums[(s + e) / 2];
        int ss = s;
        int ee = e - 1;
        this.swap(nums, (s + e) / 2, e);
        
        while (ss <= ee)
        {
            if (nums[ss] <= flag)
                ss++;
            else
                this.swap(nums, ss, ee--);
        }
        
        this.swap(nums, ss, e);
        
        if (ss == k)
            return;
        else if (ss < k)
            this.quickSearch(nums, ss + 1, e, k);
        else
            this.quickSearch(nums, s, ss - 1, k);
        
    }
    
    private void swap(int[] nums, int i, int j)
    {
        if (i == j)
            return;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    
    
    // 前几天正好看到过，单调栈.
    // nums = [0, 4999], k = 5000.....timeout....
    
    // 看来还是sort，然后直接输出好。。。
    // 或者用链表，毕竟stack的话，每次插入目前为止的最大值，都会整个stack清空，再push满。。。
    // 单调栈和插入排序有点像。。
    
    // 看了discuss，一个解法基于快速排序。直接二分，如果k在这个半区，则只计算这个半区，另外个半区就不计算了。
    //            ......public PriorityQueue(int initialCapacity)...空间可以增大的，所以直接PriorityQueue(nums.length)
    @Deprecated
    private int Lt0215a(int[] nums, int k)
    {
        
        StackHelper sh = new StackHelper(k);
        for (int i : nums)
            sh.push2(i);
        return sh.getKth();
    }
    
}

class StackHelper
{
    private Stack<Integer> stack;       // bottom is max
    
    private Stack<Integer> helper;
    
    private int k;
    
    public StackHelper(int k)
    {
        this.stack = new Stack<>();
        this.helper = new Stack<>();
        this.k = k;
    }
    
    public void push2(int val)
    {
        if (stack.size() == k && stack.peek() >= val)
            return;

        if (stack.size() >= k)      // just ==
            stack.pop();

        while (!stack.isEmpty() && stack.peek() < val)
            helper.push(stack.pop());
        stack.push(val);
        while (!helper.isEmpty())
            stack.push(helper.pop());
    }
    
    public int getKth()
    {
        return stack.peek();
    }
}