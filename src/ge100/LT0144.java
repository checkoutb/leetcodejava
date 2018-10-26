package ge100;

import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;

/**
 * 144. Binary Tree Preorder Traversal
 * */
public class LT0144
{

    public static void main(String[] args)
    {

    }

    // 0ms, most are [0, 1]ms.
    private List<Integer> Lt0144a(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();
        
        this.recursiona(root, result);
        return result;
    }
    
    private void recursiona(TreeNode node, List<Integer> list)
    {
        if (node == null)
        {
            return;
        }
        list.add(node.val);
        recursiona(node.left, list);
        recursiona(node.right, list);
    }
}
