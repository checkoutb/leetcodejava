package ge200;

import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0222_Count_Complete_Tree_Nodes
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(1, 2, 3, 4, 5, 6)[0];
        System.out.println(new LT0222_Count_Complete_Tree_Nodes().Lt0222b(root));
    }

    
    // 129ms, 唉。。。
    // most are [9, 17] U [30, 150] U [280, 400]ms.
    // 这个测试案例应该被改过, [9, 17] 是 return 1 + countNodes(root.left) + countNodes(root.right); 。。 为null，就返回0.不为null就递归。
    //              这个是遍历，现在的测试案例，应该不会通过吧。
    // 看了其他人的代码的，才发现 discuss 的和我的不一样。。
    // 我的是 判断最左和最右的个数是否一致，一致就1 << height. 不一致就 1 + 左 + 右。
    // discuss的是 判断 最左-1 == 右子树的最左， 这个等式是否成立，成立就说明左子数必然是满二叉树，不成立说明 右子树必然是满二叉数。。666666.
    //              因为右子数的最左就是底层的中间偏右那个点。而且现在是 完全二叉树。
    // 两个方法差不多。discuss的在本次递归就能砍掉一半，我的那种，在下次递归的时候能砍掉一半了。。。在递归的时候把深度传进去，就不需要算最左。
    // 还有一种深度判断，while(left != null && right != null){left++,right++,height++;} if (left == right)说明深度一样，不一样的话，必然左边深。
    private int Lt0222b(TreeNode root)
    {
        return this.recursionb1(root);
    }
    
    private int recursionb1(TreeNode node)
    {
        int left = 0;
        int right = 0;
        TreeNode node2 = node;
        while (node2 != null)
        {
            node2 = node2.left;
            left++;
        }
        node2 = node;
        while (node2 != null)
        {
            node2 = node2.right;
            right++;
        }
        if (left == right)
        {
            return (1 << left) - 1;
        }
        else
        {
            return 1 + recursionb1(node.left) + recursionb1(node.right);
        }
    }
    
    // 要获得深度和最下面一行有几个，还是得遍历啊。。
    // 14/18 timeout...关键是无法快速获得最下面那行有几个结点。
    // 遍历到底层还不如直接递归的时候计算出来。
    // 看了discuss，当left...left的深度 == right...right的深度时，就可以不需要遍历了。
    @Deprecated
    private int Lt0222a(TreeNode root)
    {
        if (root == null)
            return 0;
        int ans = 0;
        int depth = 1;
        TreeNode node = root;
        while (node.left != null)
        {
            node = node.left;
            depth++;
        }
        node = root;
        List<TreeNode> list = new LinkedList<>();
        this.recursiona1(1, depth, node, list);
        ans = list.size() + (1 << (depth - 1)) - 1;
        return ans;
    }
    
    private void recursiona1(int now, int depth, TreeNode node, List<TreeNode> list)
    {
        if (node == null)
            return;
        if (now == depth)
        {
            list.add(node);
            return;
        }
        this.recursiona1(now + 1, depth, node.left, list);
        this.recursiona1(now + 1, depth, node.right, list);
    }
}
