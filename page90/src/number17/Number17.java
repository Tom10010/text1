package number17;

import java.util.Arrays;

public class Number17 {

	public static void main(String[] args) {
		//���������в���
		System.out.println(args[0]);
		//ת�����ַ�����
		char [] a =args[0].toCharArray();
		//���ַ������������
		Arrays.sort(a);
		System.out.println(a);
		//�ж�ĳԪ���Ƿ�����������
		int index = Arrays.binarySearch(a, 'j');
		System.out.println(index);
		//����
		char [] b = Arrays.copyOfRange(a, 2, 5);
		System.out.println(b);
		//���
		Arrays.fill(b, 'w');
		System.out.println(b);
		//�Ƚ�
		System.out.println(Arrays.equals(a, b));
	}

}
