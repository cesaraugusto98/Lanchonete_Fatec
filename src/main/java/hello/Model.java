/*
 *  Model
 *  
 *  1.1
 *  
 *  Code by: Cesar Augusto e Julio Cesar
 * 
 */

package hello;

import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;

public class Model {

	private List<Lanche> lanches = new LinkedList<Lanche>(); //papel de banco de dados
	private List<Bebida> bebidas = new LinkedList<Bebida>(); //papel de banco de dados
	private List<Funcionario> funcionarios = new LinkedList<Funcionario>(); //papel de banco de dados

	
	public List<Lanche> buscarLanches(String nomeLanche){
		List<Lanche> lanchesEncontrados = new LinkedList<Lanche>();
		
		for(Lanche lanche:lanches){
			 if(nomeLanche.equals(lanche.getNome())) lanchesEncontrados.add(lanche);
		}
		
		return lanchesEncontrados;
		
	}//Cesar Augusto
	
	public void addLanche(Lanche lanche){
		lanches.add(lanche);
	}//Cesar Augusto
	
	public List<Lanche> getLanches(){
		return lanches;
	}//Cesar Augusto
	
	public boolean verificarLogin(String login, String senha) {
		for(Funcionario funcionario:funcionarios) {
			if(login.equals(funcionario.getLogin()) && senha.equals(funcionario.getSenha()))
				return true;
		}
		return false;
	}//Cesar Augusto
	
	public void addFuncionario(Funcionario func) {
		funcionarios.add(func);
	}//Julio Cesar
	
	public List<Funcionario> getFuncionariosTratados(){
		for(Funcionario func:funcionarios) {
			func.setDtNascimento(LocalDate.parse(String.valueOf(func.getDtNascimento()).replace('/', '-')));
		}
		return funcionarios;
	}//Julio Cesar
	
	/*public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}//Cesar Augusto
*/	
	public void addBebida(Bebida bebida){
		bebidas.add(bebida);
	}//Julio Cesar
	
	public List<Bebida> buscarBebidas(String nome){
		List<Bebida> bebidasEncontradas = new LinkedList<Bebida>();
		
		for(Bebida bebida:bebidas){
			 if(bebida.getNome().toUpperCase().contains(nome.toUpperCase())) bebidasEncontradas.add(bebida);
		}
		
		return bebidasEncontradas;
		
	}//Cesar Augusto
	
	public List<Bebida> getBebidas(){
		return bebidas;
	}//Cesar Augusto
	
}
