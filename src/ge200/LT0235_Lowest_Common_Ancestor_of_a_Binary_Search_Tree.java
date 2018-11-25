package ge200;

import java.util.ArrayList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(6,2,8,0,4,7,9,null,null,3,5)[0];
        int pv = 2;
        int qv = 8;
        TreeNode p = new TreeNode(pv);
        TreeNode q = new TreeNode(qv);
        LT0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree lt = new LT0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        
        System.out.println(lt.Lt0235a(root, p, q));
        
    }

    
    // 搜索p,q,然后保存从root到p的结点，然后q往上走，父结点和之前保存的集合contains一下。
    // 转换成数组，然后靠/2来判断。。。
    
    // 6ms, most are [4, 10]ms.
    // ...二叉搜索树。。。当作普通二叉树了。。
    /* 4ms...BST
    if (root == null){
        return null;
    }
    if (Math.max(p.val, q.val) < root.val){
        return lowestCommonAncestor(root.left, p,q);
    }
    if (Math.min(p.val, q.val) > root.val){
        return lowestCommonAncestor(root.right, p, q);
    }
    return root;
    */
    
    // 236....这段代码是可以通过的。。
    // 236， 7ms， beats 92%.
    /* 大部分都是这种
    if(root==null||p==root||q==root)
        return root;
    TreeNode left=lowestCommonAncestor(root.left,p,q);
    TreeNode right=lowestCommonAncestor(root.right,p,q);
    if(left!=null&&right!=null)
        return root;
    return left!=null?left:right;
    */
    // 由于必然存在，所以如果找不到2个，那么说明，p,q在同一个路径上。
    // 在最小公共父结点的上面，必然是一侧子树为null，另一侧子树不为null。
    private TreeNode Lt0235a(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode ans = null;
        
        List<TreeNode> list = new ArrayList<>(2);
        this.recursiona1(root, list, p.val, q.val);
        
        if (!list.isEmpty())
            ans = list.get(0);
        return ans;
    }
    
    private boolean[] recursiona1(TreeNode node, List<TreeNode> ans, int p, int q)
    {
        if (node == null || !ans.isEmpty())
            return new boolean[] { false, false };

        boolean[] result1 = this.recursiona1(node.left, ans, p, q);
        boolean[] result2 = this.recursiona1(node.right, ans, p, q);
        
        boolean[] result3 = new boolean[] { result1[0] || result2[0] || node.val == p, result1[1] || result2[1] || node.val == q };
        if (result3[0] && result3[1])
            ans.add(node);
        return result3;
    }
    
}
