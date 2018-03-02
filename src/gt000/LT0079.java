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
        
        for(String word : words)
        {
            System.out.println(Lt0079(board, word));
        }
        
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
