package gt000;


/**
 * 72. Edit Distance
 * */
public class LT0072 {

    public static void main(String[] args) {

        String word1 = "adfsd";
        String word2 = "asd";
        
        word1 = "horse";
        word2 = "ros";
        
//        word1 = "ab";
//        word2 = "bc";
//        
//        word1 = "sea";
//        word2 = "eat";
        
        System.out.println(Lt0072(word1, word2));
    }

    // failed
    public static int Lt0072(String word1, String word2)
    {
        int result = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        
        int i1 = 0;
        int i2 = 0;
        int j1 = 0;
        int j2 = 0;
        int count = 0;
        int t1 = 0;
        int s11 = -1;
        int e11 = -1;
        int s12 = -1;
        int e12 = -1;
        int s21 = -1;
        int e21 = -1;
        int s22 = -1;
        int e22 = -1;
        
        while(i1 < len1 && i2 < len2)
        {
            if(ch1[i1] == ch2[i2])
            {
                if(s11 == -1)
                {
                    s11 = i1;
                    s12 = i2;
                }
                e11 = i1;
                e12 = i2;
                count++;
                i1++;
                i2++;
                continue;
            }
            else
            {
                for(j1 = i1 + 1; j1 < len1; j1++)
                {
                    if(ch1[j1] == ch2[i2])
                    {
                        break;
                    }
                }
                i1 = j1;
            }
        }
        
//        result = s11 + len1 - e11 + e11 - s11 - count + e11 - s11 + e12 - s12 - count + s12 + len2 - e12;
        
        result = len1 - count + s12 + len2 - e12 - 1;
        
        
//        result = len1 > len2 ? len1 - count : len2 - count;
        
//        System.out.println(count);
        
//        t1 = count;
        count = 0;
        i1 = 0;
        i2 = 0;
        while(i1 < len1 && i2 < len2)
        {
            if(ch1[i1] == ch2[i2])
            {
                if(s21 == -1)
                {
                    s21 = i1;
                    s22 = i2;
                }
                e21 = i1;
                e22 = i2;
                
                count++;
                i1++;
                i2++;
                continue;
            }
            else
            {
                for(j2 = i2 + 1; j2 < len2; j2++)
                {
                    if(ch1[i1] == ch2[j2])
                    {
                        break;
                    }
                }
                i2 = j2;
            }
        }
        
//        System.out.println(t1 + ", " + count);
        
        
//        if(t1 > count)
//        {
//            count = t1;
//        }
        
        t1 = result;
//        result = len1 > len2 ? len1 - count : len2 - count;
        
//        result = s11 + len1 - e11 - count + e11 - s11 + e12 - s12 - count + s12 + len2 - e12;
        
        result = len1 - count + s22 + len2 - e22 - 1;
        
        System.out.println(t1 + ", " + result);
        
        result = result > t1 ? result : t1;
        
//        System.out.println(count);
        
        return result;
    }
}
