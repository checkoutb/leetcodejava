package ge100;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 102. Binary Tree Level Order Traversal
 * */
public class LT0102
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(3,9,20,null,null,15,7)[0];
        
        System.out.println(new LT0102().Lt0102(root));
    }

    // 2ms. most are 1ms.
    // 看了其他人的代码。。用到了队列。这样只要知道队列的长度，那么就for这个长度，出队，入队。。不要考虑下标之类的东西。下次继续for队列长度
    private List<List<Integer>> Lt0102(TreeNode root)
    {
        if (root == null)
        {
            return new LinkedList<>();
        }
        TreeNode tagNode = new TreeNode(-1);
        List<TreeNode> nodeList = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> intList = null;
        
        nodeList.add(tagNode);
        nodeList.add(root);
        
        TreeNode node = null;
        
        while (nodeList.size() >= 1)
        {
            node = nodeList.remove(0);
            if (node == tagNode)
            {
                if (!nodeList.isEmpty())
                {
                    nodeList.add(tagNode);
                }
                else
                {
                    continue;
                }
                intList = new LinkedList<>();
                result.add(intList);
                continue;
            }
            intList.add(node.val);
            if (node.left != null)
            {
                nodeList.add(node.left);
            }
            if (node.right != null)
            {
                nodeList.add(node.right);
            }
        }
        return result;
    }
}
