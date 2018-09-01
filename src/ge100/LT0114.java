package ge100;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 114. Flatten Binary Tree to Linked List
 * */
public class LT0114
{

    public static void main(String[] args)
    {
        TreeNode head = LTUtils.convertArrayToTreeArray2(1,2,5,3,4,null,6)[0];
        LTUtils.showTree(head, 3);
        
        new LT0114().Lt0114(head);
        
        LTUtils.showTree(head, 6);
    }
    
    
    // 看到一种解法：右子树优先的后序遍历。这种遍历方法处理的第一个点就是末结点，然后一个一个往上走。需要一个全局变量。
    
    // 9ms，almost fastest
    private void Lt0114(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        TreeNode node = root;
        preorder(node);
        while (node.left != null)
        {
            node.right = node.left;
            node.left = null;
            node = node.right;
        }
    }
    
    private TreeNode preorder(TreeNode node)
    {
        TreeNode left = node.left;
        TreeNode right = node.right;
        TreeNode pre = node;
        if (left != null)
        {
            pre = preorder(left);
        }
        
        if (right != null)
        {
            pre.left = right;
            node.right = null;
            pre = preorder(right);
        }
        return pre;
    }
}
