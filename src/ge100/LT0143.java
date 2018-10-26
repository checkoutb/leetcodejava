package ge100;

import pojo.ListNode;
import utils.LTUtils;

/**
 * 143. Reorder List
 * */
public class LT0143
{

    public static void main(String[] args)
    {
        ListNode head = LTUtils.convertIntArray2ListNode(new int[] { 1, 2, 3, 4, 5,  });
        
        new LT0143().Lt0143a(head);
        LTUtils.showListNode(head);
    }

    // 0-1-2-3-...n
    // 0-(n)-1-(n-1)-2
    // 快慢指针找中点，然后后半部分反转，然后2个合并。。
    
    // 2ms, most are [2, 3]ms
    private void Lt0143a(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode node3 = head;
        while (node2.next != null && node2.next.next != null)
        {
            node3 = node1;
            node2 = node2.next.next;
            node1 = node1.next;
        }
        node3 = node1;
        node1 = node1.next;
        node3.next = null;
        node2 = node1;
        ListNode node4 = null;
        while (node1.next != null)
        {
            node3 = node1.next;
            node1.next = node4;
            node4 = node1;
            node1 = node3;
        }
        node1.next = node4;         // 。。。
        
        LTUtils.showListNode(head);
        LTUtils.showListNode(node1);
        
        node2 = head;
        // head.length >= node1.length
        while (node2.next != null)
        {
            node3 = node2.next;
            node4 = node1.next;
            node2.next = node1;
            node1.next = node3;
            node1 = node4;
            node2 = node3;
        }
        node2.next = node1;         // ...
        
    }
}
