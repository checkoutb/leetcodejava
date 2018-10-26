package ge100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.LTUtils;

/**
 * 115. Distinct Subsequences
 * */
public class LT0115
{

    public static void main(String[] args)
    {
        String s = "rabbbit";       // 3
        String t = "rabbit";
        s = "babgbag";      // 5
        t = "bag";
        s = "CBAZTAAABBCTA";        // 5
        t = "CAT";
        
//        s = "AABCAAAAAAAA";
//        t = "ABC";
        
        s = "b";
        t = "a";
        
        // 54/63, timeout, local's result is 700531452.
//        s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
//        t = "bcddceeeebecbc";
        System.out.println(new LT0115().Lt0115d(s, t));
    }
    
    
    // 54/63..timeout.
    @Deprecated
    private int Lt0115e(String s, String t)
    {
        int result = 0;
        
        Set<Character> chSet = null;
        
//        System.out.println(s.length());
        
        if ((chSet = this.charSetOfString(t)).size() != this.charSetOfString(s).size())
        {
            s = this.convertString(s, chSet);
        }
        
//        System.out.println(s.length());
        
        result = this.recursione1(s.toCharArray(), t.toCharArray(), 0, 0);
        
        return result;
    }
    
    private int recursione1(char[] chS, char[] chT, int sIn, int tIn)
    {
        if (tIn == chT.length)
        {
            return 1;
        }
        if (sIn >= chS.length)
        {
            return 0;
        }
        int result = 0;
        char tCh = chT[tIn];
        for (int i = sIn; i < chS.length; i++)
        {
            if (tCh == chS[i])
            {
                result += this.recursione1(chS, chT, i + 1, tIn + 1);
            }
        }
        return result;
    }
    
    private Set<Character> charSetOfString(String str) 
    {
        Set<Character> result = new HashSet<>();
        for (char ch : str.toCharArray())
        {
            result.add(ch);
        }
        return result;
    }
    
