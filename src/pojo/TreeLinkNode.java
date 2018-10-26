package pojo;

/**
 * LeetCode116
 * 
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class TreeLinkNode extends TreeNode
{
    public TreeLinkNode next;

    public TreeLinkNode(int x)
    {
        super(x);
    }

//    public TreeLinkNode(TreeNode node)
//    {
//        super(node.val);
//        super.left = node.left;           // ... node.left is TreeNode...
//        super.right = node.right;
//        super.parent = node.parent;
//        this.next = null;
//    }
    
    public TreeLinkNode getNext()
    {
        return next;
    }

    public void setNext(TreeLinkNode next)
    {
        this.next = next;
    }
    
}
