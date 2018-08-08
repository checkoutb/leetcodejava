package gt000;

import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 98. Validate Binary Search Tree
 * */
public class LT0098
{

    public static void main(String[] args)
    {
        
        List<TreeNode> rootList = new LinkedList<>();
        
        Integer[][] metaDate = {{2,1,3},{5,1,4,null,null,3,6},{10,5,15,null,null,6,20},
                {3,1,5,0,2,4,6,null,null,null,3},{2147483644,-2147483648,2147483646,null,null,2147483645,2147483647}};
        
        TreeNode[] nodeArr = null;
        
        for(int i = 0; i < metaDate.length; i++)
        {
            nodeArr = LTUtils.convertArrayToTreeArray(metaDate[i]);
            rootList.add(nodeArr[0]);
        }
        
        for(TreeNode root : rootList)
        {
            LTUtils.showTree(root, 3);
        }
        
        for(TreeNode root : rootList)
        {
            System.out.println(Lt0098(root));
        }
        
    }

    // right.val < this.val &&&&&&&&& right.val > parent.val
    // ...parent.parent.parent........val...
    
    // 1ms..
    public static boolean Lt0098(TreeNode root)
    {
        if(root == null)
            return true;
        
//        int pLeft = 0;
//        int pRight = 0;
//        if(root.left != null)
//        {
//            pLeft = root.left.val
//        }
//        
//        if(root.right != null)
//        {
//            
//        }
        
        boolean result = recursion(root, Long.MIN_VALUE, Long.MAX_VALUE, 0);
        
        return result;
    }
    
    // type : 0->root, 1->parent.left, 2->parent.right
    private static boolean recursion(TreeNode node, long parentMin, long parentMax, int type)
    {
//        boolean result = false;
        
//        if(node.val == 15)
//        {
//            System.out.println(node.val);
//        }
        boolean result = false;
        long max = 0;
        long min = 0;
        if(node.left != null)
        {
            if(node.left.val < node.val && (type == 0 || (node.left.val > parentMin && node.left.val < parentMax)))     // 2147483647...
            {
                max = parentMax > node.val ? node.val : parentMax;
                result = recursion(node.left, parentMin, max, 1);
                if(!result)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        if(node.right != null)
        {
            if(node.right.val > node.val && (type == 0 || (node.right.val > parentMin && node.right.val < parentMax)))
            {
                min = parentMin > node.val ? parentMin : node.val;
                result = recursion(node.right, min, parentMax, 2);
                if(!result)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