    private String convertString(String str, Set<Character> charSet)
    {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray())
        {
            if (charSet.contains(ch))
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
    private int convertChar2Inte(char ch)
    {
        return ch > 'Z' ? ch - 'a' : ch - 'A' + 26;
    }
    
    
    
    // recursiond 1 and 2 : 54/63 timeout...
    @Deprecated
    // error...error...
    private int Lt0115d(String s, String t)
    {
        int result = 0;
        
        if (s.length() < t.length())
        {
            return result;
        }
        
        Set<Character> chSet = this.charSetOfString(t);
        Set<Character> chSet2 = null;
//        if ((chSet = this.charSetOfString(t)).size() != (chSet2 = this.charSetOfString(s)).size())
//        {
            s = this.convertString(s, chSet);
//            System.out.println("s : " + s);
//        }
        chSet2 = this.charSetOfString(s);
        System.out.println("..." + chSet2 + "\n" + chSet);
        if (chSet.size() > chSet2.size())
        {
            return result;
        }
        
        char[] sChArr = s.toCharArray();
        char[] tChArr = t.toCharArray();
//        int sChNum = pretreatmentd2(sChArr);
//        int tChNum = pretreatmentd2(tChArr);
//        if (sChNum < tChNum)
//        {
//            return result;
//        }
        
        int[] convert = pretreatmentd2(tChArr);
        int chNum = chSet.size();
//        for (int i : convert)
//        {
//            if (i != 0)
//            {
//                chNum++;
//            }
//        }
        sChArr = this.pretreatmentd1(convert, sChArr);
        
        int[][] sII = this.pretreatmentd3(chNum, sChArr, convert);
        int[][] tII = this.pretreatmentd3(chNum, tChArr, convert);
        
        LTUtils.showArrayOfArrayOneRowOneLine(sII);
        LTUtils.showArrayOfArrayOneRowOneLine(tII);
        
        // recursiond1 start
//        result = recursiond1(sII, tII, 0, 0, sII[0].length, tII[0].length, convert);
        // recursiond1 end
        
        // recursiond2 start
        int[] diffArr = new int[chNum + 1];
        
        for (int k = 1; k <= chNum; k++)
        {
            diffArr[k] = sII[k][0] - tII[k][0];
        }
        result = this.recursiond2(sII, tII, 0, 0, sII[0].length, tII[0].length, diffArr, convert);
        // recursiond2 end
        
        return result;
    }
    
    private int convertChar2Int(char ch)
    {
        if (ch > 'Z')
        {
            return ch - 'a';
        }
        else
        {
            return ch - 'A' + 26;
        }
    }
    
    
    private int recursiond2(int[][] sII, int[][] tII, int sIn, int tIn, int sLen, int tLen, int[] diffArr, int[] convert)
    {
        
//        LTUtils.showArray(diffArr);
//        System.out.println(sIn);
//        System.out.println(tIn);
        
        int[] diffArr2 = new int[diffArr.length];
        System.arraycopy(diffArr, 0, diffArr2, 0, diffArr.length);
        
        if (tIn == tLen)
        {
            return 1;
        }
        if (sIn >= sLen)
        {
            return 0;
        }
        int result = 0;
        int t = tII[0][tIn];
        int val = 0;
        boolean flag = false;
        AAA:
        for (int i = sIn; i < sLen; i++)
        {
//            if (flag)
//            {
//                System.out.println(";;;");
//                break;
//            }
            val = diffArr2[convert[sII[0][i]]]--;
//            if (val <= -1)
//            {
////                flag = true;
//                System.out.println("...");
//                break;
//            }
            if (sII[0][i] == t)
            {
//                val = --diffArr[convert[t]];
////                System.out.println(val + ", " + diffArr[convert[t]]);
//                if (val < -1)
//                {
//                    System.out.println("...");            // never execute......???why???...
//                    break;
//                }
                
                // error....
                for (int j = tIn + 1; j < tLen; j++)
                {
                    if (tII[0][j] != t && diffArr2[convert[tII[0][j]]] < 0)
                    {
//                        System.out.println("...");
                        break AAA;
                    }
                }
                
                result += this.recursiond2(sII, tII, i + 1, tIn + 1, sLen, tLen, diffArr2, convert);
//                diffArr[convert[t]]++;
            }

        }
        return result;
    
    }

    private int recursiond1(int[][] sII, int[][] tII, int sIn, int tIn, int sLen, int tLen, int[] convert)
    {
        if (tIn == tLen)
        {
            return 1;
        }
        if (sIn >= sLen)
        {
            return 0;
        }
        int result = 0;
        int t = tII[0][tIn];
//        boolean can = true;
        AAA :
        for (int i = sIn; i < sLen; i++)
        {
            if (sII[0][i] == t)
            {
                for (int k = 0; k < sII.length; k++)
                {
                    if (sII[k][i] < tII[k][tIn])
                    {
//                        can = false;
                        break AAA;
                    }
                }
//                if (can)
//                {
                    result += this.recursiond1(sII, tII, i + 1, tIn + 1, sLen, tLen, convert);
//                }
//                else
//                {
//                    break;
//                }
            }
        }
        return result;
    }
    
    private int[][] pretreatmentd3(int chNum, char[] chArr, int[] convert)
    {
        int[][] result = new int[chNum + 1][chArr.length];
        int[] chNumArr = new int[chNum + 1];
        for (int i = chArr.length - 1; i >= 0; i--)
        {
            result[0][i] = convertChar2Int(chArr[i]);
            for (int j = 1; j <= chNum; j++)
            {
                result[j][i] = chNumArr[j];
            }
            chNumArr[convert[convertChar2Int(chArr[i])]]++;
        }
        return result;
    }
    
    private int[] pretreatmentd2(char[] chArr)
    {
//        int[] result = null;
        int[] chExist = new int[26 * 2];
        int size = 1;
        for (char ch : chArr)
        {
//            chExist[ch - 'a'] = 1;
            if (chExist[convertChar2Int(ch)] == 0)
            {
                chExist[convertChar2Int(ch)] = size++;
            }
        }
//        for (int i : chExist)
//        {
//            size += i;
//        }
//        result = new int[size];
        
        return chExist;
    }
    
    private char[] pretreatmentd1(int[] convert, char[] s)
    {
        char[] result = new char[s.length];
        int i = 0;
        for (char ch : s)
        {
            if (convert[convertChar2Int(ch)] != 0)
            {
                result[i++] = ch;
            }
        }
        return Arrays.copyOf(result, i);
    }
    
//    private class Helper
//    {
//        private char ch;
//        
//        private Map<Character, Integer> map;
//        
//        
//    }
    
    
    // 54/63, timeout.
    @Deprecated
    private int Lt0115c(String s, String t)
    {
        return recursion(s.toCharArray(), t.toCharArray(), 0, 0, s.length(), t.length());
    }
    
    private int recursion(char[] s, char[] t, int sStart, int tStart, int sLen, int tLen)
    {
        if (tStart == tLen)
        {
            return 1;
        }
        if (sStart > sLen - (tLen - tStart))
        {
            return 0;
        }
        int result = 0;
        char tCh = t[tStart];
        for (int i = sStart; i < sLen; i++)
        {
            if (s[i] == tCh)
            {
                result += recursion(s, t, i + 1, tStart + 1, sLen, tLen);
            }
        }
        return result;
    }
    
    @Deprecated
    private int Lt0115b(String s, String t)
    {
        int result = 0;
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen == 0 || tLen == 0)
        {
            return result;
        }
        
        char[] sChArr = s.toCharArray();
        char[] tChArr = t.toCharArray();
        
        char sCh = 0;
        char tCh = 0;
        char tCh0 = tChArr[0];
        int tIndex = 0;
        int tIndexMax = tLen - 1;
        int sIndex = 0;
        
        for (int i = 0, len = sLen - tLen; i <= len; i++)
        {
            if (sChArr[i] != tCh0)
            {
                continue;
            }
            tIndex = 1;
            sIndex = i + 1;
            while (true) {
                if (tIndex == tIndexMax)
                {
                    result++;
                    break;
                }
                else if (sIndex > (sLen - tLen + tIndex))       // sLen - sIndex < tLen - tIndex, sIndex > sLen - (tLen - tIndex)
                {
                    break;
                }
                else
                {
                    
                }
                
            }
        }
        
        
        
        
        return result;
    }
    
    
    @Deprecated
    private int Lt0115a(String s, String t)
    {
        Set<Character> tChSet = new HashSet<>();
        char[] tChArr = t.toCharArray();
        
        for (char c : tChArr)
        {
            tChSet.add(c);
        }
        
        List<Character> sChList = new ArrayList<>();
        char[] sChArr = s.toCharArray();
        
        for (char c : sChArr)
        {
            if (tChSet.contains(c))
            {
                sChList.add(c);
            }
        }
        Character[] sChArr2 = sChList.toArray(new Character[0]);
        
        
        return 0;
    }
    
    
    // error
    @Deprecated
    private int Lt0115(String s, String t)
    {
        if (s == null || t == null)
        {
            return 0;
        }
        int num = 0;
        
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        num = recursion(sCh, tCh, 0, 0);
        return num;
    }
    
    private int recursion(char[] s, char[] t, int sIndex, int tIndex)
    {
//        System.out.println(sIndex + ", " + tIndex);

        if (tIndex >= t.length)
        {
//            System.out.println("    1");
            return 1;
        }
        
        if (sIndex >= s.length)
        {
            return 0;
        }
        
        char ch = t[tIndex];
        int num = 0;
        int temp = 0;
        for (int i = sIndex; i < s.length; i++)
        {
            
//            if (ch == 'b')
//            {
//                System.out.println("b");
//            }
            
            if (ch == s[i])
            {
                int multi = 1;
//                i++;
//                int step = 1;
                int j = i + 1;
                if (tIndex + 1 < t.length && tIndex - 1 >= 0 && t[tIndex + 1] != ch && t[tIndex - 1] != ch)
                {
//                    System.out.println("........ " + (tIndex + 1) + ", " + i + ", " + ch);
                    for (; j < s.length; j++)
                    {
                        if (s[j] == ch)
                        {
                            multi++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
//                System.out.println(" ......  " + multi);
                
                temp = recursion(s, t, j, tIndex + 1);
                
//                num += temp;
//                System.out.println("           " + multi + ", " + temp);
                
                num += (temp * multi);
            }
        }
        return num;
    }
    
}
