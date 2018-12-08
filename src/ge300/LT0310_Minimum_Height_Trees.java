package ge300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

public class LT0310_Minimum_Height_Trees
{

    public static void main(String[] args)
    {
//        int[][] arr2 = { { 0, 0, 0, 0 }, { 1, 0, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
//        int[][] arr2 = {{1, 0}, {1, 2}, {1, 3}};
//        int n = 4;
//        int[][] arr2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
//        int n = 6;
        
        int n = 3;
        int[][] arr2 = { { 0, 1 }, { 0, 2 } };            // 1

        LTUtils.showArrayOfArrayOneRowOneLine(arr2);
        System.out.println(new LT0310_Minimum_Height_Trees().Lt0310d(n, arr2));
    }

    
    // discuss: 关于无向图求最长路径的方法，任选一个节点Q，dfs到终点W停止，则W为Q为起点的最长路径，必为图最长路径的一个端点，再以此端点dfs找到另一个端点.
    // 600ms.......most are [12, 65]ms.
    
    // 13ms:
    //      2个辅助数组，第一个图的稀疏矩阵表示法(无向～=双向)，第二个下标所代表的顶点的度。
    //          List<Integer>[] edgeList = new ArrayList[n];
    //          int[] incoming = new int[n];
    //      保存度为1的结点。。。拓扑排序。。。
    //          Queue<Integer> q = new LinkedList<>();
    /*  
    while(!q.isEmpty()){
        int count = q.size();
        res = new ArrayList<>();
        
        for(int i = 0; i < count; i++){
            int node = q.poll();
            res.add(node);
            for(int next: edgeList[node]){
                incoming[next]--;
                if(incoming[next] == 1)
                    q.add(next);
            }
        }
    }
    return res;
    */
    // 最长路径的两端的度必然为1。。
    // 最长路径，所以做拓扑排序能活到最后。
    // 对每条无环路径来说，两端的度都是1,每次拓扑就是把两个端点删除。等于每次拓扑都是，路径长度-2.只有最长的才能活到最后。
    // 每次都是两端各减少一个顶点，所以活到最后的就是路径最中间的点。
    
