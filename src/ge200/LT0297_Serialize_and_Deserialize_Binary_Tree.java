package ge200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import pojo.TreeNode;
import utils.LTUtils;

public class LT0297_Serialize_and_Deserialize_Binary_Tree
{

    public static void main(String[] args)
    {
        TreeNode root = LTUtils.convertArrayToTreeArray2(1,2,3,null,null,4,5)[0];
        Codec c = new Codec();
        String s = null;
        System.out.println(s = c.serialize(root));
        LTUtils.showTree(c.deserialize(s), 4);
        
        
        System.out.println(Arrays.toString("1,2,3,,,4,5".split(",")));
        
    }

    
}


class Lt0297b
{
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            
            return sb.toString();
        }
        
        
        
        
        
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            TreeNode root = null;
            
            return root;
        }
    }
}


// 层级转换不好写。。v1(v2(v4,v5),v3(,v6))这种不知道好不好写。先序遍历。
@Deprecated         // 47/48, timeout... 输入是 所有right非null，所有left为null的 树。。。。1000层。。但是，2^1000不敢想象。应该是内存溢出吧。
// [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9...,995,null,996,null,997,null,998,null,999,null,1000] 
// 这个照leetCode描述树的写法，应该就是1000层的啊。
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        TreeNode tag = new TreeNode(-1);
        TreeNode tag2 = new TreeNode(-2);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(tag2);
        TreeNode t1 = null;
        boolean breakFlag = false;
        while (!que.isEmpty())
        {
            
//            if (que.size() > 100)
//            {
//                System.out.println(".....");
//                break;
//            }
            
            t1 = que.poll();
            if (t1 == tag2)
            {
                if (breakFlag)
                    break;
                que.add(tag2);
                breakFlag = true;
                continue;
            }
            if (t1 != tag)
            {
                sb.append(t1.val);
            }
            sb.append(",");
//            que.add(t1.left == null ? tag : t1.left);
//            que.add(t1.right == null ? tag : t1.right);
            if (t1.left == null)
            {
                que.add(tag);
            }
            else
            {
                que.add(t1.left);
                breakFlag = false;
            }
            if (t1.right == null)
            {
                que.add(tag);
            }
            else
            {
                que.add(t1.right);
                breakFlag = false;
            }
            
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] arr = data.split(",");
        TreeNode[] nodeArr = new TreeNode[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (arr[i].isEmpty())
                continue;
            nodeArr[i] = new TreeNode(Integer.valueOf(arr[i]));
            nodeArr[i].left = (i * 2 + 1 >= arr.length) ? null : nodeArr[i * 2 + 1];
            nodeArr[i].right = (i * 2 + 2 >= arr.length) ? null :  nodeArr[i * 2 + 2];
        }
        
        return nodeArr[0];
    }
}