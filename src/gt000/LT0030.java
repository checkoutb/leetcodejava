package gt000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.LTUtils;

/**
 * Substring with Concatenation of All Words
 * */
public class LT0030 {

    public static void main(String[] args)
    {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        
        s = "barfoofoobarthefoobarman";
        words = new String[]{"bar","foo","the"};
        
        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word","good","best","good"};      //... good == good...
        
        s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        words = new String[]{"fooo","barr","wing","ding","wing"};
        
        long time = System.nanoTime(); 
        List<Integer> result = Lt0030(s, words);
        System.out.println(System.nanoTime() - time);
        LTUtils.showList(result);
    }
    
    public static List<Integer> Lt0030(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        
        int NOT = -1024;
        int i = 0;
        int j = 0;
        int m = 0;
        int k = 0;
        int i1 = 0;
        
//        Set<String> wordsSet = new HashSet<>();
//        Set<String> sameSet = new HashSet<>();
        Map<String, Integer> strIntMap = new HashMap<>();
        for(i = 0; i < words.length; i++)
        {
            if(strIntMap.containsKey(words[i]))
            {
//                sameSet.add(words[i]);
            }
            else
            {
//                wordsSet.add(words[i]);
                strIntMap.put(words[i], i);
            }
        }
        
//        words = new String[wordsSet.size()];
//        i = 0;
//        for(String str : wordsSet)
//        {
//            words[i] = str;
//            i++;
//        }
//        
//        LTUtils.showArray(words);
        
        int sLength = s.length();
        int wordsLength = words[0].length();
        
        char[] charStr = s.toCharArray();
        char[] charWord = null;
        
        int[][] wordsIndex = new int[words.length][sLength / wordsLength + 1];
        
        for(i = 0; i < wordsIndex.length; i++)
        {
            for(j = 0; j < wordsIndex[0].length; j++)
            {
                wordsIndex[i][j] = NOT;
            }
        }
        
        for(i = 0; i < words.length; i++)
        {
            i1 = 0;
            charWord = words[i].toCharArray();
            for(j = 0, k = sLength - wordsLength + 1; j < k; j++)
            {
                if(charStr[j] == charWord[0])
                {
                    j++;
                    for(m = 1; m < wordsLength; m++)
                    {
                        if(charStr[j] != charWord[m])
                        {
                            break;
                        }
                        j++;
                    }
                    if(m == wordsLength)
                    {
                        wordsIndex[i][i1] = j - wordsLength;
                        j--;                                    //...barfoofoobarthefoobarman,foo
                        i1++;
                    }
                }
            }
        }
        
        LTUtils.showArrayOfArray(wordsIndex);
        
        int[] wordInStr = new int[wordsIndex[0].length];
        for(i = 0; i < wordInStr.length; i++)
        {
            wordInStr[i] = NOT;
        }
        
        for(i = 0; i < wordsIndex.length; i++)
        {
            for(j = 0; j < wordsIndex[0].length; j++)
            {
                if(wordsIndex[i][j] == NOT)
                {
                    break;
                }
                else
                {
                    wordInStr[wordsIndex[i][j] / wordsLength] = strIntMap.get(words[i]);
                }
            }
        }
        
        LTUtils.showArray(wordInStr);
        
//        int sum = (0 + words.length - 1) * words.length / 2;
        int sum = 0;
//        for(Integer value : strIntMap.values())
//        {
//            sum += value;
//        }
        
        for(i = 0; i < words.length; i++)
        {
            sum += strIntMap.get(words[i]);
        }
        
        System.out.println("sum : " + sum);
        
        m = 0;
        for(i = 0, k = wordInStr.length - words.length + 1; i < k; i++)
        {
            if(wordInStr[i] != NOT)
            {
                i1 = i;
                for(j = i; j < i + words.length; j++)
//                for(j = i + words.length; i < j && i < k; i++)
                {
                    m += wordInStr[j];
                }
                
                if(sum == m)
                {
                    result.add(i1 * words[0].length());
                }
                m = 0;
            }
        }
        
        return result;
    }
}


/*

s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].



Input: "wordgoodgoodgoodbestword"
["word","good","best","good"]
Output: [12]
Expected: [8]






*/
