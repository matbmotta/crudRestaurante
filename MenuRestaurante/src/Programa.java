import java.io.IOException;
import java.util.Scanner;

public class Programa {

	public static void main (String[] args) throws IOException {
		
		System.out.println("Sistma de Gestão de Menu de Restaurantes");
		System.out.println("Para começar digite uma das opções a seguir:");
		
		 Menu option = new Menu();
		 OrderList pedidos = new OrderList();
		
		int choose;
		
		Scanner scan = new Scanner(System.in);
		
		do {
            System.out.println("1 - Mostrar Menu");
            System.out.println("2 - Registrar e ou Remover Produtos");
            System.out.println("3 - Registrar Novo Pedido ");
            System.out.println("4 - Mostrar pedidos");
            System.out.println("0 - Sair");
            
            choose = scan.nextInt();
            
            switch (choose) {
            	case 0:
            		System.out.println("Obrigado Por Utilizar o Sistema");
            		System.out.println("Sistema Finalizado !!");
            		scan.next();
            	break;
            	case 1:
            		System.out.println("Menu");
            		option.printMenu();
            		System.out.println("Pressione Qualquer Tecla e Digite ENTER");
            		scan.next();
            	break;
            	case 2:
                    System.out.println("Digite a opção desejada:");
                    System.out.println("1 - Registrar prato");
                    System.out.println("2 - Registrar bebida");
                    System.out.println("3 - Registrar vinho");
                    System.out.println("4 - Remover prato");
                    System.out.println("5 - Remover bebida");
                    System.out.println("6 - Remover vinho");
                    System.out.println("0 - Sair");
                    int choose2 = scan.nextInt();
                    String name;
                    String price;
                    switch(choose2) {
	                    case 0:
	                    break;
	                    case 1:
	                        System.out.println("Registre o Nome do Prato:");
	                        scan.nextLine();
	                        name = scan.nextLine();
	                        System.out.println("Registre o Preço do Prato:");
	                        price = scan.nextLine();
	                        option.addDish(name, Double.parseDouble(price.replace(',','.')));
	                    break;
	                    case 2:
	                        System.out.println("Registre o nome da bebida:");
	                        scan.nextLine();
	                        name = scan.nextLine();
	                        System.out.println("Registre o preço da bebida:");
	                        price = scan.nextLine();
	                        option.addBeverage(name, Double.parseDouble(price.replace(',','.')));
	                    break;
	                    case 3:
	                        System.out.println("Registre o nome do vinho:");
	                        scan.nextLine();
	                        name = scan.nextLine();
	                        System.out.println("Registre o preço do vinho:");
	                        price = scan.nextLine();
	                        option.addWine(name, Double.parseDouble(price.replace(',','.')));
	                    break;
	                    case 4:
	                        System.out.println("Escreva o nome do prato a ser removido:");
	                        scan.nextLine();
	                        name = scan.nextLine();
	                        option.removeDish(name);
	                    break;
	                    case 5:
	                        System.out.println("Escreva o nome da bebida a ser removida:");
	                        scan.nextLine();
	                        name = scan.nextLine();
	                        option.removeBeverage(name);
	                    break;
	                    case 6:
	                        System.out.println("Escreva o nome do vinho a ser removido:");
	                        scan.nextLine();
	                        name = scan.nextLine();
	                        option.removeWine(name);
	                    break;
	                    default:
	                        System.out.println("Opção inválida!!");
	                    break;                    
                    }
                    
            break;
            case 3:
            	System.out.println("Escreva o nome do cliente:");
                scan.nextLine();
                String nome_cliente = scan.nextLine();
                System.out.println("Escreva o número da mesa:");
                int numero_mesa = scan.nextInt();
                Order pedido = new Order(nome_cliente, numero_mesa, option);
                int choose3;
                do {
                    System.out.println("Digite a opção desejada:");
                    System.out.println("1 - Incluir Item");
                    System.out.println("2 - Excluir Item");
                    System.out.println("3 - Mostrar Cardápio");
                    System.out.println("4 - Finalizar Pedido");
                    System.out.println("0 - Sair");
                    choose3 = scan.nextInt();
                    int choose4;
                    String id;
                    String quantity;
                    String obs = null;
                    switch(choose3) {
                        case 0:
                        break;
                        case 1:
                            System.out.println("Informe o identificador do item a ser adicionado:");
                            scan.nextLine();
                            id = scan.nextLine();
                            System.out.println("Informe a quantidade:");
                            quantity = scan.nextLine();
                            System.out.println("Gostaria de Deixar Alguma Observação? (Digite 1 se sim ou Digite 2 se não)");
                            choose4 = scan.nextInt();
                            if(choose4 == 1) {
                                System.out.println("Escreva a Sua Observação");
                                scan.nextLine();
                                obs = scan.nextLine();
                            }
                            pedido.incluir(Integer.parseInt(id), Integer.parseInt(quantity), obs);
                            obs = null;
                        break;
                        case 2:
                            System.out.println("Informe o identificador do item a ser removido:");
                            scan.nextLine();
                            id = scan.nextLine();
                            System.out.println("Informe a quantidade:");
                            quantity = scan.nextLine();
                            pedido.remover(Integer.parseInt(id), Integer.parseInt(quantity));
                        break;
                        case 3:
                            option.printMenu();
                            System.out.println("Pressione qualquer tecla para continuar e pressione ENTER.");
                            scan.next();
                        break;
                        case 4:
                            pedidos.incluir(pedido);
                            choose3 = 0;
                        break;
                        default:
                            System.out.println("Opção inválida!!");
                        break;
                    }
                } while (choose3 != 0);
            break;
            case 4:
                System.out.println("Digite a opção desejada:");
                System.out.println("1 - Todos os pedidos");
                System.out.println("2 - Imprimir pedido da mesa");
                System.out.println("0 - Sair");
                int choose5 = scan.nextInt();
                switch(choose5){
                    case 0:                            
                    break;
                    case 1:
                        pedidos.imprimirTodos();
                        System.out.println("Pressione qualquer tecla para continuar e pressione ENTER.");
                        scan.next();
                    break;
                    case 2:
                        System.out.println("Digite o número da mesa:");
                        int id_mesa_pedido = scan.nextInt();
                        pedidos.imprimir(id_mesa_pedido);
                        System.out.println("Pressione qualquer tecla para continuar e pressione ENTER.");
                        scan.next();
                    break;
                    default:
                        System.out.println("Opção inválida!!");
                    break;
                }
            break;
            default:
                System.out.println("Opção inválida!!");
            break;
            }
			} while (choose != 0);
			scan.close();
			

        }
	}
	
	

