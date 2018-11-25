package ge200;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT0207_Course_Schedule
{

    public static void main(String[] args)
    {
        int[] courses = {2,2};
        int[][][] requests = {{{0,1}},{{0,1},{1,0}}};
        
        LT0207_Course_Schedule lt = new LT0207_Course_Schedule();
        for (int i = 0; i < courses.length; i++)
        {
            System.out.println(lt.Lt0207b(courses[i], requests[i]));
        }
    }

    
    // 搜索了有向图找环的方法。
    // 12ms，5-100都有。。5-15,15-50,50-100几个阶梯。
    private boolean Lt0207b(int numCourses, int[][] prerequisites)
    {
        
        int[] arr1 = new int[numCourses];
        Map<Integer, List<Integer>> map = this.convertb1(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++)
            if (arr1[i] == 0)
                if (!this.recursionb1DFS(arr1, map, i))
                    return false;
        return true;
    }
    
    private Map<Integer, List<Integer>> convertb1(int max, int[][] arr2)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < max; i++)
            map.put(i, new LinkedList<>());
        for (int[] arr : arr2)
            map.get(arr[0]).add(arr[1]);
        return map;
    }
    
    private boolean recursionb1DFS(int[] arr1, Map<Integer, List<Integer>> map, int index)
    {
        if (arr1[index] == -1)
            return false;
        if (arr1[index] == 1)
            return true;
        arr1[index] = -1;
        for (int i : map.get(index))
            if (!this.recursionb1DFS(arr1, map, i))
                return false;
        arr1[index] = 1;
        return true;
    }
    
    
    
    
    // 上面的通过以后，看这个。BSF搜索，但是由于没有标记位，所以没有办法成功。不加标记位的话，加一个set和deque一起应该也可以。
    @Deprecated
    private boolean Lt0207a(int numCourses, int[][] prerequisites)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        for (int[] arr : prerequisites)
        {
            if ((list = map.get(arr[0])) == null)
                map.put(arr[0], (list = new LinkedList<>()));
            list.add(arr[1]);
        }
        
        Set<Integer> finished = new HashSet<>();
//        Set<Integer> tempSet = new HashSet<>();
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new LinkedList<>();
        int t1 = 0;
        for (int i = 0; i < numCourses; i++)
        {
            if (finished.contains(i))
                continue;
            if (!map.containsKey(i))
                finished.add(i);
            else
            {
                deque.clear();
                deque.addFirst(i);
                
                while (!deque.isEmpty())
                {
                    t1 = deque.peekLast();
                    if (map.containsKey(t1))
                    {
                        list = map.get(t1);
                        for (int i2 : list)
                        {
                            if (deque.contains(i2))
                                return false;
                            deque.addFirst(i2);
                        }
                    }
                    deque.removeLast();
                }
                
//                tempSet.clear();
//                tempSet.add(i);
//                stack.clear();
//                stack.push(i);
//                while (!stack.isEmpty())
//                {
//                    t1 = stack.pop();
//                    if (map.containsKey(t1))
//                    {
//                        list = map.get(t1);
//                        for (int i2 : list)
//                        {
//                            if (stack.contains(i2))
//                                return false;
//                            stack.push(i2);
//                        }
//                        stack.remove(stack.size());
//                    }
//                }
            }
        }
        
        return true;
    }
}
