
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaLogistico {
    private ArrayList<Entrega> entregas;
    private int proximoID;
    private Scanner scanner;
    

    public SistemaLogistico() {
        this.entregas = new ArrayList<>();
        this.proximoID = 1;
        this.scanner = new Scanner(System.in);

    }
    
    public void exibirMenu() throws IOException {
        int opcao = 0;

        while (opcao != 4) {
        System.out.println("\n=== Sistema Logístico ===");
        System.out.println("1. Adicionar entrega");
        System.out.println("2. Listar entregas");
        System.out.println("3. Atualizar status de entrega");
        System.out.println("4. Remover entrega");
        System.out.println("5. Salvar entregas em arquivo");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
         opcao = scanner.nextInt();
         scanner.nextLine();

         switch (opcao) {
            case 1:
                adicionarEntrega();
                break;
            case 2:
                listarEntregas();
                break;
            case 3:
                atualizarStatus();
                break;
            case 4:
                removerEntrega();
                break;
            case 5:
                salvarEntregasEmArquivo();
                break;
            case 6:
                System.out.println("Encerrando o sistema...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");

         }
        }
    }

    private void adicionarEntrega() {
        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Produto: ");
        String produto = scanner.nextLine();
        String status = "Pendente";

        Entrega novaEntrega = new Entrega(proximoID++, cliente, endereco, produto, status);
        entregas.add(novaEntrega);
        int idd = proximoID-1;
        System.out.println("Entrega adicionada com sucesso! O ID da sua entrega é" + idd);
    }

    private void listarEntregas() {
        System.out.println("Listando entregas...");
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
        } else {
            System.out.println("\n=== Lista de Entregas ===");
            for (Entrega entrega : entregas) {
                System.out.println(entrega);
            }
        }
    }

    private void atualizarStatus() {
        System.out.println("Digite o ID da entrega:");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean encontrada = false;

        for (Entrega entrega : entregas) {
            if (entrega.getId() == id) {
                System.out.println("Novo status (Pendente, Em transporte, Entregue): ");
                String novoStatus = scanner.nextLine();
                entrega.setStatus(novoStatus);
                System.out.println("Status atualizado com sucesso!" + novoStatus);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Entrega não encontrada!");
        }
    }

    private void removerEntrega() {
        System.out.println("Digite o ID da entrega a ser removida");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean removida = entregas.removeIf(entrega -> entrega.getId() == id);
        if (removida) {
            System.out.println("Entrega removida com sucesso!");
        } else {
            System.out.println("Erro! Entrega não encontrada!");
        }
    }

    private void salvarEntregasEmArquivo() throws IOException {
        try (FileWriter writer = new FileWriter("entregas.txt")) {
            for (Entrega entrega : entregas) {
                writer.write(entrega.toString() + "\n");
            }
        System.out.println("Entregas salvas em 'Entregas.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar entregas: " + e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
        SistemaLogistico sistema = new SistemaLogistico();
        sistema.exibirMenu();
    }
}