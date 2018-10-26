package ge100;

import java.util.Deque;
import java.util.LinkedList;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 129. Sum Root to Leaf Numbers
 * */
public class LT0129
{

    public static void main(String[] args)
    {
        Integer[][] arrArr = {{1,2,3},{4,9,0,5,1}};
        LT0129 lt = new LT0129();
        for (Integer[] arr : arrArr)
        {
            TreeNode root = LTUtils.convertArrayToTreeArray(arr)[0];
            System.out.println(lt.Lt0129b(root));
        }
    }
    
    
    // 0ms..
    // ..和Lt0129a比起来代码很少啊。。
    private int Lt0129b(TreeNode root)
    {
        int result = 0;
        if (root == null)
        {
            return result;
        }
        result = recursionb(root, 0);
        return result;
    }
    
    private int recursionb(TreeNode node, int path)
    {
        int path2 = path * 10 + node.val;
        
        if (node.left == null && node.right == null)
        {
            return path2;
        }
        int result = 0;
        if (node.left != null)
        {
            result += this.recursionb(node.left, path2);
        }
        if (node.right != null)
        {
            result += this.recursionb(node.right, path2);
        }
        return result;
    }
    
    
    // 计算出来的是 数值左对齐，然后后面补0,的和。
    @Deprecated
    private int Lt0129a(TreeNode root)
    {
        int result = 0;
        if (root == null)
        {
            return result;
        }
        result = levelTraversal(root);
        return result;
    }
    
    private int levelTraversal(TreeNode node)
    {
        int result = 0;
        int temp = 0;
        TreeNode flag = new TreeNode(-1);
//        int count = leafCount(node);
        
        TreeNode countTree = this.createLeafCountTree(node);
        
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> dequeCount = new LinkedList<>();
        
        deque.addFirst(node);
        deque.addFirst(flag);
        
        dequeCount.addFirst(countTree);
        
        TreeNode n = null;
        TreeNode count = null;
        while(true)
        {
            
            System.out.println(deque + "\n" + dequeCount);
            
            
            n = deque.removeLast();
            if (n == flag)
            {
                if (deque.isEmpty())
                {
                    break;
                }
                temp *= 10;
                deque.addFirst(flag);
                continue;
            }
            else
            {
                count = dequeCount.removeLast();
                if (n.left != null)
                {
                    deque.addFirst(n.left);
                    dequeCount.addFirst(count.left);
                }
                if (n.right != null)
                {
                    deque.addFirst(n.right);
                    dequeCount.addFirst(count.right);
                }
            }
            // 需要再计算leafCount才能知道这个val会出现几次，太繁琐了，除非第一次的时候就生成一颗树来保存结点的叶子数目。后续遍历可以。
            // just 干 ta。
            temp += n.val * count.val;
            
//            if (n.left == null && n.right == null)
//            {
//                
//            }
            
            System.out.println(temp);
            
        }
        
        result = temp;
        return result;
    }
    
    private TreeNode createLeafCountTree(TreeNode node)
    {
        if (node.left == null && node.right == null)
        {
            return new TreeNode(1);
        }
        TreeNode n = new TreeNode(0);
        TreeNode left = null;
        TreeNode right = null;
        if (node.left != null)
        {
            left = this.createLeafCountTree(node.left);
        }
        if (node.right != null)
        {
            right = this.createLeafCountTree(node.right);
        }
        n.val = (left == null ? 0 : left.val) + (right == null ? 0 : right.val);
        n.left = left;
        n.right = right;
        return n;
    }
    
    private int leafCount(TreeNode node)
    {
        int count = 0;
        if (node.left == null && node.right == null)
        {
            return 1;
        }
        if (node.left != null)
        {
            count += leafCount(node.left);
        }
        if (node.right != null)
        {
            count += leafCount(node.right);
        }
        return count;
    }
}
