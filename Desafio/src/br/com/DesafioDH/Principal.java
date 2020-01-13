package br.com.DesafioDH;

public class Principal {
    public static void main(String[] args) {

        DigitalHouseManager DH = new DigitalHouseManager();
        DH.registrarProfessorTitular("Roberto", "Alves Santos", 1, "Android");
        DH.registrarProfessorTitular("Juliana", "Figueredo", 2, "Android");
        DH.registrarProfessorAdjunto("Fernanda", "Braga", 3, 8);
        DH.registrarProfessorAdjunto("Carlos", "Rodrigues", 4, 6);

        DH.registrarCurso("Full Stack", 20001, 3);
        DH.registrarCurso("Android", 20002, 2);

        DH.alocarProfessores(20001, 1, 3);
        DH.alocarProfessores(20002, 2, 4);

        DH.matricularAluno("Arthur", "Nogueira", 1);
        DH.matricularAluno("Felipe", "Cunha", 2);
        DH.matricularAluno("Carol", "Silva", 3);
        DH.matricularAluno("Matheus", "Santos", 4);
        DH.matricularAluno("Vitor", "Marques", 5);

        DH.matricularAluno(1, 20001);
        DH.matricularAluno(5, 20001);

        DH.matricularAluno(4, 20002);
        DH.matricularAluno(2, 20002);
        DH.matricularAluno(5, 20002);
    }
}