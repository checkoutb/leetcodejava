package ge200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LT0295_Find_Median_from_Data_Stream
{

    public static void main(String[] args)
    {
//        MedianFinder mf = new MedianFinder();
//        mf.addNum(1);
//        mf.addNum(2);
//        System.out.println(mf.findMedian());
//        mf.addNum(3);
//        System.out.println(mf.findMedian());
        
//        ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//        [[],              [6],        [],        [10],    [],         [2],      [],           [6],    [],         [5],    [],             [0],        [],     [6],        [],     [3],        [],         [1],    [],[0],[],[0],[]]
        
        
//        ge200.Lt0295b.MedianFinder mf = new Lt0295b().new MedianFinder();
        
        ge200.Lt0295c.MedianFinder mf = new Lt0295c().new MedianFinder();
        
        int[] arr = {6,10,2,6,5,0,6,3,1,0,0};
        
        for (int i : arr)
        {
            mf.addNum(i);
            System.out.println(mf.findMedian());
        }
        
    }
    
}


@Deprecated     // timeout。。。和上个一样，都是17/18... 2分也救不了吧。。
// discuss。。。2个优先队列。。。一个是升序，一个是降序。。Median 在 升序的最大值，降序的最小值 之中。。。。。
class Lt0295c
{
    // Node自己保存前驱后继，不用list怎么样？
    class MedianFinder {
        
        private List<Node> list = null;
        
        private int size = 0;
        
        /** initialize your data structure here. */
        public MedianFinder() {
            this.size = 0;
            this.list = new LinkedList<>();
        }
        
        public void addNum(int num) {
            this.size++;
            this.setNode(num);
        }
        
        // 二分的话。ArrayList好，但是扩容就坑。。。。不会。
        private void setNode(int num)
        {
            int i = 0;
            for (Node n : list)
            {
                if (n.value > num)
                {
                    break;
                }
                if (n.value == num)
                {
                    i = -1;
                    n.addCount();
                    break;
                }
                i++;
            }
            if (i >= 0)
            {
                list.add(i, new Node(num));
            }
        }
        
        public double findMedian() {
            int c = 0;
            int lim = size % 2 == 0 ? size / 2 : size / 2 + 1;
            double ans = 0;
            boolean flag = false;
            for (Node n : list)
            {
                if (flag)
                {
                    ans += n.value;
                    ans /= 2;
                    break;
                }
                c += n.count;           // ... private ???
                if (c >= lim)
                {
                    flag = true;
                    if (size % 2 == 0)
                    {
                        if (c > lim)
                        {
                            ans = n.value;
                            break;
                        }
                        ans = n.value;
                    }
                    else
                    {
                        ans += n.value;
                        break;
                    }
                }
            }
            return ans;
        }
        
        class Node
        {
            private int value;
            private int count;
            public Node(int value)
            {
                this.value = value;
                this.count = 1;
            }
            public void addCount()
            {
                this.count++;
            }
            public int getValue()
            {
                return this.value;
            }
            public int getCount()
            {
                return this.count;
            }
        }
    }

}



@Deprecated         // timeout...
// 不过对于follow1,倒是有点思路：int[100],保存下标代表的值出现的次数。取中值的时候，两个指针从两端开始，累加次数，两个指针的值要近似相等。
//                改进：int[100], size. 数组保存下标的次数，size保存addNum过几个值，取中值时：size/2,指针从头开始累加次数，当然得判断size的奇偶来决定取值。
// follow2,是list，int[100]，list？。。map,int[100],map?
// 对于普通的操作，来个map？保存 值：次数？
// 自己写个node，保存 值 和 次数，然后按照 值 排序。size。
class Lt0295b {
    class MedianFinder {

        private List<Integer> list = null;
        
        /** initialize your data structure here. */
        public MedianFinder() {
            this.list = new LinkedList<>();
        }
        
        public void addNum(int num) {
            int index = 0;
            for (int i : list)
            {
                if (i > num)
                    break;
                index++;
            }
            list.add(index, num);
        }
        
        public double findMedian() {
            if (list.size() == 0)
                return 0;
            return list.size() % 2 == 0 ? ((double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2) : list.get(list.size() / 2);
        }
    }
}


// 直接ArrayList保存全部。
// ...还要排序。。。
class MedianFinder {

    private List<Integer> list = null;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        if (list.size() == 0)
            return 0;
        return list.size() % 2 == 0 ? ((double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2) : list.get(list.size() / 2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */