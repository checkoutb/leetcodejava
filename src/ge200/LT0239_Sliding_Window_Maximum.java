package ge200;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LT0239_Sliding_Window_Maximum
{

    public static void main(String[] args)
    {
//        int[] arr = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
//        int[] arr = {1, -1};
//        int k = 1;
        int[] arr = { 1, 3, 1, 2, 0, 5 };
        int k = 3;
        System.out.println(Arrays.toString(new LT0239_Sliding_Window_Maximum().Lt0239a(arr, k)));
    }

    
    // 单调栈.
    // 108ms........most are [2, 20]ms...
    /*
    while(!maxIndex.isEmpty() && a[maxIndex.peekLast()] < a[i]){
        maxIndex.pollLast();
    }
    while(!maxIndex.isEmpty() && maxIndex.peekFirst() < (i - k + 1)){
        maxIndex.pollFirst();
    }
    */
    private int[] Lt0239a(int[] nums, int k)
    {
        if (nums.length < k || k == 0)
            return new int[] {};
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> priQue = new PriorityQueue<>((v1, v2) -> (v1 == v2 ? 0 : v1 < v2 ? 1 : -1));
        
        for (int i = 0; i < k; i++)
            priQue.add(nums[i]);
        
        int j = 0;
        ans[j++] = priQue.peek();
        for (int i = k; i < nums.length; i++)
        {
            priQue.remove(Integer.valueOf(nums[i - k]));
            priQue.add(nums[i]);
            ans[j++] = priQue.peek();
        }
        return ans;
    }
    
}


