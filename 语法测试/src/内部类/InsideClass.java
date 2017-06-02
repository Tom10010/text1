package 内部类;

public class InsideClass {

	int aaa = 0;
	private int bbb = 1;
	protected int ccc = 2;
	public int ddd = 3;
	public class Inside{
		int aa = 0;
		private int bb = 1;
		protected int cc = 2;
		public int dd = 3;
		private void aaa() {
			System.out.println(aaa+"  "+bbb+"   "+ccc+"   "+ ddd);
		}
	}
	private void kkk() {
		Inside i = new Inside();
		final int aaaa = 1;
		i.aaa();
		i.bb = 10;
		System.out.println(i.bb);
		class text{
			void print() {
				System.out.println(aaaa + "zhang");
				int m = aaaa;
				// aaaa+=11;  //出错
			}
		}
		text t = new text();
		t.print();
	}
	public static void main(String[] args) {
		//System.out.println(aa + "    "+bb+"   "+ cc +"   "+dd);
		InsideClass i = new InsideClass();
		i.kkk();
	}
}
