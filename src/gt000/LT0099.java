package gt000;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import pojo.TreeNode;
import utils.LTUtils;

/**
 * 99. Recover Binary Search Tree
 * */
public class LT0099 {

    public static void main(String[] args) {
        
        TreeNode root = LTUtils.convertArrayToTreeArray(new Integer[] {1,3,null,null,2})[0];
        root = LTUtils.convertArrayToTreeArray(new Integer[] {3,1,4,null,null,2})[0];
        root = LTUtils.convertArrayToTreeArray(new Integer[] {0,1})[0];
        root = LTUtils.convertArrayToTreeArray(new Integer[] {2,3,1})[0];
//        LTUtils.showTree(root, 2);
//        Lt0099(root);
//        LTUtils.showTree(root, 3);
        
//        LTUtils.showTree(root, 3);
//        new LT0099().Lt0099a(root);
//        LTUtils.showTree(root, 3);
        
        LT0099 lt = new LT0099();
        LTUtils.showTree(root, 3);
        lt.Lt0099b(root);
        LTUtils.showTree(root, 3);
    }
    
    
    
    
    /**
     * 仔细看了网上的文章，最简单的：中序遍历，获得结点数组，val数组;
     * val数组排序，挨个放到结点数组中。这种可以解n个错乱结点。。。
     * 都忘记了有序二叉树的中序遍历也是有序的。。。
     * 
     * 第二种，3指针，不过空间复杂度还是O(n)
     * 
     * 第三种，利用Morris遍历，这种空间复杂度是O(1)
     * 
     * 这几种都只是2个val的对比，没有max，min，之类的。
     * 
     * 中序遍历，用一个指针指向中序顺序下前面一个结点，中序遍历应该是有序的，所以如果当前结点<前面的结点，说明错误。
     * 那如果是前面的那个结点变大了，导致本结点<前面的结点呢？所以还需要筛选啊。
     * */
    
    
    
    
    // 网上搜索了这道题目，主要是：找到2个错误的结点，就更换它们；只有一个的话，就要和它的中序遍历的旁边结点互换。
    // 回朔吧
    @Deprecated
    public void Lt0099b(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<>(2); 
        this.findAllNonstandardNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE, result);
        
        out.println(result);
        
