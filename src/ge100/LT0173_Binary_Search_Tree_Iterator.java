package ge100;

import java.util.Stack;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0173_Binary_Search_Tree_Iterator
{

    public static void main(String[] args)
    {
        Integer[][] arr = {
                {},
//                { 1 }, { 1, 2, 3 }, { 1, null, 2, null, null, 3 },
                { 41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40, null, 43, 46, 49, 0, 2, 30, 36, null, null, null, null, null, null, 45, 47, null, null,
                        null, null, null, 4, 29, 32, null, null, null, null, null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null,
                        null, 33, null, 6, 8, 10, 16, null, null, null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null, null,
                        null, 12, null, 18, 20, null, 13, 17, null, null, 22, null, 14, null, null, 21, 23 } };
        TreeNode[] arr2 = new TreeNode[arr.length];
        
        for (int i = 0; i < arr.length; i++)
        {
            arr2[i] = LTUtils.convertArrayToTreeArray(arr[i])[0];
        }
        
        LT0173_Binary_Search_Tree_Iterator lt = new LT0173_Binary_Search_Tree_Iterator();
        for (TreeNode node : arr2)
        {
            LTUtils.showTree(node, 10);
            BSTIterator bst = lt.new BSTIterator(node);
            while (bst.hasNext())
                System.out.println(bst.next());
        }
//        TreeNode node = LTUtils.convertArrayToTreeArray(new Integer [] {1})[0];
        
//        BSTIterator bst = new BSTIterator(node);
//        while (bst.hasNext())
//            System.out.println(bst.next());
    }

    
    
    // 5ms, most are [2, 6]ms
    
    // 其他人的代码
    // 2ms, 简单暴力，保存current结点和root结点，
    //          hasNext : current != null;
    //          next : 找current的右子树的最左结点。如果没有右子树，则根据root找到深度最深 且 把current包含在其左子树的结点。
    //          这个应该算O(h)时间，O(1)空间。
    
    // 3,4ms, 更简单，更暴力，一个队列，保存了bst的中序遍历。O(1)时间，O(n)空间。
    //      不过，这种中序的方法第一次见。
    /*
    private void inorder(TreeNode root, Queue<TreeNode> queue){
        if(root == null){return;}
        inorder(root.left, queue);
        queue.offer(root);
        inorder(root.right, queue);
    }
    */
    
    // 5,6ms, 和我这个差不多，但是代码只有一半吧。。只有一个Stack。没有其他。
    //        他们的stack的栈顶是将输出的结点，我这边的栈顶是已经输出的结点。他们的更简单。
    
    
    class BSTIterator
    {
        private Stack<TreeNode> stack;
        
        private TreeNode node;
        
        private TreeNode last;
        
        private boolean tag;
        
        public BSTIterator(TreeNode root) {
            tag = false;
            node = last = null;
            if (root == null)
                return;
            stack = new Stack<>();
            node = root;
            last = root;
            while (node.left != null)
            {
                stack.push(node);
                node = node.left;
            }
            stack.push(node);
            
            while (last.right != null)
            {
                last = last.right;
            }
            tag = true;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return tag || node != last;
        }

        /** @return the next smallest number */
        public int next() {
            if (tag)
            {
                tag = false;
                return node.val;
            }
            if (node.right != null)
            {
                node = node.right;
                stack.push(node);
                while (node.left != null)
                {
                    node = node.left;
                    stack.push(node);
                }
                return node.val;
            }
            else
            {
                stack.pop();
                TreeNode p = stack.pop();
                if (node == p.left)
                {
                    node = p;
                    stack.push(node);
                    return node.val;
                }
                else
                {
                    while (!stack.isEmpty())
                    {
                        node = p;
                        p = stack.pop();
                        if (node == p.left)
                        {
                            node = p;
                            stack.push(node);
                            return node.val;
                        }
                    }
                    return -1;      // unreachable...
                }
            }
        }
    }
}






@Deprecated
class BSTIterator {
    
    private TreeNode node;
    
    private TreeNode last;
    
    private Stack<TreeNode> stack;
    
    private boolean flag;
    
    public BSTIterator(TreeNode root) {
        if (root == null)
            return;
        this.last = root;
        while (last.right != null)
            last = last.right;
        this.node = root;
        this.stack = new Stack<>();
        while (node.left != null)
        {
            stack.push(node);
            node = node.left;
        }
        stack.push(node);
        flag = true;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (node != last)
        {
            return true;
        }
        else
        {
            if (flag)
            {
                flag = false;
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (node == null)
            return -1;
        if (node.right != null)
        {
            node = node.right;
            stack.push(node);
            while (node.left != null)
            {
                node = node.left;
                stack.push(node);
            }
            return node.val;
        }
        stack.pop();        // node
        if (stack.size() == 0)
        {
            if (node.right == null)
            {
                return -1;          // ?
            }
            else
            {
                stack.push(node);
                node = node.right;
                stack.push(node);
                while (node.left != null)
                {
                    node = node.left;
                    stack.push(node);
                }
                return node.val;
            }
        }
        TreeNode p = stack.pop();
        if (node == p.left)
        {
            if (node.right != null)
            {
                stack.push(p);
                stack.push(node);
                node = node.right;
                stack.push(node);
                while (node.left != null)
                {
                    node = node.left;
                    stack.push(node);
                }
                return node.val;
            }
            node = p;
            stack.push(node);
            return node.val;
        }
        if (node == p.right)
        {
            if (node.right != null)
            {
                stack.push(p);
                stack.push(node);
                node = node.right;
                stack.push(node);
                while (node.left != null)
                {
                    node = node.left;
                    stack.push(node);
                }
                return node.val;
            }
            node = stack.pop();
            return node.val;
        }
        else
        {
            return -1;          // ?
        }
    }
}