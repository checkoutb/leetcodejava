package ge100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo.Point;

public class LT0149_Max_Points_on_a_Line
{

    public static void main(String[] args)
    {
        // 相异为1.
//        System.out.println(true ^ true);        // false
//        System.out.println(false ^ true);       // T
//        System.out.println(false ^ false);      // F
        
        Point[] points = { new Point(1, 2), new Point(1, 4), new Point(2, 4), new Point(3, 6) };
        // [[0,0],[1,1],[1,-1]]
        points = new Point[] { new Point(0, 0), new Point(1, 1), new Point(1, -1) };
        
        // [[0,0],[1,1],[0,0]]
        points = new Point[] {new Point(0,0), new Point(1,1), new Point(0,0)};
        
        points = new Point[] {new Point(0,0), new Point(0,0)};
        
        // [[3,1],[12,3],[3,1],[-6,-1]]
        points = new Point[] { new Point(3, 1), new Point(12, 3), new Point(3, 1), new Point(-6, -1) };
        
        // [[0,0],[65536,65536],[65536,131072]]
        points = new Point[] { new Point(0, 0), new Point(65536, 65536), new Point(65536, 131072) };
        
        System.out.println(new LT0149_Max_Points_on_a_Line().Lt0149a(points));
        
    }

    
    // 80ms. most are [12, 33]ms
    // 相同点的处理：用变量累加，然后在计算的时候加上去。每次i循环都新建一个putMap。并且相同点个数清空。i循环结束的时候就计算至今的max。
    // putMap：只要Map<String, Integer> 保存点的个数就可以了。
    private int Lt0149a(Point[] points)
    {
        
        if (points.length <= 1)
        {
            return points.length;
        }
        int t1 = points.length;
        Map<Point, List<Point>> map2 = this.pretreatmenta2(points);
        points = map2.keySet().toArray(new Point[map2.keySet().size()]);
        
        if (points.length <= 2)
        {
            return t1;
        }
        int result = 0;
        Map<String, Set<Point>> map = this.pretreatmenta1(points, map2);
        int temp = 0;
        for (Set<Point> set : map.values())
        {
            temp = set.size();
            if (temp > result)
            {
                result = temp;
            }
        }
        return result;
    }

    private Map<Point, List<Point>> pretreatmenta2(Point[] arr)
    {
        Map<Point, List<Point>> map = new HashMap<>();
        AAA:
        for (Point p : arr)
        {
            for (Map.Entry<Point, List<Point>> entry : map.entrySet())
            {
                if (entry.getKey().x == p.x && entry.getKey().y == p.y)
                {
                    entry.getValue().add(p);
                    continue AAA;
                }
            }
            map.put(p, new ArrayList<>());
            map.get(p).add(p);
        }
        return map;
    }
    
    private Map<String, Set<Point>> pretreatmenta1(Point[] arr, Map<Point, List<Point>> map2)
    {
        int size = arr.length;
        Map<String, Set<Point>> result = new HashMap<>();
        int x = 0;
        int y = 0;
        boolean negate = false;
        int gcd = 0;
        int b = 0;
        int max = 0;
        int t1 = 0;
        for (int i = 0; i < size - max; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                x = arr[j].x - arr[i].x;
                y = arr[j].y - arr[i].y;
                if (x == 0)
                {
                    t1 = putMap(result, map2.get(arr[i]), map2.get(arr[j]), "1:0:" + arr[j].x);
                    if (t1 > max)
                    {
                        max = t1;
                    }
                }
                else if (y == 0)
                {
                    t1 = this.putMap(result, map2.get(arr[i]), map2.get(arr[j]), "0:1:" + arr[j].y);
                    if (t1 > max)
                    {
                        max = t1;
                    }
                }
                else
                {
                    negate = (x < 0) ^ (y < 0);
                    x = Math.abs(x);
                    y = Math.abs(y);
                    gcd = this.gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    b = arr[i].y - (negate ? -1 : 1) * y * arr[i].x / x;
                    t1 = this.putMap(result, map2.get(arr[i]), map2.get(arr[j]), (negate ? "-" : "+") + Integer.toString(x) + ":" + y + ":" + b);
                    if (t1 > max)
                    {
                        max = t1;
                    }
                }
            }
        }
        return result;
    }
    
    private int putMap(Map<String, Set<Point>> map, List<Point> p1, List<Point> p2, String key)
    {
        Set<Point> set = null;
        if ((set = map.get(key)) == null)
        {
            map.put(key, set = new HashSet<>());
        }
        set.addAll(p1);
        set.addAll(p2);
        return set.size();
    }
    
    private int gcd(int a, int b)
    {
        if (a == b)
        {
            return a;
        }
        int mul = 1;
        while ((a % 2 == 0) && (b % 2 == 0))
        {
            a /= 2;
            b /= 2;
            mul++;
        }
        if (a < b)
        {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        int diff = a - b;
        while (diff != b)
        {
            if (b > diff)
            {
                a = b;
                b = diff;
            }
            else
            {
                a = diff;
                b = b;
            }
            diff = a - b;
        }
        for (int i = 1; i < mul; i++)
        {
            diff <<= 1;
        }
        return diff;
        
    }
    
}
