package ge100;

import java.util.Arrays;

/**
 * 135. Candy
 * */
public class LT0135
{

    public static void main(String[] args)
    {
        int[] ratings = { 1, 0, 2 };
//        ratings = new int[] { 1, 2, 87, 87, 87, 2, 1 };
//        ratings = new int[] { 0, 1, 2, 3, 2, 1 };
        ratings = new int[] { 0, 1, 2, 5, 3, 2, 7 };
//        ratings = new int[] { 1, 2, 2 };
//        ratings = new int[] { 10, 10, 10, 10, 10, 10 };
        ratings = new int[] { 1, 3, 2, 2, 1 };
        ratings = new int[] { 1, 2, 3, 5, 4, 3, 2, 1, 4, 3, 2, 1, 3, 2, 1, 1, 2, 3, 4 };
        
        System.out.println(new LT0135().Lt0135h(ratings));
        
    }
    
    // it has been accepted, although it is so looooooooooooooooooooooooooooooooooooooooong.
    // 3ms....most are [2, 4]ms.
    private int Lt0135h(int[] ratings)
    {
        if (ratings.length == 1)
        {
            return 1;
        }
        
        int[] nums = new int[ratings.length];
        int bi = 0;
        int ti = 0;
        int j = 0;
        int t = 0;
        for (int i = 0; i < ratings.length; i++)
        {
            if (i == 0)
            {
                if (ratings[i] > ratings[1])
                {
                    bi = this.funh1(ratings, 1);
                    t = 1;
//                    nums[0] = 1;
                    for (j = bi; j > i; j--)
                    {
                        nums[j] = t++;
                    }
                    if (t > nums[i])        // .
                    {
                        nums[i] = t;
                    }
                    i = bi;
                    continue;
                }
                else
                {
                    nums[i] = 1;
                }
            }
            else if (i == ratings.length - 1)
            {
                if (ratings[i] > ratings[i - 1])
                {
                    nums[i] = nums[i - 1] + 1;
                }
                else
                {
                    nums[i] = 1;
                }
            }
            else
            {
                if (ratings[i] < ratings[i + 1])
                {
                    if (ratings[i] == ratings[i - 1])
                    {
                        nums[i] = 1;
                    }
                    else
                    {
                        nums[i] = nums[i - 1] + 1;
                    }
                }
                else if (ratings[i] == ratings[i + 1])
                {
                    if (ratings[i] == ratings[i - 1])
                    {
                        nums[i] = 1;
                    }
                    else
                    {
                        nums[i] = nums[i - 1] + 1;
                    }
                }
                else if (ratings[i] > ratings[i + 1])
                {
                    if (ratings[i] > ratings[i - 1])
                    {
                        nums[i] = nums[i - 1] + 1;
                    }
                    else
                    {
                        if (ratings[i] == ratings[i - 1])
                        {
                            nums[i] = 1;
                        }
                    }
                    bi = this.funh1(ratings, i + 1);
                    t = 1;
//                    nums[0] = 1;
                    for (j = bi; j > i; j--)
                    {
                        nums[j] = t++;
                    }
                    if (t > nums[i])        // .
                    {
                        nums[i] = t;
                    }
                    i = bi;
                    continue;
                }
            }
        }
        
//        System.out.println(Arrays.toString(ratings) + "\n" + Arrays.toString(nums));
        
        int result = 0;
        
        for (int num : nums)
        {
            result += num;
        }
        
        return result;
    }
    
    private int funh1(int[] ratings, int s)
    {
        for (; s < ratings.length - 1; s++)
        {
            if (ratings[s] <= ratings[s - 1] && ratings[s] <= ratings[s + 1])
            {
                break;
            }
        }
        return s;
    }
    
