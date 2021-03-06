package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pojo.Interval;
import pojo.ListNode;
import pojo.TreeLinkNode;
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
            return new TreeNode[1];
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
    
    public static TreeNode[] convertArrayToTreeArray2(Integer ... a)
    {
        return LTUtils.convertArrayToTreeArray(a);
    }

    public static TreeLinkNode[] convertArrayToTreeLinkNode(Integer[] array)
    {
        TreeNode[] arr1 = LTUtils.convertArrayToTreeArray(array);
        return LTUtils.convertTreeNodeArray2TreeLinkNodeArray(arr1);
    }

    public static TreeLinkNode[] convertArrayToTreeLinkNode2(Integer... a)
    {
        TreeNode[] arr1 = LTUtils.convertArrayToTreeArray2(a);
        return LTUtils.convertTreeNodeArray2TreeLinkNodeArray(arr1);
    }

    private static TreeLinkNode[] convertTreeNodeArray2TreeLinkNodeArray(TreeNode[] arr1)
    {
        TreeLinkNode[] arr2 = new TreeLinkNode[arr1.length];
        LTUtils.recursionConvertTreeNode2TreeLinkNode(arr2, arr1[0], 0, null);
        return arr2;
    }
    
    private static TreeLinkNode recursionConvertTreeNode2TreeLinkNode(TreeLinkNode[] arr2, TreeNode node, int index, TreeLinkNode parent)
    {
        if (node == null)
        {
            return null;
        }
        arr2[index] = new TreeLinkNode(node.val);
        arr2[index].parent = parent;
        arr2[index].left = recursionConvertTreeNode2TreeLinkNode(arr2, node.left, index * 2 + 1, arr2[index]);
        arr2[index].right = recursionConvertTreeNode2TreeLinkNode(arr2, node.right, index * 2 + 2, arr2[index]);
        return arr2[index];
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
//                    sb.append("   NaN");
                    sb.append("    %");
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
    
    public static void showListOfList(List<List<Integer>> list)
    {
        for(List<Integer> li : list)
        {
            System.out.println(li);
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
//            int i = 0;
//            for(Object o : list)
//            {
//                System.out.print(o + ", ");
//                i++;
//                if(i % 5 == 0)
//                {
//                    System.out.println();
//                }
//            }
            System.out.println(list);
        }
    }
    
    
    public static void showArrayOfArrayOneRowOneLine(char[][] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        int rows = arr.length;
        for(int i = 0; i < rows; i++)
        {
            showArrayNoNewLine(arr[i]);
            System.out.println();
        }
        System.out.println();
    }
    
    public static void showArrayNoNewLine(char[] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        System.out.print(Arrays.toString(arr));
    }
    
    public static void showArrayOfArrayOneRowOneLine(int[][] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        int rows = arr.length;
        for(int i = 0; i < rows; i++)
        {
            showArrayNoNewLine(arr[i]);
            System.out.println();
        }
        System.out.println();
    }
    
    public static void showArrayNoNewLine(int[] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        System.out.print(Arrays.toString(arr));
    }
    
    public static void showArrayOfArrayOneRowOneLine(Object[][] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        int rows = arr.length;
        for(int i = 0; i < rows; i++)
        {
            showArrayNoNewLine(arr[i]);
            System.out.println();
        }
        System.out.println();
    }
    
    public static void showArrayNoNewLine(Object[] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        System.out.print(Arrays.toString(arr));
    }
    
    public static void showArrayOfArray(int[][] arr)
    {
        if(arr == null)
        {
            System.out.println(" is null ");
            return;
        }
        Integer[][] arr2 = new Integer[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                arr2[i][j] = arr[i][j];
            }
        }
        showArrayOfArray(arr2);
    }
    
    public static void showArrayOfArray(Object[][] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            showArray(arr[i]);
//            System.out.println();
        }
    }
    
    public static void showArray(Object[] arr)
    {
//        for(int i = 0; i < arr.length; i++)
//        {
//            System.out.print(arr[i] + ", ");
//            if(i % 5 == 4)
//            {
//                System.out.println();
//            }
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
    
    public static void showArray(int[] arr) {
//        for(int i = 0; i < arr.length; i++)
//        {
//            System.out.print(arr[i] + ", ");
//            if(i % 5 == 4)
//            {
//                System.out.println();
//            }
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
    
    public static void showListNode(ListNode head)
    {
        ListNode head2 = head;
        while(head2 != null)
        {
            System.out.print(head2.getVal() + ", ");
            head2 = head2.getNext();
        }
        System.out.println();
    }
    
    public static ListNode convertIntArray2ListNode(int[] array)
    {
        if(array.length == 0)
        {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for(int i = 1; i < array.length; i++)
        {
            temp.setNext(new ListNode(array[i]));
            temp = temp.getNext();
        }
        
        return head;
    }
    
    public static List<Interval> convertIntArray2ListInterval(int[][] array)
    {
        List<Interval> result = new LinkedList<>();
        
        int len = array.length;
        Interval val = null;
        for(int i = 0; i < len; i++)
        {
            val = new Interval(array[i][0], array[i][1]);
            result.add(val);
        }
        return result;
    }
    
    public static List<List<Integer>> convertArrayArray2ListList(int[][] array)
    {
        List<List<Integer>> result = new ArrayList<>(array.length);
        List<Integer> ele = null;
        
        for(int i = 0; i < array.length; i++)
        {
            ele = new ArrayList<>(array[i].length);
            for(int j = 0; j < array[i].length; j++)
            {
                ele.add(array[i][j]);
            }
            result.add(ele);
        }
        return result;
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
