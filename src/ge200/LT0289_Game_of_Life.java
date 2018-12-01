package ge200;

import utils.LTUtils;

public class LT0289_Game_of_Life
{

    public static void main(String[] args)
    {
        int[][] arr2 = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
              };
        
        new LT0289_Game_of_Life().Lt0289a(arr2);
        
        LTUtils.showArrayOfArrayOneRowOneLine(arr2);
    }

    
    
    // 1.  活的，少于两个活的邻居，死
    // 2.  活的，2,3个活的邻居，活
    // 3.  活的，大于3个活的邻居，死
    // 4.  死的，有3个活的邻居，活。
    // 生与死的转换是同时发生的。
    
    // 遍历？
    // 原地也简单，用2,3来代替下个状态为0,1,最后再遍历下。
    // 2,3代表原来死，下次死，活。4,5代表原来活，下次死，活。
    
    // 2ms, most are [1, 2]ms.
    // 可以只用2,3的。不需要4,5。
    private void Lt0289a(int[][] board)
    {
        int i, j;
        for (i = 0; i < board.length; i++)
        {
            for (j = 0; j < board[0].length; j++)
            {
                switch (this.NumberOfLiveNeighbours(board, i, j))
                {
                case 0:
                case 1:
                    board[i][j] = 2 + board[i][j] * 2;
                case 2:
                    break;
                case 3:
                    if (board[i][j] == 0)
                        board[i][j] = 3;
                    break;
                case 4:         // default:
                case 5:
                case 6:
                case 7:
                case 8:
                    board[i][j] = board[i][j] == 1 ? 4 : 0;
                    break;
                }
            }
        }
        for (i = 0; i < board.length; i++)
            for (j = 0; j < board[0].length; j++)
                board[i][j] = board[i][j] % 2;
    }
    
    private int NumberOfLiveNeighbours(int[][] board, int i, int j)
    {
        int ii = i > 0 ? i - 1 : 0;
        int jj = j > 0 ? j - 1 : 0;
        int jjj = jj;
        int iimax = i + 1 > board.length - 1 ? board.length - 1 : i + 1;
        int jjmax = j + 1 > board[0].length - 1 ? board[0].length - 1 : j + 1;
        int num = 0;
        for (; ii <= iimax; ii++)
        {
            for (jj = jjj; jj <= jjmax; jj++)           // jjj...
            {
                num += (board[ii][jj] < 2 ? board[ii][jj] : (board[ii][jj] <= 3 ? 0 : 1));
            }
        }
        num -= (board[i][j] % 2);           // self
        return num;
    }
    
}
