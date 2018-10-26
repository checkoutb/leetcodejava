package ge100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 139. Word Break
 * */
public class LT0139
{

    public static void main(String[] args)
    {
        Map<String, List<String>> map = new HashMap<>();
        
//        map.put("leetcode", Arrays.asList("leet", "code"));
//        map.put("applepenapple", Arrays.asList("apple", "pen"));
//        map.put("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        
//        map.put("bb", Arrays.asList("a", "b", "bbb", "bbbb"));
        
//        map.put("ccaccc", Arrays.asList("cc", "ac", "c"));
        
        map.put("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"));
        
        LT0139 lt = new LT0139();
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            System.out.println(lt.Lt0139b(entry.getKey(), entry.getValue()));
        }
        
        
//        String s33 = "aabbaabbababa";
//        String[] arr33 = s33.split("a");
//        System.out.println(Arrays.toString(arr33));
        
        String s11 = "bb";
        String[] arr11 = s11.split("b");
        System.out.println(Arrays.toString(arr11));         // size == 0.
        
        String s22 = "ccaccc";
        String[] arr22 = s22.split("cc");
        System.out.println(Arrays.toString(arr22));     // [, a, c]
        
    }
    
    
    
    
    // gg, 百度了。。分割s，，，看是否在wordDict中，，一个辅助数组。。动态规划。。。
    @Deprecated
    private boolean Lt0139b(String s, List<String> wordDict)
    {
        wordDict = this.pretreatmentb8(wordDict);
        boolean[][] arr3 = this.pretreatmentb3(s, wordDict);
        
        String word = null;
        for (int i = 0; i < wordDict.size(); i++)
        {
            word = wordDict.get(i);
            if (s.startsWith(word))
            {
                if (recursionb1(s, word.length(), wordDict, i, arr3))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private List<String> pretreatmentb8(List<String> wordDict)
    {
        wordDict.sort((v1, v2) -> v1.length() == v2.length() ? 0 : v1.length() > v2.length() ? -1 : 1);
        List<String> result = new ArrayList<>();
        int size = wordDict.size();
        String word = null;
        String word2 = null;
        String[] arr12 = null;
        boolean allEmpty = true;
        AAA:
        for (int i = 0; i < size; i++)
        {
            word = wordDict.get(i);
            for (int j = size - 1; j > i; j--)
            {
                word2 = wordDict.get(j);
                arr12 = word.split(word2);
                if (arr12.length == 0)
                {
                    continue AAA;
                }
                allEmpty = true;
                for (String str : arr12)
                {
                    allEmpty &= (str.length() == 0);
                }
                if (allEmpty)
                {
                    continue AAA;
                }
            }
            result.add(word);
        }
        
        return result;
    }
    
    private boolean recursionb1(String s, int index, List<String> wordDict, int index2, boolean[][] arr3)
    {
        if (index >= s.length())
        {
            return true;
        }
        String word = null;
        for (int j = 0; j < arr3.length; j++)
        {
            if (arr3[index2][j])
            {
                word = wordDict.get(j);
                if (s.startsWith(word, index))
                {
                    if (recursionb1(s, index + word.length(), wordDict, j, arr3))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    /* 29/36
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    */
    // ...29/36...timeout...确实29/36返回的是一个绝大部分为true的数组。怎么缩短s。好像不行，得是所有word的长度的最小公倍数才能缩小吧。不如缩word
    private boolean[][] pretreatmentb3(String s, List<String> wordDict)
    {
        int size = wordDict.size();
        boolean[][] result = new boolean[size][size];
        
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (s.indexOf(wordDict.get(i).concat(wordDict.get(j))) != -1)
                {
                    result[i][j] = true;
                }
            }
        }
        return result;
    }
    
    // timeout...29/36
    @Deprecated
    private boolean[][] pretreatmentb2(String s, List<String> wordDict)
    {
        int size = wordDict.size();
        boolean[][] result = new boolean[size][size];
        int i = 0;
        int j = 0;
        String word = null;
        int index = -1;
        String word2 = null;
        boolean all = false;
        for (i = 0; i < size; i++)
        {
            index = 0;
            word = wordDict.get(i);
            
            // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" , "a" .....timeout.....
            AAA:
            while((index = s.indexOf(word, index)) != -1)
            {
                index += word.length();
                for (j = 0; j < size; j++)
                {
                    word2 = wordDict.get(j);
                    if (s.startsWith(word2, index))
                    {
                        result[i][j] = true;
                        all = true;
                        for (int k = 0; k < size; k++)
                        {
                            all &= result[i][k];
                        }
                        if (all)
                        {
                            break AAA;
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    // ccaccc
    @Deprecated
    private boolean[][] pretreatmentb1(String s, List<String> wordDict)
    {
        int size = wordDict.size();
        boolean[][] result = new boolean[size][size];
        int i = 0;
        int j = 0;
        String word = null;
        String[] partArr = null;
        String str = null;
        String word2 = null;
        for (i = 0; i < size; i++)
        {
            word = wordDict.get(i);
            partArr = s.split(word);
//            for (String str : partArr)      // partArr[0]...
            if (partArr.length == 0 && s.length() > word.length())
            {
                result[i][i] = true;
            }
            for (int k = 1; k < partArr.length; k++)
            {
                str = partArr[k];
                if (str.length() == 0)
                {
                    result[i][i] = true;
                    continue;
                }
                for (j = 0; j < size; j++)
                {
                    word2 = wordDict.get(j);
                    if (str.startsWith(word2))
                    {
                        result[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
    
    // 32/36 timeout
    @Deprecated
    private boolean Lt0139a(String s, List<String> wordDict)
    {
        boolean result = true;

        Map<Character, List<String>> map = new HashMap<>();
        Set<Character> dictSet = new HashSet<>();
        
        char ch = '0';
        List<String> dictTemp = null;
        for (String word : wordDict)
        {
            ch = word.charAt(0);
            if ((dictTemp = map.get(ch)) == null)
            {
                map.put(ch, dictTemp = new ArrayList<>());
            }
            dictTemp.add(word);
            for (char c : word.toCharArray())
            {
                if (!dictSet.contains(c))
                {
                    dictSet.add(c);
                }
            }
        }
        
        for (char c : s.toCharArray())
        {
            if (!dictSet.contains(c))
            {
                return false;
            }
        }
        
        for (List<String> wordList : map.values())
        {
            wordList.sort((v1, v2) -> v1.length() > v2.length() ? -1 : 1);
        }
        
        result = this.recursiona1(s, 0, map);
        
        return result;
    }
    
    private boolean recursiona1(String s, int start, Map<Character, List<String>> map)
    {
        if (start >= s.length())
        {
            return true;
        }
        List<String> wordDict = map.get(s.charAt(start));
        if (wordDict == null)
        {
            return false;
        }
        for (String word : wordDict)
        {
            if (s.startsWith(word, start))
            {
                if (this.recursiona1(s, start + word.length(), map))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
