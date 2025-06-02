package controller;

import model.Automovel;
import model.AutomovelDados;
import view.CadastroAutomovel;

import java.util.*;

public class CadastroAutomoveisController {
    private List<Automovel> lista = new ArrayList<>();
    private final AutomovelDados dao = new AutomovelDados();
    private final CadastroAutomovel view = new CadastroAutomovel();

    public CadastroAutomoveisController() {
        lista = dao.carregarLista();
    }

    public void iniciar() {
        int opcao;

        do {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1 -> incluir();
                case 2 -> excluir();
                case 3 -> alterar();
                case 4 -> consultar();
                case 5 -> listarOrdenado();
                case 0 -> {
                    dao.salvarLista(lista);
                    view.exibirMensagem("Sistema encerrado.");
                }
                default -> view.exibirMensagem("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void incluir() {
        Automovel auto = view.incluirAutomovel();
        if (buscarPorPlaca(auto.getPlaca()) != null) {
            view.exibirMensagem("Já existe automóvel com essa placa.");
        } else {
            lista.add(auto);
            view.exibirMensagem("Automóvel incluído com sucesso.");
        }
    }

    private void excluir() {
        String placa = view.obterPlaca();
        Automovel auto = buscarPorPlaca(placa);

        if (auto != null) {
            lista.remove(auto);
            view.exibirMensagem("Automóvel removido.");
        } else {
            view.exibirMensagem("Automóvel não encontrado.");
        }
    }

    private void alterar() {
        String placa = view.obterPlaca();
        Automovel auto = buscarPorPlaca(placa);

        if (auto != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo modelo: ");
            auto.setModelo(scanner.nextLine());
            System.out.print("Nova marca: ");
            auto.setMarca(scanner.nextLine());
            view.exibirMensagem("Automóvel alterado.");
        } else {
            view.exibirMensagem("Automóvel não encontrado.");
        }
    }

    private void consultar() {
        String placa = view.obterPlaca();
        Automovel auto = buscarPorPlaca(placa);

        if (auto != null) {
            view.exibirMensagem(auto.toString());
        } else {
            view.exibirMensagem("Automóvel não encontrado.");
        }
    }

    private void listarOrdenado() {
        System.out.println("Ordenar por:\n1 - Placa\n2 - Modelo\n3 - Marca");
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();

        List<Automovel> copia = new ArrayList<>(lista);

        switch (op) {
            case 1 -> copia.sort(Comparator.comparing(Automovel::getPlaca));
            case 2 -> copia.sort(Comparator.comparing(Automovel::getModelo));
            case 3 -> copia.sort(Comparator.comparing(Automovel::getMarca));
            default -> {
                view.exibirMensagem("Opção inválida.");
                return;
            }
        }

        view.exibirListaOrdenada(copia);
    }

    private Automovel buscarPorPlaca(String placa) {
        return lista.stream().filter(auto -> auto.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
    }
}
