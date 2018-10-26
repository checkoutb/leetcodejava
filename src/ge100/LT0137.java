package ge100;

/**
 * 137. Single Number II
 * */
public class LT0137
{

    public static void main(String[] args)
    {
        
    }
    
    // 136 只想到TreeMap，但这并不是线性时间，看了discuss，XOR。。。
    // 这个也只想到TreeMap。。
    // 或者Set保存全部，看数组和 与 Set和*3 的差。。。Set应该比TreeMap快吧，毕竟修改树应该也挺费时间的。
    
    // 和代码一起的解释是香浓定理。需要2个位才能辨别。。。这个突破天际了。
    /*  pseudo-code
    a = b = 0
    for num in nums:
        b = b ^ num & ~a
        a = a ^ num & ~b
    return a|b
    */
    
    /*  java
    int a = 0;
    int b = 0;
    for (int n : nums) {
        a = a^n & ~b;
        b = b^n & ~a;
    }
    return a;
    */
    
    // 这个是136 异或的一般形式，如果csum %= 2. 就可以用来解 136了。。
    // 由于(n-1)个数重复k遍，1个数只有1遍，所以每个位累加，然后 % k，商就是 1个数 在这个位上的 值。。。。
    // 吊吊吊。以后知道怎么弄了。希望能记住。。。。
    // 不知道有没有更一般的方法：(n-1)个数重复k遍，1个数重复j遍。。求那个数。。。(位累加 % k) / j ?
    // 更一般，(n-m)个重复k遍，m个重复j遍。不过不知道求什么。。
    /*  cpp
    int result = 0;
    for(int i=0;i<32;++i){
        int csum = 0;
        for(const auto& num : nums)
            csum += (num>>i) & 1;
        csum %= 3;
        if(csum!=0) result |= 1<<i;
    }
    return result;
    */
    
    
    // 我。。。。
    private int Lt0137a(int[] nums)
    {
        int result = 0;
        
        
        return result;
    }
}
