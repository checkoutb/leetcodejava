package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * Remove Nth Node From End of List
 * */
public class LT0019 {

    public static void main(String[] args) {
        
        int[] array = {1,2,3,4,5};
        array = new int[]{1};
        ListNode head = LTUtils.convertIntArray2ListNode(array);
        LTUtils.showListNode(head);
        int t = 5;
        t = 1;
        
        
        LTUtils.showListNode(Lt0019(head, t));
    }

    // beats 41%
    // remove the first node ...
    public static ListNode Lt0019(ListNode head, int n)
    {
        ListNode front, tail;
        tail = new ListNode(-1);
        tail.next = head;
        front = tail;
        head = tail;
        int i;
        for(i = 0; i < n; i++)
        {
            if(front.next != null)
            {
                front = front.next;
            }
            else
            {
                return head;
            }
        }
        while(front.next != null)
        {
            front = front.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return head.next;
    }
}

/*
1,2,3,4,5 .. 2
1,2,3,  5


*/