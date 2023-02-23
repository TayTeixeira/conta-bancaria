package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

	// CRUD da Conta
		public void searchForNumber(int number);
		public void listAll();
		public void register(Conta conta);
		public void update(Conta conta);
		public void delete(int number);
		
		// Métodos Bancários
		public void withdrawMoney(int numero, float valor);
		public void deposit(int number, float value);
		public void transfer(int originNumber, int destinationNumber, float value);
	
}
