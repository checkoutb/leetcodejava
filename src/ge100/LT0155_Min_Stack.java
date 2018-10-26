package ge100;

import java.util.Stack;

public class LT0155_Min_Stack
{

    public static void main(String[] args)
    {
        
    }

}

// Stack + TreeMap, 新建一个类AAA，保存一个int值，Stack<AAA>, Map<Integer, AAA>, push,pop,top都是Stack的。
//      getMin，就靠TreeMap了。push的时候put，pop的时候remove.
//      应该不算O(1)吧，没办法固定时间，由于元素个数可以无限，所以TreeMap的put，remove不可能O(1).

// Stack。 类AAA，保存int值，和前后结点。按int值顺序做成一个双向链表。MinStack增加一个属性保存最小的AAA。
//      pop,top,getMin,都是O(1)。。push不是O(1),得在链表上找到结点的位置。

// Stack是数组保存的，所以LinkedList应该更好点。


// 264ms....most are [61, 127]ms
/*
class StackNode {
    int val;
    int min;
    public StackNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}
*/
// 在结点上保存这个结点压栈时的最小值。。。。。。。。。。。

// 双栈，一个普通栈A，一个保存最小值的栈B
// push的时候，看新的值是否大于B的栈顶，小于等于的话，B.push.
// pop的时候，看pop出来的值，是否等于B的栈顶，是的花B.pop...上面是小于等于，这里才能保证正确。因为可能压入几个相同的最小值。

// 栈是有顺序的。所以能保存目前的最小值。

class MinStack {
    
    private Stack<Helper> stack;
    
    private Helper min;
    
    public MinStack() {
        stack = new Stack<>();
        min = null;
    }
    
    public void push(int x) {
        Helper h = new Helper(x);
        stack.push(h);
        this.insert(h);
    }
    
    private void insert(Helper h)
    {
        Helper t = min;
        Helper last = null;
        while (t != null)
        {
            if (t.val > h.val)
            {
                break;
            }
            last = t;
            t = t.next;
        }
        if (t == null)
        {
            if (last == null)
            {
                min = h;
            }
            else
            {
                last.next = h;
                h.pre = last;
            }
        }
        else
        {
            if (last == null)
            {
                min = h;
                h.next = t;
                t.pre = h;
            }
            else
            {
                last.next = h;
                h.pre = last;
                t.pre = h;
                h.next = t;
            }
        }
    }
    
    private void delete(Helper h)
    {
        if (h.pre != null)
        {
            h.pre.next = h.next;
        }
        else
        {
            min = h.next;
        }
        if (h.next != null)
        {
            h.next.pre = h.pre;
        }
    }
    
    public void pop() {
        if (stack.isEmpty())
        {
            return;
        }
        Helper h = stack.pop();
        this.delete(h);
    }
    
    public int top() {
        return stack.peek() == null ? 0 : this.stack.peek().val;
    }
    
    public int getMin() {
        return this.min == null ? 0 : this.min.val;
    }
    
    class Helper
    {
        public int val;

        public Helper pre;

        public Helper next;

        public Helper(int val)
        {
            super();
            this.val = val;
        }
    }
    
}