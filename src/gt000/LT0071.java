package gt000;


/**
 * 71. Simplify Path
 * */
public class LT0071 {

    public static void main(String[] args) {
        
        String path = "/a/./b/../../c/";
        path = "///";
        path = "/./";
        
        System.out.println(Lt0071(path));
    }
    
    // gg,完全不知道unix的绝对规则是什么...29/252
    public static String Lt0071(String path)
    {
        String result = null;
        
        int len = path.length();
        
        int index1 = path.indexOf('/');
        int last1 = path.lastIndexOf('/');
        
        int index2 = path.indexOf('.');
        int last2 = path.lastIndexOf('.');
        
        if(index1 == last1)
        {
            if(last2 > index1 + 2)
                return path;
            return "/";
        }
        if(last2 +1 == last1)
        {
            return "/";
        }
        result = path.substring(0, len - 1);
        int index3 = result.lastIndexOf('/');
        result = result.substring(index3 > last2 ? index3 : last2);
        
        return result;
    }

}
