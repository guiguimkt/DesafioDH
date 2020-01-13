package br.com.DesafioDH;

import java.util.Date;

public class Matricula {

    public Aluno aluno;
    public Curso curso;
    public Date dataMatricula;

    public Matricula(Aluno umAluno, Curso umCurso, Date umaData) {
        this.aluno = umAluno;
        this.curso = umCurso;
        this.dataMatricula = umaData;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}