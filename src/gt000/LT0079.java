package gt000;


/**
 * 79. Word Search
 * */
public class LT0079 {

    public static void main(String[] args) {

        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        String[] words = { "ABCCED", "SEE", "ABCB" };
                // word = "ABCCED", -> returns true,
                // word = "SEE", -> returns true,
                // word = "ABCB", -> returns false.
        
//        for(String word : words)
//        {
//            System.out.println(Lt0079(board, word));
//        }
        
//        board = new char[][]{{'a'}};
//        words = new String[]{"a"};

        board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        words = new String[] { "ABCCED" };
        
        board = new char[][] {{'a', 'a'}};
        words = new String[] {"aaa"};
        
        LT0079 lt = new LT0079();
        for(String word : words)
        {
        	System.out.println(lt.Lt0079a(board, word));
        }
        
    }

    // 21ms, beats 29.1%
    public boolean Lt0079a(char[][] board, String word)
    {
    	char[] chArr = word.toCharArray();
    	int lenI = board.length;
    	int lenJ = board[0].length;
    	char ch = chArr[0];
    	char t;
    	boolean result = false;
    	
    	for(int i = 0; i < lenI; i++)
    	{
    		for(int j = 0; j < lenJ; j++)
    		{
    			if(board[i][j] == ch)
    			{
    				t = ch;
    				board[i][j] = (char) -1;
    				result = RecursionB(board, chArr, 1, i, j);
    				if(result)
    				{
    					return result;
    				}
    				board[i][j] = t;
    			}
    		}
    	}
    	return result;
    }
    
    // 擦，是上下左右搜索，不是九宫格。
    public boolean RecursionB(char[][] board, char[] chArr, int n, int i, int j)
    {
        if(n == chArr.length)
        {
            return true;
        }
        char ch = chArr[n];
        int lenI = board.length;
        int lenJ = board[0].length;
        char t;
        
        lenI = i == (lenI - 1) ? i : i + 1;
        lenJ = j == (lenJ - 1) ? j : j + 1;
        int j2 = j > 0 ? j - 1 : 0;
        int i2 = i > 0 ? i - 1 : 0;
        int j3 = j;
        int i3 = i;
        
        for(i3 = i2; i3 <= lenI; i3++)
        {
            if(board[i3][j] == ch)
            {
                t = ch;
                board[i3][j] = (char) -1;
                if (RecursionB(board, chArr, n + 1, i3, j))
                {
                    return true;
                }
                board[i3][j] = t;
            }
        }
        
        for(j3 = j2; j3 <= lenJ; j3++)
        {
            if(board[i][j3] == ch)
            {
                t = ch;
                board[i][j3] = (char) -1;
                if (RecursionB(board, chArr, n + 1, i, j3))
                {
                    return true;
                }
                board[i][j3] = t;
            }
        }
        return false;
    }
    
    public boolean RecursionA(char[][] board, char[] chArr, int n, int i, int j)
    {
    	if(n == chArr.length)
    	{
    		return true;
    	}
    	char ch = chArr[n];
    	int lenI = board.length;
    	int lenJ = board[0].length;
    	char t;
    	
    	lenI = i == (lenI - 1) ? i : i + 1;
    	lenJ = j == (lenJ - 1) ? j : j + 1;
    	int j2 = j = j > 0 ? j - 1 : 0;
    	
    	for(i = i > 0 ? i - 1 : 0; i <= lenI; i++)
    	{
    		j = j2;
    		for(; j <= lenJ; j++)
    		{
    			if(board[i][j] == ch)
    			{
    				t = ch;
    				board[i][j] = (char) -1;
    				if(RecursionA(board, chArr, n + 1, i, j))
    				{
    					return true;
    				}
    				
    				board[i][j] = t;
    			}
    		}
    	}
    	return false;
    }
    
    // ... 还是要递归。
    public static boolean Lt0079(char[][] board, String word)
    {
        boolean result = false;
        
        int rowNum = board.length;
        int colNum = board[0].length;
        
        int i = 0;
        int j = 0;
        int m = 0;
        int n = 0;
        
        char[] chWord = word.toCharArray();
        
        for(i = 0; i < rowNum; i++)
        {
            for(j = 0; j < colNum; j++)
            {
                if(board[i][j] == chWord[0])
                {
                    for(m = i - 1; m >= 0 && m < i + 1 && m < rowNum; m++)
                    {
                        for(n = j - 1; n >= 0 && n < j + 1 && n < colNum; n++)
                        {
                            
                        }
                    }
                }
            }
        }
        
        
        
        
        
        return false;
    }
}
