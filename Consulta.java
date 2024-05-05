package spring;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private String horario;

    public Consulta(Medico medico, Paciente paciente, String horario) {
        this.medico = medico;
        this.paciente = paciente;
        this.horario = horario;
    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
