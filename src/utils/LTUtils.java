package utils;

import java.util.ArrayList;
import java.util.List;

import pojo.TreeNode;

public class LTUtils 
{

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode parent;                // add by self
     *     TreeNode(int x) { val = x; }
     * }
     */
    // array[0] is root
    // parent's index = (self's index - 1) / 2
    // child's index = self's index * 2, then +1 or +2.
    public static TreeNode[] convertArrayToTreeArray(Integer[] array)
    {
        if(array.length == 0 || array[0] == null)
        {
            return new TreeNode[0];
        }
        
        TreeNode[] nodeArray = new TreeNode[array.length];
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != null)
            {
                nodeArray[i] = new TreeNode(array[i]);
            }
        }
        for(int i = 0; i < nodeArray.length; i++)
        {
            if(nodeArray[i] == null)
            {
                continue;
            }
            if(i-1 >= 0)
            {
                if(nodeArray[(i-1) / 2] == null)
                {
                    nodeArray[i] = null;    //not root node must have a parent node
                    continue;
                }
                nodeArray[i].setParent(nodeArray[(i-1) / 2]);
            }
            if((i*2 + 1) < nodeArray.length)
            {
                nodeArray[i].setLeft(nodeArray[i*2 + 1]);
            }
            if((i*2 + 2) < nodeArray.length)
            {
                nodeArray[i].setRight(nodeArray[i*2 + 2]);
            }
            
        }
        return nodeArray;
    }
    
    /**
     * 意思意思。先用着。
     * */
    public static void showTree(TreeNode head, Integer high)
    {
        if(high == null)
        {
            high = 10;
        }
        int level = high * 2;
        float width2 = level;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        List<TreeNode> tempList = new ArrayList<>(32);
        StringBuilder sb = new StringBuilder();
        TreeNode node = null;
        
        while(!nodeList.isEmpty())
        {
            if(nodeList.size() > 10000)
            {
                System.out.println("error");
                break;
            }
            tempList.clear();
            for(int j = 0; j < level; j++)
            {
                sb.append("   ");
            }
            level--;

            for(int i = 0; i < nodeList.size(); i++)
            {
                node = nodeList.get(i);
                if(node == null)
                {
                    sb.append("   NaN");
                    tempList.add(null);
                    tempList.add(null);
                }
                else
                {
                    sb.append(String.format("%".concat(Integer.toString((int)width2)).concat("d"), node.getVal()));
                    tempList.add(node.getLeft());
                    tempList.add(node.getRight());
                }
            }
            width2 /= 1.27;
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
            nodeList.removeAll(nodeList);
            for(TreeNode n : tempList)
            {
                if(n != null)
                {
                    nodeList.addAll(tempList);
                    break;
                }
            }
        }
    }
    
    
    public static void showList(List<?> list)
    {
        if(list == null)
        {
            System.out.println("list is null");
        }else if(list.isEmpty())
        {
            System.out.println("list is empty");
        }
        else
        {
            int i = 0;
            for(Object o : list)
            {
                System.out.print(o + ", ");
                i++;
                if(i % 5 == 0)
                {
                    System.out.println();
                }
            }
        }
    }
    
    public static void showArray(Object[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
            if(i % 5 == 0)
            {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
            if(i % 5 == 4)
            {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};
        array = new Integer[]{0,1,2,null,4,5,6,7,8,9};
        TreeNode[] tree = convertArrayToTreeArray(array);
        for(int i = 0; i < tree.length; i++)
        {
            if(tree[i] == null)
            {
                System.out.println("null, ");
            }
            else
            {
                System.out.println(tree[i].getVal() + ", " + tree[i].getLeft() + ", " + tree[i].getRight());
            }
        }
        
        showTree(tree[0], 6);
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
