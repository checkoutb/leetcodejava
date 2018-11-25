package ge100;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LT0179_Largest_Number
{

    public static void main(String[] args)
    {
        // 9609938 824 8247 69735703560743981399  T
        // 9609938 8247 824 69735703560743981399  F
        int[][] arr2 = { 
//                { 10, 2 }, { 3, 30, 34, 5, 9 }, { 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247 }, 
                { 824, 8247 } };

        LT0179_Largest_Number lt = new LT0179_Largest_Number();
        
        for (int[] arr : arr2)
        {
            System.out.println(lt.Lt0179a(arr));
        }
    }
    
    
    // 121,12  12 121,, 121 12
    // 212,21  212 21,, 21 212
    
    // 22212, 2221, 2221 22212  22212 2221   降序就长的放前面，升序就短的放前面？ no
    
    // 123215， 12321, 多出来的是升序还是降序，
    
    // 456542222222, 45654,
    
    // 2343266666, 23432
    
    // 1212121， 1212
    // 。。。。。。。不知道。。
    

    // 就是字典顺序，然后字符串连接吧。不是字典顺序。5,58,是58+5, 5,54是5+54。和第二位有关。看升序降序？
    
    // 43ms, most are [13, 33]ms, some are [52, 82]ms
    
    // ........直接全转成String，然后 a+b，b+a,用String 的 compareTo(String anotherString)
    // ...利用Arrays.sort(T[] a, Comparator<? super T> c)
    private String Lt0179a(int[] nums)
    {
        boolean allZero = true;
        for (int n : nums)
            if (n != 0)
                allZero = false;
        if (allZero)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        this.order(nums);
        for (int n : nums)
            sb.append(n);
        return sb.toString();
    }
    
    private int[] order(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (this.comparea2(nums[i], nums[j]) < 0)
                    this.swap(nums, i, j);
        return nums;
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    private int comparea2(int a, int b)
    {
        long aa = a;
        long bb = b;
        aa = aa * ((long) Math.pow(10, String.valueOf(b).length())) + b;
        bb = bb * ((long) Math.pow(10, String.valueOf(a).length())) + a;
        return aa == bb ? 0 : (aa > bb ? 1 : -1);
    }
    
    // error
    @Deprecated
    private int comparea(int a, int b)
    {
        char[] aArr = String.valueOf(a).toCharArray();          // 如果有个辅助数组的话，可以减少很多次转换吧。
        char[] bArr = String.valueOf(b).toCharArray();
        
        int aLen = aArr.length;
        int bLen = bArr.length;
        int i = -1;
        int minLen = aLen > bLen ? bLen : aLen;
        
        while (++i < minLen)
            if (aArr[i] != bArr[i])
                return aArr[i] < bArr[i] ? -1 : 1;
        
        if (aLen == bLen)
            return 0;
        
        boolean aLonger = aLen > bLen;
        char[] longArr = aLonger ? aArr : bArr;
        int maxLen = aLonger ? aLen : bLen;
        int j = 0;
        while (i < maxLen)
        {
            if (longArr[j] != longArr[i])
                if (aLonger)
                    return longArr[j] < longArr[i] ? 1 : -1;
                else
                    return longArr[j] < longArr[i] ? -1 : 1;
            i++;
            j++;
        }
        return 0;
    }
}
