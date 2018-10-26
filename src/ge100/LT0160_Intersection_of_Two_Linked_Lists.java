package ge100;

import pojo.ListNode;
import utils.LTUtils;

public class LT0160_Intersection_of_Two_Linked_Lists
{

    public static void main(String[] args)
    {
        ListNode aa = LTUtils.convertIntArray2ListNode(new int[] { 1, 2, 3, 4, 5 });
        ListNode bb = LTUtils.convertIntArray2ListNode(new int[] { 111, 222 });
        
        ListNode aa1 = aa;
        ListNode bb1 = bb;
        int t = 2;
        for (int i = 0; i < t; i++)
        {
            aa1 = aa1.next;
        }
        
        while (bb1.next != null)
        {
            bb1 = bb1.next;
        }
        bb1.next = aa1;
        
        LT0160_Intersection_of_Two_Linked_Lists lt = new LT0160_Intersection_of_Two_Linked_Lists();
        
        LTUtils.showListNode(aa);
        LTUtils.showListNode(bb);
        
        System.out.println(lt.Lt0160a(aa, bb).val);

        LTUtils.showListNode(aa);
        LTUtils.showListNode(bb);
    }

    
    // 原来没有思路，但是看到提示2：2个list需要恢复原来的形状...此地无银三百两。
    // 如果只是确定有没有交点就好弄，listA全部反转，然后listB遍历，看listB的尾巴是不是listA的尾巴
    
    // 可以listA全部反转，把listA的尾巴指向listB，快慢指针遍历listA，之前有个题目就是靠快慢指针找到环的入口。这个入口就是交点。然后恢复listA就可以了。
    // 反转成环+快慢指针能满足O(n) + O(1)。
    
    // 不知道反转前，先遍历一下，看哪个短 会不会提升效率，，不过至少会平均一下速度。.会提速。
    
    
    // 4ms, most are [1, 2]ms..
    
    // 1ms的解法： 2个指针，各自next遍历，如果碰到null，就指向另一个链表头，继续遍历，直到两个指针相同。最差情况2个链表长度和 步之后退出。
    //                  指针相同可能是null==null,也可能是第一个交点。
    //          就是2个指针，一个遍历headA+headB, 一个遍历headB+headA。没有交点就遍历完后null==null，
    //      要用到2ms的思路，第一个交点之后的距离是相同的。所以假设headA长m，headB长n，共用的结点是i个，
    //                      那么 m-i==n-i or m+n-i==n+m-i..，第二个等式必然成立，所以在存在交点的情况下必然能找到第一个交点。
    
    // 2ms的解法： 将两根链表截到相同长度，然后开始遍历，直到两个指针相同，直接返回。
    //          m-(m-n)-i == n-i (m>=n) 等式必然成立。
    private ListNode Lt0160a(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null)
        {
            return null;
        }
        ListNode result = null;
        
        ListNode[] arr2 = this.orderByLength(headA, headB);
        ListNode listShort = arr2[0];
        ListNode listLong = arr2[1];
        
        ListNode[] arr3 = this.reverseAndCircle(listShort, listLong);
        
        result = this.findIntersection(arr3[1]);
        
        arr3[0].next = null;
        this.reverse(arr3[1]);
        
        return result;
    }
    
    private ListNode findIntersection(ListNode node)
    {
        ListNode result = null;
        ListNode speed1 = node;
        ListNode speed2 = node;
        
        while (speed2.next != null && speed2.next.next != null)
        {
            speed2 = speed2.next.next;
            speed1 = speed1.next;
            if (speed1 == speed2)
            {
                speed2 = node;
                while (speed1 != speed2)
                {
                    speed1 = speed1.next;
                    speed2 = speed2.next;
                }
                result = speed1;
                break;
            }
        }
        
        return result;
    }
    
    // 0:short, 1:long
    private ListNode[] orderByLength(ListNode listA, ListNode listB)
    {
        int count1 = 0;
        ListNode a = listA;
        ListNode b = listB;
        while (listA != null)
        {
            count1++;
            listA = listA.next;
        }
        int count2 = 0;
        while (listB != null)
        {
            count2++;
            listB = listB.next;
        }
        ListNode[] result = new ListNode[2];
        result[0] = count1 > count2 ? b : a;
        result[1] = count1 > count2 ? a : b;
        return result;
        
    }
    
    private ListNode[] reverseAndCircle(ListNode listShort, ListNode listLong)
    {
        ListNode[] arr3 = this.reverse(listShort);
        arr3[0].next = listLong;
        return arr3;
    }
    
    // 0:original head, 1:now head.
    private ListNode[] reverse(ListNode node)
    {
        ListNode[] result = new ListNode[2];
        result[0] = node;
        ListNode temp = null;
        ListNode last = null;
        while (node != null)
        {
            temp = node.next;
            node.next = last;
            last = node;
            node = temp;
        }
        result[1] = last;
        
        return result;
        
    }
    
}
