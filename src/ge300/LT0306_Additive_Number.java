package ge300;

public class LT0306_Additive_Number
{

    public static void main(String[] args)
    {
        String[] arr1 = {
//                "11235813", 
//                "199100199", 
//                "112456",
//                "1023",
//                "0235813",
//                "121224036",
                "121474836472147483648",            // 1 + Integer.MAX_VALUE
                };
        LT0306_Additive_Number lt = new LT0306_Additive_Number();
        
        for (String s : arr1)
        {
            System.out.println(lt.Lt0306a(s));
        }
    }

    
    
    // 0ms......most are [1, 2]ms.
    // 这个还有改进的余地，t4得到以后，能直接知道t3的位数，不需要for。t1的位数不能超过length/3 + 1, t2的位数不能超过(length-t1位数)/2，
    // 而且 t3,t4 对比的时候可以 for循环对比 位，而不是 *=10, +=..
    // 不需要把i,j,k,m这些下标的值算出来，直接 t3,t4 对比的时候算每个位。这样就能避免超大数了。
    
    /*  1ms:
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)) return true;
        return false;
    }
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
    */
    // startsWith.. x2 和 x1 的运算
    
    
    /*  2ms:
    public boolean isAdditiveNumber(String num) {
        if(num==null || num.length()<3) return false;
        return dfs(num, 0, new ArrayList<String>());
    }
    private boolean dfs(String num, int start, List<String> path) {
        if(start==num.length()) {
            if(path.size()>=3) return true;
        }
        for(int i=start; i<num.length(); i++) {
            String s = num.substring(start, i+1);
            if(s.length()>1 && s.charAt(0)=='0') return false;
            if(path.size()<2 || Long.parseLong(s) == Long.parseLong(path.get(path.size()-1))
                    + Long.parseLong(path.get(path.size()-2))) {
                path.add(s);
                if(dfs(num, i+1, path)) return true;
                path.remove(path.size()-1);
            }
        }
        return false;
    }
    */
    // List 保存分割。
    
    private boolean Lt0306a(String num)
    {
        
        boolean ans = false;
        char[] arr1 = num.toCharArray();
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
        {
            arr2[i] = arr1[i] - '0';
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int m = 0;
        long t1 = 0;
        long t2 = 0;
        long t11 = 0;
        long t3 = 0;
        long t4 = 0;
        while (i < arr2.length - 2)
        {
            t1 = 0;
            if (arr2[0] == 0)
            {
                if (i > 0)
                    break;
            }
            else
            {
                for (j = 0; j <= i; j++)
                {
                    t1 *= 10;
                    t1 += arr2[j];
                    
                }
            }
            t11 = t1;
            AAA:
            for (j = i + 1; j < arr2.length - 1; j++)
            {
                t1 = t11;
                t2 = 0;
                if (arr2[i + 1] == 0)
                {
                    if (j > i + 1)
                        break;
                }
                else
                {
                    for (k = i + 1; k <= j; k++)
                    {
                        t2 *= 10;
                        t2 += arr2[k];
                    }
                }
                k = j + 1;
                
                while (k < arr2.length)
                {
                    t4 = t1 + t2;
                    t3 = 0;
                    for (m = k; m < arr2.length; m++)
                    {
                        if (arr2[k] == 0)
                        {
                            t3 = 0;
                            if (m > k)
                                continue AAA;
                        }
                        else
                        {
                            t3 *= 10;
                            t3 += arr2[m];
                        }
                        if (t3 == t4)
                        {
                            t1 = t2;
                            t2 = t3;
                            break;
                        }
                        if (t3 > t4)
                        {
                            continue AAA;
                        }
                    }
                    k = m + 1;
                }
                if (t3 == t4)
                    return true;
            }
            i++;
        }
        return false;
    }
    
}
