package gt000;

import java.util.ArrayList;
import java.util.List;

/**
 * Regular Expression Matching
 * */
public class LT10 {

    public static void main(String[] args)
    {
        String s = "aa";
        String p = "a";
        
        List<String[]> strList = new ArrayList<>();
        
        strList.add(new String[]{"aa", "a"});
        strList.add(new String[]{"aa", "aa"});
        strList.add(new String[]{"aaa", "aa"});
        strList.add(new String[]{"aa", "a*"});
        strList.add(new String[]{"aa", ".*"});
        strList.add(new String[]{"ab", ".*"});
        strList.add(new String[]{"aab", "c*a*b"});
        
        
        
        
        for(String[] s2 : strList)
        {
            System.out.println(Lt10(s2[0],s2[1]));
        }
    }
    
    
    // ... failed，暂时放弃了，应该是递归的吧。
    public static boolean Lt10b(String s, String p)
    {
        boolean result = false;
        char sch;
        char pch;
        
        int pi = 0;
        // fore
        for(int i = 0; i < s.length(); i++)
        {
            sch = s.charAt(i);
            if(pi >= p.length())
            {
                return false;
            }
            for(; pi < p.length(); pi++)
            {
                pch = p.charAt(pi);
                if(sch == pch || pch == '.')
                {
                    if((pi+1) < p.length() && '*' == p.charAt(pi+1))
                    {
                        break;
                    }
                    else
                    {
                        // pch is last or the next of pch is not '*'
                        if(pch == p.length())
                        {
                            // pch is last, if sch is also last, they are matched
                            if(i == s.length()-1)
                            {
                                return true;
                            }
                            else
                            {
                                return false;
                            }
                        }
                        else
                        {
                            pi++;
                            break;
                        }
                    }
                }
                else    // ��ƥ��
                {
                    // ����
                    if((pi+1) < p.length() && '*' == p.charAt(pi+1))
                    {
                        pi++;
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        
        // back, s遍历完，但是p还有剩余。
        if(pi == p.length())
        {
            return true;
        }
        else if((pi+1) == p.length() && '*' == p.charAt(pi+1))
        {
            return true;
        }
        else
        {
            if(times == 1)  // s == "aaa" p == "aaaaaaa"
            {
                return true;
            }
        }
        
        
        return result;
    }
    
    public static int times = 0;
    
    // failed
//    '.' Matches any single character.
//    '*' Matches zero or more of the preceding element.
    public static boolean Lt10(String s, String p)
    {
        if(s.equals(p))
        {
            return true;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        
        boolean result = false;
        int psi = 0;
        int pei = 0;
        
        int pi = 0;
        char ch;
        char pch;
        
        for(int i = 0; i < sArray.length; i++)
        {
            ch = sArray[i];
//            for(int j = psi; j <= pei; j++)
//            {
//                if(pArray[j] == '.')
//                {
//                    
//                }
//                else if(pArray[j] == '*')
//            }
            
            if(pi >= pArray.length)
            {
                return false;
            }
            
            pch = pArray[pi];
            if(pch == '.')
            {
                if(pi < pArray.length-1)
                {
                    if(pArray[pi+1] == '*')
                    {
                        ;
                    }
                    else
                    {
                        pi++;
                    }
                }
                else
                {
                    // p end
                    if(i == sArray.length-1)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else if(pch == '*')     // always false;
            {
                
            }
            else        // not . not *
            {
                if(pch != ch)
                {
                    if(pi < pArray.length - 1)
                    {
                        if(pArray[pi+1] == '*')
                        {
                            pi += 2;                    //........
                            i--;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if(pi < pArray.length - 1)
                    {
                        if(pArray[pi+1] == '*')
                        {
                            
                        }
                        else
                        {
                            pi++;
                        }
                    }
                    else
                    {
                        if(i == sArray.length - 1)
                        {
                            return true;
                        }
                    }
                }
            }
            
        }

        if(pi < pArray.length - 1)
        {
            if(pi == pArray.length-2)
            {
                if(pArray[pi+1] == '*')
                {
                    return true;
                }
            }
        }
        
        
        return result;
    }
}




/*


Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "a*") �� true
isMatch("aa", ".*") �� true
isMatch("ab", ".*") �� true
isMatch("aab", "c*a*b") �� true

"aa", ".."




*/