package ge100;

import java.util.LinkedList;
import java.util.List;

import utils.LTUtils;

/**
 * 118. Pascal's Triangle
 * */
public class LT0118
{

    // 杨辉三角...帕斯卡三角...忘记怎么写了...
    // printf("%d ", (s = (i - j) * s / j));        i: rowIndex; j: columnIndex; s start from 0..不知道对不对..从第3行开始的。
    //                                          可以的，119用到了，只不过行数需要++。。。乘法会超过int上限。
    //             先除的话，5的时候后半段有问题，所以选择long，不清楚只算前半段，然后后半段直接==前半段的降序 行不行。
    public static void main(String[] args)
    {
        int numRows = 5;
        LTUtils.showListOfList(new LT0118().Lt0118(numRows));
    }

    // 1ms
    private List<List<Integer>> Lt0118(int numRows)
    {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> ele = new LinkedList<>();
        List<Integer> lastEle = null;
        int num = 0;
        int lastNum = 0;
        
        while(numRows > 0)
        {
            lastEle = ele;
            ele = new LinkedList<>();
            result.add(ele);
            lastNum = 0;                        //
            for (int i = 0; i < lastEle.size(); i++)
            {
                num = lastEle.get(i);
                ele.add(lastNum + num);
                lastNum = num;
            }
            ele.add(1);
            numRows--;
        }
        return result;
    }
}
