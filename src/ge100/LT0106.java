package ge100;

import java.util.HashMap;
import java.util.Map;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * */
public class LT0106
{

    public static void main(String[] args)
    {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        
        LTUtils.showTree(new LT0106().Lt0106(inorder, postorder), 3);
    }

    // 4ms, most are 3ms..
    // 看了105题的3ms以后，这个就很容易了。。。
    private TreeNode Lt0106(int[] inorder, int[] postorder)
    {
        Map<Integer, Integer> value2InIndex = new HashMap<>();
        int j = 0;
        for (int v : inorder)
        {
            value2InIndex.put(v, j++);
        }
        int num = inorder.length - 1;
        TreeNode root = generateTree(postorder, value2InIndex, 0, num, 0, num);

        return root;
    }
    
    private TreeNode generateTree(int[] postorder, Map<Integer, Integer> value2InIndex, int postStart, int postEnd, int inStart, int inEnd)
    {
        if (postStart > postEnd)
        {
            return null;
        }
        int value = postorder[postEnd];
        TreeNode node = new TreeNode(value);

        int inIndex = value2InIndex.get(value);
        int leftNum = inIndex - inStart;

        node.left = generateTree(postorder, value2InIndex, postStart, postStart + leftNum - 1, inStart, inIndex - 1);
        node.right = generateTree(postorder, value2InIndex, postStart + leftNum, postEnd - 1, inIndex + 1, inEnd);

        return node;
    }
    
}
