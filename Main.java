import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Edital edital = new Edital();
        Scanner sc = new Scanner(System.in);

        int opcao;
        String nome;
        int idItem;
        int idCliente;
        double lance;
        
        do {
            System.out.println("\n- Adicionar itens ao leilão -\n");
            System.out.println("1- Adicionar item");
            System.out.println("2- Sair\n");
            System.out.print("> ");
            opcao = Integer.parseInt(sc.nextLine());

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Item: ");
                    nome = sc.nextLine();
                    System.out.print("ID do Item: ");
                    idItem = Integer.parseInt(sc.nextLine());

                    Item item = new Item(nome, idItem);
                    edital.adicionarItem(item);

                    System.out.println("\nItem registrado: " + nome + " (ID " + idItem + ")\n");
                    break;
            
                case 2:
                    if (edital.itensLeilao.isEmpty()) {
                        System.out.println("Pelo menos um item deve ser adicionado\n");
                    }
                    break;
            
                default:
                    System.out.println("Opção inválida\n");
                    break;
            }
        } while (opcao != 2 || edital.itensLeilao.isEmpty());

        System.out.println("\n\n- Leilão -");

        Sessao sessao = new Sessao();

        do {
            System.out.println("\n- Item: " + edital.itensLeilao.inicio.nome + " -\n");
            System.out.println("1- Dar lance");
            System.out.println("2- Próximo item\n");
            System.out.print("> ");
            opcao = Integer.parseInt(sc.nextLine());

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("ID do Cliente: ");
                    idCliente = Integer.parseInt(sc.nextLine());
                    System.out.print("Lance: ");
                    lance = Double.parseDouble(sc.nextLine());

                    if (sessao.lanceMaisRecente < lance) {
                        Cliente cliente = new Cliente(idCliente);
                        System.out.println();
                        cliente.darLance(lance, sessao);
                    } else {
                        System.out.println("\nLance deve ser maior que o anterior\n");
                    }

                    break;
            
                case 2:
                    if (sessao.ultimosLances.isEmpty()) {
                        System.out.println("Pelo menos um lance deve ser feito\n");
                    } else {
                        edital.proximoItem(sessao);
                        sessao = new Sessao();
                        System.out.println();
                    }
                    
                    break;
            
                default:
                    System.out.println("Opção inválida\n");
                    break;
            }
        } while (!edital.itensLeilao.isEmpty());
        
        sc.close();
    }
}
