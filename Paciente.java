package spring;

public class Paciente extends Pessoa {
	public String cpf;
	public String endereco;
	public String contato;
	public String historicoMedico;
	
	public Paciente(String nome) {
		super(nome);
		}

	public Paciente(String nome, String cpf, String endereco, String contato, String historicoMedico) {
		super(nome);
		this.cpf = cpf;
		this.endereco = endereco;
		this.contato = contato;
		this.historicoMedico = historicoMedico;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(String historicoMedico) {
		this.historicoMedico = historicoMedico;
	}
}
