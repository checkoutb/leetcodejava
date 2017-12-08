package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * Swap Nodes in Pairs
 * */
public class LT0024 {

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4};
        
        LTUtils.showListNode(Lt0024(LTUtils.convertIntArray2ListNode(arr)));
    }

    
    // 5ms,beat 10.6%
    public static ListNode Lt0024(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode tail = head;
        head = head.next;
        tail.next = head.next;
        head.next = tail;
        
        ListNode temp;
        
        while(tail.next != null && tail.next.next != null)
        {
            temp = tail.next.next;
            tail.next.next = temp.next;
            temp.next = tail.next;
            tail.next = temp;
            tail = tail.next.next;
        }
        
        return head;
    }
}


/*

Given 1->2->3->4, you should return the list as 2->1->4->3. 

*/