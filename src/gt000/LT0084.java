package gt000;

/**
 * 84. Largest Rectangle in Histogram
 * */
public class LT0084
{

    public static void main(String[] args)
    {
        int[] heights = {2,1,5,6,2,3};
        
        System.out.println(Lt0084a(heights));
    }

    
    // 想不出怎么优化。。。不知道从最大值/下标中间值开始向两侧遍历会不会速度快一点点？
    // 还是 找出最大值，然后向两侧开始遍历，对每一个碰到的值保存第一次比它小的值的下标？
    public static int Lt0084a(int[] heights)
    {
        int result = 0;
        int len = heights.length;
        int i = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        int t = 0;
        int t2 = 0;
        
        while(i < len)
        {
            i++;
        }
        
        
        return result;
    }
    
    
    // 168ms || timeout...
    public static int Lt0084(int[] heights)
    {
        int result = 0;
        int len = heights.length;
        int i = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        int t = 0;
        int t2 = 0;
        
        while(i < len)
        {
            start = i - 1;
            end = i + 1;
            t = heights[i];
            while(start >= 0 && heights[start] >= t)
            {
                start--;
            }
            start++;
            while(end < len && heights[end] >= t)
            {
                end++;
            }
            end--;
            
            t2 = (end - start + 1) * t;
            if(t2 > max)
            {
                max = t2;
            }
            for(; i < len; i++)
            {
                if(heights[i] != t)
                {
                    break;
                }
            }
        }
        
        result = max;
        return result;
    }
    
    
    // 很多方法都用来stack，不知道怎么用到这里。
    
    // not mine, one of 4ms.
    // 靠，有代码都无法理解啊。。。
    public int largestRectangleArea(int[] heights) {
        int res = 0, len = heights.length;
        if (len == 0) return res;
        int[] index = new int[len];
        int p = -1;
        for (int i = 0; i < len; i++) {
            if (p == -1 || heights[i] >= heights[index[p]]) {
                p++;
                index[p] = i;
            }
            else {
                // 第一次进入这个while，是第一次下降的时候。
                // 如果没有这个while，index的元素的值就是下标。并且，在这行时，p是前一个下标。
                // 所以第一次进入while时，index[p]是前一个下标，也是至今的最高值。
                while (p >= 0 &&  heights[i] < heights[index[p]]) {
                    // 前前面一个下标啊。
                    int start = p > 0 ? index[p - 1] : -1;
                    // 第一次的时候(i-start-1)就是1
                    // 这里就是每次碰到下降就一直回退到比它低的地方。
                    res = Math.max(res, (i - start - 1) * heights[index[p]]);
                    p--;
                }
                p++;
                index[p] = i;
            }
        }
        
        
        
        // 画个曲线的话，的确是，当曲线下降时，去计算前面的面积才是有意义的。而且高度是要>本次的，并且计算过以后就可以扔掉了。
        // 思想就应该是这个。nbnbnbnbnbnb。
        // 看来以后曲线图都能用这个套啊，只有曲线下降时，去计算前面的高度>本次的。并且算完扔掉。
        // 曲线下降才去计算，算完扔掉。
        
        // 这个应该是和上面那个while一样的。也是回退到比他低的地方。
        int end = index[p];
        while (p >= 0) {
            int start = p > 0 ? index[p - 1] : -1;
            res = Math.max(res, (end - start) * heights[index[p]]);
            p--;
        }
        return res;
    }
}
