package gt000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pojo.ListNode;
import utils.LTUtils;

/**
 * Merge k Sorted Lists 
 * */
public class LT0023 {

    public static void main(String[] args) {
        
        int[] a1 = {1,4,6};
        int[] a2 = {2,3,9};
        int[] a3 = {1};
        int[] a4 = {};
        
        
        ListNode[] lists = {
//                LTUtils.convertIntArray2ListNode(a1), LTUtils.convertIntArray2ListNode(a2),
                LTUtils.convertIntArray2ListNode(a3)
                , 
//                LTUtils.convertIntArray2ListNode(a3)
                LTUtils.convertIntArray2ListNode(a4) 
//                ,
//                LTUtils.convertIntArray2ListNode(a4) 
                };
        LTUtils.showListNode(Lt0023c(lists));
        
    }

    // 遍历lists，构造一个list，list转为数组，根据val排序，遍历一遍，然后输出。不知道会不会time out。
    
    // 网上是分治或者java的优先队列PriorityQueue。分治就是两两合并，应该能直接用while来解决吧。不要递归。
    
    
    // 129/130 time out.
    public static ListNode Lt0023c(ListNode[] lists)
    {
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        if(lists.length == 1)
        {
            return lists[0];
        }
        
        ListNode result = null;
        ListNode tail = null;
        
        int len = lists.length;
        
        boolean[] valid = new boolean[len];
        
        int min = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        int val;
        int index = -1;
        ListNode temp;
        for(; i < len; i++)
        {
            valid[i] = true;
            
            if(lists[i] == null)
            {
                valid[i] = false;
                sum++;
            }
            else
            {
                val = lists[i].val;
                if(val <= min)
                {
                    min = val;
                    index = i;
                }
            }
        }
        
        if(index == -1)
        {
            return null;
        }
        result = lists[index];
        tail = result;
        lists[index] = lists[index].next;
        if(lists[index] == null)
        {
            valid[index] = false;
            sum++;
        }
        while(sum < len-1)
        {
            min = Integer.MAX_VALUE;
            for(i = 0; i < len; i++)
            {
                if(!valid[i])
                {
                    continue;
                }
                val = lists[i].val;
                if(val <= min)
                {
                    min = val;
                    index = i;
                }
            }
            
            temp = lists[index];
            lists[index] = lists[index].next;
            tail.next = temp;
            tail = tail.next;
            if(lists[index] == null)
            {
                valid[index] = false;
                sum++;
            }
        }
        
        for(i = 0; i < len; i++)
        {
            if(valid[i])
            {
                tail.next = lists[i];
                break;
            }
        }
        
        return result;
    }
    
    
    
    // [[][]] [[1][0]] [[][1]]... failed
    
    public static ListNode Lt0023b(ListNode[] lists)
    {
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        if(lists.length == 1)
        {
            return lists[0];
        }
        ListNode result = null;
        ListNode tail = null;
        int len = lists.length;

        int[] listsIndex2 = new int[len];
        
        int i = 0;
        
        int val;
        int index = -1;
        int min;
        ListNode temp;
        int sum = 0;
        
        min = Integer.MAX_VALUE;
        
        for(i = 0; i < len; i++)
        {
            if(listsIndex2[i] == -1)
            {
                continue;
            }
            if(lists[i] == null)
            {
                listsIndex2[i] = -1;
                sum++;
            }
            else
            {
                val = lists[i].val;
                if(val <= min)
                {
                    min = val;
                    index = i;
                }
            }
        }
        
        if(index == -1)             // [[][]]
        {
            return null;
        }
        
        result = lists[index];
        tail = result;
        
        while(sum < len - 1)
        {
            min = Integer.MAX_VALUE;
            for(i = 0; i < len; i++)
            {
                if(listsIndex2[i] == -1)
                {
                    continue;
                }
                if(lists[i] == null)
                {
                    listsIndex2[i] = -1;
                    sum++;
                }
                else
                {
                    val = lists[i].val;
                    if(val <= min)
                    {
                        min = val;
                        index = i;
                    }
                }
            }
            temp = lists[index];
            lists[index] = lists[index].next;
            listsIndex2[index]++;                           // [[1][0]]
            tail.next = temp;
            tail = tail.next;
        }
        for(i = 0; i < len; i++)
        {
            if(listsIndex2[i] != -1)
            {
                tail.next = lists[i];
                break;
            }
        }
        return result;
    }
    
    
    
