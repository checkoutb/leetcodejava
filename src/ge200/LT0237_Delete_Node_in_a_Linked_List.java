package ge200;

import pojo.ListNode;

public class LT0237_Delete_Node_in_a_Linked_List
{

    public static void main(String[] args)
    {
        
    }

    
    // ... 看起来这个题目是出错了啊。。。
    // 结合答案，看懂了，址传递，删除第一个结点。。。直接抄的。。
    private void Lt0237a(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
}
