package ge100;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * */
public class LT0105
{

    public static void main(String[] args)
    {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        LTUtils.showTree(new LT0105().Lt0105a(preorder, inorder), 3);
    }
    
    // 57ms...most are [3, 5] or [13, 16]
    // 不清楚了，10秒粗略看了下3ms的代码，觉得和我的差不多的感觉。。然后就又提交了几次，后续几次分别是 8ms,32ms,9ms,51ms,21ms
    // ..时间差别有点大。。。

    // 和3ms的差别似乎在于，3ms是以preorder为主，inorder为辅; 这里是inorder为主，preorder为辅;
    // 毕竟无论是先序 还是 中序，子树的结点是在一起的。 中序的话，根结点左边都是左子树，右边都是右子树。
    // 先序的话是 root，左子树结点，右子树结点。。3ms的是从中序 获得 左子树的结点个数，右子树的结点个数，然后直接分割先序，
    // 左子树结点部分的第一个就是左子树的根，右子树结点部分的第一个就是右子树的根。
    // 还有 3ms 用map保存对应关系(key:结点值，value:中序下标)。
    
    // 这里是分割 中序，中序的左子树部分的值 在先序中下标最小的 就是 左子树的根。 右子树也是。。3ms不需要搜索。这里要搜索in2Pre。
    // 不知道把in2Pre 转换为 LinkedList，每次找到pre以后，就把那个结点删除点。这样会不会快一点。
    private TreeNode Lt0105a(int[] preorder, int[] inorder)
    {
        int nodeNum = preorder.length;
        if (nodeNum == 0)
        {
            return null;
        }
        TreeNode[] nodeArr = new TreeNode[nodeNum];
        for (int i = 0; i < nodeNum; i++)
        {
            nodeArr[i] = new TreeNode(preorder[i]);
        }
        
        int[] in2Pre = new int[nodeNum];
        int t1 = 0;
        for (int i = 0; i < nodeNum; i++)
        {
            t1 = inorder[i];
            for(int j = 0; j < nodeNum; j++)
            {
                if (preorder[j] == t1)
                {
                    in2Pre[i] = j;
                    break;
                }
            }
        }
        
        generateTree(nodeArr, nodeArr[0], in2Pre, 0, nodeNum - 1, this.findTreeNodeIndex(in2Pre, 0, nodeNum - 1)[1]);
        
        return nodeArr[0];
    }
    
    
    private void generateTree(TreeNode[] nodeArr, TreeNode node, int[] in2Pre, int inStart, int inEnd, int index)
    {
        int[] subIndex = null;
        if (inStart > index - 1)
        {
            // left child tree is none
        }
        else
        {
            subIndex = this.findTreeNodeIndex(in2Pre, inStart, index - 1);
            node.left = nodeArr[subIndex[0]];
            generateTree(nodeArr, node.left, in2Pre, inStart, index - 1, subIndex[1]);
        }
        
        if (index + 1 > inEnd)
        {
            // right is none
        }
        else
        {
            subIndex = this.findTreeNodeIndex(in2Pre, inStart, inEnd);
            node.right = nodeArr[subIndex[0]];
            generateTree(nodeArr, node.right, in2Pre, index + 1, inEnd, subIndex[1]);
        }
    }
    
    private int[] findTreeNodeIndex(int[] in2Pre, int inStart, int inEnd)
    {
        int i1 = 0;
        int t1 = in2Pre[inStart];
        int index1 = inStart;
        for (i1 = inStart + 1; i1 <= inEnd; i1++)
        {
            if (t1 > in2Pre[i1])
            {
                t1 = in2Pre[i1];
                index1 = i1;
            }
        }
        return new int[] { t1, index1 };
    }
    
    
    // fail
    @Deprecated
    private TreeNode Lt0105(int[] preorder, int[] inorder)
    {
        if (preorder.length == 0)
        {
            return null;
        }
        int nodeNum = preorder.length;
        
        TreeNode[] nodeArr = new TreeNode[nodeNum];
        for (int i = 0; i < nodeNum; i++)
        {
            nodeArr[i] = new TreeNode(preorder[i]);
        }
        boolean[] used = new boolean[nodeNum];      // inorder
        
        int num = 0;
        int t1 = 0;
        int i1 = 0;
        int i2 = 0;
        while (num < nodeNum)
        {
            t1 = preorder[num];
            for (i1 = 0; i1 < nodeNum; i1++)
            {
                if (inorder[i1] == t1)
                {
                    used[i1] = true;
                    break;
                }
            }
            System.out.println("aaa " + i1);
            for (i2 = i1 - 1; i2 >= 0; i2--)
            {
                if (!used[i2])
                {
                    break;
                }
            }
            num++;
            if (i2 >= 0)
            {
                if (num < nodeNum)
                {
                    nodeArr[num - 1].left = nodeArr[num];
                }
            }
            
            for (i2 = i1 + 1;  i2 < nodeNum; i2++)
            {
                if (!used[i2])
                {
                    break;
                }
            }
            if (i2 < nodeNum)
            {
                if (num < nodeNum)
                {
                    nodeArr[num - 1].right = nodeArr[num];
                }
            }
            
            
            System.out.println(i2);
            num++;
            if (i2 < 0)
            {
                if (num < nodeNum)
                {
                    nodeArr[num - 1].right = nodeArr[num];
                }
            }
            else
            {
                if (num < nodeNum)
                {
                    nodeArr[num - 1].left = nodeArr[num];
                }
            }
        }
        
        return nodeArr[0];
    }
    
}
