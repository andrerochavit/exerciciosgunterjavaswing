package spring;

public class Medico extends Pessoa {
	public String especialidade;
	public String crm;
	public String horariosDisponiveis;
	
	public Medico(String nome) {
		super(nome);
	}

	public Medico(String nome, String especialidade, String crm, String horariosDisponiveis) {
		super(nome);
		this.especialidade = especialidade;
		this.crm = crm;
		this.horariosDisponiveis = horariosDisponiveis;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getHorariosDisponiveis() {
		return horariosDisponiveis;
	}

	public void setHorariosDisponiveis(String horariosDisponiveis) {
		this.horariosDisponiveis = horariosDisponiveis;
	}
	
}
