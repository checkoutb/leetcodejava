package ge200;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LT0218_The_Skyline_Problem
{

    public static void main(String[] args)
    {
        // [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
        int[][] buildings = { {2, 9, 10}, {3, 7, 15}
        , {5, 12, 12}, {15, 20, 10}, {19, 24, 8} 
        };
//        int[][] buildings = {{2,9,10},{9,12,10}};
        
        // 1,3  2,0
//        int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};      // ... 前后。。
        
        LT0218_The_Skyline_Problem lt = new LT0218_The_Skyline_Problem();
        List<int[]> result = lt.Lt0218e(buildings);
        
        for (int[] arr1 : result)
        {
            System.out.println(Arrays.toString(arr1));
        }
    }

    // sort by r?
    
    
    // 234ms....看了discuss，收到2点启发：1.PriorityQueue; 2.有个人贴的网址，里面有个动图，从左往右读取。
    // 从2到420ms,基本都有代码。。看了几个，总结：代码都很长。。。
    private List<int[]> Lt0218e(int[][] buildings)
    {
        
        PriorityQueue<int[]> priQue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
//        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> highPriQue = new PriorityQueue<>((a, b) -> (b - a));
        List<int[]> result = new LinkedList<>();
        int[] arr1 = null;
        int[] arr2 = null;
        int high1 = 0;
        int high2 = 0;
        int high = 0;
        int[] arr = null;
//        for (int[] arr : buildings)
        for (int i = 0; i < buildings.length; i++)
        {
            arr = buildings[i];
            if (priQue.isEmpty())
            {
                priQue.add(arr);
                highPriQue.add(arr[2]);
//                result.add(new int[] {arr[0], arr[2]});
                if (i + 1 < buildings.length)
                {
                    arr2 = buildings[i + 1];
                    if (arr2[0] == arr[0] && arr2[2] > arr[2])
                    {
                        ;
                    }
                    else
                    {
                        result.add(new int[] {arr[0], arr[2]});
                    }
                }
                else
                {
                    result.add(new int[] {arr[0], arr[2]});
                }
                continue;
            }
            while (!priQue.isEmpty() && priQue.peek()[1] < arr[0])          // == ?
            {
                arr1 = priQue.poll();
                high1 = highPriQue.peek();
                highPriQue.remove(arr1[2]);
                high2 = highPriQue.peek() == null ? 0 : highPriQue.peek();
                if (high1 > high2)
                {
                    result.add(new int[] {arr1[1], high2});
                }
            }
            high = arr[2];
            if (high > (highPriQue.peek() == null ? 0 : highPriQue.peek()))
            {
                if (i + 1 < buildings.length)
                {
                    arr2 = buildings[i + 1];
                    if (arr2[0] == arr[0] && arr2[2] > arr[2])
                    {
                        ;
                    }
                    else
                    {
                        result.add(new int[] {arr[0], high});
                    }
                }
                else
                {
                    result.add(new int[] {arr[0], high});
                }
            }
            priQue.add(arr);
            highPriQue.add(arr[2]);
        }
        
        while (!priQue.isEmpty())
        {
            arr1 = priQue.poll();
            highPriQue.remove(arr1[2]);
            if (!priQue.isEmpty())
            {
                arr2 = priQue.peek();
                if (arr1[1] == arr2[1])
                {
                    if (arr2[2] < arr1[1])
                    {
                        priQue.poll();
                        highPriQue.remove(arr2[2]);
                        priQue.add(arr1);
                        highPriQue.add(arr1[2]);
                    }
                    continue;
                }
            }
            high1 = highPriQue.peek() == null ? 0 : highPriQue.peek();
            if (arr1[2] > high1)
            {
                result.add(new int[] {arr1[1], high1});
            }
        }
        
        return result;
    }
    
//    @Deprecated
    private List<int[]> Lt0218d(int[][] buildings)
    {
        List<int[]> result = new LinkedList<>();
        List<int[]> highEndList = new LinkedList<>();
        int high = 0;
        int hEnd = 0;
        int[] arr5 = null;
        int t1 = -1;
        int high2 = 0;
        for (int[] arr1 : buildings)
        {
//            high = 0;
//            hEnd = 0;
            t1 = -1;
            high2 = 0;
            for (Iterator<int[]> it = highEndList.iterator(); it.hasNext();)
            {
                arr5 = it.next();
                if (arr5[1] < arr1[0])
                {
                    if (arr5[0] == high)
                    {
                        if (arr5[1] > t1)
                            t1 = arr5[1];
                    }
                    it.remove();
                    continue;
                }
                if (arr5[0] >= high2)
                {
//                    if (arr5[1] >= hEnd)
                        hEnd = arr5[1];
                        high = arr5[0];
                        high2 = arr5[0];
                }
            }
            
            if (t1 != -1)
                result.add(new int[] {t1, high});
            
            System.out.println(arr1[2] + ", " + high + ", " + hEnd);
            
            if (arr1[2] < high)
            {
                highEndList.add(new int[] {arr1[2], arr1[1]});
            }
            else
            {
//                high = arr1[2];
//                hEnd = arr1[1];
//                result.add(new int[] {arr1[0], high});
                result.add(new int[] {arr1[0], arr1[2]});
                highEndList.add(new int[] {arr1[2], arr1[1]});
            }
        }
        
        return result;
    }
    
    
    @Deprecated
    private List<int[]> Lt0218c(int[][] buildings)
    {
        List<int[]> result = new LinkedList<>();
        
        Stack<int[]> stack = new Stack<>();
        Stack<int[]> stackTemp = new Stack<>();
        
        int[] arr1 = null;
        int[] arr2 = null;
        int flag1 = 0;          // start to pop stack
        int high = 0;
        int t = buildings[0][1];
        for (int i = 0; i < buildings.length; i++)
        {
            arr1 = buildings[i];
//            if (i >= flag1)
            if (arr1[1] == t)
            {
                while (!stack.isEmpty())
                {
                    arr2 = stack.pop();
                    
                }
                
                
            }
            
            if (arr1[2] > high)
            {
                result.add(new int[] {arr1[0], arr1[2]});
                high = arr1[2];
                if (arr1[1] < t)
                {
                    t = arr1[1];
                }
            }
            
            while (stack.peek()[1] > arr1[1])
                stackTemp.push(stack.pop());
            stack.push(arr1);
            while (!stackTemp.isEmpty())
                stack.push(stackTemp.pop());
            
        }
        
        
        return result;
    }
    
    @Deprecated
    private List<int[]> Lt0218b(int[][] buildings)
    {
        List<int[]> result = new LinkedList<>();
//        List<Integer> startList = new ArrayList<>(buildings.length / 2 + 1);
//        List<Integer> endList = new ArrayList<>(buildings.length / 2 + 1);
        List<Integer> startList = new LinkedList<>();
        List<Integer> endList = new LinkedList<>();
        
        int si = 0;
        int ei = 0;
        int i = 0;
        for (int[] arr1 : buildings)
        {
            i = si;
            for (; i < startList.size(); i++)
            {
                if (arr1[0] < startList.get(i))
                    break;
            }
            si = i;
            
            
        }
        
        
        return result;
    }
    
    @Deprecated
    // 已按Li排序  l,r,h
    private List<int[]> Lt0218a(int[][] buildings)
    {
        List<int[]> result = new LinkedList<>();
        
        List<Helper> list = new LinkedList<>();
        
        for (int[] arr1 : buildings)
        {
            this.insert(arr1, list);
        }
        
        return result;
    }
    
    // LinkedHashMap?
    private void insert(int[] arr1, List<Helper> list)
    {
        int index = 0;
        int size = list.size();
        Helper h = null;
        for (; index < size; index++)
            if (list.get(index).x >= arr1[0])
                break;
        
        if (index == size || size == 0)
        {
            h = Helper.getInstance(arr1[0], arr1[2], true);
            list.add(h);
            h = Helper.getInstance(arr1[1], arr1[2], false);
            list.add(h);
            return;
        }
        
        Helper h2 = list.get(index);
        if (h2.x == arr1[0])
        {
            if (!h2.isLeft)
            {
//                if (h2.h < arr1[2])
//                {
//                    h2.isLeft = true;
//                    h2.h = arr1[2];
//                }
//                else
//                {
//                    
//                }
            }
            else
            {
                if (h2.h < arr1[0])
                    h2.h = arr1[0];
            }
        }
        else
        {
            
        }
        int high = arr1[2];
        int index2 = index;
        for (; index2 < size; index2++)
        {
            if (list.get(index2).x > arr1[1])
                break;
            
            
        }
        h = Helper.getInstance(arr1[0], arr1[2], true);
        
        
    }
    
}

@Deprecated
class Helper implements Cloneable
{
    public int x;
    public int h;
    public boolean isLeft;
    
    private Helper() {}
    
    private final static Helper instance = new Helper();
    
    public static Helper getInstance(int x, int h, boolean isLeft)
    {
        try
        {
            Helper h2 = instance.clone();
            h2.x = x;
            h2.h = h;
            h2.isLeft = isLeft;
            return h2;
        } catch (CloneNotSupportedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    protected Helper clone() throws CloneNotSupportedException
    {
        return (Helper) super.clone();
    }
    
}