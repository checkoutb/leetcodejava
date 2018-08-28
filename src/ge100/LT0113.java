package ge100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pojo.TreeNode;
import utils.LTUtils;

/**
 * 113. Path Sum II
 * */
public class LT0113
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(5,4,8,11,null,13,4,7,2,null,null,null,null,5,1)[0];
        LTUtils.showTree(root, 5);
        System.out.println(new LT0113().Lt0113(root, 22)); 
    }
    
    
    
    /**
     * list里应该保存的就是需要的，就是说出方法之前要remove掉。
     * null的计算放在第一行，而不是对 left，right进行非null判断。
     * 不过对left，right进行非null判断的话，速度应该更快吧。毕竟少一层方法调用。
     * */
    
    
    
    // 5ms, most are 1ms... 
    private List<List<Integer>> Lt0113(TreeNode root, int sum)
    {
        if (root == null)
        {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        this.recursion(root, 0, sum, list, result);
        return result;
    }
    
    private void recursion(TreeNode node, int floor, int sum, List<Integer> list, List<List<Integer>> result)
    {
//        System.out.println(node.val + ", " + floor + ", " + sum + ", " + list);
        if (node.left == null && node.right == null)
        {
//            System.out.println("   ..   " + sum + ", " + node.val);
            if (sum == node.val)
            {
                list.add(floor, node.val);
                List<Integer> tempList = new ArrayList<>(floor);
//                System.out.println(floor);
                for (int i = 0; i <= floor; i++)
                {
                    tempList.add(list.get(i));
                }
                result.add(tempList);
            }
        }
        list.add(floor, node.val);
        if (node.left != null)
        {
            recursion(node.left, floor + 1, sum - node.val, list, result);
        }
        if (node.right != null)
        {
            recursion(node.right, floor + 1, sum - node.val, list, result);
        }
    }
    
}






















