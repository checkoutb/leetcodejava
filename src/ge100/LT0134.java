package ge100;

/**
 * 134. Gas Station
 * */
public class LT0134
{

    public static void main(String[] args)
    {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        
        gas = new int[] { 2, 3, 4 };
        cost = new int[] { 3, 4, 3 };

        gas = new int[] { 3, 1, 1 };
        cost = new int[] { 1, 2, 2 };

        System.out.println(new LT0134().Lt0134a(gas, cost));
    }
    
    
    // 45ms, most are 0ms.....
    // 先累加gas，cost一遍，判断能不能。。
    /*
    int i = 0;
    int ans = 0;
    while(i < gas.length){
        //go to i+1
        sum = gas[i];
        ans = i;
        while(i < gas.length && (sum - cost[i]) >0) {
            sum = sum - cost[i]  + gas[(i+1)%gas.length];
            i++;
        }
        i++;
    }
    return ans;
    */
    // 由于总油数 >= 总花费数，且 油箱无限大，所以 必然存在循环。。。应该是反证。
    // 如果一段不行，那么这一段中任何结点作为start都不行。。。
    //      [i, j]为失败的段，则gas[i,j] < cost[i,j]，由于gas[i]>cost[i],所以gas[i,j]-gas[i] < cost[i,j]-cost[i]，所以[i+1, j]也是失败段。
    // 由于必然存在循环，所以可以while(i < gas.length)一遍遍历。。
    //      如果i成立，那么[0, i-1]的都是失败的。[0,i-1]中任何一个结点作为start，都不行。i作为start能抵达数组末尾。
    //      由于必然存在循环，且从0开始，第一个能抵达数组末尾的是i，则说明i在数组末尾的油量是足够从0到i的。
    //      由于i是第一个能到达数组尾的，说明[0, i-1]都无法到达i结点。
    //      好像还是只能数学归纳法。。
    //      如果0可以到达尾巴，那么根据必然有环，尾巴->0肯定是可以的。
    //      如果0没有办法，但1可以到达尾巴，说明cost[0] > gas[0],根据gas总 > cost总，可知: gas[1,end]-cast[1,end] > cost[0] - gas[0]..这个好像没用。。
    //      如果0,1没有办法，但2可以，两种情况，0无法到达1&&1无法到达2,或者0能到达1但无法到达2&&1无法到达2.。都是因为gas < cost,
    //      但是由于gas总 > cost总，所以在数组尾的剩余gas，足够成环。。
    //      不知道怎么证明。。。找不到关键点。
    private int Lt0134a(int[] gas, int[] cost)
    {
        int result = -1;
        if (gas == null)
        {
            return -1;
        }
        if (gas.length == 1)
        {
            return gas[0] < cost[0] ? -1 : 0;
        }
        for (int i = 0; i < gas.length; i++)
        {
            if (canTravelAround(gas, cost, i, 0, i))
            {
                return i;
            }
        }
        
        return result;
    }
    
    private boolean canTravelAround(int[] gas, int[] cost, int index, int remain, int endIndex)
    {
        int i = index;
        int gSum = gas[i];
        int cSum = cost[i];
        boolean second = false;
        while (true)
        {
            if (gSum < cSum)
            {
                return false;
            }
            if (i == endIndex)
            {
                if (second)
                {
                    break;
                }
                else
                {
                    second = true;
                }
            }
            i++;
            if (i == gas.length)
            {
                i = 0;
            }
            gSum += gas[i];
            cSum += cost[i];
        }
        return true;
    }
    
}
