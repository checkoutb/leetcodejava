package ge100;

import pojo.ListNode;
import utils.LTUtils;

/**
 * 
 * */
public class LT0147_Insertion_Sort_List
{

    public static void main(String[] args)
    {
        int[] arr = {4,2,1,3};
        ListNode head = LTUtils.convertIntArray2ListNode(arr);
        LTUtils.showListNode(new LT0147_Insertion_Sort_List().Lt0147a(head));
    }

    // 插入排序
    // 6ms, most are [5, 11] U [27, 40]ms
    // 这个题目应该换过测试案例吧。
    private ListNode Lt0147a(ListNode head)
    {
        
        if (head == null || head.next == null)
        {
            return head;
        }
        
        ListNode node1 = head;
        ListNode pre = null;
        ListNode node2 = null;
        ListNode min = head;
        ListNode node3 = null;
        while (node1.next != null)
        {
            pre = node1;
            node1 = node1.next;
            if (node1.val < min.val)
            {
                pre.next = node1.next;
                node1.next = min;
                min = node1;
                node1 = pre;
            }
            else
            {
                if (node1.val < pre.val)
                {
                    node2 = min;
                    while (node2.next != null)            // 可以和 node1.val < min.val 合并
                    {
                        node3 = node2.next;
                        if (node3.val > node1.val)
                        {
                            break;
                        }
                        node2 = node3;
                    }
                    pre.next = node1.next;
                    node1.next = node3;
                    node2.next = node1;
                    node1 = pre;
                }
            }
        }
        
        return min;
        
    }
}
