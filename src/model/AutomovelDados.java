package model;

import java.io.*;
import java.util.*;

public class AutomovelDados {
    private final String arquivo = "automoveis.txt";

    public void salvarLista(List<Automovel> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public List<Automovel> carregarLista() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Automovel>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
