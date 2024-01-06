package modelo.entidade;

public class Paciente {
    
    private String nome;
    private String cpf;
    private String doenca;


    public Paciente() {
    }


    public Paciente(String nome, String cpf, String doenca) {
        this.nome = nome;
        this.cpf = cpf;
        this.doenca = doenca;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDoenca() {
        return this.doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    @Override
    public String toString() {
        return "Nome do paciente: " + nome + ", cpf do paciente: " + cpf + ", doença do paciente: " + doenca;
    }
}
