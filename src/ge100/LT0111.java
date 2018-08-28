package ge100;

import java.util.Deque;
import java.util.LinkedList;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 111. Minimum Depth of Binary Tree
 * */
public class LT0111
{

    public static void main(String[] args)
    {
        TreeNode head = LTUtils.convertArrayToTreeArray2(3,9,20,null,null,15,7)[0];
        LTUtils.showTree(head, 3);
        
        System.out.println(new LT0111().Lt0111(head));
    }
    
    
    /**
     * 其他代码都是递归。。。return Math.min(left, right) + 1;
     * */
    
    
    
    // 1ms, most are 0ms...
    private int Lt0111(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        TreeNode tag = new TreeNode(-1);
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.addLast(root);
        nodeDeque.addLast(tag);
        TreeNode node = null;
        int depth = 1;
        while (nodeDeque.size() > 1)
        {
            if ((node = nodeDeque.removeFirst()) == tag)
            {
                depth++;
                nodeDeque.addLast(tag);
                continue;
            }
            if (node.left == null && node.right == null)
            {
                return depth;
            }
            if (node.left != null)
            {
                nodeDeque.addLast(node.left);
            }
            if (node.right != null)
            {
                nodeDeque.addLast(node.right);
            }
        }
        return -1;
    }
}
