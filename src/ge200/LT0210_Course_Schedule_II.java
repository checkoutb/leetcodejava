package ge200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LT0210_Course_Schedule_II
{

    public static void main(String[] args)
    {
        int n = 2;
        int[][] nums = {{1,0}};
        
        n = 4;
        nums = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        
        System.out.println(Arrays.toString(new LT0210_Course_Schedule_II().Lt0210c(n, nums)));
    }
    
    
    
    
    // 判断 并 用集合保存被遍历结点的后继，只有这些后继的度会发生变化。
    // 160ms...most are [6-30]ms..
    // 解法千奇百怪。。。
    /*
    int[] degree = new int[num];
    List[] edges = new List[num];
    int[] ans = new int[num];
    
    edges[pre[i][1]].add(pre[i][0]);            // 把前驱改成后继,v1,v2互换。
    */
    
    private int[] Lt0210c(int numCourses, int[][] prerequisites)
    {
        Map<Integer, List<Integer>> map = this.convertc2(prerequisites);
        int p1 = 0;
        int p2 = -1;
        int[] result = new int[numCourses];
        int[] tagArr = new int[numCourses];
        List<Integer> defaultList = new LinkedList<>();
        while (p1 != p2)
        {
            p2 = p1;
            for (int i = 0; i < numCourses; i++)
                if (tagArr[i] == 0)
                {
                    if (map.getOrDefault(i, defaultList).size() == 0)
                    {
                        tagArr[i] = 1;
                        result[p1++] = i;
                        for (int j = 0; j < numCourses; j++)
                        {
                            if (tagArr[j] == 0 && map.containsKey(j) && map.get(j).contains(i))
                            {
                                map.get(j).remove((Integer) i);
                            }
                        }
                    }
                }
        }
        return p1 == numCourses ? result : new int[0];
    }
    
    private Map<Integer, List<Integer>> convertc2(int[][] arr2)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        for (int[] arr1 : arr2)
        {
            list = map.getOrDefault(arr1[0], new LinkedList<>());
            list.add(arr1[1]);
            map.put(arr1[0], list);
        }
        return map;
    }
    
    
    // ??? 反向输出。。。拓扑排序是入度为0开始。。。题目应该是出度为0开始。。出度为0意味着没有前置课程，所以可以直接学。。。
    // v1 -> v2, 一般来说是指 v1是v2的前置，，但是题目是 v2是v1的前置。。。
    @Deprecated
    private int[] Lt0210b(int numCourses, int[][] prerequisites)
    {
        
        Map[] arr3 = this.convertb2(prerequisites);
        Map<Integer, Integer> map1 = arr3[0];
        Map<Integer, List<Integer>> map2 = arr3[1];
        
        int[] tagArr = new int[numCourses];
        int[] result = new int[numCourses];
        int p = 0;
        int p2 = -1;
        while (p != p2)
        {
            p2 = p;
            for (int i = 0; i < numCourses; i++)
                if (tagArr[i] == 0)
                {
                    if (map1.getOrDefault(i, 0) == 0)       // 入度0
                    {
                        tagArr[i] = 1;
                        result[p++] = i;
                        if (map2.containsKey(i))
                            for (int i2 : map2.get(i))
                                map1.put(i2, map1.get(i2) - 1);
                    }
                }
        }
        return p == numCourses ? result : new int[0];
    }
    
    private Map[] convertb2(int[][] arr2)
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        List<Integer> list = null;
        for (int[] arr1 : arr2)
        {
            map1.put(arr1[1], map1.getOrDefault(arr1[1], 0) + 1);
            list = map2.getOrDefault(arr1[0], new LinkedList<>());
            list.add(arr1[1]);
            map2.put(arr1[0], list);
        }
        return new Map[] { map1, map2 };
    }
    
    // 入度
    private Map<Integer, Integer> convertb1(int[][] arr2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr1 : arr2)
            map.put(arr1[1], map.getOrDefault(arr1[1], 0) + 1);
        return map;
    }
    
    // 昨天看过，今早也看过，但是就是忘了，幸好最终想起了我们的英雄---拓扑排序。。。
    @Deprecated
    private int[] Lt0210a(int numCourses, int[][] prerequisites)
    {
        int[] result = new int[numCourses];
        result[numCourses - 1] = -1;
        Map<Integer, List<Integer>> map = this.converta1(prerequisites);
        int[] tagArr = new int[numCourses];
//        for (int i : tagArr)
//            if (i == 0)
//                if (!this.recursiona1(result, 0, map, tagArr, i))
//                    break;
        for (int i = 0; i < numCourses; i++)
            if (tagArr[i] == 0)
                if (!this.recursiona1(result, i, map, tagArr, i))
                    break;
        result = result[numCourses - 1] == -1 ? new int[0] : result;
        return result;
    }
    
    private Map<Integer, List<Integer>> converta1(int[][] arr)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        for (int[] arr1 : arr)
        {
            if ((list = map.get(arr1[0])) == null)
                map.put(arr1[0], (list = new LinkedList<>()));
            list.add(arr1[1]);
        }
        return map;
    }
    
    private boolean recursiona1(int[] arr, int index, Map<Integer, List<Integer>> map, int[] arr2, int index2)
    {
        if (arr2[index2] == -1)
            return false;
        arr2[index2] = -1;
        arr[index] = index2;
        if (map.containsKey(index2))
            for (int i : map.get(index2))
                if (!recursiona1(arr, ++index, map, arr2, i))
                    return false;
        arr2[index2] = 1;
        return true;
    }
    
}
