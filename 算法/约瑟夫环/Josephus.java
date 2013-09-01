import java.util.ArrayList;
import java.util.List;

public class Josephus
{
	public static void main(String[] args)
	{
		System.out.println(getResult(3, 0, 1));
	}
	/**
	 * 计算约瑟夫环最后结果
	 * @param total 总共人数
	 * @param begin 开始报数的编号
	 * @param number 报数个数
	 * @return
	 */
	public static int getResult(int total, int begin, int number)
	{
		Integer Result = null;  //最后报数的编号
		//将所有的人数保存到list
		List<Integer> list = new ArrayList<Integer>(total);
		for (int i = 0; i < total; i++)
		{
			list.add(i);
		}
		//报数从1开始， 存储从0开始.故先要减一
		begin -= 1;
		//循环模拟报数
		while (total > 0)
		{
			begin += number;
			Result = list.remove(begin % total);
			begin = (begin % total) - 1;
			total--;
		}
		return Result;
	}
}
