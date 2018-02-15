package gt000;

import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 68. Text Justification
 * */
public class LT0068
{

	public static void main(String[] args)
	{
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		words = new String[]{""};
		maxWidth = 2;
		
		words = new String[]{"a","b","c","d","e"};
		maxWidth = 1;
		
		LTUtils.showList(Lt0068(words, maxWidth));
	}

	// 1,2ms
	public static List<String> Lt0068(String[] words, int maxWidth)
	{
		List<String> result = new LinkedList<>();
		
		int len = words.length;
		int[][] strLen = new int[len + 1][2];
		String[] blank = new String[maxWidth + 1];
		int i = 0, j = 0;
		int t = 0;
		int m = 0;
		int n = 0;
		int t2 = 0;
		int t3 = 0;
		String blk = "";
		String temp = "";
		
		strLen[len][1] = -1;
		
		blank[0] = blk;
		for(i = 1; i <= maxWidth; i++)
		{
			blk += " ";
			blank[i] = blk;
		}
		
		if(len == 1)
		{
			temp = words[0] + blank[maxWidth - words[0].length()];
			result.add(temp);
			return result;
		}
		
		
		t = words[0].length();
		strLen[0][0] = t;
		strLen[0][1] = 0;
		
		for(i = 1; i < len; i++)
		{
			m = words[i].length();
			strLen[i][0] = m;
			
			if((t + m + 1) > maxWidth)
			{
				j++;
				t = m;
			}
			else
			{
				t = t + m + 1;
			}
			
			strLen[i][1] = j;
		}
		
//		LTUtils.showArrayOfArrayOneRowOneLine(strLen);
		
		t = 0;
		j = strLen[0][1];
		m = 0;
		n = 0;
		for(i = 0; i <= len; i++)
		{
			if(strLen[i][1] == j)
			{
				t += strLen[i][0];
			}
			else if (i == len)
			{
				n = i - 1;
				temp = blank[0];
				t2 = n - m;
				for(; m < n; m++)
				{
					temp += words[m];
					temp += blank[1];
				}
				temp += words[m];
				temp += blank[maxWidth - t - t2];
				result.add(temp);
			}
			else
			{
				n = i - 1;
				
				if((n - m) != 0)
				{
					t2 = (maxWidth - t) / (n - m);
					t3 = (maxWidth - t) - t2 * (n - m);
					
					temp = blank[0];
					
					for(; m < n; m++)
					{
						if(t3 > 0)
						{
							temp += words[m];
							temp += blank[t2 + 1];
							t3--;
						}
						else
						{
							temp += words[m];
							temp += blank[t2];
						}
					}
					temp += words[n];
					result.add(temp);
					j = strLen[i][1];
					t = strLen[i][0];
					m = i;
				}
				else
				{
					temp = words[m] + blank[maxWidth - strLen[m][0]];
					result.add(temp);
					j = strLen[i][1];
					t = strLen[i][0];
					m = i;
				}
			}
		}
		
		return result;
	}
}
