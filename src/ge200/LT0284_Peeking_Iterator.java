package ge200;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LT0284_Peeking_Iterator
{

    public static void main(String[] args)
    {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        PeekingIterator it = new PeekingIterator(list.iterator());
        
        System.out.println(it.next());
        System.out.println(it.peek());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        
    }

}

// 57ms, most are [57, 70]ms.
// 一种写法是： hasNext返回：return curr != null;  即 peek始终都有值，除非是真的没有值。
// 一种是：写个Queue，构造器里遍历iterator，保存到Queue里。。。。。。
class PeekingIterator implements Iterator<Integer> {
    
    private Integer peek = null;
    
    private Iterator<Integer> iterator;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null && iterator.hasNext())
            peek = iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek != null)
        {
            Integer p = peek;
            peek = null;
            return p;
        }
        if (iterator.hasNext())
            return iterator.next();
        return null;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || peek != null;
    }
}