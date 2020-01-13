package br.com.DesafioDH;

public class Professor {

    public int codigoProfessor;
    public String nome;
    public String sobrenome;
    public int tempoCasa;
    public int qtdHoras;
    public String especialidade;

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getTempoCasa() {
        return tempoCasa;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setTempoCasa(int tempoCasa) {
        this.tempoCasa = tempoCasa;
    }
}