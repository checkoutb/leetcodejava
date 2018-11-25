package ge200;

import java.util.LinkedList;
import java.util.Queue;

public class LT0225_Implement_Stack_using_Queues
{

    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        for (int i = 0; i < 5; i++)
            s.push(i);
        while (!s.empty())
            System.out.println(s.top() + ", " + s.pop());
    }

}

// 68ms, most are [57, 63] U [64, 85]ms.
// 基本都是2个队列，不过细节都不同。
// 有一种1个队列的，push/pop的时候获得size，循环que.offer(que.poll());
// while (e-->0)
class MyStack {

    // queue : push, pop, size, isEmpty
    private Queue<Integer> que1 = new LinkedList<>();
    
    private Queue<Integer> que2 = new LinkedList<>();
    
    private boolean useQue1 = true;
    
    private Integer top = null;
    
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        if (useQue1)
            que1.offer(x);
        else
            que2.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top2 = top;
        Queue<Integer> src = useQue1 ? que1 : que2;
        Queue<Integer> tar = useQue1 ? que2 : que1;
        while (src.size() >= 2)
            tar.offer((top = src.poll()));
        if (!src.isEmpty())
            src.poll();
        useQue1 ^= true;
        return top2;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return useQue1 ? que1.isEmpty() : que2.isEmpty();
    }
}