package ge200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LT0229_Majority_Element_II
{

    public static void main(String[] args)
    {
//        int[][] arr2 = {
//                {3,2,3},
//                {1,1,1,3,3,2,2,2}};
//        int[][] arr2 = {{0,3,4,0}};
//        int[][] arr2 = {{4,2,1,1}};
        int[][] arr2 = {{1,2,3,4}};
        LT0229_Majority_Element_II lt = new LT0229_Majority_Element_II();
        
        for (int[] arr1 : arr2)
            System.out.println(lt.Lt0229f(arr1));
    }

    // gg...
    @Deprecated
    private List<Integer> Lt0229f(int[] nums)
    {
        List<Integer> ans = new LinkedList<>();
        if (nums.length == 0)
            return ans;
        int c1 = 0, c2 = 0, n1 = nums[0], n2, n, n3, n4;
        int j = 0;
        while (++j < nums.length && nums[j] == n1);
        if (j == nums.length)
        {
            ans.add(n1);
            return ans;
        }
        n2 = nums[j];
        for (int i = 0; i < nums.length; i++)
        {
            n = nums[i];
            c1 += (n1 == n ? 2 : -1);
            c2 += (n2 == n ? 2 : -1);
            n3 = n1;
            n4 = n2;
            n1 = (c1 >= 0 ? n1 : n2 == n ? n1 : n);
            n2 = (c2 >= 0 ? n2 : n1 == n ? n2 : n);
            c1 = (n1 == n3 ? c1 : c1 + 3);
            c2 = (n2 == n4 ? c2 : c2 + 3);
        }
        if (c1 > 0)
            ans.add(n1);
        if (c2 > 0)
            ans.add(n2);
        return ans;
    }
    
    // 想法是：由于至少1/3,所以是自己就+2,不是自己就-1,==0/<0就换自己。由于x > 1/3所以 x*2 - (1-x)*1 > 0 是可以成立的。
    // 但是要一次遍历找出2个数，这样就会互相影响。
    @Deprecated
    private List<Integer> Lt0229e(int[] nums)
    {
        List<Integer> ans = new LinkedList<>();
        
        int c1 = 1, c2 = 1, n1 = nums[0], n2;
        int i = -1;
        while (++i < nums.length && nums[i] == n1)
        {
            ;
        }
        if (i == nums.length)
        {
            ans.add(n1);
            return ans;
        }
        n2 = nums[i];
        int n = 0;
        int j = 0;
//        for (int n : nums)
        for (i = 0; i < nums.length; i++)
        {
            n = nums[i];
            if (n1 == n)
                c1 += 2;
            else
            {
                c1--;
            }
            c2 += ((n2 == n) ? 2 : -1);
            
            if (c1 <= 0 && c2 <= 0)
            {
                n1 = n;
                c1 = 2;
                j = i;
                while (++j < nums.length && nums[j] == n1)
                {
                    ;
                }
                if (j == nums.length)
                {
                    ;
                }
                else
                {
                    n2 = nums[j];
                    c2 = 1;
                }
            }
            if (c1 <= 0)
            {
                if (n != n2)
                {
                    n1 = n;
                    c1 = 2;
                }
                else
                {
                    j = i;
                    while (++j < nums.length && nums[j] == n1)
                    {
                        ;
                    }
                    if (j == nums.length)
                    {
                        ;
                    }
                    else
                    {
                        n1 = nums[j];
                        c1 = 1;
                    }
                }
            }
            if (c2 <= 0)
            {
                if (n != n1)
                {
                    n2 = n;
                    c2 = 2;
                }
                else
                {
                    j = i;
                    while (++j < nums.length && nums[j] == n1)
                    {
                        ;
                    }
                    if (j == nums.length)
                    {
                        ;
                    }
                    else
                    {
                        n2 = nums[j];
                        c2 = 1;
                    }
                }
            }
        }
        
        if (c1 > 0)
            ans.add(n1);
        if (c2 > 0)
            ans.add(n2);
        
        return ans;
    }
    
    @Deprecated
    private List<Integer> Lt0229d(int[] nums)
    {
        List<Integer> ans = new LinkedList<>();
        if (nums.length == 0)
            return ans;
        if (nums.length == 1)
        {
            ans.add(nums[0]);
            return ans;
        }
        int c1 = 1;
        int c2 = 1;
//        int n1 = Math.min(nums[0], nums[1]) - 1;
//        int n2 = n1;
        
//        int n1 = nums[0];
//        int n2 = nums[3];
        
        int n1 = nums[0];
        int i = 0;
        for (; i < nums.length; i++)
            if (nums[i] != n1)
                break;
        if (i == nums.length)
        {
            ans.add(nums[0]);
            return ans;
        }
        int n2 = nums[i];
        
        for (int n : nums)
        {
            if (n == n1)
            {
                c1 += 1;
            }
            else
            {
                if (n != n2)
                {
                c1--;
                if (c1 <= 0)
                    {
                        n1 = n;
                        c1 += 1;
                    }
                }
            }
            
            if (n == n2)
            {
                c2 += 1;
            }
            else
            {
                if (n != n1)
                {
                c2--;
                if (c2 <= 0)
                    {
                        n2 = n;
                        c2 += 1;
                    }
                }
            }
        }
        
        if (c1 > 0)
            ans.add(n1);
        if (c2 > 0)
            ans.add(n2);
        
        return ans;
    }
    
    
    @Deprecated
    private List<Integer> Lt0229c(int[] nums)
    {
        List<Integer> ans = new LinkedList<>();
        
        int c1 = 0;
        int c2 = 0;
        int n1 = nums[0];
        int i = 0;
        for (; i < nums.length; i++)
            if (nums[i] != n1)
                break;
        if (i == nums.length)
        {
            ans.add(nums[0]);
            return ans;
        }
        int n2 = nums[i];
        int incre1 = 2;
        int incre2 = 1;
        
        for (int num : nums)
        {
            if (n1 == num)
                c1 += incre1;
            else
            {
                c1--;
                if (c1 == 0)
                {
                    n1 = num;
                    c1 = incre1;
                }
            }
            if (n1 != num)
            {
                if (n2 == num)
                    c2 += incre2;
                else
                {
                    c2--;
                    if (c2 == 0)
                    {
                        n2 = num;
                        c2 = incre2;
                    }
                }
            }
        }
        
        if (c1 > 0)
            ans.add(n1);
        if (c2 > 0)
            ans.add(n2);
        
        return ans;
    }
    
    
    // num1 和 num2 需要不一样，怎么解决。
    @Deprecated
    private List<Integer> Lt0229b(int[] nums)
    {
        List<Integer> ans = new LinkedList<>();
        if (nums.length < 1)
            return ans;
        double count1 = 0;
        double count2 = 0;
        int num1 = nums[0];
        int i = 0;
        for (; i < nums.length; i++)
            if (nums[i] != nums[0])
                break;
        if (i == nums.length)
        {
            ans.add(nums[0]);
            return ans;
        }
        int num2 = nums[i];
        double incre = 2;
        double decre = -1;
        for (int num : nums)
        {
            if (num == num1)
            {
                count1 += incre;
                count2 += decre;
            }
            else
            {
                if (num == num2)
                {
                    count1 += decre;
                    count2 += incre;
                }
                else
                {
                    count1 += decre;
                    count2 += decre;
                }
            }
            if (count1 <= 0)
            {
                num1 = num;
                count1 += incre;
            }
            if (count2 <= 0)
            {
                if (num != num1)
                {
                    num2 = num;
                    count2 += incre;
                }
            }
        }
        
        if (count1 > 0)
            ans.add(num1);
        if (count2 > 0)
            ans.add(num2);
        
        return ans;
    }
    
    
    // 线性 + O(1)空间。。线性就不能排序，O(1)空间就不能Map。。。。。
    
    // 2ms, most are [2, 4]ms.
    // 看了1ms的那个，想起来以前有个题目似乎是一半的数是k，线性找出k，那个就是遍历+血量。是自己，血量++，不是自己，血量--，如果血量<0(or ==0?)，当前数作为自己。
    // 1ms的就是2个count计算"血量"，因为是more than 1/3，所以最多就2个数。
    // 不过1ms的代码也挺复杂的。
    // 看了discuss，有个中文的。。摩尔投票法。。
    // 如果2个数大于1/3，那么只有小于1/3的几率是--。大于1/3的几率是++，所以能找到这个值。最后for一遍，看个数是> 1/3。
    // 如果2个数都是1/4,其他都是单个的数，那么1/2的几率是--，1/4的几率++，所以需要看位置，如果1/4 1/4 单个，遍历完获得的2个数都是单个值。
    //          再for一遍，不会满足。如果单个 1/4 1/4，得到的2个数是1/4几率的值，但是for一遍后，也不会满足，所以结果是空。
    // 我想如果++，--变下，是否能够直接得到结果，就是从+1,-1,变成+?,-?
    private List<Integer> Lt0229a(int[] nums)
    {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        int step = nums.length / 3;
        int j = 0;
        int t1 = nums.length - step;
        int t2 = 0;
        for (int i = 0; i < t1; i++)
        {
            j = i + step;
            if (nums[i] == nums[j])
            {
                t2 = nums[j];
                list.add(t2);
                for (; j < t1; j++)
                    if (nums[j] != t2)
                        break;
                i = --j;
            }
            else
            {
                if (nums[j] != nums[j - 1])
                {
                    i = --j;
                    continue;
                }
                else
                {
                    t2 = nums[j];
                    for (; ; j--)               // 碰到 1,2,2,2,2,2,2,2,2,2 就变慢了。。是不是两个指针一头一尾向中间走会更稳定点。。或者二分。。
                    {
                        if (nums[j] != t2)
                            break;
                    }
                    i = j;
                }
            }
        }
        return list;
    }
    
}
