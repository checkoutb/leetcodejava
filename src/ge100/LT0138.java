package ge100;

import java.util.HashMap;
import java.util.Map;

import pojo.RandomListNode;

/**
 * 138. Copy List With Random Pointer
 * */
public class LT0138
{

    public static void main(String[] args)
    {
        RandomListNode node = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        node.next = node2;
        node.random = node;
        node2.random = node;
        
        RandomListNode result = new LT0138().Lt0138a(node);
        
        System.out.println(result);
    }

    // 4ms, most are [1, 4]ms.
    // 看了1ms的代码，似乎是要 next能遍历全部结点 的情况下才对。
    // while循环老结点next，对每个结点，都复制一个新结点，然后 新结点.next -> 老结点.next, 老结点.next -> 新结点 
    // while循环老结点nextnext，如果老结点有random，则老结点.next.random = 老结点.random.next。
    // 因为老结点的next就是新结点，老结点.random是老结点。老结点.random.next 就是 老结点.random对应的新结点。
    // 然后剔除老结点，就ok了。
    private RandomListNode Lt0138a(RandomListNode head)
    {
        if (head == null)
        {
            return null;
        }
        RandomListNode result = new RandomListNode(head.label);
        // key: original, value: clone
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, result);
        recursiona1(head, result, map);
        
        return result;
    }
    
    private void recursiona1(RandomListNode source, RandomListNode target, Map<RandomListNode, RandomListNode> map)
    {
        if (source.next != null)
        {
            if (map.containsKey(source.next))
            {
                target.next = map.get(source.next);
            }
            else
            {
                target.next = new RandomListNode(source.next.label);
                map.put(source.next, target.next);
                this.recursiona1(source.next, target.next, map);
            }
        }
        if (source.random != null)
        {
            if (map.containsKey(source.random))
            {
                target.random = map.get(source.random);
            }
            else
            {
                target.random = new RandomListNode(source.random.label);
                map.put(source.random, target.next);
                this.recursiona1(source.random, target.random, map);
            }
        }
    }
    
}
