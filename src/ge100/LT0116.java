package ge100;

import java.util.Deque;
import java.util.LinkedList;

import com.sun.corba.se.impl.orbutil.graph.Node;

import pojo.TreeLinkNode;
import utils.LTUtils;

/**
 * 116. Populating Next Right Pointers in Each Node
 * */
public class LT0116
{

    public static void main(String[] args)
    {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        TreeLinkNode root = LTUtils.convertArrayToTreeLinkNode(arr)[0];
        LTUtils.showTree(root, 3);
        
        new LT0116().Lt0116a(root);
        System.out.println("done...");
    }

    // 116: 3ms, most are 1ms..
    // other's solution: node.left.next == node.right... node.right.next == node.next.left...
    
    // 117: 4ms, most are 2ms..
    // other's solution: use a TreeLinkNode to keep the lastNode...row first traversal...
    //                   2 lines, one is node(traversal; node = node.next), another is node's child(set node.child.next)...
    private void Lt0116a(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }
        
        TreeLinkNode tag = new TreeLinkNode(-1);
        TreeLinkNode lastNode = tag;
        TreeLinkNode node = tag;
        Deque<TreeLinkNode> deque = new LinkedList<>();
        
        deque.addFirst(root);
        deque.addFirst(tag);
        
        while(deque.size() > 1)
        {
            lastNode = node;
            if ((node = deque.removeLast()) == tag)
            {
                lastNode.next = null;
                deque.addFirst(tag);
            }
            else
            {
                lastNode.next = node;
            }
            if (node.left != null)
            {
                deque.addFirst((TreeLinkNode) node.left);
            }
            if (node.right != null)
            {
                deque.addFirst((TreeLinkNode) node.right);
            }
        }
    }

}
