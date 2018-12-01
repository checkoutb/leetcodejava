package ge200;

import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0257_Binary_Tree_Paths
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(1,2,3,null,5)[0];
        System.out.println(new LT0257_Binary_Tree_Paths().Lt0257a(root));
    }

    
    // 12ms, most are [7, 16]ms.
    // path + root.val + "->"   ......
    private List<String> Lt0257a(TreeNode root)
    {
        if (root == null)
            return new LinkedList<>();
        List<String> ans = new LinkedList<>();
        this.recursiona1(root, "", ans);
        return ans;
    }
    
    private void recursiona1(TreeNode node, String path, List<String> ans)
    {
        if (node.left == null && node.right == null)
        {
            ans.add((path == "" ? "" : path + "->") + node.val);
            return;
        }
        String path2 = (path == "" ? "" : path + "->") + node.val;
        if (node.left != null)
            this.recursiona1(node.left, path2, ans);
        if (node.right != null)
            this.recursiona1(node.right, path2, ans);
    }
}
