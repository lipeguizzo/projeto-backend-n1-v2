package br.com.guizzo.exercicio08.domain.entity;

public class Marca {
    private String codigo;
    private String nome;

    public Marca() {
    }

    public Marca(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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
