package ge100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 110. Balanced Binary Tree
 * */
public class LT0110
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(3,9,20,null,null,15,7)[0];
        root = LTUtils.convertArrayToTreeArray2(1,2,2,3,3,null,null,4,4)[0];
        root = LTUtils.convertArrayToTreeArray2(1,null,2,null,null,null,3)[0];      // ...
        root = LTUtils.convertArrayToTreeArray2(1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5)[0];
        LTUtils.showTree(root, 3);
        
        System.out.println(new LT0110().Lt0110a(root));
    }

    
    /**
     * 1ms的好奸诈。。。用-1来表示false，不需要return false了。。
     * Math.max, Math.abs
     * */
    
    
    
    
    
    
    
    
    // 3ms, most are 1ms...
    private boolean Lt0110a(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        boolean result = checkDepth(root, new HashMap<>());
        return result;
    }
    
    private boolean checkDepth(TreeNode node, Map<TreeNode, Integer> heightMap)
    {
        if (node.left != null)
        {
            boolean result = checkDepth(node.left, heightMap);
            if (!result)
            {
                return result;
            }
        }
        
        if (node.right != null)
        {
            boolean result = checkDepth(node.right, heightMap);
            if (!result)
            {
                return result;
            }
        }
        
        int lh = calHeight(node.left, heightMap);
        int rh = calHeight(node.right, heightMap);
        
        if (Math.abs(lh - rh) > 1)
        {
            return false;
        }
        
        return true;
    }
    
    private int calHeight(TreeNode node, Map<TreeNode, Integer> heightMap)
    {
        if (node == null)
        {
            return 0;
        }
        Integer height = null;
        if (node.left == null && node.right == null)
        {
            heightMap.put(node, 1);
            return 1;
        }
        else if (node.left == null)
        {
            if ((height = heightMap.get(node.right)) != null)
            {
                heightMap.put(node, height + 1);
                return height + 1;
            }
            else
            {
                throw new NullPointerException();
            }
        }
        else if (node.right == null)
        {
            if ((height = heightMap.get(node.left)) != null)
            {
                heightMap.put(node, height + 1);
                return height + 1;
            }
            else
            {
                throw new NullPointerException();
            }
        }
        else
        {
            Integer h2 = heightMap.get(node.left);
            height = heightMap.get(node.right);
            if (height < h2)                     // 应该不可能出现 null的情况。所以直接 <
            {
                height = h2;
            }
            height++;
            heightMap.put(node, height);
            return height;
        }
    }
    
    
    
    
    // error
    // ... 是每个结点的左右子树差。不是总的。。
    @Deprecated
    private boolean Lt0110(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        TreeNode tag = new TreeNode(-1);
        TreeNode nil = new TreeNode(-11);
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        nodeList.add(tag);
        int i = 0;
        TreeNode node = null;
        while (nodeList.size() > 1)
        {
            if ((node = nodeList.remove(0)) == tag)
            {
                i = i == 0 ? 0 : ++i;
                if (i == 2)
                {
                    for (int j = 0; j < nodeList.size(); j++)
                    {
                        if (nodeList.get(j) != nil && nodeList.get(j) != tag)
                        {
                            return false;
                        }
                    }
                    return true;
                }
                nodeList.add(tag);          // 和 addLast 一样，就是 一个有return,一个void, 还有就是接口不一样，所以List接口调不到addLast
                continue;
            }
            
            if (node == nil)
            {
                i = i == 0 ? 1 : i;
                continue;
            }
            nodeList.add(node.left == null ? nil : node.left);
            nodeList.add(node.right == null ? nil : node.right);
        }
        return true;
    }
}
