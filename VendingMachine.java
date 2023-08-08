import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine {
	// ArrayList of Integers represents inserted coins in Coin Slot
	private ArrayList<Integer> insetedCoins;

	// ArrayList of Product represents inventories of products
	private ArrayList<Product> products;

	public int total;

	public VendingMachine() {
		insetedCoins = new ArrayList<Integer>();
		products = new ArrayList<Product>();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	/* You may add other properties and methods */

	// for CmdInsertCoin
	public void insertCoin(Integer c) {
		insetedCoins.add(c);
		// the sum of insertedCoins
		total = total + c;
	}

	// for CmdRejectCoin
	public void clearCoin() {
		total = 0;
		insetedCoins.clear();
	}

	public int c_price = 0;
	public int c_quantity = 0;

	public void checkProduct(String c) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(c)) {
				c_price = products.get(i).getPrice();
				c_quantity = products.get(i).getQuantity();
				break;
			}
		}
	}

	public void minus_one(String c) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(c)) {
				products.get(i).setQuantity(c_quantity - 1);
				c_quantity = products.get(i).getQuantity();
				break;
			}
		}
	}

	public String rejectCoin() {
		String x = "";
		Collections.sort(insetedCoins);
		
		// Reject all coin in Coin Slot
		for (int i=0; i<insetedCoins.size();i++) {
			x = x + "$" + Integer.toString(insetedCoins.get(i)) + ", ";
		}
		x = x.substring(0, x.length()-2) + ".";
		return x;
	}
		
	public String purchaseChange() {
		String x = "";
		int amount = total - c_price;
		
		int ten_dollar = amount / 10;
		String ten_dollar_count = "";
		for (int i=0; i<ten_dollar; i++) {
			ten_dollar_count = ten_dollar_count + "$10, ";
		}

		amount = amount - ten_dollar * 10;
		int five_dollar = amount / 5;
		String five_dollar_count = "";
		for (int i=0; i<five_dollar; i++) {
			five_dollar_count = five_dollar_count + "$5, ";
		}

		amount = amount - five_dollar * 5;
		int two_dollar = amount / 2;
		String two_dollar_count = "";
		for (int i=0; i<two_dollar; i++) {
			two_dollar_count = two_dollar_count + "$2, ";
		}

		amount = amount - two_dollar * 2;
		int one_dollar = amount;
		String one_dollar_count = "";
		for (int i=0; i<one_dollar; i++) {
			one_dollar_count = one_dollar_count + "$1, ";
		}

		x = x + one_dollar_count + two_dollar_count + five_dollar_count + ten_dollar_count;
		x = x.substring(0, x.length()-2) + ".";
		return x;
	}
}