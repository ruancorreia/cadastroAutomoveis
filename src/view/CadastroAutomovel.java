package view;

import model.Automovel;

import java.util.*;

public class CadastroAutomovel {

    public int exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Lasalle Motors =====");
        System.out.println("\n--- Cadastro de Veiculos  ---");
        System.out.println("1 - Incluir");
        System.out.println("2 - Excluir");
        System.out.println("3 - Alterar");
        System.out.println("4 - Consultar");
        System.out.println("5 - Listar ordenado");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
        return scanner.nextInt();
    }

    public Automovel incluirAutomovel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ano: ");
        Integer ano = scanner.nextInt();
        System.out.print("Valor: ");
        Double valor = scanner.nextDouble();
        return new Automovel(placa, modelo, marca, ano, valor);
    }

    public String obterPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a placa: ");
        return scanner.nextLine();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirListaOrdenada(List<Automovel> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum automóvel cadastrado.");
        } else {
            System.out.println("\n--- Lista de Automóveis ---");
            for (Automovel auto : lista) {
                System.out.println(auto);
            }
        }
    }
}
