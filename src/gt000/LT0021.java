package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * Merge Two Sorted Lists
 * */
public class LT0021 {

    public static void main(String[] args) {

        int[] arr1 = {1,3,4};
        int[] arr2 = {1,2,4};
        
        ListNode l1 = LTUtils.convertIntArray2ListNode(arr1);
        ListNode l2 = LTUtils.convertIntArray2ListNode(arr2);
        
        LTUtils.showListNode(Lt0021(l1, l2));
        
    }

    // beats 13%..
    // they use prehead to avoid null pointer..
    public static ListNode Lt0021(ListNode l1, ListNode l2)
    {
        // null pointer...
        if(l1 == null && l2 == null)
        {
            return null;
        }
        if(l1 == null)
        {
            return l2;
        }
        if(l2 == null)
        {
            return l1;
        }
        
        ListNode head;
        if(l1.val > l2.val)
        {
            head = l2;
            l2 = l2.next;
        }
        else
        {
            head = l1;
            l1 = l1.next;
        }
        
        ListNode tail = head;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val > l2.val)
            {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
            else
            {
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            }
        }
        if(l1 == null)
        {
            tail.next = l2;
        }
        else
        {
            tail.next = l1;
        }
        
        return head;
    }
}
