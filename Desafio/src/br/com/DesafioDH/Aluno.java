package br.com.DesafioDH;

public class Aluno {

    public int codigoAluno;
    public String nome;
    public String sobrenome;

    public Aluno () {

    }

    public Aluno (int codigoAluno, String nome, String sobrenome) {
        this.codigoAluno = codigoAluno;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}