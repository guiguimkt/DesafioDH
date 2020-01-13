package br.com.DesafioDH;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    public int codigoCurso;
    public String nome;
    public int qtdMaxAlunos;
    public Professor profesorAdjunto;
    public Professor ProfessorTitular;
    public List<Aluno> listaAlunos = new ArrayList();

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdMaxAlunos() {
        return qtdMaxAlunos;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtdMaxAlunos(int qtdMaxAlunos) {
        this.qtdMaxAlunos = qtdMaxAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Professor getProfesorAdjunto() {
        return profesorAdjunto;
    }

    public void setProfesorAdjunto(Professor profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
    }

    public Professor getProfessorTitular() {
        return ProfessorTitular;
    }

    public void setProfessorTitular(Professor professorTitular) {
        ProfessorTitular = professorTitular;
    }

    public Boolean adicionarUmAluno(Aluno umAluno) {
        Boolean pode = true;
        for (int i = 0; i < this.listaAlunos.size(); i++) {
            if (this.listaAlunos.get(i).codigoAluno == umAluno.codigoAluno) {
                pode = false;
                break;
            }
            else if (this.qtdMaxAlunos == this.listaAlunos.size()) {
                pode = false;
                break;
            }
            else { pode = true; }
        }

        if (pode == true) {
            this.listaAlunos.add(umAluno);
            System.out.println("Aluno adicionado com sucesso.");
        }
        else {
            System.out.println("Não há vagas.");
        }
        return pode;
    }

    public void excluirAluno(Aluno umAluno) {
        for (int i = 0; i < this.listaAlunos.size(); i++) {
            if (this.listaAlunos.get(i).codigoAluno == umAluno.codigoAluno) {
                this.listaAlunos.remove(i);
                System.out.println("Aluno removido com sucesso.");
            }
        }
    }
}