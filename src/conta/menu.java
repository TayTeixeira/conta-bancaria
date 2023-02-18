package conta;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option;
		
		Scanner read = new Scanner(System.in);
		
		while (true) {
			
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
			
			option = read.nextInt();
			
			if(option == 9) {
				System.out.println("\n Banco TATA - RICO");
				read.close();
				System.exit(0);
				
			}
			
			switch(option) {
			case 1:
				System.out.println("Criar uma conta\n");
				break;
			case 2:
				System.out.println("Listar todas as contas\n");
				break;
			case 3:
				System.out.println("Buscar conta por número\n");
				break;
			case 4:
				System.out.println("Atualizar dados da conta\n");
				break;
			case 5:
				System.out.println("Deletar a conta\n");
				break;
			case 6:
				System.out.println("Sacar\n");
				break;
			case 7:
				System.out.println("Depositar\n");
				break;
			case 8:
				System.out.println("Fazer trasnferência entre contas\n");
				break;
			default:
				System.out.println("Opção inválida!\n");
				break;
				
			}

		}
		
	}

}
