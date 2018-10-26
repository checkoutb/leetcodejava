package ge100;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0124
{

    public static void main(String[] args)
    {
        TreeNode root = null;
        root = LTUtils.convertArrayToTreeArray2(-10, 9, 20, null, null, 15, 7)[0];
        root = LTUtils.convertArrayToTreeArray2(-3)[0];
        root = LTUtils.convertArrayToTreeArray2(-2, -1)[0];
        root = LTUtils.convertArrayToTreeArray2(1, -2, -3, 1, 3, -2, null, -1)[0];
        root = LTUtils.convertArrayToTreeArray2(5,4,8,11,null,13,4,7,2,null,null,null,null,null,1)[0];
        root = LTUtils.convertArrayToTreeArray2(-2, null, -3)[0];
        root = LTUtils.convertArrayToTreeArray2(5,4,8,11,null,13,4,7,2,null,null,null,null,5,1)[0];   // 48
        LTUtils.showTree(root, 4);
        System.out.println(new LT0124().Lt0124c(root));
    }

    // 4ms, most are [1, 2]ms...
    /*
        我代码膨胀的速度比津巴布韦币还快。
        
        别人的解法。。注释是代码作者他自己的。。
        
        private int max = Integer.MIN_VALUE;
        public int dfs(TreeNode node){
            if(node == null) return 0;
            
            int left = Math.max(0, dfs(node.left));  //精髓在于此！！！ 如果左边或者右边是负的，则不取，只取能够让路径变长的正值
            int right = Math.max(0, dfs(node.right));
            max = Math.max(max, node.val + left + right); //不断更新结点的值，结点的值可以是原结点或者加上左右子树的值
            
            return Math.max(left,right) + node.val;
        }
        
     */
    private int Lt0124c(TreeNode root)
    {
        int result = 0;
        result = recursionc(root)[0];
        return result;
    }
    
    // 0max, 1line, join
    private int[] recursionc(TreeNode node)
    {
        if (node == null)
        {
            return new int[] { 0, 0, -2 };
        }
        if (node.left == null && node.right == null)
        {
            return new int[] { node.val, node.val, 1 };
        }
        int[] lv = this.recursionc(node.left);
        int[] rv = this.recursionc(node.right);
        
        int lmax = lv[0];
        int rmax = rv[0];
        
        int ll = lv[1];
        int rl = rv[1];
        
        int lj = lv[2];
        int rj = rv[2];
        
        int val = node.val;
        
        int max1 = (lj == -2 ? 0 : (lj == 1 ? lmax : ll)) + val;
        int max2 = (rj == -2 ? 0 : (rj == 1 ? rmax : rl)) + val;
        int max3 = (lj == -2 ? 0 : (lj == 1 ? lmax : ll)) + (rj == -2 ? 0 : (rj == 1 ? rmax : rl)) + val;
        
        int line1 = ll + val;
        int line2 = rl + val;
        int line3 = val;
        
//        int max4 = max1 > max2 ? max1 > max3 ? max1 : max3 : max2 > max3 ? max2 : max3;
//        int line4 = line1 > line2 ? line1 > line3 ? line1 : line3 : line2 > line3 ? line2 : line3;
        
//        System.out.println(max1 + ", " + max2 + ", " + max3);
        
        int max4 = Math.max(Math.max(max1, max2), max3);
        int line4 = Math.max(Math.max(line1, line2), line3);
        int join = 1;
        int temp1 = max4;
        max4 = Math.max(max4, Math.max(lj == -2 ? Integer.MIN_VALUE : lmax, rj == -2 ? Integer.MIN_VALUE : rmax));
        if (temp1 != max4)
        {
            join = -1;
        }
        max4 = Math.max(val, max4);
        
//        System.out.println(max4 + ", " + val + ", " + lmax + ", " + rmax);
        if (max4 == max3)
        {
            join = -1;
        }
        
//        System.out.println(max4 + ", " + line4 + ", " + join);
        return new int[] { max4, line4, join };
        
    }
    
    
    // error
    @Deprecated
    private int Lt0124b(TreeNode root)
    {
        int result = 0;
        result = this.recursionb(root)[1];
        return result;
    }
    
    private int[] recursionb(TreeNode node)
    {
        if (node == null)
        {
            return new int[] {0, 0, 0};
        }
        
        int[] lv = this.recursionb(node.left);
        int[] rv = this.recursionb(node.right);
        
        System.out.println(lv[1] + ", " + rv[1]);
        
        if (node.left == null && node.right == null)
        {
            return new int[] {node.val, node.val, 1};
        }
        int join = 1;
        int max = node.val;
        int maxLeft = lv[2] == 1 ? lv[0] : 0;
        int maxRight = rv[2] == 1 ? rv[0] : 0;
        int now = node.val;
        int nowLeft = 0;
        int nowRight = 0;
        
        max = (node.val < 0 ? 0 : node.val) + (maxLeft > maxRight ? lv[1] : rv[1]);
        now = node.val + (maxLeft > maxRight ? lv[1] : rv[1]);
        
        int max3 = node.val + maxLeft + maxRight;
        
        if (max < 0)
        {
            join = -1;
            now = 0;
        }
        
        int max2 = max > lv[1] ? max > rv[1] ? max : rv[1] : lv[1] > rv[1] ? lv[1] : rv[1];
        
        max2 = max2 > max3 ? max2 : max3;
        
        System.out.println("... " + max3 + ", " + node.val + ", " + maxLeft + ", " + maxRight + ", " + lv[1] + ", " + rv[1] + ", " + join);
        return new int[] {now, max2, join};
    }
    
    // 最开始认为这是 求路径和最大的 子树 的路径和。然后认为这是 求路径和最大的 连通图的路径和。
    // 百度了才知道，这是 求路径和最大的 线(不能回退) 的路径和。。。
    @Deprecated
    private int Lt0124a(TreeNode root)
    {
        
        int result = 0;
        
        result = recursiona(root)[1];
        
        return result;
    }
    
    // 0: all, 1: max
    private Integer[] recursiona(TreeNode node)
    {
        if (node == null)
        {
            return new Integer[] { 0, null, -1 };
        }

        Integer[] leftArr = this.recursiona(node.left);
        Integer[] rightArr = this.recursiona(node.right);

        int all = leftArr[0] + rightArr[0] + node.val;
        Integer leftMax = leftArr[1] == null ? 0 : leftArr[1];
        Integer rightMax = rightArr[1] == null ? 0 : rightArr[1];
        int max = 0;
        if (node.left == null && node.right == null)
        {
            max = node.val;
            return new Integer[] { all, max, 1 };
        }
        max = node.val + ((leftMax > 0 && leftArr[2] == 1) ? leftMax : 0) + ((rightMax > 0 && rightArr[2] == 1) ? rightMax : 0);
        int max2 = max;
        int join = 1;
        if (leftArr[1] != null)
        {
            max = max > leftMax ? max : leftMax;
        }
        
        if (rightArr[1] != null)
        {
            max = max > rightMax ? max : rightMax;
        }
        
        if (max2 != max)
        {
            join = -1;
        }
        
        return new Integer[] { all, max, join };
    }
}
