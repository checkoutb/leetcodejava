package pojo;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x)
    {
        val = x;
    }
    
    /**
     * @return the val
     */
    public int getVal() {
        return val;
    }
    /**
     * @return the next
     */
    public ListNode getNext() {
        return next;
    }
    /**
     * @param val the val to set
     */
    public void setVal(int val) {
        this.val = val;
    }
    /**
     * @param next the next to set
     */
    public void setNext(ListNode next) {
        this.next = next;
    }
    
    
}
