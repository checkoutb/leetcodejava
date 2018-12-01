package ge200;

public class LT0273_Integer_to_English_Words
{

    public static void main(String[] args)
    {
        int[] arr11 = { 123, 12345, 1234567, 1234567891 };
        LT0273_Integer_to_English_Words lt = new LT0273_Integer_to_English_Words();
//        String[] anss = { "One Hundred Twenty Three", "Twelve Thousand Three Hundred Forty Five",
//                "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
//                "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One" };
////        for (String s : anss)
////        {
////            System.out.println(s);
////        }
//        
//        int ii = 0;
//        for (int i : arr11)
//        {
//            System.out.println(lt.Lt0273a(i));
//            System.out.println(anss[ii++]);
//        }
        
        int n = 1000000;
        System.out.println(lt.Lt0273a(n));
        
    }

    
    String[] arr1 = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    String[] arr2 = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    String[] arr3 = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    String[] arr4 = { "Hundred", "Thousand", "Million", "Billion" };
    
    
    // 000,000,000,000      // 0,2,1
    
    // 3ms.. most are [1, 3]ms.
    /*  2ms:
    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
    */
    
    /*  1ms
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int c = 0;
        String res = "";
        while(num > 0){
            int val = num % 1000;
            if(val != 0)
                res = helper(val) + thousands[c] + " " + res;
            num /= 1000;
            c++;
        }
        return res.trim();
    }
    public String helper(int v){
        if(v == 0)
            return "";
        else if(v < 20){
            return lessThan20[v] + " ";
        } else if(v < 100){
            return tens[v/10] + " " + helper(v%10);
        } else{
            return lessThan20[v/100] + " Hundred " + helper(v%100);
        }
    }
    */
    
    private String Lt0273a(int num)
    {
        
        if (num < 10)
        {
            return arr1[num];
        }
        if (num <= 19)
        {
            return arr2[num - 10];
        }
        String ans = "";
        
        int len = 1;
        int t1 = num;
        int t2 = 1;
        int t3 = 0;
        int last = 0;
        boolean first = true;
        while (t1 >= 10)
        {
            len++;
            t2 *= 10;
            t1 /= 10;
        }
        
        t1 = num;
        
        while (len > 0)
        {
            t3 = t1 / t2;
            t1 %= t2;
            t2 /= 10;
            switch (len % 3)
            {
            case 1:
                if (t3 != 0)
                {
                    if (last != 1)
                        ans += (" " + arr1[t3]);
                    else
                        ans += (" " + arr2[t3]);
                }
                else
                {
                    if (last == 1)
                        ans += (" " + arr2[t3]);
                }
                if ((num / (int) Math.pow(10, len - 1)) % 1000 != 0)
                {
                    switch (len / 3)
                    {
                    case 1:
                        ans += (" " + arr4[len / 3]);
                        break;
                    case 2:
                        ans += (" " + arr4[len / 3]);
                        break;
                    case 3:
                        ans += (" " + arr4[len / 3]);
                        break;
                    }
                }
                break;
            case 2:
//                if (first)
//                {
//                    ans += (" " + arr3[t3 - 1]);
//                }
//                else
//                {
                    if (t3 >= 2)
                        ans += (" " + arr3[t3 - 1]);
//                }
                break;
            case 0:
                if (t3 != 0)
                    ans += (" " + arr1[t3] + " " + arr4[0]);
                break;
            }
            len--;
            last = t3;
            first = false;
        }
        
        return ans.substring(1);
        
    }
    
}
