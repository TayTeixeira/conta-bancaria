package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		int option = 0, number, agency, type, birthday, destinationNumber;
		String titular;
		float balance, limit, value;

		Scanner read = new Scanner(System.in);

		System.out.println("\n Criar contas \n");

		ContaCorrente cc1 = new ContaCorrente(contas.generateNumber(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.register(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.generateNumber(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.register(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.generateNumber(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.register(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.generateNumber(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.register(cp2);

		contas.listAll();

		while (true) {

			System.out.println(cores.TEXT_BLUE_BOLD);

			System.out.println("---------------------------------------------------------------------");
			System.out.println("");
			System.out.println("\t\t\t Banco TATA");
			System.out.println("");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("");
			System.out.println("\t\t 1- Criar uma conta");
			System.out.println("\t\t 2- Listar todas as contas");
			System.out.println("\t\t 3- Buscar conta por número");
			System.out.println("\t\t 4- Atualizar dados da conta");
			System.out.println("\t\t 5- Deletar a conta");
			System.out.println("\t\t 6- Sacar");
			System.out.println("\t\t 7- Depositar");
			System.out.println("\t\t 8- Fazer trasnferência entre contas");
			System.out.println("\t\t 9- Sair");
			System.out.println("");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Digite a opção desejada: ");
			System.out.println("");
			System.out.println(cores.TEXT_RESET);

			try {
				option = read.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				read.nextLine();
				option = 0;
			}

			if (option == 9) {
				System.out.println("\n Banco TATA - RICO");
				read.close();
				System.exit(0);

			}

			switch (option) {
			case 1:
				System.out.println("Criar uma conta\n");

				System.out.println("Digite o número da Agência: ");
				agency = read.nextInt();
				read.nextLine();
				System.out.println("Digite o nome do titular: ");
				titular = read.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CF): ");
					type = read.nextInt();
				} while (type < 1 && type > 2);

				System.out.println("Digite o saldo da conta (R$): ");
				balance = read.nextFloat();

				switch (type) {
				case 1 -> {
					System.out.println("Digite o limite do crédito (R$): ");
					limit = read.nextFloat();
					contas.register(new ContaCorrente(contas.generateNumber(), agency, type, titular, balance, limit));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					birthday = read.nextInt();
					contas.register(
							new ContaPoupanca(contas.generateNumber(), agency, type, titular, balance, birthday));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as contas\n");
				contas.listAll();
				keyPress();
				break;
			case 3:
				System.out.println("Buscar conta por número\n");

				System.out.println("Digite o número da conta: ");
				number = read.nextInt();

				contas.searchForNumber(number);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da conta\n");

				System.out.println("Digite o número da conta: ");
				number = read.nextInt();

				if (contas.searchInCollection(number) != null) {
					System.out.println("Digite o número da Agência: ");
					agency = read.nextInt();
					read.nextLine();
					System.out.println("Digite o nome do titular: ");
					titular = read.nextLine();

					System.out.println("Digite o saldo da conta (R$): ");
					balance = read.nextFloat();

					type = contas.returnType(number);

					switch (type) {
					case 1 -> {
						System.out.println("Digite o limite do crédito (R$): ");
						limit = read.nextFloat();
						contas.update(new ContaCorrente(number, agency, type, titular, balance, limit));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						birthday = read.nextInt();
						contas.update(new ContaPoupanca(number, agency, type, titular, balance, birthday));
					}
					}
				} else
					System.out.println("\n Conta não encontrada!");

				keyPress();
				break;
			case 5:
				System.out.println("Deletar a conta\n");

				System.out.println("Digite o número da conta: ");
				number = read.nextInt();

				contas.delete(number);

				keyPress();
				break;
			case 6:
				System.out.println("Sacar\n");

				System.out.println("Digite o número da conta: ");
				number = read.nextInt();

				do {
					System.out.println("Digite o valor do saque (R$): ");
					value = read.nextFloat();
				} while (value <= 0);

				contas.withdrawMoney(number, value);

				keyPress();
				break;

			case 7:
				System.out.println("Depositar\n");

				System.out.println("Digite o número da conta: ");
				number = read.nextInt();

				do {
					System.out.println("Digite o valor do saque (R$): ");
					value = read.nextFloat();
				} while (value <= 0);

				contas.deposit(number, value);

				keyPress();
				break;

			case 8:
				System.out.println("Fazer trasnferência entre contas\n");

				System.out.println("Digite o número da conta de origem: ");
				number = read.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				destinationNumber = read.nextInt();

				do {
					System.out.println("Digite o valor da tranferência (R$): ");
					value = read.nextFloat();
				} while (value <= 0);

				contas.transfer(number, destinationNumber, value);

				keyPress();
				break;

			default:
				System.out.println(cores.TEXT_RED_BOLD + "Opção inválida!\n" + cores.TEXT_RESET);
				keyPress();
				break;

			}

		}

	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar" + cores.TEXT_RESET);
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
