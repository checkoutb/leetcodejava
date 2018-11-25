package ge200;

import java.util.Stack;

public class LT0232_Implement_Queue_using_Stacks
{

    public static void main(String[] args)
    {
        MyQueue que = new MyQueue();
        que.push(1);
        que.push(2);  
        System.out.println(que.peek());  // returns 1
        System.out.println(que.pop());   // returns 1
        System.out.println(que.peek());
        System.out.println(que.empty()); // returns false
        
        
        for (int i = 10; i < 15; i++)
            que.push(i);
        
        while (!que.empty())
        {
            System.out.println("... " + que.peek());
            System.out.println(".   " + que.pop());
            System.out.println("  . " + que.peek());
        }
        
    }

}

// push to top, peek/pop from top, size, and is empty
// 上次那个 queue实现stack，可以一个queue实现(记住size，然后for循环size(还是 size-1?) -> 从头pop，然后直接push到尾巴)，
// 这个好像没有办法一个stack吧。
// 代码重复的以后再说。
// 58ms, most are [56, 76]ms.

// 56ms, 单个stack，吓死了。。结果push里用了辅助stack。。。
// 他们写的真简洁。。。
/* 55ms, 其他方法 基本 直接s1.xxx()..觉得size没什么意义(代码里empty(){return size==0})吧，直接全部s1就可以了啊。
public void push(int x) {
    size++;
    while (!s1.isEmpty()) s2.push(s1.pop());
    s1.push(x);
    while (!s2.isEmpty()) s1.push(s2.pop());
}
*/
class MyQueue {
    
    private Stack<Integer> stack1;      // top:last input, botton:first input
    
    private Stack<Integer> stack2;      // top:first, bottom:last
    
    private boolean use1;
    
    private Integer peek;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
        this.use1 = true;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (peek == null)
            peek = x;
        if (use1)
        {
            stack1.push(x);             //
            return;
        }
        if (!stack1.isEmpty())
            stack1.clear();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        stack1.push(x);                 // 最后都是stack1.push().所以if(use1) 没什么意义 
        use1 = true;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!use1)
        {
            int top = stack2.pop();
            if (!stack2.isEmpty())
                peek = stack2.peek();           //
            else
                peek = null;
            return top;
        }
        
        if (!stack2.isEmpty())
            stack2.clear();
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int top = stack2.pop();
        if (!stack2.isEmpty())
            peek = stack2.peek();           // 和if(!use1) 也是重复的。
        else
            peek = null;
        use1 ^= true;
        return top;
    }
    
    /** Get the front element. */
    public int peek() {
        return peek == null ? -1 : peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return use1 ? stack1.isEmpty() : stack2.isEmpty();
    }
    
}