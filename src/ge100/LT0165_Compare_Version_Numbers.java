package ge100;

public class LT0165_Compare_Version_Numbers
{

    public static void main(String[] args)
    {
        String v1 = "1.0.1";
        String v2 = "1";
        
        v1 = "01";
        v2 = "1";
        
        v1 = "1.0";
        v2 = "1";
        
        System.out.println(new LT0165_Compare_Version_Numbers().Lt0165a(v1, v2));
    }

    // 2ms, most are [1, 2]ms.
    private int Lt0165a(String version1, String version2)
    {
        
        int[] arr1 = this.pretreatmenta1(version1);
        int[] arr2 = this.pretreatmenta1(version2);
        
        int i = 0;
        while (i < arr1.length && i < arr2.length)
        {
            if (arr1[i] != arr2[i])
            {
                return arr1[i] > arr2[i] ? 1 : -1;
            }
            i++;
        }
        if (arr1.length == arr2.length)
        {
            return 0;
        }
        
        if (arr1.length > arr2.length)
        {
            for (; i < arr1.length; i++)
            {
                if (arr1[i] > 0)
                {
                    return 1;
                }
            }
        }
        else
        {
            for (; i < arr2.length; i++)
            {
                if (arr2[i] > 0)
                {
                    return -1;
                }
            }
        }
        
        return 0;
    }
    
    private int[] pretreatmenta1(String version)
    {
        String[] arr = version.split("\\.");                // 正则。。
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
        
    }
}
