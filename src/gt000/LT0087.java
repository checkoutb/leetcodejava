package gt000;


/**
 * 87. Scramble String
 * */
public class LT0087
{

    public static void main(String[] args)
    {
        String s1 = "great";
        String s2 = "rgtae";
        
        s1 = "xstjzkfpkggnhjzkpfjoguxvkbuopi";
        s2 = "xbouipkvxugojdpkzjhnggkpfkzjts";
        
//        s1 = "abb";
//        s2 = "bab";
        
        s1 = "abcd";
        s2 = "bdac";
        
        s1 = "abc";
        s2 = "bca";
        
        s1 = "abcdefghij";
        s2 = "efghijcadb";
        
        s1 = "abcdd";
        s2 = "dbdac";
        
        System.out.println(Lt0087a(s1, s2));
        
//        System.out.println((int) 'a');      // 97
    }

    // 9ms, beats 35.7%
    // 正序遍历，反序遍历，分割，两部分都是true才是true。
    public static boolean Lt0087a(String s1, String s2)
    {
        boolean result = false;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] numOfChar = new int[26][2];
        int charSize = numOfChar.length;
        int i = 0;
        int j = 0;
        int len = s1.length();
        boolean flag = true;
        
        for(i = 0; i < len; i++)
        {
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[i] - 97][1]++;
            if(flag && chs1[i] != chs2[len - i - 1])
            {
                flag = false;
            }
        }
        if(flag)
        {
            return flag;
        }
        
        for(i = 0; i < charSize; i++)
        {
            if(numOfChar[i][0] != numOfChar[i][1])
            {
                return false;
            }
        }
        
        for(i = 0; i < charSize; i++)
        {
            numOfChar[i][0] = 0;
            numOfChar[i][1] = 0;
        }
        
        for(i = 0; i < len - 1; i++)
        {
            flag = true;
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[i] - 97][1]++;
            for(j = 0; j < charSize; j++)
            {
                if(numOfChar[j][0] != numOfChar[j][1])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                result = Recursion2(s1.substring(0, i + 1), s2.substring(0, i + 1));
                if(!result)
                {
                    continue;
                }
                result = Recursion2(s1.substring(i + 1), s2.substring(i + 1));
                if(result)
                {
                    return true;
                }
            }
        }
        

        for(i = 0; i < charSize; i++)
        {
            numOfChar[i][0] = 0;
            numOfChar[i][1] = 0;
        }
        
        // 反序
        for(i = 0; i < len - 1; i++)
        {
            flag = true;
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[len - i - 1] - 97][1]++;
            for(j = 0; j < charSize; j++)
            {
                if(numOfChar[j][0] != numOfChar[j][1])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                result = Recursion2(s1.substring(0, i + 1), s2.substring(len - i - 1));
                if(!result)
                {
                    continue;
                }
                result = Recursion2(s1.substring(i + 1), s2.substring(0, len - i - 1));
                if(result)
                {
                    return true;
                }
            }
        }
        
        return result;
    }
    
    public static boolean Recursion2(String s1, String s2)
    {
        
//        System.out.println(s1 + ":" + s2);
        
        boolean result = false;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] numOfChar = new int[26][2];
        int charSize = numOfChar.length;
        int i = 0;
        int j = 0;
        int len = s1.length();
        boolean flag = true;
        
        for(i = 0; i < len; i++)
        {
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[i] - 97][1]++;
            if(flag && chs1[i] != chs2[len - i - 1])
            {
                flag = false;
            }
        }
        if(flag)
        {
            return flag;
        }
        
        for(i = 0; i < charSize; i++)
        {
            if(numOfChar[i][0] != numOfChar[i][1])
            {
                return false;
            }
        }
        
        for(i = 0; i < charSize; i++)
        {
            numOfChar[i][0] = 0;
            numOfChar[i][1] = 0;
        }
        
        for(i = 0; i < len - 1; i++)
        {
            flag = true;
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[i] - 97][1]++;
            for(j = 0; j < charSize; j++)
            {
                if(numOfChar[j][0] != numOfChar[j][1])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                result = Recursion2(s1.substring(0, i + 1), s2.substring(0, i + 1));
                if(!result)
                {
                    continue;
                }
                result = Recursion2(s1.substring(i + 1), s2.substring(i + 1));
                if(result)
                {
                    return true;
                }
            }
        }
        
        for(i = 0; i < charSize; i++)
        {
            numOfChar[i][0] = 0;
            numOfChar[i][1] = 0;
        }
        
        // 反序
        for(i = 0; i < len - 1; i++)
        {
            flag = true;
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[len - i - 1] - 97][1]++;
            for(j = 0; j < charSize; j++)
            {
                if(numOfChar[j][0] != numOfChar[j][1])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                result = Recursion2(s1.substring(0, i + 1), s2.substring(len - i - 1));
                if(!result)
                {
                    continue;
                }
                result = Recursion2(s1.substring(i + 1), s2.substring(0, len - i - 1));
                if(result)
                {
                    return true;
                }
            }
        }
        
//        System.out.println(result);
        return result;
    }
    
    
    
    // ... 竟然不是按照  s1.length()/2 划分的，是随机划分的。
    // "abb" "bab" 这要返回 true。
    // 这样的话，划分就得看前n个字母的集合是否相同，相同就划分，n从1-length。
    // 写了上面的，才发现划分是i + 1...
    @Deprecated
    public static boolean Lt0087(String s1, String s2)
    {
        boolean result = false;
        
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] numOfChar = new int[26][2];     // Uppoer or Lower?
        int i = 0;
        int len = s1.length();
        
        boolean flag = true;
        for(i = 0; i < len; i++)
        {
            if(chs1[i] != chs2[len - i - 1])
            {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            return true;
        }
        
        for(i = 0; i < len; i++)
        {
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[i] - 97][1]++;
        }
        for(i = 0; i < 26; i++)
        {
            if(numOfChar[i][0] != numOfChar[i][1])
            {
                return result;
            }
        }
        
        result = Recursion(s1.substring(0, len / 2), s2.substring(0, len / 2));
        if(!result)
        {
            return result;
        }
        result = Recursion(s1.substring(len / 2), s2.substring(len / 2));
        
        return result;
    }
    
    public static boolean Recursion(String s1, String s2)
    {
        boolean result = false;
        int len = s1.length();
        
//        System.out.println(len);
//        System.out.println(s1 + ", " + s2);
        
        if(len <= 1)
        {
            if(s1.equals(s2))
                return true;
            return false;
        }
        
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] numOfChar = new int[26][2];     // Uppoer or Lower?
        int i = 0;
        boolean flag = true;
        for(i = 0; i < len; i++)
        {
            if(chs1[i] != chs2[len - i - 1])
            {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            return true;
        }
        
        for(i = 0; i < len; i++)
        {
            numOfChar[chs1[i] - 97][0]++;
            numOfChar[chs2[i] - 97][1]++;
        }
        for(i = 0; i < 26; i++)
        {
            if(numOfChar[i][0] != numOfChar[i][1])
            {
                return result;
            }
        }
        
        result = Recursion(s1.substring(0, len / 2), s2.substring(0, len / 2));
        if(!result)
        {
            return result;
        }
        result = Recursion(s1.substring(len / 2), s2.substring(len / 2));
        
        return result;
    
    }
}
