package ge500;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * Minimum Absolute Difference in BST 
 * 搜索二叉树中差的绝对值的最小值。
 * */
public class LT530 
{

    public static void main(String[] args) 
    {
        Integer[] array = new Integer[]{1,null,6,null,null,3};
        array = new Integer[]{5,4,7};
        TreeNode[] tree = LTUtils.convertArrayToTreeArray(array);
        LTUtils.showTree(tree[0], 4);
        
        System.out.println(Lt530(tree[0]));
    }

    //beat 14.09%...
    public static int Lt530(TreeNode root)
    {
        int result = 0;
        if(root.left != null)
        {
            result = root.val - root.left.val;
        }
        else if(root.right != null)
        {
            result = root.right.val - root.val;
        }
        else
        {
            return 0;
        }
        
        Set<TreeNode> nodeSet = new HashSet<>();
        Set<TreeNode> tempSet = new HashSet<>();
        nodeSet.add(root);
        TreeNode temp2 = null;
        int t = 0;
        
        while(!nodeSet.isEmpty())
        {
            tempSet.clear();
            for(TreeNode temp : nodeSet)
            {
                if(temp.left != null)
                {
                    temp2 = temp.left;
                    tempSet.add(temp2);
                    while(temp2.right != null)
                    {
                        temp2 = temp2.right;
                    }
                    t = temp.val - temp2.val;
                    if(t < result)
                    {
                        result = t;
                    }
                }
                if(temp.right != null)
                {
                    temp2 = temp.right;
                    tempSet.add(temp2);
                    while(temp2.left != null)
                    {
                        temp2 = temp2.left;
                    }
                    t = temp2.val - temp.val;
                    if(t < result)
                    {
                        result = t;
                    }
                }
            }
            nodeSet.clear();
            nodeSet.addAll(tempSet);
        }
        return result;
    }
}

/*

直接把树转成数组，然后for，相邻两个相减，相减的最小值就是结果。
转数组不好弄，不知道有几个节点，是否平衡。
或许可以先转成有序的list，然后再转成数组。。不用转数组了，直接有序的list遍历一遍就可以了。

                11
        5               20
   3        10       15      100
          6

最近的值，应该是这个节点的左节点的子树中最右的，或者右节点的子树中最左的
这样的话，要对每个节点都要get两个子树的最右，最左。


不知道哪种快。


*/