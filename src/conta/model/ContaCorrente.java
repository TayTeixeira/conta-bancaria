package conta.model;

public class ContaCorrente extends Conta {
	
	private float limit;

	public ContaCorrente(int number, int agency, int type, String titular, float balance, float limit) {
		super(number, agency, type, titular, balance);
		this.limit = limit;
		// TODO Auto-generated constructor stub
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	@Override
	public boolean withdrawMoney (float value) {
		
		if(this.getBalance() + this.getLimit() < value) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		
		this.setBalance(this.getBalance() - value);
		return true;
		
	}
	
	@Override
	public void view() {
		super.view();
		System.out.println("Limite de Crédito: "+this.limit);
	}
	
}
