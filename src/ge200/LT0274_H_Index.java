package ge200;

import java.util.Arrays;

public class LT0274_H_Index
{

    public static void main(String[] args)
    {
        int[] arr = {3,0,6,1,5};
        
        System.out.println(new LT0274_H_Index().Lt0274a(arr));
    }
    
    // 7ms. most are [3, 8]ms.
    /* 3ms:
    int length = citations.length;
    int[] count = new int[length + 1];
    for(int i : citations){
        if(i >= length) count[length]++;
        else count[i]++;
    }
    int countSum = 0;
    for(int i = length; i >= 0; i--){
        countSum += count[i];
        if(countSum >= i) return i;
    }
    return 0;
    */
    
    /* 7ms, sort后
    for(int i = citations.length - 1; i >= 0; i--){       
        if(citations[i] >= citations.length - i)
            result = citations.length - i;
    }
    */
    
    /* 8ms, sort后
    while(i < n && citations[n - i - 1] > i){
        i++;
    }
    */
    
    // 各种各样。
    
    // 275, 这个也能用，删除Arrays.sort后，131ms. most are [6, 18]ms.
    // 有序的话，可以二分提速。其他想不出怎么能那么快。。
    // 看来就是二分，题目有要求对数时间。二分就是对数。
    
    private int Lt0274a(int[] citations)
    {
        int ans = citations.length;
        Arrays.sort(citations);
        int len = citations.length;
        
        while (ans > 0)
        {
            if (citations[len - ans] >= ans)
                break;
            ans--;
        }
        
        return ans;
    }
    
}
