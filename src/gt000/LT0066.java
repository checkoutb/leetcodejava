package gt000;

import java.util.Arrays;

/**
 * 66. Plus One
 * */
public class LT0066
{

	public static void main(String[] args)
	{
		int[] digits = {1, 0};
		
		System.out.println(Arrays.toString(Lt0066(digits)));
	}

	// 0,2ms
	public static int[] Lt0066(int[] digits)
	{
		int[] result = digits;
		
		int t = 0;
		int i = 0;
		int len = digits.length;
		
		t = 1;
		for(i = len - 1; i >= 0 && t > 0; i--)			// .. digits[0] 是最高位
		{
			t = result[i] + t;
			result[i] = t % 10;
			t /= 10;
		}
		
		if(t > 0)
		{
			int[] result2 = result;
			result = new int[len + 1];
			System.arraycopy(result2, 0, result, 1, len);
			result[0] = t;
		}
		
		
		
		return result;
	}
}
