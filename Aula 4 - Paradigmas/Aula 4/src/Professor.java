class Professor{
    private String nome;
    private Integer matricula;
    private Integer cargahoraria;
    private String retornaprofessor;

    public Professor(){

    }
    
    public Professor(String n){
        this.nome=n;
    }

    public Professor(String n, int c){
        this.nome = n;
        this.cargahoraria = c;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
    public Integer getCargahoraria() {
        return cargahoraria;
    }
    public void setCargahoraria(Integer cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String retornaprofessor(){
        String dados = "";
        String dadost = "\nProfessor: " + this.nome + "\nCarga horária: " + this.cargahoraria + "\nMatricula: " + this.matricula;

        dados += "Professor: " + this.nome;
        dados += "\nCarga horária: " + this.cargahoraria;
        dados += "\nMatricula: " + this.matricula;
        return dadost;
    } 
}