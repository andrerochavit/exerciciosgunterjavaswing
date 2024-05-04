package spring;

public class Aluno1 {
	String nome;
	String cpf;
	String dataNascimento;
	public Aluno1(String nome, String cpf, String dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDatNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataDeNascimento) {
		this.dataNascimento = dataDeNascimento;
	}	
}
