package gt000;


/**
 * 44. Wildcard Matching
 * */
public class LT0044 {

    public static void main(String[] args) {

        String s = "aa";
        String p = "*";
        
        s = "a";
        p = "aa";
        
        s = "aa";
        p = "*";
        
        s = "zacabz";
        p = "*a?b*";
        
        s = "leetcode";
        p = "*e*t?d*";
        
//        System.out.println(Lt0044(s, p));
        System.out.println(isMatch(s, p));
    }

    
    // endless loop...
    public static boolean isMatch(String s, String p) {
        boolean result = true;
        
        if(s.equals(p))
        {
            return true;
        }

        int t = 0;
        int si = 0;
        int pi = 0;
        int sLen = s.length();
        int pLen = p.length();
        
        char[] sCh = s.toCharArray();
        char[] pCh = p.toCharArray();
        
        char sc = 0;
        char pc = 0;
        
        if(pLen == 0 || sLen == 0)
        {
            return false;
        }
        
        int i = 0;
        t = 0;
        if(pLen > sLen)
        {
            if(!p.contains("*"))
            {
                return false;
            }
            else
            {
                for(i = 0; i < pLen; i++)
                {
                    if(pCh[i] == '*')
                    {
                        t++;
                    }
                }
                if((pLen - t) > sLen)
                {
                    return false;
                }
            }
        }
        

        while(si < sLen)
        {
            if(pi >= pLen)
            {
                return false;
            }
            sc = sCh[si];
            pc = pCh[pi];
            
            if(pc == '*')
            {
//                if(si < sLen && )
                t = si;
                while(t < sLen)
                {
                    t++;
                    result = isMatch(new String(sCh, t, sLen - t), new String(pCh, pi + 1, pLen - pi - 1));
//                    result = isMatch();
                    if(result)
                    {
                        return true;
                    }
                }
            }
            else if(pc == '?' || pc == sc)
            {
                pi++;
                si++;
            }
            else
            {
                return false;
            }
                
        }
        
        
        
        
        return result;
    }
    
    @Deprecated
    public static boolean Lt0044a(String s, String p)
    {

        boolean result = true;
        
        if(s.equals(p))
        {
            return true;
        }
        
        int t = 0;
        int si = 0;
        int pi = 0;
        int sLen = s.length();
        int pLen = p.length();
        
        char[] sCh = s.toCharArray();
        char[] pCh = p.toCharArray();
        
        char sc = 0;
        char pc = 0;
        
        if(pLen > sLen && !p.contains("*"))
        {
            return false;
        }
        
        while(si < sLen)
        {
            if(pi >= pLen)
            {
                return false;
            }
            sc = sCh[si];
            pc = pCh[pi];
            
            if(pc == '*')
            {
                
            }
            else if(pc == '?' || pc == sc)
            {
                pi++;
                si++;
            }
            else
            {
                return false;
            }
                
        }
        
        
        
        return result;
    }
    
    
    // failed
    public static boolean Lt0044(String s, String p)
    {
        boolean result = true;
        
        if(s.equals(p))
        {
            return true;
        }
        
        int t = 0;
        int si = 0;
        int pi = 0;
        int sLen = s.length();
        int pLen = p.length();
        
        char[] sCh = s.toCharArray();
        char[] pCh = p.toCharArray();
        
        char sc = 0;
        char pc = 0;
        
        if(pLen > sLen && !p.contains("*"))
        {
            return false;
        }
        
        
        
        while(si < sLen)
        {
            if(pi >= pLen)
            {
                return false;
            }
            sc = sCh[si];
            pc = pCh[pi];
            
            
//            System.out.println(sc + ", " + pc);
            
            
            if(pc == '*')
            {
                si++;
            }
            else if(pc == '?' || sc == pc)
            {
                si++;
                pi++;
            }
            
//            else if(sc == pc)
//            {
//                si++;
//                pi++;
//            }
            else
            {
//                result = false;
//                break;
                return false;
            }
            
        }
        
        
//        System.out.println(pi);
        
//        if(pi < pLen)
//        {
//            t = pi;
//            si = sLen - 1;
//            pi = pLen - 1;
//            
//            while(si >= 0)
//            {
//                if(pi < 0)
//                {
//                    return false;
//                }
//                if(pi == '*')
//                {
//                    
//                }
//            }
//        }
        
        
        
        
        
        return result;
    }
}
