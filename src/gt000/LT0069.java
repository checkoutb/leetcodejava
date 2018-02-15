package gt000;


/**
 * 69. Sqrt(x)
 * */
public class LT0069
{

	public static void main(String[] args)
	{
		// 46340.95
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}

	//...看了别人的代码。瞬间没意思了。
	public static int Lt0069(int x)
	{
		int result = 1;
		
		if(x == 0)
		{
			return 0;
		}
		else if(x <= 46340)
		{
			
		}
		
		return result;
	}
	
	// accepted...beats 22.9%
	public static int Lt0069a(int x)
	{
		return (int)Math.sqrt(x);
	}
}
