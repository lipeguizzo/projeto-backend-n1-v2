package br.com.guizzo.exercicio08.domain.entity;

public class Modelo {
    private String codigo;
    private String nome;

    public Modelo() {
    }

    public Modelo(String codigo, String name) {
        this.codigo = codigo;
        this.nome = name;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