    // [], [[]],[[1]], 129/130 time out...
    public static ListNode Lt0023a(ListNode[] lists)
    {
        ListNode result = null;
        ListNode tail = null;
        int len = lists.length;
        
        List<Integer> listsIndex = new ArrayList<>();
        List<Integer> del = new ArrayList<>();
        
        int i = 0;
        for(; i < len; i++)
        {
            listsIndex.add((Integer)i);
        }
        
        int val;
        int index = -1;
        int min;
        ListNode temp;
        
        min = Integer.MAX_VALUE;
        for(int in : listsIndex)
        {
            if(lists[in] == null)
            {
                del.add((Integer)in);
            }
            else
            {
                val = lists[in].val;
                if(val <= min)
                {
                    min = val;
                    index = in;
                }
            }
            
        }
        if(!del.isEmpty())
        {
            listsIndex.removeAll(del);
            del.clear();
        }
        
        if(listsIndex.isEmpty())
        {
            return null;
        }
        else if(listsIndex.size() == 1)
        {
            return lists[listsIndex.get(0)];
        }
        
        result = lists[index];
        tail = result;
        
        while(listsIndex.size() > 1)
        {
            min = Integer.MAX_VALUE;
            for(int in : listsIndex)
            {
                if(lists[in] == null)
                {
                    del.add((Integer)in);
                }
                else
                {
                    val = lists[in].val;
                    if(val <= min)
                    {
                        min = val;
                        index = in;
                    }
                }
                
            }
            if(!del.isEmpty())
            {
                listsIndex.removeAll(del);
                del.clear();
            }
            temp = lists[index];
            lists[index] = lists[index].next;
            tail.next = temp;
            tail = tail.next;
        }
        tail.next = lists[listsIndex.get(0)];
        return result;
    }
    
    
    // failed...pre + tail cause endless loop
    public static ListNode Lt0023(ListNode[] lists)
    {
        int len = lists.length;
        int len1 = len - 1;
        ListNode[] pre = new ListNode[len];
        ListNode result = null;
        ListNode tail = null;
        List<Integer> index = new ArrayList<>();
        int i = 0;
        
        for(; i < len; i++)
        {
            pre[i] = new ListNode(-1);
            pre[i].next = lists[i];
            index.add(i);
        }
        
        int index2 = -1;
        int index3;
        int min;
        int val;
        ListNode temp;
        
        min = Integer.MAX_VALUE;

        
//        for(Iterator<Integer> it = index.iterator(); it.hasNext();)
//        {
//            index3 = it.next();
//            if(pre[index3].next == null)
//            {
//                it.remove();
//                continue;
//            }
//            val = pre[index3].next.val;
//            if(val < min)
//            {
//                min = val;
//                index2 = index3;
//            }
//        }
        
        List<Integer> del = new ArrayList<>();
        for(int index1 : index)
        {
            if(pre[index1].next == null)
            {
                del.add(index1);
                continue;
            }
            val = pre[index1].next.val;
            if(val < min)
            {
                min = val;
                index2 = index1;
            }
        }
        
        if(index2 == -1)
        {
            return null;
        }

        pre[index2] = pre[index2].next;
        result = pre[index2];
        tail = result;
        
        for(int index1 : del)
        {
            index.remove((Integer)index1);
        }

        while(index.size() > 1)
        {
            min = Integer.MAX_VALUE;
            for(int index1 : index)
            {
                val = pre[index1].next.val;
                if(val <= min)
                {
                    min = val;
                    index2 = index1;
                }
            }
            pre[index2] = pre[index2].next;
            tail.next = pre[index2];
            tail = tail.next;
            
            if(pre[index2].next == null)
            {
                index.remove((Integer)index2);
            }
            
            LTUtils.showListNode(result);
        }
        
        tail.next = pre[index.get(0)];

        return result.next;
    }
}

/*
1 4 6
2 3 9

46
239
1

12



*/























