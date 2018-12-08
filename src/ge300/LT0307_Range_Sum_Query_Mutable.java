package ge300;

public class LT0307_Range_Sum_Query_Mutable
{

    public static void main(String[] args)
    {
//        int[] nums = {1,3,5};
        
        int[] nums = {-1};
        Lt0307b.NumArray na = new Lt0307b().new NumArray(nums);
//        System.out.println(na.sumRange(0, 2));
//        na.update(1, 2);
//        System.out.println(na.sumRange(0, 2));
        
        System.out.println(na.sumRange(0, 0));
        na.update(0, 1);
        System.out.println(na.sumRange(0, 0));
    }

    
    
    
}



class Lt0307b
{

    // 471ms...most are [65, 117]ms.
    // 用了二叉树。
    /*  68ms
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.tree = new int[this.n * 2];
        for (int i = 0; i < nums.length; i++) {
            this.tree[i + this.n] = nums[i];
        }
        for (int i = this.n - 1; i > 0; i--) {
            this.tree[i] = this.tree[2 * i] + this.tree[2 * i + 1];
        }
    }
    */
    
    /*  80ms
    private void buildTree(int[] nums) {
        for (int i = size, j = 0; j < nums.length; j++, i++) {
            tree[i] = nums[j];
        }
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
    */
    
    /*  342ms, 看lambda。
    public NumArray(int[] nums) {
        this.nums = nums;
        IntStream.range(0, nums.length)
                .forEach(i -> {
                    final int prevSum;
                    if (i > 0) {
                        prevSum = nums[i - 1];
                    } else {
                        prevSum = 0;
                    }
                    nums[i] = nums[i] + prevSum;
                });
    }
    
    IntStream.range(i, nums.length).forEach(j -> {
        nums[j] = nums[j] + diff ;
    });
    */
    
    class NumArray
    {

        private int[] arr;
        
        public NumArray(int[] nums)
        {
            this.arr = new int[nums.length + 1];
            for (int i = 1; i < arr.length; i++)
            {
                arr[i] = arr[i - 1] + nums[i - 1];
            }
        }

        public void update(int i, int val)
        {
            int t = val - arr[i + 1] + arr[i];
            i++;
            while (i < arr.length)
                arr[i++] += t;
        }

        public int sumRange(int i, int j)
        {
            return arr[j + 1] - arr[i];
        }
    }

}

class Lt0307a
{
    
    // 398ms.
    class NumArray
    {
        
        private int[] arr;

        public NumArray(int[] nums)
        {
            this.arr = nums;
        }

        public void update(int i, int val)
        {
            this.arr[i] = val;
        }

        public int sumRange(int i, int j)
        {
            int s = 0;
            while (i <= j)
                s += arr[i++];
            return s;
        }
        
    }
}

//class NumArray {
//    
//    public NumArray(int[] nums) {
//        
//    }
//    
//    public void update(int i, int val) {
//        
//    }
//    
//    public int sumRange(int i, int j) {
//        
//    }
//}
