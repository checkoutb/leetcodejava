package ge100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * */
public class LT0103
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(3,9,20,null,null,15,7)[0];
        
        System.out.println(new LT0103().Lt0103(root));
    }

    // 1ms
    private List<List<Integer>> Lt0103(TreeNode root)
    {
        if (root == null)
        {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> intList = null;
        
        // 用两个队列就简单多了
        Deque<TreeNode> nodeDeque = new LinkedList<>();             // LinkedList是Deque...
        nodeDeque.addFirst(root);
        
        int size = 0;
        TreeNode node = null;
        boolean flag = false;            // true : left->right ; false : right->left
        while ((size = nodeDeque.size()) > 0)
        {
            flag = !flag;
            intList = new LinkedList<>();
            result.add(intList);
            for (int i = 0; i < size; i++)
            {
                node = flag ? nodeDeque.pollFirst() : nodeDeque.pollLast();
                intList.add(node.val);
                if (flag)
                {
                    if (node.left != null)
                    {
                        nodeDeque.addLast(node.left);
                    }
                    if (node.right != null)
                    {
                        nodeDeque.addLast(node.right);
                    }
                }
                else
                {
                    if (node.right != null)
                    {
                        nodeDeque.addFirst(node.right);
                    }
                    if (node.left != null)
                    {
                        nodeDeque.addFirst(node.left);
                    }
                }
            }
        }
        return result;
    }
}
