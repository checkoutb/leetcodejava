package gt000;


/**
 * 67. Add Binary
 * */
public class LT0067
{

	public static void main(String[] args)
	{
		String a = "11";
		String b = "1";
		
		System.out.println(Lt0067(a, b));
	}

	// 2ms,beats 97%
	public static String Lt0067(String a, String b)
	{
		String result = null;
		
		if(a == null || a.length() == 0)
		{
			return b;
		}
		if(b == null || b.length() == 0)
		{
			return a;
		}
		
		int aLen = a.length();
		int bLen = b.length();
		int maxLen = 0;
		int minLen = 0;
		boolean isALongest = false;
		if(aLen > bLen)
		{
			isALongest = true;
			maxLen = aLen;
			minLen = bLen;
		}
		else
		{
			maxLen = bLen;
			minLen = aLen;
		}
		char[] chArr = new char[maxLen];
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();
		int i = 0;
		int t = 0;
		final char[] convert = {'0', '1'};
		
		// 48 49 50
		t = 0;
		for(i = 1; i <= minLen; i++)
		{
			t = cha[aLen - i] + chb[bLen - i] - 96 + t;		// 0 1 2
			chArr[maxLen - i] = convert[t % 2];
			t /= 2;
		}
		
		if(isALongest)
		{
			for(i = maxLen - minLen - 1; i >= 0 && t > 0; i--)
			{
				t = cha[i] - 48 + t;
				chArr[i] = convert[t % 2];
				t /= 2;
			}
			if(i >= 0)
			{
				System.arraycopy(cha, 0, chArr, 0, i + 1);
			}
		}
		else
		{
			for(i = maxLen - minLen - 1; i >= 0 && t > 0; i--)
			{
				t = chb[i] - 48 + t;
				chArr[i] = convert[t % 2];
				t /= 2;
			}
			if(i >= 0)
			{
				System.arraycopy(chb, 0, chArr, 0, i + 1);
			}
		}
		
		
		result = new String(chArr);
		if(t > 0)
		{
			result = convert[t] + result;
		}
		
		
		return result;
	}
}
