package gt000;

import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;


/**
 * 77. Combinations
 * */
public class LT0077 {

    public static void main(String[] args) {
        
        int n = 4;
        int k = 2;
        
        LTUtils.showListOfList(Lt0077a(n, k));
    }

    
    public static List<List<Integer>> Lt0077b(int n, int k)
    {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = null;
        int i = 0;
        int j = 0;
        int m = 0;
        int t1 = 0;
        int t2 = 0;
        int[] nArr = new int[n];
        
        for(i = 0; i < n; i++)
        {
            nArr[i] = i + 1;
        }
        
        
//        m = k;
//        for(i = 0; i < n; i++)
//        {
//            while(m > 0)
//            {
//                for(j = i; j < n; j++)
//                {
//                    
//                }
//            }
//        }
        
//        m = k;
//        while(m > 0)
//        {
//            for(i = 0; i < n; i++)
//            {
//                
//            }
//        }
        
//        m = k;
//        int len = n - k;
//        for(i = 0; i < len; i++)
//        {
//            list = new LinkedList<>();
//            list.add(i);
//            m--;
//            while(m > 0)
//            {
//                for(j = i + 1; j < n; j++)
//                {
//                    list.add(j);
//                }
//            }
//        }
        
        
        
        return result;
    }
    
    
    // 看来想要快，还是得直接得出组合，不能for 1-n。。
    public static List<List<Integer>> Lt0077a(int n, int k)
    {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = null;
        
        int i = 0;
        int j = 0;
        int t1 = 0;
        int t2 = 0;
        int nBit = 1 << n;
        
        int[] nArr = new int[n];
        
        for(i = 0; i < n; i++)
        {
            nArr[i] = i + 1;
        }
        
        // 不知道怎么样才能快速判断 一个int，由几个1组成。。。看来>>1是最快的了。
        for(i = 0; i < nBit; i++)
        {
            
        }
        
        
//        Integer a = 111;
//        System.out.println(a.byteValue());
//        System.out.println(a.BYTES);
//        System.out.println(a.byteValue());
//        System.out.println(a.toBinaryString(111).toCharArray());
//        System.out.println();
//        Byte as = 0x11;
//        System.out.println(as.intValue());
//        System.out.println(as.byteValue());
//        System.out.println(as.BYTES);
//        System.out.println(as.toString());
//        System.out.println();
        
        
        
//        // 应该是第二种方法快，快至少1倍，
//        for(i = 0; i < 100000; i++)
//        {
//            
//        }
//        
//        char[] ch;
//        int count = 0;
//        
//        Long start = System.nanoTime();
//        
//        for(i = 0; i < 100000; i++)
//        {
//            count = 0;
//            ch = Integer.toBinaryString(i).toCharArray();
//            for(char ch1 : ch)
//            {
//                if(ch1 == '1')
//                {
//                    count++;
//                }
//            }
//        }
//        
//        System.out.println(System.nanoTime() - start);
//        
//        
//        start = System.nanoTime();
//        
//        for(i = 0; i < 100000; i++)
//        {
//            count = 0;
//            t1 = i;
//            while(t1 > 0)
//            {
//                if(t1 % 2 == 1)
//                {
//                    count++;
//                }
//                t1 = t1 >> 1;
//            }
//        }
//        
//        System.out.println(System.nanoTime() - start);
        
        
        
        return result;
    }
    
    // 昨天正好看过一个排列组合的代码，不过那个是全排列，全组合，没有元素个数的限制。 http://blog.csdn.net/joson793847469/article/details/52743632
    // 有上面的借鉴，但是还是差点翻车。。本地改了好久才让它输出对。。
    // 64ms...那么多的3ms怎么来的。。
    public static List<List<Integer>> Lt0077(int n, int k)
    {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = null;
        int nBit = 1 << n;
        int i = 0;
        int t = 0;
        int t2 = 0;
        int count = 0;
        
        for(i = 0; i < nBit; i++)
        {
            count = 0;
            t = i;
            while(t > 0)
            {
                if(t % 2 == 1)
                {
                    count++;
                }
                t = t >> 1;
            }
            
            if(count == k)
            {
                t = i;
                t2 = 1;
                list = new LinkedList<>();
                while(t > 0)
                {
                    if(t % 2 == 1)
                    {
                        list.add(t2);
                    }
                    t2++;
                    t = t >> 1;
                }
                result.add(list);
            }
        }
        
        return result;
    }
}
