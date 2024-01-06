package modelo.entidade;
import java.time.LocalDateTime;

public class Consulta {
    
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime horario;
    private float valor;


    public Consulta() {
    }


    public Consulta(Medico medico, Paciente paciente, LocalDateTime horario, float valor) {
        this.medico = medico;
        this.paciente = paciente;
        this.horario = horario;
        this.valor = valor;
    }


    public Medico getMedico() {
        return this.medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getHorario() {
        return this.horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }


    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Nome do medico: " + medico + ", Nome do Paciente " + paciente + ", Horario da consulta: " + horario + ", Valor da consulta: " + valor;
    }

}
