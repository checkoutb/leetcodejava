package gt000;


/**
 * 70. Climbing Stairs
 * */
public class LT0070 {

    public static void main(String[] args) {
        
        int n = 6;
        
        System.out.println(Lt0070a(n));
    }

    /*
    试了下，真的是fibonacci，但是不知道为什么。。大约应该是：每次增加一个点，就增加了n个可能性
    
    答案：
    F​n​​=1/√​5​​​((​2​​1+√​5​​​​​)​n+1​​−(​2​​1−√​5​​​​​)​n+1​​)。。。。。
    
    第一个的思路是，递归，每次取最前面的1个或2个，剩下的点递归。
            。。想起来了，62题，应该也是这样递归的，每次选择↓或者→，直到边界或终点，
                每次2个选择，是否也是fibonacci？不是吧，fibonacci是无边界的，62是有边界的。收敛与发散，
                但是在碰到第一个边界/终点 之前，应该是fibonacci，但是碰到边界/终点之后路径就已经决定了，那么62是否就是fibonacci(短边的长度)？
                不是，边长2正方形 和 短边2的很长的长方形 结果肯定不一样。
                是瘸腿fibonacci。应该也有一个公式的。
                
    第二个是，保存递归生成的中间结果以便复用。
    
    第五个是矩阵，。。。是矩阵求fibonacci。。。
    
    其他都是fibonacci。
    
    */
    // 4ms,beats 8%
    public static int Lt0070a(int n)
    {
        if(n <= 1)
        {
            return n;
        }
        int result = 1;
        int t1 = 1;
        int t2 = 1;
//        int t3 = 1;
        int i = 2;
        for(i = 2; i <= n; i++)
        {
            t2 = result;
            result += t1;
            t1 = t2;
        }
        
        return result;
    }
    
    // error
    public static int Lt0070(int n)
    {
        if(n <= 1)
        {
            return n;
        }
        int result = 1;
        int n1 = n - 1;
        int k = n1 / 2;
        int i = 0;
        int m = n1;
        int n2 = n1;
        
        for(i = 0; i < k; i++)
        {
            result += m;
            n2 -= 2;
            m *= n2;
        }
        if(n % 2 == 0)
        {
            result++;
        }
        
        return result;
    }
}

// 1-1, 2-2, 3-3, 4-5, 5-8,, fibonacci?