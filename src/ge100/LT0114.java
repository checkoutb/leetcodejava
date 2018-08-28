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
        
        LTUtils.showTree(head, 3);
    }

    private void Lt0114(TreeNode root)
    {
        
    }
}
