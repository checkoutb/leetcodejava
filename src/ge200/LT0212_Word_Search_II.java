package ge200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LT0212_Word_Search_II
{

    public static void main(String[] args)
    {
        String[] words = {
                "oath",
                "pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
              };
        
        System.out.println(new LT0212_Word_Search_II().Lt0212a(board, words));
    }

    
    // 700ms,,,most are [14, 57]ms...
    // 靠前的基本都是char[][] 转成 Trie....
    // 不知道行不行：2个set，一个保存确定可行，一个保存确定不可行，然后每个words，都会先，判断 确定可行.startsWith(word),word.startsWith(确定不可行)
    //                  用Map<Character, Set<String>> 做一个筛选应该会更快。
    //                  看了几个其他人的代码，暂时没有看见这种。。
    private List<String> Lt0212a(char[][] board, String[] words)
    {
//        List<String> result = new LinkedList<>();
        Set<String> result = new HashSet<>();

        for (String s : words)
            if (this.recursiona1(board, s.toCharArray(), 0, 0, 0))
                result.add(s);
        
        return new ArrayList<>(result);
    }
    
    private boolean recursiona1(char[][] arr2, char[] arr, int index, int ii, int jj)
    {
        if (index == arr.length)
            return true;

        if (index == 0)
        {
            for (int i = 0; i < arr2.length; i++)
                for (int j = 0; j < arr2[0].length; j++)
                    if (arr2[i][j] == arr[index])
                    {
                        arr2[i][j] = '0';
                        if (recursiona1(arr2, arr, index + 1, i + 1, j))
                        {
                            arr2[i][j] = arr[index];
                            return true;
                        }
                        if (recursiona1(arr2, arr, index + 1, i - 1, j))
                        {
                            arr2[i][j] = arr[index];
                            return true;
                        }
                        if (recursiona1(arr2, arr, index + 1, i, j + 1))
                        {
                            arr2[i][j] = arr[index];
                            return true;
                        }
                        if (recursiona1(arr2, arr, index + 1, i, j - 1))
                        {
                            arr2[i][j] = arr[index];
                            return true;
                        }
                        arr2[i][j] = arr[index];
                    }
            return false;
        }
        else
        {
            if (ii < 0 || ii >= arr2.length || jj < 0 || jj >= arr2[0].length || arr2[ii][jj] != arr[index])
                return false;
            arr2[ii][jj] = '1';
            if (this.recursiona1(arr2, arr, index + 1, ii, jj - 1))
            {
                arr2[ii][jj] = arr[index];
                return true;
            }
            if (this.recursiona1(arr2, arr, index + 1, ii, jj + 1))
            {
                arr2[ii][jj] = arr[index];
                return true;
            }
            if (this.recursiona1(arr2, arr, index + 1, ii + 1, jj))
            {
                arr2[ii][jj] = arr[index];
                return true;
            }
            if (this.recursiona1(arr2, arr, index + 1, ii - 1, jj))
            {
                arr2[ii][jj] = arr[index];
                return true;
            }
            arr2[ii][jj] = arr[index];
            return false;
        }
    }
}
