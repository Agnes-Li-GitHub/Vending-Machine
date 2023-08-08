public class CmdPurchase implements Command {
	
	@Override
	public String execute(VendingMachine v, String[] cmdParts) {
		String c = String.valueOf(cmdParts[1]);
		String x = "";
		v.checkProduct(c);
		
		// out of stock
		if (v.c_quantity == 0) {
			x = c + " is out of stock!";
		}
		
		// no money
		else if (v.c_price > v.total) {
			x = "Not enough credit to buy " + c + "! Inserted $" + v.total + " but needs $" + v.c_price + ".";
		}
		
		// can buy + no need change
		else if (v.c_price == v.total) {
			v.clearCoin();
			v.minus_one(c);
			x = "Dropped " + c + ". Paid $" + v.c_price + ". No change.";
		}
		
		// can buy, with change
		else if (v.c_price < v.total) {
			x = v.purchaseChange();
			x = "Dropped " + c + ". Paid $" + v.total + ". Your change: " + x;
			v.clearCoin();
			v.minus_one(c);
		}
		return x;	
	}
}