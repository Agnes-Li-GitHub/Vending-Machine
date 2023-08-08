public class CmdRejectCoins implements Command {
	
	@Override
	public String execute(VendingMachine v, String[] cmdParts) {
		String x = "";
		if (v.total > 0) {
			x = v.rejectCoin();
			x = "Rejected " + x +  " $" + v.total + " in total.";
			v.clearCoin();
			v.total = 0;
		}
		
		else {
			x = "Rejected no coin!";
		}
		
		return x;	
	}
}
