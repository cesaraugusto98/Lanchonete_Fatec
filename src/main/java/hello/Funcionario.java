/*
 *  Funcionanrio
 *  
 *  1.0
 *  
 *  Code by: Cesar Augusto Siqueira Santos
 * 
 */

package hello;

import java.time.LocalDate;

public class Funcionario {
	
	private String nome;
	private String cpf;
	private String login;
	private String senha;
	private LocalDate dtNascimento;
	private double salario;
	
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public Funcionario(String nome,String cpf, String  login, String senha, LocalDate dtNascimento, double salario){
		this.nome = nome;		
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.dtNascimento = dtNascimento;
		this.salario = salario;
		
	}
}
