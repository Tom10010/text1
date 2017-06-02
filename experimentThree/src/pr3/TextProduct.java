package pr3;

class Product {

	private int price;
	private String name;
	private String ID;
	
	public Product(int price, String name, String ID){
		this.ID = ID;
		this.name = name;
		this.price = price;
	}
	
	public void show(){
		System.out.println("The name of the product is: " + name);
		System.out.println("The price of the product is: " + price);
		System.out.println("The ID of the product is: " + ID);
	}
}

class Custom{
	
	private String ID;
	private String name;
	private String Tel;
	Product pro;
	
	public Custom(String ID, String name, String Tel, Product pro)
	{
		this.ID = ID;
		this.name = name;
		this.Tel = Tel;
		this.pro = pro; 
	}
	
	public void show(){
		System.out.println("The ID of the custom is: " + ID);
		System.out.println("The name of the custom is: " + name);
		System.out.println("The Tel of the custom is: " + Tel);
	}
	
	public void BY()
	{
		System.out.println("Custom information is: ");
		show();
		System.out.println("Product information is: ");
		pro.show();
	}
}

public class TextProduct{
	public static void main(String[] args){
		Product Pro = new Product(32, "cap", "123123");
		Custom Cus = new Custom("111111", "Wang", "12325463254", Pro);
		Cus.BY();
	}
}

