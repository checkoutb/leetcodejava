package ge100;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 101. Symmetric Tree
 * */
public class LT0101
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(1,2,2,3,4,4,3)[0];
        root = LTUtils.convertArrayToTreeArray2(1,2,2,null,3,null,3)[0];
//        root = LTUtils.convertArrayToTreeArray2()[0];
        LTUtils.showTree(root, 4);
        LT0101 lt = new LT0101();
        System.out.println(lt.Lt0101(root));
    }

    
    // 17ms. beats 1.7%... most are 8ms...
    private boolean Lt0101(TreeNode root)
    {
        if (root == null)           // ...
        {
            return true;
        }
        boolean result = isSymmetric(root.left, root.right);
        return result;
    }
    
    private boolean isSymmetric(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)             // ...
        {
            return true;
        }
        boolean result = isEqual(p, q);
        if (!result)
        {
            return result;
        }
        result = isSymmetric(p.left, q.right);
        if (!result)
        {
            return result;
        }
        
        result = isSymmetric(p.right, q.left);
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
