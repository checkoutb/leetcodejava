package ge200;

public class LT0223_Rectangle_Area
{

    public static void main(String[] args)
    {
        int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
        System.out.println(new LT0223_Rectangle_Area().Lt0223a(A, B, C, D, E, F, G, H));
    }

    // 3ms, most are [2, 3]ms.
    // 看到一种算重叠的方法，虽然慢：x轴4个点组成一个数组，Arrays.sort.取下标1,2的点。
    // 我这种就是，a必然小于c，e必然小于g，if中g大于a，c大于e，所以能直接Math.max min.
    private int Lt0223a(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int ans = 0;
        ans = (C - A) * (D - B) + (G - E) * (H - F) - functiona1(A,B,C,D,E,F,G,H);
        return ans;
    }
    
    private int functiona1(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int ans = 0;
        int x, y;
        if (G > A && E < C && H > B && D > F)
        {
            x = Math.min(G, C) - Math.max(A, E);
            y = Math.min(H, D) - Math.max(B, F);
            ans = x * y;
        }
        return ans;
    }
}
