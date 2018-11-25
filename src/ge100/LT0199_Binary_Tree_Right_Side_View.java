package ge100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0199_Binary_Tree_Right_Side_View
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(1,2,3,5,null,null,null,7,10)[0];
        LTUtils.showTree(root, 5);
        System.out.println(new LT0199_Binary_Tree_Right_Side_View().Lt0199a(root));
    }

    // level-order
    // 1ms, most are [0, 2]ms.
    // 其他的一个解法，递归，传进去TreeNode,做为结果的链表，int深度，如果深度==链表.size()，链表.add().
    //              先序遍历，且先右子树。所以每一层都是最右的结点最先被遍历到，通过判断深度和链表的长度，可以每层只加一个，且加的这个是最右的。
    private List<Integer> Lt0199a(TreeNode root)
    {
        
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        
        deque.addFirst(root);           // 头加，尾pop，先左后右。
        int size = 1;
        int i = 0;
        TreeNode node = null;
        while (!deque.isEmpty())
        {
            size = deque.size();
            result.add(deque.peekFirst().val);
            
            for (i = 0; i < size; i++)
            {
                node = deque.pollLast();
                if (node.left != null)
                    deque.addFirst(node.left);
                if (node.right != null)
                    deque.addFirst(node.right);
            }
        }
        
        return result;
    }
}
