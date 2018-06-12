package gt000;

import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 94. Binary Tree Inorder Traversal
 * */
public class LT0094
{

    public static void main(String[] args)
    {
        Integer[] treeArr = {1,null,2,null,null,3};
        
        TreeNode[] treeNodeArr = LTUtils.convertArrayToTreeArray(treeArr);
        
        List<Integer> result = Lt0094(treeNodeArr[0]);
        
        System.out.println(result);
    }
    
    public static List<Integer> Lt0094(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();
        
        inorder(root, result);
        
        
        return result;
    }

    // 1ms
    private static void inorder(TreeNode node, List<Integer> result)
    {
        if (node == null)
            return;
        
        TreeNode left = node.left;
//        if (left != null)
            inorder(left, result);
        
        result.add(node.val);
        
        TreeNode right = node.right;
//        if (right != null)
            inorder(right, result);
    }
}


/*

copy from other's solution

use stack

while (root != null || !stack.isEmpty()) {
    if (root != null) {
        stack.push(root);
        root = root.left;
    } else {
        root = stack.pop();
        res.add(root.val);
        root = root.right;
    }
}


*/