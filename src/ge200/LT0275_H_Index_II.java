package ge200;

public class LT0275_H_Index_II
{

    public static void main(String[] args)
    {
        int[] arr = {0,1,3,5,6};
//        arr = new int[] { 0, 0 };
        
        System.out.println(new LT0275_H_Index_II().Lt0275a(arr));
    }
    
    // 有序, 二分
    @Deprecated     // 失败太多， 放弃了。。。
    
    /* 6ms:
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (n - mid == citations[mid]) {
            return n - mid;
        }
        if (citations[mid] < n - mid) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return n - start;
    */
    // 我的反过来了，所以似乎永远不会对。。。len-mid mid..反向。。。
    // 当i,j越大，mid越大，len-mid越小。。。。。
    
    private int Lt0275a(int[] citations)
    {
        if (citations.length == 0)
            return 0;
        if (citations.length == 1)
            return citations[0] > 0 ? 1 : 0;
        int ans = 0;
        int j = citations.length - 1;
        int i = 0;
        int mid = 0;
        int len = citations.length;
        
        while (i < j)
        {
            mid = (i + j) / 2 + 1;
            if (citations[len - mid] == mid)
            {
                
            }
            else if (citations[len - mid] > mid)
                i = mid;
            else
                j = mid - 1;
        }
//        ans = citations[j];
//        ans = len - j;
        ans = i;
        return ans;
    }

}
