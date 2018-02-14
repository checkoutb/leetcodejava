package gt000;

import java.math.BigDecimal;

/**
 * 65. Valid Number
 * */
public class LT0065
{

	public static void main(String[] args)
	{
		String s = "  0.1";
		s = "-1.";
		s = "+.8";
		
		
		System.out.println(Lt0065a(s));
	}

	// 完全是错一个改一个的
	// beats 25%
	public static boolean Lt0065a(String s)
	{
		boolean result = true;
		if(s == null)
		{
			return false;
		}
		String s2 = s.trim();
		if(s2.length() == 0)
		{
			return false;
		}
		
		char[] chArr = s2.toCharArray();
		int i = 0;
		int j = 0;
		int k = 0;
		int len = chArr.length;
		char ch = '0';
		int m = -1;		// the index of e/E
		int n = -1;		// the index of .
		
		for(i = 0; i < len; i++)
		{
			ch = chArr[i];
			if(!(ch >= '0' && ch <= '9'))
			{
				if(ch == '-' || ch == '+')
				{
					if(i != 0 && i != m + 1)
					{
						return false;
					}
					if(i == len - 1)
					{
						return false;
					}
				}
				else if(ch == 'e' || ch == 'E')
				{
					if(i == 0)
					{
						return false;
					}
					if(i == 1 && chArr[0] == '-')
					{
						return false;
					}
					if(m != -1)
					{
						return false;
					}
					m = i;
				}
				else if(ch == '.')
				{
					if(n != -1)
					{
						return false;
					}
					n = i;
				}
				else
				{
					return false;
				}
			}
			
		}
//		if(result = false)
//		{
//			return result;
//		}
		
		
		if(n != -1)
		{
			if(len == 1)
			{
				return false;
			}
			if(m != -1 && m == n - 1 && n == len - 1)
			{
				return false;
			}
			if(len == 2 && (chArr[0] == '-' || chArr[0] == '+'))
			{
				return false;
			}
		}
		
		if(m != -1)
		{
			if(m == len - 1)
			{
				return false;
			}
			if(n + 1 == m && (n == 0 || (n == 1 && (chArr[0] == '-' || chArr[0] == '+'))))
			{
				return false;
			}
			if(m == 1 && (chArr[0] == '-' || chArr[0] == '+'))
			{
				return false;
			}
			if(n > m)
			{
				return false;
			}
		}
		
		
		return result;
	}
	
	// haha
	// Line 7: error: cannot find symbol: class BigDecimal
	public static boolean Lt0065(String s)
	{
		boolean result = true;
		try
		{
			BigDecimal bd = new BigDecimal(s);
		}
		catch(Exception e)
		{
			result = false;
		}
		return result;
	}
}
