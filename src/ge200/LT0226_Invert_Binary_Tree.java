package ge200;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0226_Invert_Binary_Tree
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeLinkNode2(1,2,3,4,5,6,7)[0];
        LTUtils.showTree(root, 4);
        new LT0226_Invert_Binary_Tree().Lt0226a(root);
        LTUtils.showTree(root, 4);
    }

    // 0ms...almost all submissions are 0ms..
    private TreeNode Lt0226a(TreeNode root)
    {
        TreeNode node = root;
        this.recursiona1(node);
        return root;
    }
    
    private void recursiona1(TreeNode node)
    {
        if (node == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        this.recursiona1(node.left);
        this.recursiona1(node.right);
    }
}
