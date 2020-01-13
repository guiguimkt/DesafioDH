package br.com.DesafioDH;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DigitalHouseManager {

    public List<Aluno> listaAluno = new ArrayList();
    public List<Professor> listaProfessor = new ArrayList();
    public List<Curso> listaCurso = new ArrayList();
    public List<Matricula> listaMatricula = new ArrayList();

    public void registrarCurso(String nome, Integer codigoCurso, Integer quantidadeMaximaDeAlunos) {
        Curso curso = new Curso();
        curso.codigoCurso = codigoCurso;
        curso.nome = nome;
        curso.qtdMaxAlunos = quantidadeMaximaDeAlunos;

        listaCurso.add(curso);
        System.out.println("Curso " + nome + " adicionado com sucesso.");
    }

    public void excluirCurso(Integer codigoCurso) {
        boolean tem = false;
        for (int i = 0; i < listaCurso.size(); i++) {
            if (listaCurso.get(i).codigoCurso == codigoCurso) {
                listaCurso.remove(i);
                tem  = true;
            }
        }

        if (tem == false) { System.out.println("Curso não encontrado."); }
        else { System.out.println("Curso removido com sucesso."); }
    }

    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoProfessor, Integer quantidadeDeHoras) {
        boolean tem = false;
        for (int i = 0; i < listaProfessor.size(); i++) {
            if (listaProfessor.get(i).codigoProfessor == codigoProfessor) {
                tem = true;
                break;
            }
            else {
                tem = false;
            }
        }

        if (tem == true) { System.out.println("Professor " + nome + " já foi registrado."); }
        else {
            Professor profAdjunto = new Professor();
            profAdjunto.codigoProfessor = codigoProfessor;
            profAdjunto.nome = nome;
            profAdjunto.sobrenome = sobrenome;
            profAdjunto.qtdHoras = quantidadeDeHoras;

            listaProfessor.add(profAdjunto);
            System.out.println("Professor " + nome + " registrado com sucesso.");
        }
    }

    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProfessor, String especialidade) {
        boolean tem = false;

        if (this.listaProfessor.size() == 0) {
            Professor profAdjunto = new Professor();
            profAdjunto.codigoProfessor = codigoProfessor;
            profAdjunto.nome = nome;
            profAdjunto.sobrenome = sobrenome;
            profAdjunto.especialidade = especialidade;

            this.listaProfessor.add(profAdjunto);
            System.out.println("Professor " + nome + " registrado com sucesso.");
        }
        else {
            for (int i = 0; i < this.listaProfessor.size(); i++) {
                if (this.listaProfessor.get(i).codigoProfessor == codigoProfessor) {
                    tem = true;
                    break;
                }
                else { tem = false; }
            }

            if (tem == true) { System.out.println("Professor " + nome + " já foi registrado."); }
            else {
                Professor profAdjunto = new Professor();
                profAdjunto.codigoProfessor = codigoProfessor;
                profAdjunto.nome = nome;
                profAdjunto.sobrenome = sobrenome;
                profAdjunto.especialidade = especialidade;

                this.listaProfessor.add(profAdjunto);
                System.out.println("Professor " + nome + " registrado com sucesso.");
            }
        }
    }

    public void excluirProfessor(Integer codigoProfessor) {
        boolean tem = false;
        for (int i = 0; i < this.listaProfessor.size(); i++) {
            if (this.listaProfessor.get(i).codigoProfessor == codigoProfessor) {
                this.listaProfessor.remove(i);
                tem = true;
            }
            else { tem = false; }
        }

        if (tem == true) { System.out.println("Professor excluído com sucesso."); }
        else { System.out.println("Profesor não encontrado."); }
    }

    public void matricularAluno(String nome, String sobrenome, Integer codigoAluno) {
        boolean tem = false;
        for (int i = 0; i < listaAluno.size(); i++) {
            if (listaAluno.get(i).codigoAluno == codigoAluno) { tem = true; }
        }

        if (tem == true) { System.out.println("Aluno " + nome +" já matriculado"); }
        else {
                Aluno aluno = new Aluno(codigoAluno, nome, sobrenome);
                listaAluno.add(aluno);
                System.out.println("Aluno " + nome + " matriculado com sucesso.");
        }
    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso) {
        Aluno aluno = new Aluno();
        boolean existeAluno = false;
        for (int i = 0; i < listaAluno.size(); i++) {
            if (listaAluno.get(i).codigoAluno == codigoAluno) {
                aluno = listaAluno.get(i);
                existeAluno = true;
            }
        }

        Curso curso = new Curso();
        boolean existeCurso = false;
        for (int i = 0; i < listaCurso.size(); i++) {
            if (listaCurso.get(i).codigoCurso == codigoCurso) {
                curso = listaCurso.get(i);
                existeCurso = true;
            }
        }

        if (existeCurso == false) { System.out.println("Curso não encontrado."); }
        else if (existeAluno == false) { System.out.println("Aluno não encontrado."); }
        else {

            Boolean ret = curso.adicionarUmAluno(aluno);

            if (ret == false) {
                System.out.println("Não há vagas no curso " + curso.nome + ".");
            }
            else {
                curso.qtdMaxAlunos += 1;
                curso.listaAlunos.add(aluno);
                Matricula matricula = new Matricula(aluno, curso, new Date());
                listaMatricula.add(matricula);
                System.out.println("Aluno " + aluno.nome + " matriculado no curso " + curso.nome + ".");
            }
        }
    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto) {
        Professor professorAdjunto = new Professor();
        Boolean temAdjunto = false;
        for (int i = 0; i < listaProfessor.size(); i++) {
            if (listaProfessor.get(i).codigoProfessor == codigoProfessorAdjunto) {
                professorAdjunto = listaProfessor.get(i);
                temAdjunto = true;
            }
        }

        if (temAdjunto == false) {
            System.out.println("Professor adjunto não encontrado.");
            return;
        }

        Professor professorTitular = new Professor();
        Boolean temTitular = false;
        for (int i = 0; i < listaProfessor.size(); i++) {
            if (listaProfessor.get(i).codigoProfessor == codigoProfessorTitular) {
                professorTitular = listaProfessor.get(i);
                temTitular = true;
            }
        }

        if (temTitular == false) {
            System.out.println("Professor titular não encontrado.");
            return;
        }

        Curso curso = new Curso();
        Boolean temCurso = false;
        for (int i = 0; i < listaCurso.size(); i++) {
            if (listaCurso.get(i).codigoCurso == codigoCurso) {
                listaCurso.get(i).profesorAdjunto = professorAdjunto;
                listaCurso.get(i).ProfessorTitular = professorTitular;

                System.out.println("Professores " + professorTitular.nome + " e " + professorAdjunto.nome + " adicionados com sucesso.");

                temCurso = true;
            }
        }

        if (temCurso == false) {
            System.out.println("Curso não encontrado.");
        }
    }
}