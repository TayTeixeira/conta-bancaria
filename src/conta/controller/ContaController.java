package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> accountList = new ArrayList<Conta>();

	@Override
	public void searchForNumber(int number) {
		var conta = searchInCollection(number);

		if (conta != null)
			conta.view();
		else
			System.out.println("\n Conta número: " + number + " não foi encontrada!");

	}

	@Override
	public void listAll() {
		for (var conta : accountList) {
			conta.view();
		}

	}

	@Override
	public void register(Conta conta) {
		accountList.add(conta);
		System.out.println("\n Conta nnúmero: " + conta.getNumber() + " foi criada com sucesso!");

	}

	@Override
	public void update(Conta conta) {
		var searchAccount = searchInCollection(conta.getNumber());

		if (searchAccount != null) {
			accountList.set(accountList.indexOf(searchAccount), conta);
			System.out.println("\n A conta número: "+conta.getNumber()+" foi atualizada com sucesso!");
		} else 
			System.out.println("\n A conta número: "+conta.getNumber()+" não foi encontrada!");
	}

	@Override
	public void delete(int number) {
		var conta = searchInCollection(number);

		if (conta != null) {
			if(accountList.remove(conta) == true)
				System.out.println("\n A conta número: "+number+" foi atualizada com sucesso!");
		} else 
			System.out.println("\n A conta número: "+number+" não foi encontrada!");
		
	}

	@Override
	public void withdrawMoney(int number, float value) {
		var searchAccount = searchInCollection(number);
		
		if (searchAccount != null) {
			
			if(accountList.get(accountList.indexOf(searchAccount)).withdrawMoney(value) == true)
				System.out.println("\n O saque na conta número: "+number+" foi atualizada com sucesso!");
			
		} else 
			System.out.println("\n A conta número: "+number+" não foi encontrada!");
		
	}

	@Override
	public void deposit(int number, float value) {
		var searchAccount = searchInCollection(number);
		
		if(searchAccount != null) {
			var accountIndex = accountList.indexOf(searchAccount);
			accountList.get(accountIndex).deposit(value);
			System.out.println("\nO depósito na conta número: "+number+" foi efetutuado com sucesso!");
		}else
			System.out.println("\nA conta número: "+number+" não foi encontrada ou a conta destino não é uma conta corrente!");
	}

	@Override
	public void transfer(int originNumber, int destinationNumber, float value) {
		var searchOriginAccount = searchInCollection(originNumber);
		var searchDestinationAccount = searchInCollection(destinationNumber);
		
		if(searchOriginAccount != null && searchDestinationAccount != null) {
			if(accountList.get(accountList.indexOf(searchOriginAccount)).withdrawMoney(value) == true) {
				accountList.get(accountList.indexOf(searchDestinationAccount)).deposit(value);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
		}else
			System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
	}

	public int generateNumber() {
		return accountList.size() + 1;
	}

	public Conta searchInCollection(int number) {
		Conta foundedAccount = null;
		for (var conta : accountList) {
			if (conta.getNumber() == number) {
				foundedAccount = conta;
				break;
			}
		}

		return foundedAccount;

	}
	
	public int returnType(int number) {
		int accountType = 0;
		for (var conta: accountList) {
			if (conta.getNumber() == number) {
				accountType = conta.getType();
				break;
			}
		}
		
		return accountType;
	}

}
