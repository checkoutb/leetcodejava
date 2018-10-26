package ge100;

import java.util.Stack;

/**
 * 146. LRU Cache
 * */
public class LT0146_LRU_Cache
{

    public static void main(String[] args)
    {
        
    }

    
}





// 再来一个内部类AAA，里面是key，value，long(保存毫秒数)。
// 本想TreeMap，看了代码才发现TreeMap不能用。得自己写最小堆保存AAA，。，TreeMap的排序 Comparator<? super K> 必须是Key类型或它的父类。
// 或者用2个Map。HashMap<Integer, AAA>，key是用户给的key, TreeMap<Long, AAA>,key是毫秒数。
// 没办法O(1)...能。

// 看了discuss，内部类AAA，是双向链表的结点，里面保存了key,value,pre,post,每次用到结点的时候，就把结点放到最后。容量不够时，删除第一个。
//              LRUCache中有个Map<Integer, AAA> map3，get的时候直接map3.get()。取到结点就调方法把结点放到最后。
//                          set的时候，先map3.get(),如果有，直接改这个结点的value，没有，就新建结点，加到最后，如果容量不够，就把第一个结点删除掉。

// 直接用数组做偏移的话，没有办法处理冲突。就像10容量，5,15分别%10,都映射到一个位置上去了。除非和map一样数组的元素是链表，但这种就不算是O(1)了吧。
//      要是所有的key%capacity都是一个值，就是O(capacity)了啊。。。靠。O(capacity)就是O(1)....

// 上面的map由于元素不过超过capacity,所以也是O(capacity)，所以就是O(1).。。对，而且结点放到最后，由于元素个数有上限，所以也算O(1)..

// discuss的双向链表能直接用LinkedList吧，包含了队列(首，末结点) 和 链表(中间截取结点)

@Deprecated
class LRUCache 
{
    
    int[] data;
    
    int[][] offset;
    
    int capacity;
    
    int size;
    
    Stack<Integer> stackOffset;
    
    Stack<Integer> stackData;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        offset = new int[2][capacity];
        stackOffset = new Stack<>();
        stackData = new Stack<>();
        size = 0;
        for (int i = capacity - 1; i >= 0; i--)
        {
            stackOffset.push(i);
            stackData.push(i);
        }
    }
    
    public int get(int key) {
        for (int i = 0; i < size; i++)
        {
            if (key == offset[0][i])
            {
                return data[offset[1][i]]; 
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (size < capacity)
        {
            int index = stackOffset.pop();
            offset[0][index] = key;
            offset[1][index] = stackData.pop();
            data[offset[1][index]] = value;
            return;
        }
        else
        {
            
        }
    }
    
}