    // 驻点。。。
    // error
    @Deprecated
    private int Lt0135f(int[] ratings)
    {
        if (ratings.length == 1)
        {
            return 1;
        }
        int result = 0;
        
        int[][] arr = this.pretreatmentf1(ratings);
        
        
        System.out.println(Arrays.toString(arr[0]) + "\n" + Arrays.toString(arr[1]));
        
        int[] nums = new int[ratings.length];
        int ti = 0;
        int bi = 0;
        int[] top = arr[0];
        int[] bottom = arr[1];
        
        int index = 0;
        int left = 0;
        int right = 0;
        int lastMe = 0;
        int me = 0;
        int i = 0;
        for (; bi < bottom.length; bi++)
        {
            lastMe = me;
            me = bottom[bi];
            nums[me] = 1;
//            if (ti + 1 >= top.length)
//            {
//                break;
//            }
//            left = top[ti++];
//            right = top[ti];
            
            left = -1;
            right = -1;
            for (int j = 0; j < top.length - 1; j++)
            {
                if (top[j] <= me && me <= top[j + 1])
                {
                    left = top[j] < lastMe ? lastMe : top[j];
                    right = top[j + 1];
                }
            }
            
            left = left == -1 ? me : left;
            right = right == -1 ? me : right;
            
            for (i = me - 1; i > left; i--)
            {
                nums[i] = nums[i + 1] + 1;
            }
            if (i == left)
            {
                if (nums[i] == 0)
                {
                    nums[i] = nums[i + 1] + 1;
                }
                else
                {
                    if (nums[i] < nums[i + 1] + 1)
                    {
                        nums[i] = nums[i + 1] + 1;
                    }
                }
            }
            for (i = me + 1; i <= right; i++)
            {
                nums[i] = nums[i - 1] + 1;
            }
//            if (i == left)
//            {
//                
//            }
            
        }
        
        System.out.println(Arrays.toString(ratings) + "\n" + Arrays.toString(nums));
        
        for (int num : nums)
        {
            result += num;
        }
        
        return result;
    }
    
