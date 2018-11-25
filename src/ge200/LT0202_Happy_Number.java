package ge200;

import java.util.HashSet;
import java.util.Set;

public class LT0202_Happy_Number
{

    public static void main(String[] args)
    {
        int n = 19;
//        n = 2;
        System.out.println(new LT0202_Happy_Number().Lt0202a(n));
    }

    // 只想到set保存，出现过就是循环，就是false
    // 2ms, most are [1, 4]ms
    
    // 0ms的代码
    /*
    int result=0;
    if(n<=10&&(n==1||n==10||n==7)) return true;         // [0, 10]中，只有1,7,10才会最终变成1.。。1必然是1。。。
    else if(n<10&&n!=1) return false;
    else{
        while(n!=0){
            result=result+(n%10)*(n%10);                // 看来按照规则，n的大趋势肯定是变小，才能这样写。
            n=n/10;                     // 也是，一个位最多81.所以9999 -> 324， 999 -> 243.只有99会变大，但是最多也是162,再下一步就变少了
        }
        return isHappy(result);
    }
    */
    
    // 1ms的代码，这个思路有点吊。所有成环的都可以用快慢指针来搞定。。1->1,也是环。
    /*
    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
    boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);
        if (slow == 1) return true;
        else return false;
    }
    */
    
    private boolean Lt0202a(int n)
    {
        Set<Integer> set = new HashSet<>();
        
        int t = n;
        while (set.add(t) && t != 1)
        {
            t = this.converta1(t);
//            System.out.println(t);
        }
        
        return t == 1;
    }
    
    private int converta1(int n)
    {
        int result = 0;
        int t = 0;
        while (n != 0)
        {
            t = n % 10;
            result += (t * t);
            n /= 10;
        }
        return result;
    }
    
}
