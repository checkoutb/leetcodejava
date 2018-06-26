package gt000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 95. Unique Binary Search Trees II
 * */
public class LT0095
{

    public static void main(String[] args)
    {
        
        int n = 3;
        
//        System.out.println(Lt0095(n));
        List<TreeNode> result = Lt0095(n);
        for(TreeNode node : result)
        {
            LTUtils.showTree(node, 2);
        }
        
    }

    // ... 161ms, others are 2-6ms...
    public static List<TreeNode> Lt0095(int n)
    {
        List<TreeNode> result = new LinkedList<>();
        
        Map<String, TreeNode> treeNodeMap = new HashMap<>();
        
        if(n == 0)
        {
            return result;
        }
        
        int[][] nodeArr = new int[n][2];
        int i = 0;
        for(i = 0; i < n;)
        {
            nodeArr[i][1] = 0;
            nodeArr[i][0] = ++i;
        }
        
//        createBST(nodeArr, result, 1);
        createBSTMap(nodeArr, treeNodeMap, 1);
        
//        for(i = 0; i < n; i++)
//        {
//            result.add(new TreeNode(nodeArr[i][0]));
//            nodeArr[i][1] = 1;
//            createBST(nodeArr, result);
//        }
        
        result = new ArrayList<>(treeNodeMap.values());
        
        return result;
    }
    
    
    
    public static void createBSTMap(int[][] nodeArr, Map<String, TreeNode> treeNodeMap, int level)
    {
        int i = 0;
        boolean isLast = true;
        for(; i < nodeArr.length; i++)
        {
            if(nodeArr[i][1] == 0)
            {
                nodeArr[i][1] = level;
                createBSTMap(nodeArr, treeNodeMap, level + 1);
                nodeArr[i][1] = 0;
                isLast = false;
            }
        }
        if(isLast)
        {
            int j = 0;
            TreeNode root = new TreeNode(-1);
            String key = "";
            for(i = 1; i <= nodeArr.length; i++)
            {
                for(j = 0; j < nodeArr.length; j++)
                {
                    if(nodeArr[j][1] == i)
                    {
//                        key += nodeArr[j][0];
                        insertIntoBST(root, nodeArr[j][0]);
                    }
                }
            }
            key = createKeyOfTreeNode(root, key);
            treeNodeMap.put(key, root.right);
        }
    }
    
    public static String createKeyOfTreeNode(TreeNode node, String key)
    {
        if(node == null)
        {
            key += "-";
            return key;
        }
        else
        {
            key += node.val;
            return createKeyOfTreeNode(node.left, key) + createKeyOfTreeNode(node.right, key);
        }
    }
    
    public static void createBST(int[][] nodeArr, List<TreeNode> result, int level)
    {
        int i = 0;
        boolean isLast = true;
        for(; i < nodeArr.length; i++)
        {
            if(nodeArr[i][1] == 0)
            {
                nodeArr[i][1] = level;
                createBST(nodeArr, result, level + 1);
                nodeArr[i][1] = 0;
                isLast = false;
            }
        }
        if(isLast)
        {
            int j = 0;
            TreeNode root = new TreeNode(-1);
            for(i = 1; i <= nodeArr.length; i++)
            {
                for(j = 0; j < nodeArr.length; j++)
                {
                    if(nodeArr[j][1] == i)
                    {
                        insertIntoBST(root, nodeArr[j][0]);
                    }
                }
            }
            result.add(root.right);
        }
    }
    
    private static void insertIntoBST(TreeNode node, int value)
    {
//        if(node.val == 0)           // 1-n, so 0 means none
//        {
//            node.val = value;
//            return;
//        }
//        else
//        {
            if(value > node.val)        // never ==
            {
                if(node.right == null)
                {
                    node.right = new TreeNode(value);
                    return;
                }
                else
                {
                    insertIntoBST(node.right, value);
                }
            }
            else
            {
                if(node.left == null)
                {
                    node.left = new TreeNode(value);
                    return;
                }
                else
                {
                    insertIntoBST(node.left, value);
                }
            }
//        }
        
    }
}

/*
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/