    private List<Integer> Lt0310d(int n, int[][] edges)
    {
        
        List<Integer> ansList = new ArrayList<>(2);
        if (edges.length == 0)
        {
            ansList.add(0);
            return ansList;
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> llist = new ArrayList<>();
        llist.add(Collections.emptyList());
        
        this.recursiond1(edges, list, 1, edges[0][0], llist);
        int val = llist.get(0).get(llist.get(0).size() - 1);
        list.clear();
        this.recursiond1(edges, list, 1, val, llist);
        
        list = llist.get(0);
        if (list.size() % 2 == 1)
        {
            ansList.add(list.get(list.size() / 2));
        }
        else
        {
            ansList.add(list.get(list.size() / 2 - 1));
            ansList.add(list.get(list.size() / 2));
        }
        return ansList;
    }
    
    private void recursiond1(int[][] arr1, List<Integer> list, int depth, int p, List<List<Integer>> llist)
    {
        int t1, t2, t3;
        boolean flag = true;
        list.add(p);
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i][0] < 0)
                continue;
            if (arr1[i][0] == p)
            {
                flag = false;
                t1 = arr1[i][0];
                t2 = arr1[i][1];
                t3 = arr1[i][1];
                arr1[i][0] = -1;
                arr1[i][1] = -1;
                this.recursiond1(arr1, list, depth + 1, t3, llist);
                list.remove(list.size() - 1);
                arr1[i][0] = t1;
                arr1[i][1] = t2;
            }
            if (arr1[i][1] == p)
            {
                flag = false;
                t1 = arr1[i][0];
                t2 = arr1[i][1];
                t3 = arr1[i][0];
                arr1[i][0] = -2;
                arr1[i][1] = -2;
                this.recursiond1(arr1, list, depth + 1, t3, llist);
                list.remove(list.size() - 1);
                arr1[i][0] = t1;
                arr1[i][1] = t2;
            }
        }
        if (flag)
        {
            if (depth > llist.get(0).size())            // list.size > llist.get(0).size ...
            {
                List<Integer> list2 = new ArrayList<>(list);
                llist.set(0, list2);
            }
        }
    }
    
    @Deprecated
    private List<Integer> Lt0310c(int n, int[][] edges)
    {
        List<Integer> list = new ArrayList<>(2);
        if (edges == null || edges.length == 0)
        {
            list.add(0);
            return list;
        }
        
        int i, j, k, t1, t2, t3, ti, tj, ts;
        ts = 0;
        int len = edges.length;
        for (i = 0; i < edges.length; i++)
        {
            if (edges[i][0] > edges[i][1])
            {
                t1 = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = t1;
            }
        }
        
        int[] arr2 = new int[n];
        int[] arr3 = new int[len];
        
        for (i = 0; i < len; i++)
        {
            arr2[edges[i][1]] = Math.max(arr2[edges[i][1]], arr2[edges[i][0]] + 1);
            arr3[i] = arr2[edges[i][1]];
            if (arr3[i] > ts)
            {
                ts = arr3[i];
                ti = i;
            }
        }
        
        for (i = 0; i < len; i++)
        {
            
        }
        
        return list;
    }
    
    
    @Deprecated
    private List<Integer> Lt0310b(int n, int[][] edges)
    {
        
        List<Integer> list = new LinkedList<>();
        if (edges == null || edges.length == 0)
        {
            list.add(0);
            return list;
        }
        int t1 = 0;
        boolean flag = true;
        for (int i = 0; i < edges.length; i++)
        {
            if (edges[i][0] > edges[i][1])
            {
                t1 = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = t1;
            }
        }
        
        for (int i = 0; i < edges.length; i++)
        {
            flag = false;
            for (int j = 0; j < edges.length - 1 - i; j++)
            {
                if (edges[j][0] > edges[j + 1][0])
                {
                    flag = true;
                    t1 = edges[j + 1][0];
                    edges[j + 1][0] = edges[j][0];
                    edges[j][0] = t1;
                    t1 = edges[j + 1][1];
                    edges[j + 1][1] = edges[j][1];
                    edges[j][1] = t1;
                }
            }
            if (!flag)
            {
                break;
            }
        }
        
        int[] arr2 = new int[n];
        int[] arr3 = new int[edges.length];
        
        int ti = 0;
        int tj = 0;
        int ts = 0;
        
        for (int i = 0; i < edges.length; i++)
        {
            arr2[edges[i][1]] = Math.max(arr2[edges[i][1]], arr2[edges[i][0]] + 1);
            arr3[i] = arr2[edges[i][1]];
            if (arr2[edges[i][1]] > ts)
            {
                ts = arr2[edges[i][1]];
                ti = i;
            }
        }
        
//        int t2 = 0;
//        int i1 = 0;
//        int i2 = 0;
//        for (int j = 0; j < arr3.length; j++)
//        {
//            int i = j;
//            while (i + 1 < arr3.length && edges[i][0] == edges[i + 1][0])
//            {
//                i++;
//            }
//            t1 = 0;
//            t2 = 0;
//            while (j < i)
//            {
////                if ()
//                j++;
//            }
//        }
        
        boolean f2 = ts % 2 == 0; 
        t1 = (ts + 1) / 2;
        int j = edges.length - 1;
        int lastj = 0;
        for (int i = 0; i < t1; i++)
        {
            lastj = j;
            ts--;
            while (j >= 0)
            {
                if (arr3[j] == ts)
                {
                    break;
                }
                j--;
            }
        }
        list.add(edges[lastj][0]);
        if (!f2)
            list.add(edges[lastj][1]);
        
        return list;
        
    }
    
    
    // 多叉树，找到最长的路径，然后这条路径的中间点就是结果？
    @Deprecated         // 输入是稀疏图的写法。
    private List<Integer> Lt0310a(int n, int[][] edges)
    {
        
        List<Integer> list = new LinkedList<>();
        int rowMax = edges.length - 1;
        int colMax = edges[0].length - 1;
        
        int i = 0;
        int j = 0;
        for (; i <= rowMax; i++)
        {
            for (j = 0; j < i; j++)
            {
                if (edges[i][j] != 0)
                {
                    edges[j][i] = edges[i][j];
                    edges[i][j] = 0;
                }
            }
        }
        
        int[] arr1 = new int[rowMax + 1];
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        i = 0;
        for (; i <= rowMax; i++)
        {
            for (j = i + 1; j <= colMax; j++)
            {
                if (edges[i][j] != 0)
                {
                    arr1[j] = Math.max(arr1[i] + 1, arr1[j]);
                    edges[i][j] = arr1[j];
                    if (arr1[j] > t3)
                    {
                        t1 = i;
                        t2 = j;
                        t3 = arr1[j];
                    }
                }
            }
        }
        j = t3;
        i = t3 / 2;
        while (j >= i)
        {
            j--;
            for (int k = 0; k < t1; k++)
            {
                if (edges[k][t1] == j)
                {
                    t2 = t1;
                    t1 = k;
                    break;
                }
            }
        }
        list.add(t2);
        return list;
        
    }
    
}
