package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * Reverse Nodes in k-Group
 * */
public class LT0025 {

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4};
        arr = new int[]{1,2,3,4,5};
        int k = 2;
        
        LTUtils.showListNode(Lt0025(LTUtils.convertIntArray2ListNode(arr), k));
        
    }

    
    // beats 8.25%
    public static ListNode Lt0025(ListNode head, int k)
    {
        ListNode[] temp = new ListNode[k];
        int i = 0;
        ListNode tail = head;
        ListNode temp2;
        int k1 = k - 1;
        
        for(; i < k; i++)
        {
            if(tail != null)
            {
                temp[i] = tail;
                tail = tail.next;
            }
            else
            {
                return head;
            }
        }
        
        head = temp[k1];
        temp[0].next = temp[k1].next;
        for(i = k1; i > 0; i--)
        {
            temp[i].next = temp[i-1];
        }
        tail = temp[0];                         //
        
        while(true)
        {
            temp2 = tail;
            for(i = 0; i < k ;i++)
            {
                tail = tail.next;
                
                if(tail != null)
                {
                    temp[i] = tail;
                }
                else
                {
                    return head;
                }
            }
            
            temp2.next = temp[k1];                      //
            temp[0].next = temp[k1].next;
            for(i = k1; i > 0; i--)
            {
                temp[i].next = temp[i-1];
            }
            tail = temp[0];                             //
        }
    }
}



/*

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5             .. not 321 54


*/