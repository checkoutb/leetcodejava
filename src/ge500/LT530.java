package ge500;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * Minimum Absolute Difference in BST 
 * �����������в�ľ���ֵ����Сֵ��
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

ֱ�Ӱ���ת�����飬Ȼ��for����������������������Сֵ���ǽ����
ת���鲻��Ū����֪���м����ڵ㣬�Ƿ�ƽ�⡣
���������ת�������list��Ȼ����ת�����顣������ת�����ˣ�ֱ�������list����һ��Ϳ����ˡ�

                11
        5               20
   3        10       15      100
          6

�����ֵ��Ӧ��������ڵ����ڵ�����������ҵģ������ҽڵ�������������
�����Ļ���Ҫ��ÿ���ڵ㶼Ҫget�������������ң�����


��֪�����ֿ졣



*/