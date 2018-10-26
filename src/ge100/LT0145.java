package ge100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 145. Binary Tree Postorder Traversal
 * */
public class LT0145
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(1,null,2,null,null,3)[0];
        System.out.println(new LT0145().Lt0145a(root));
    }

    // 靠。一文不值。只要一个stack辅助就可以了，list.addFirst.
    // 中序的话是不是：stack辅助，list.add(x++, node.left.val), list.add(x+1, node.right.val), 
    //               x是node的下标，list.add(index, object),是加在index下标所代表结点的前面。下标范围[0, size]。x下标就是插入后新结点的下标。
    // 2ms, most are [0, 1]ms...
    private List<Integer> Lt0145a(TreeNode root)
    {
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        if (root != null)
        {
            stack.add(root);
        }
        TreeNode node = null;
        boolean tag = false;
        while (!stack.empty())
        {
//            node = stack.pop();
            node = stack.peek();
            set.add(node);
            if (node.left == null && node.right == null)
            {
                result.add(node.val);
                stack.pop();
                continue;
            }
            tag = true;
            if (node.right != null && !set.contains(node.right))
            {
                tag = false;
                set.add(node.right);
                stack.push(node.right);
            }
            if (node.left != null)
            {
                if (!set.contains(node.left))
                {
                    tag = false;
                    set.add(node.left);
                    stack.push(node.left);
                }
            }
            
            if (tag)
            {
                result.add(node.val);
                stack.pop();
            }
        }
        
        return result;
    }
}