    private int[][] pretreatmentf1(int[] ratings)
    {
        int[][] result = new int[2][];
        int[] top = new int[ratings.length];
        int[] bottom = new int[ratings.length];
        int ti = 0;
        int bi = 0;
        if (ratings[0] <= ratings[1])
        {
            bottom[bi++] = 0;
//            top[ti++] = 0;
        }
        else
        {
            top[ti++] = 0;
        }
        int i = 1;
        for (; i < ratings.length - 1; i++)
        {
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
            {
                bottom[bi++] = i;
            }
            else if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1])
            {
                top[ti++] = i;
            }
        }
        if (ratings[i] <= ratings[i - 1])
        {
            bottom[bi++] = i;
//            top[ti++] = i;
        }
        else
        {
            top[ti++] = i;
        }
        
        result[0] = Arrays.copyOf(top, ti);
        result[1] = Arrays.copyOf(bottom, bi);
        
        return result;
    }

    // error
    @Deprecated
    private int Lt0135e(int[] ratings)
    {
        if (ratings.length == 1)
        {
            return 1;
        }
        int result = 0;
        int[] nums = new int[ratings.length];
        int left = 0;
        int right = 0;
        for (int i = 0; i < ratings.length; i++)
        {
            if (i == 0)
            {
                if (ratings[0] <= ratings[1])
                {
                    nums[0] = 1;
                }
                else
                {
                    if (nums[1] == 0)
                    {
                        
                    }
                    nums[0] = nums[1] + 1;
                }
            }
            else if (i == ratings.length - 1)
            {
                if (ratings[i] <= ratings[i - 1])
                {
                    nums[i] = 1;
                }
                else
                {
                    if (nums[i - 1] == 0)
                    {
                        
                    }
                    nums[i] = nums[i - 1] + 1;
                }
            }
            else
            {
                
            }
            
        }
        
        return result;
    }
    
    // error
    @Deprecated
    private int Lt0135d(int[] ratings)
    {
        if (ratings.length == 1)
        {
            return 1;
        }
        int result = 0;
        boolean change = false;
        int last = 0;
        int me = 0;
        int next = 0;
        while(true)
        {
            change = false;
            last = -1;
            next = ratings[0];
            me = Integer.MAX_VALUE;
            for (int i = 1; i < ratings.length; i++)
            {
                last = me;
                me = next;
                next = ratings[i];
                if (me <= last && me <= next)
                {
                    ratings[i - 1] = 1;
                }
                else
                {
                    if (me > next)
                    {
                        if (me > last)
                        {
                            
                        }
                    }
                    else
                    {
                        
                    }
                }
            }
            
            if (!change)
            {
                break;
            }
        }
        
        return result;
    }
    
    
    // error
    @Deprecated
    private int Lt0135c(int[] ratings)
    {
        if (ratings.length == 1)
        {
            return 1;
        }
        int result = 0;
        
        int[] numArr = new int[ratings.length];
        
        this.pretreatmentc1(ratings, numArr, 0);
        
        System.out.println(Arrays.toString(ratings) + "\n" + Arrays.toString(numArr));
        
        for (int i : numArr)
        {
            result += i;
        }
        
        return result;
    }
    
    private int pretreatmentc1(int[] ratings, int[] numArr, int index)
    {
        int numMe = 0;
        int ratingsMe = ratings[index];
        
        if (index == 0)
        {
            if (ratings[0] <= ratings[1])
            {
                numMe = 1;
                numArr[index] = numMe;
                pretreatmentc1(ratings, numArr, index + 1);
            }
            else
            {
                numMe = pretreatmentc1(ratings, numArr, index + 1) + 1;
                numArr[index] = numMe;
            }
        }
        else if (index == ratings.length - 1)
        {
            if (ratings[index] <= ratings[index - 1])
            {
                numMe = 1;
                numArr[index] = numMe;
            }
            else
            {
                numMe = numArr[index - 1] + 1;
                numArr[index] = numMe;
            }
        }
        else
        {
            int left = ratings[index - 1];
            int right = ratings[index + 1];
            if (ratingsMe <= left && ratingsMe <= right)
            {
                numMe = 1;
                numArr[index] = numMe;
                pretreatmentc1(ratings, numArr, index + 1);
            }
            else
            {
                boolean isLeftHigher = left >= right;
                int max2 = isLeftHigher ? left : right;
                if (ratingsMe > max2)
                {
                    if (isLeftHigher)
                    {
                        numMe = numArr[index - 1] + 1;
                        numArr[index] = numMe;
                        pretreatmentc1(ratings, numArr, index + 1);
                    }
                    else
                    {
                        numMe = this.pretreatmentc1(ratings, numArr, index + 1) + 1;
                        int l = numArr[index - 1];
                        numMe = numMe > (l + 1) ? numMe : (l + 1);
                        numArr[index] = numMe;
                    }
                }
                else
                {
                    if (isLeftHigher)
                    {
                        numMe = this.pretreatmentc1(ratings, numArr, index + 1) + 1;
                        int l = numArr[index - 1];
                        numMe = numMe > (l + 1) ? numMe : (l + 1);
                        numArr[index] = numMe;
                    }
                    else
                    {
                        numMe = numArr[index - 1] + 1;
                        numArr[index] = numMe;
                        pretreatmentc1(ratings, numArr, index + 1);
                    }
                }
            }
        }
        
//        numArr[index] = numMe;
        return numMe;
    }
    
    
    // error
    @Deprecated
    private int Lt0135b(int[] ratings)
    {
        if (ratings.length == 1)
        {
            return 1;
        }
        int result = 0;
        this.pretreatmentb1(ratings, 0);
        for (int i : ratings)
        {
            result += i;
        }
        
        System.out.println(Arrays.toString(ratings));
        
        return result;
    }
    
    private int pretreatmentb1(int[] ratings, int index)
    {
        if (index == (ratings.length - 1))
        {
            if (ratings[index] > ratings[index - 1])
            {
                ratings[index] = ratings[index - 1] + 1;
            }
            else
            {
                ratings[index] = 1;
            }
            return ratings[index];
        }
        int left = index > 0 ? ratings[index - 1] : 0;
        int right = index < ratings.length - 1 ? ratings[index + 1] : 0;
        int me = ratings[index];
        if (me <= left && me <= right)
        {
            me = 1;
            ratings[index] = 1;
            this.pretreatmentb1(ratings, index + 1);
            return 1;
        }
        if (me > left)
        {
            if (me > right)
            {
                int leftNum = index > 0 ? ratings[index - 1] : 0;
                int rightNum = this.pretreatmentb1(ratings, index + 1);
                me = (leftNum > rightNum ? leftNum : rightNum) + 1;
                ratings[index] = me;
            }
            else
            {
                me = (index > 0 ? ratings[index - 1] : 0) + 1;
                ratings[index] = me;
                this.pretreatmentb1(ratings, index + 1);
            }
        }
        else
        {
            // me > right
            me = this.pretreatmentb1(ratings, index + 1) + 1;
            ratings[index] = me;
        }
        
        return me;
    }
    
    // 写到差不多的时候，觉得可以直接根据优先级来生成糖果数。。把优先级整体降下去。
    // 必须改了，，47/48 timeout...20000 到 0。。。
    @Deprecated
    private int Lt0135a(int[] ratings)
    {
        int result = 0;
        
        int[] indexArr = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++)
        {
            indexArr[i] = i;
        }
        int[] ratings2 = Arrays.copyOf(ratings, ratings.length);
        sort(ratings2, indexArr);
        
