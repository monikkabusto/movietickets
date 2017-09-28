package movietickets.application;

public class PurchaseVerification {

	private final String transactionNumber;

	public PurchaseVerification(String transactionNumber) {
		super();
		this.transactionNumber = transactionNumber;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

}
