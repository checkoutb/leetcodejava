package ge100;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 112. Path Sum
 * */
public class LT0112
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(5,4,8,11,null,13,14,7,2,null,null,null,null,null,1)[0];
        LTUtils.showTree(root, 5);
        System.out.println(new LT0112().Lt0112(root, 22));
    }
    
    
    /**
     * 其他人 的 0ms 的 代码。。。。没什么说的，劈个叉吧
     * 
     * if(root == null) return false;
     * if(root.left == null && root.right == null ) return root.val==sum;
     * return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
     */

    // zero zone...
    private boolean Lt0112(TreeNode root, int sum)
    {
        if (root == null)
        {
            return false;
        }
        boolean result = recursion(root, sum, 0);
        return result;
    }
    
    private boolean recursion(TreeNode node, int sum, int now)
    {
        now += node.val;
//        if (sum < now)            // 有负数的存在，所以：1不能提前return，2不能用<，而是应该对比绝对值。有1了，2就没什么意义了。
//        {
//            return false;
//        }
        if (node.left == null && node.right == null)
        {
            return now == sum;
        }
        boolean result = false;
        if (node.left != null)
        {
            result = recursion(node.left, sum, now);
            if (result)
            {
                return result;
            }
        }
        if (node.right != null)
        {
            result = recursion(node.right, sum, now);
            if (result)
            {
                return result;
            }
        }
        return false;
    }
}
