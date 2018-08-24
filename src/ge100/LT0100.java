package ge100;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 100. Same Tree
 * */
public class LT0100
{

    public static void main(String[] args)
    {
        TreeNode p = LTUtils.convertArrayToTreeArray(new Integer[] {1,2,3})[0];
        TreeNode q = LTUtils.convertArrayToTreeArray(new Integer[] {1,2,3})[0];
        p = LTUtils.convertArrayToTreeArray(new Integer[] {1,2})[0];
        q = LTUtils.convertArrayToTreeArray(new Integer[] {1, null, 2})[0];
        p = LTUtils.convertArrayToTreeArray(new Integer[] {1,1,2})[0];
        q = LTUtils.convertArrayToTreeArray(new Integer[] {1,2,1})[0];
        
        System.out.println(p.hashCode() + ", " + q.hashCode());     // hashCode is/are different
        
        LT0100 lt = new LT0100();
        System.out.println(lt.Lt0100(p, q));
    }

    // 4ms...most are 3ms...
    public boolean Lt0100(TreeNode p, TreeNode q)
    {
        boolean result = isSame(p, q);
        return result;
    }
    
    private boolean isSame(TreeNode p, TreeNode q)
    {
        if (p == null && q != null || p != null && q == null)
        {
            return false;
        }
        if (p == null && q == null)
        {
            return true;
        }
        if (p.val != q. val)
        {
            return false;
        }
        
        boolean result = isSame(p.left, q.left);
        if (!result)
        {
            return result;
        }
        result = isSame(p.right, q.right);
        return result;
    }
    
    private boolean isEqual(TreeNode p, TreeNode q)
    {
        if (p == q)
        {
            return true;
        }
        if (p == null || q == null)
        {
            return false;
        }
        if (p.val == q.val)
        {
            return true;
        }
        return false;
    }
}
