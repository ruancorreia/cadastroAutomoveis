package model;

import java.io.Serializable;

public class Automovel implements Serializable {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double valor;

    public Automovel(String placa, String modelo, String marca, Integer ano, Double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }



    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano + ", Valor: " + valor;
    }
}
