package gt000;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import utils.LTUtils;

/**
 * 89. Gray Code
 * */
public class LT0089
{

    public static void main(String[] args)
    {
        
        int i = 1 << 4;
        for(int j = 0; j < i; j++)
        {
            System.out.println(j + " : " + (j ^ j >> 1));
        }
        
//        LTUtils.showList(Lt0089(2));
    }

    // ...看了1ms的代码，还是不懂，然后百度，才知道格雷码。无法理解。数n和n/2异或 == 数n的每个bit和后一个bit是否相同，相同就是0
    // n不同的话，n/2只有连续的1偶1奇才会相同，但是偶数奇数末尾不同，但是n/2的末尾相同，所以异或必然不同，所以n^(n>>1)必然能和每个n对应。
    // 连续的1偶1奇只差一位(就是偶数的最后一位0改成1)，所以n^n>>1只差最后一位。
    // 连续的1奇1偶就差的bit数有点多。111->1000,111^11,1000^100,差一位。
    // 连续1奇1偶的差距是从奇数的最后一个0到最后(这段全是1)。偶数就是把奇数的最后一个0设置为1，然后原本0后所有的1变成0.
    // 所以奇数最后1个0之前的和偶数最后一个1之前的bit异或(后移1位)是相同的，剩下的部分就是0[1]+,和1[0]+，这两种的各自异或各自后移一位后差一位，主要是
    // 因为最前面的0和1的差别。毕竟0[1]+,1[0]+所处的位异或后自己后移一位后从从第二位往后肯定是1[0]+，第一位的话得看前半段给它一个什么数。
    // 但是由于前半段是相同的，所以后移一位的也是相同的，等于给0，1都是相同的一个数来异或，所以必然不相等。
    // 5ms, beats 6.7%
    public static List<Integer> Lt0089(int n)
    {
        List<Integer> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int[][] bits = new int[n][2];
        int i = 0;
        int t = 1;
//        bits[0][1] = t;
        for(i = 0; i < n; i++)
        {
            bits[i][1] = t;
            t *= 2;
        }
//        long size = (long) Math.pow(2, n);
        int size = t;
        result.add(0);
        set.add(0);
        t = 0;
        
//        System.out.println(size);
        
        while(result.size() < size)
        {
            for(i = 0; i < n; i++)
            {
                if(bits[i][0] == 0)
                {
                    t += bits[i][1];
                    if(set.contains(t))
                    {
                        t -= bits[i][1];
                        continue;
                    }
                    else
                    {
                        set.add(t);
                        result.add(t);
                        bits[i][0] = 1;
                        break;              // ...
                    }
                }
                else
                {
                    t -= bits[i][1];
                    if(set.contains(t))
                    {
                        t += bits[i][1];
                        continue;
                    }
                    else
                    {
                        set.add(t);
                        result.add(t);
                        bits[i][0] = 0;
                        break;              // ...
                    }
                }
            }
        }
        
        return result;
    }
}