//        System.out.println(Arrays.toString(ratings2));
//        System.out.println(Arrays.toString(indexArr));
        
        for (int i = 0; i < ratings2.length; i++)
        {
            ratings2[i] = 0;
        }
        
        int num = 1;
        int i = 0;
        int t1 = ratings[indexArr[0]];
        for (; i < indexArr.length; i++)
        {
            if (ratings[indexArr[i]] == t1)
            {
                ratings2[indexArr[i]] = 1;
            }
            else
            {
                break;
            }
        }
        result += i;
        for (; i < indexArr.length; i++)
        {
            result += (ratings2[indexArr[i]] = this.candyNum2(ratings, ratings2, indexArr[i]));
        }
        
        return result;
    }
    
    private int candyNum2(int[] ratings, int[] ratings2, int index)
    {
        boolean isHigher = false;
        int t1 = 0;
        int t2 = 0;
        if (index > 0 && ratings[index] > ratings[index - 1])
        {
            t1 = ratings2[index - 1];
            isHigher = true;
        }
        if (index < ratings.length - 1 && ratings[index] > ratings[index + 1])
        {
            t2 = ratings2[index + 1];
            isHigher = true;
        }
        return (t1 > t2 ? t1 : t2) + 1;
    }
    
    private int candyNum(int[] ratings2, int index)
    {
        int left = index > 0 ? ratings2[index - 1] : 0;
        int right = (index < ratings2.length - 1) ? ratings2[index + 1] : 0;
        return left > right ? left + 1 : right + 1;
    }
    
    private boolean isHigher(int[] ratings, int index)
    {
        if (index > 0 && ratings[index] > ratings[index - 1])
        {
            return true;
        }
        if (index < ratings.length - 1 && ratings[index] > ratings[index + 1])
        {
            return true;
        }
        return false;
    }
    
    private void sort(int[] ratings, int[] indexArr)
    {
        int t1 = 0;
        for (int step = (ratings.length / 2); step >= 1; step /= 2)
        {
            for (int i = 0; i < step; i++)
            {
                for (int j = i; j < ratings.length - step; j += step)
                {
                    for (int k = j; k < ratings.length; k += step)
                    {
                        if (ratings[j] > ratings[k])
                        {
                            t1 = ratings[j];
                            ratings[j] = ratings[k];
                            ratings[k] = t1;
                            t1 = indexArr[j];
                            indexArr[j] = indexArr[k];
                            indexArr[k] = t1;
                        }
                    }
                }
            }
        }
    }
    
}
