package conta.model;

public class Conta {

	private int number;
	private int agency;
	private int type;
	private String titular;
	private float balance;
	
	public Conta(int number, int agency, int type, String titular, float balance) {
		this.number = number;
		this.agency = agency;
		this.type = type;
		this.titular = titular;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getAgency() {
		return agency;
	}


	public void setAgency(int agency) {
		this.agency = agency;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public boolean withdrawMoney(float value) { 
		
		if(this.getBalance() < value) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
			
		this.setBalance(this.getBalance() - value);
		return true;
	}

	public void deposit(float value) {

		this.setBalance(this.getBalance() + value);

	}

	
	public void view() {

		String type = "";
		
		switch(this.type) {
		case 1:
			type = "Conta Corrente";
		break;
		case 2:
			type = "Conta Poupança";
		break;
		}
		
		System.out.println("\n\n----------------------------------------------------------");
		System.out.println("Dados da Conta:");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Numero da Conta: " + this.number);
		System.out.println("Agência: " + this.agency);
		System.out.println("Tipo da Conta: " + type);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: " + this.balance);

	}
	
	

}
