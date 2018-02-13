package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * 61. Rotate List
 * */
public class LT0061 {

    public static void main(String[] args) {
        
        int[] nodeArr = {1,2,3,4,5};
        int k = 2;
        
        nodeArr = new int[]{1};
        k = 99;
        
        ListNode head = LTUtils.convertIntArray2ListNode(nodeArr);
        
        LTUtils.showListNode(Lt0061(head, k));
        
    }

    public static ListNode Lt0061(ListNode head, int k)
    {
        if(k == 0 || head == null || head.next == null)
        {
            return head;
        }
        
        
        ListNode result = null;
        
        ListNode front = null;
        ListNode tail = null;
        int i = 0;
        int j = 0;
        
        front = head;
        
        while(front != null)
        {
            i++;
            front = front.next;
        }
        
//        System.out.println(i);
        
        if(k >= i)              // >=
        {
            k = k % i;
        }
        if(k == 0)              // ...
        {
            return head;
        }
        
        
        front = head;
        for(i = 1; i < k; i++)
        {
            front = front.next;
        }
        front = front.next;
        tail = head;
        
        while(front != null && front.next != null)
        {
            front = front.next;
            tail = tail.next;
        }
        
        result = tail.next;
        tail.next = null;
        front.next = head;
        
        
        return result;
    }
    
}



/*

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

*/