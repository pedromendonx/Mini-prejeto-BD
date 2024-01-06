package modelo.entidade;

public class Medico {

    private String nome;
    private int matricula;
    private String especialidade;
    private float salario;


    public Medico() {
    }


    public Medico(String nome, int matricula, String especialidade, float salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.especialidade = especialidade;
        this.salario = salario;  
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome do médico: " + nome + ", Matricula do medico: " + matricula + ", Especialidade do medico: " + especialidade + ", Salario do médico: " + salario;
    }

}
