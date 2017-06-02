package number17;

import java.util.Arrays;

public class Number17 {

	public static void main(String[] args) {
		//传进命令行参数
		System.out.println(args[0]);
		//转换成字符数组
		char [] a =args[0].toCharArray();
		//对字符数组进行排序
		Arrays.sort(a);
		System.out.println(a);
		//判断某元素是否在数组里面
		int index = Arrays.binarySearch(a, 'j');
		System.out.println(index);
		//拷贝
		char [] b = Arrays.copyOfRange(a, 2, 5);
		System.out.println(b);
		//填充
		Arrays.fill(b, 'w');
		System.out.println(b);
		//比较
		System.out.println(Arrays.equals(a, b));
	}

}