        if (result.size() == 2)
        {
            Object[] nodeArr = result.toArray();
            ((TreeNode) nodeArr[0]).val = ((TreeNode) nodeArr[0]).val + ((TreeNode) nodeArr[1]).val;
            ((TreeNode) nodeArr[1]).val = ((TreeNode) nodeArr[0]).val - ((TreeNode) nodeArr[1]).val;
            ((TreeNode) nodeArr[0]).val = ((TreeNode) nodeArr[0]).val - ((TreeNode) nodeArr[1]).val;
        }
        else if (result.size() == 1)
        {
            // 没有指向父结点的指针，无法回朔
            // 好像如果只有一个错误结点的话，另一个错误的结点就是它父结点的父结点。
            // 只有叶子结点和它的父结点的父结点互换，才会出现只有一个错误结点这种情况。
            // 所以网上说中序，中序+叶子结点是它父结点的左结点还是右结点，就能确定它的父结点的父结点是它的左边这个还是右边这个
            // 当叶子结点是它父结点的左结点时，取中序顺序下的叶子结点的前面那个结点就是父结点的父结点；右结点时，取后面那个
            
            TreeNode node0 = result.get(0);
            TreeNode parentParent = findParentNodeParentNode(root, node0);
            
            out.println(parentParent);
            
            if (parentParent == null)
            {
                //      0
                //    1   -
                // ...这种
                //      2
                //    3   1
                // 全是这里的问题。这种情况中序遍历也是没有办法的吧。得想办法把 result.size 变成2.
                if (node0.left != null && node0.left.val > node0.val)
                {
                    // 借用下。
                    parentParent = node0.left;
                }
                if (node0.right != null && node0.right.val < node0.val)
                {
                    parentParent = node0.right;
                }
            }
            
            node0.val = node0.val + parentParent.val;
            parentParent.val = node0.val - parentParent.val;
            node0.val = node0.val - parentParent.val;
        }
    }
    
    private TreeNode findParentNodeParentNode(TreeNode root, TreeNode target)
    {
        TreeNode parentParent = findParentParent(root, null, null, target);
        return parentParent;
    }
    
    private TreeNode findParentParent(TreeNode node, TreeNode parent, TreeNode parentParent, TreeNode target)
    {
        if (node == null)
        {
            return null;
        }
        if (node == target)
        {
            return parentParent;
        }
        else
        {
            parentParent = parent;
            parent = node;
            TreeNode result = null;
            if (node.left != null)
            {
                if ((result = findParentParent(node.left, parent, parentParent, target)) != null)
                {
                    return result;
                }
            }
            if (node.right != null)
            {
                if ((result = findParentParent(node.right, parent, parentParent, target)) != null)
                {
                    return result;
                }
            }
        }
        return null;
    }
    
    // 是否中序无所谓
    private void findAllNonstandardNode(TreeNode node, int min, int max, List<TreeNode> result)
    {
        if (node == null || result.size() >= 2)
        {
            return;
        }
        boolean changeLimit = true;
        Integer rightVal = null;
        Integer leftVal = null;
        if (node.val < min || node.val > max || (node.left == null ? false : node.val < node.left.val)
                || (node.right == null ? false : node.val > node.right.val))
        {
            // 01,231的情况
            if (node.left != null && node.right != null)
            {
                if (node.left.val > node.val || node.right.val < node.val)     // 231
                {
                    result.add(node.left);
                    result.add(node.right);
                    return;
                }
                else
                {
                    rightVal = node.right.val;
                    leftVal = node.left.val;
                }
            }
            else if (node.left != null)
            {
                leftVal = node.left.val;
            }
            else if (node.right != null)
            {
                rightVal = node.right.val;
            }
            
            result.add(node);
            if (result.size() >= 2)
            {
                return;
            }
            changeLimit = false;
        }
        findAllNonstandardNode(node.left, min, changeLimit ? node.val : max, result);
        findAllNonstandardNode(node.right, changeLimit ? node.val : min, max, result);
    }
    
    @Deprecated
    public void Lt0099a(TreeNode root)
    {
        TreeNode nonStandard = getFirstNonstandardNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("aaa: " + nonStandard.val);
        
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        
        TreeNode node = null;
        TreeNode node2 = null;
        TreeNode node3 = null;
        int min = 0;
        int max = 0;
        // should use iterator
        while (!nodeList.isEmpty())
        {
            node = nodeList.remove(0);
            if (node.left != null)
            {
                nodeList.add(node.left);
            }
            if (node.right != null)
            {
                nodeList.add(node.right);
            }
            min = node.val;
            max = min;
            node2 = node.left;
            node3 = node.right;
            while (node2 != null)
            {
                if (node2 == nonStandard)
                {
                    node2 = node2.right;
                }
                else
                {
                    min = node2.val;
                    node2 = node2.right;
                }
            }
            while (node3 != null)
            {
                if (node3 == nonStandard)
                {
                    node3 = node3.left;
                }
                else
                {
                    max = node3.val;
                    node3 = node3.left;
                }
            }
            
            if (nonStandard.val < max && nonStandard.val > min)
            {
                
            }
        }
        
    }
    
//    // post-order
//    private int[] findLocation(TreeNode node, TreeNode nonStandard, int val, int min, int max, List<TreeNode> result)
//    {
//        
//    }
    
    private TreeNode getFirstNonstandardNode(TreeNode node, int min, int max)
    {
        if (node.left != null)
        {
            if (node.left.val > node.val || node.left.val < min)
            {
                return node.left;
            }
            int max2 = node.val;
            TreeNode result = getFirstNonstandardNode(node.left, min, max2);
            if (result != null)
            {
                return result;
            }
        }
        if (node.right != null)
        {
            if (node.right.val < node.val || node.right.val > max)
            {
                return node.left;
            }
            int min2 = node.val;
            TreeNode result = getFirstNonstandardNode(node.right, min2, max);
            if (result != null)
            {
                return result;
            }
        }
        return null;
    }
    
    
    
    @Deprecated
    public static void Lt0099(TreeNode root)
    {
        List<TreeNode> nonStandardList = findAllNonstandardTreeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE, new LinkedList<>());
        out.println(nonStandardList);
        if (nonStandardList.size() == 2)
        {
            TreeNode node0 = nonStandardList.get(0);
            TreeNode node1 = nonStandardList.get(1);
            node0.val += node1.val;
            node1.val = node0.val - node1.val;
            node0.val -= node1.val;
        }
    }
    
    private static List<TreeNode> findAllNonstandardTreeNode(TreeNode node, int min, int max, List<TreeNode> list)
    {
//        out.println("-------- " + node.val + ", " + min + ", " + max);
        if (node.left != null)
        {
            if (node.left.val > node.val || node.left.val < min)
            {
//                out.println(".." + node.left.val + ", " + node.val + ", " + min);
                list.add(node);
            }
            int max2 = node.val;
            findAllNonstandardTreeNode(node.left, min, max2, list);
        }
        if (node.right != null)
        {
            if (node.right.val < node.val || node.right.val > max)
            {
//                out.println("''" + node.right.val + ", " + node.val + ", " + max);
                list.add(node);
            }
            int min2 = node.val;
            findAllNonstandardTreeNode(node.right, min2, max, list);
        }
        return list;
    }
}
