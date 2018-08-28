package ge100;

import java.util.ArrayList;
import java.util.List;

import pojo.ListNode;
import pojo.TreeNode;
import utils.LTUtils;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * */
public class LT0109
{

    public static void main(String[] args)
    {
        ListNode head = LTUtils.convertIntArray2ListNode(new int[] { -10, -3, 0, 5, 9 });
        
        LTUtils.showTree(new LT0109().Lt0109(head), 3);
    }
    
    /**
     * 这个是二叉搜索树的先序遍历，先while一遍，获得总长度以后，应该能一次就成型
     * 总长度就是 树的结点个数，结点个数向上取到2的n次方-1。就是满二叉树的结点。
     * 建立一棵满二叉树，将最后的 (2^n - ListNode个数) 个叶子结点变成null。
     * 然后中序遍历 二叉树，遍历的时候 顺便设置下值。
     * */
    
    /**
     * 1ms的代码。 用了快慢指针，当2倍速度的快指针到达尾巴的时候，1倍速度的慢指针就是中间的值。
     * 用一个指针指向慢指针的前面那个结点
     * 当找到 中间结点的时候(就是快指针到尾巴时，慢指针所指的结点)，慢指针前面的结点的next设置为null
     * 这样就分裂成了2个ListNode链，前一个全是左子树，后一个(除了它的首结点)全是右子树。
     * 返回 new TreeNode(慢指针.val)
     * treeNode.left = 递归。
     * treeNode.righ = 递归。
     * */
    
    
    // 5ms
    private TreeNode Lt0109(ListNode head)
    {
        List<Integer> list = new ArrayList();
        {
            ListNode node = head;
            while (node != null)
            {
                list.add(node.val);
                node = node.next;
            }
        }
        
        TreeNode node = generateTree(list, 0, list.size() - 1);
        return node;
    }
    
    private TreeNode generateTree(List<Integer> list, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        int index = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(index));
        
        node.left = generateTree(list, start, index - 1);
        node.right = generateTree(list, index + 1, end);
        return node;
    }
    
}


