package ge100;

import pojo.ListNode;

/**
 * 141. Linked List Cycle
 * */
public class LT0141
{

    public static void main(String[] args)
    {
        
    }

    // 以前看过确定是否存在环的方法，快慢指针。
    // 1ms, most are 0ms... but the code is same
    private boolean Lt0141a(ListNode head)
    {
//        boolean result = false;
        if (head == null)
        {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        // 必须2个!=null，否则nullPointer，主要是fast为null的话，fast.next空指针。
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }
    
}
