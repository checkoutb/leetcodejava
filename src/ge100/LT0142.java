package ge100;

import pojo.ListNode;

/**
 * 142. Linked List Cycle II
 * */
public class LT0142
{

    public static void main(String[] args)
    {
        
    }

    // 我也看过，和141一起的，但是好像忘记了。。只有一些零星记忆了。。快慢指针，保存下步数，然后四则预算就出来结果了。
    // 或者简单点，干脆Set保存下经过的结点算了。。
    
    // baidu了。。是快慢指针相遇后，快指针设置为head，速度改成和慢指针一样，然后下次相遇就是 环的入口。
    // ok，主要是：相遇时，慢指针路径*2 == 快指针路径，慢指针路径 = (非环部分 + 部分环)，快指针路径 = (非环部分 + n个圈 + 部分环)。
    // 部分环是指。相遇时，从入口到相遇点的距离。
    // 所以 2*非环部分 + 2个部分环 == 非环部分 + n个环 + 部分环。-> 非环部分 == 环-部分环。。。所以一个指针从头开始，再相遇就是入口。
    private ListNode Lt0142(ListNode head)
    {
        ListNode result = null;
        
        
        return result;
    }
    
}
