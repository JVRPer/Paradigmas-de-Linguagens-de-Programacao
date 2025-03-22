public class App {
    public static void main(String[] args) throws Exception {
        Professor professor;
        professor = new Professor();

        professor.setNome("Marcelo");
        professor.setMatricula(37845);
        professor.setCargahoraria(24);

        Professor p2;
        p2 = new Professor("Franz");
        Professor p3;
        p3 = new Professor("Matheus", 11);

        System.out.println(professor.retornaprofessor());
        System.out.println(p2.retornaprofessor());
        System.out.println(p3.retornaprofessor());
    }
}
