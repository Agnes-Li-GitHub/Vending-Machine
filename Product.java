public class Product {
	private String name;
	private int price;
	private int quantity;
	
	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product() {
		this.name = "null";
		this.price = 0;
		this.quantity = 0;
	}
	
	
	/* You may add other properties and methods */
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int q) {
		this.quantity = q;
	}
}